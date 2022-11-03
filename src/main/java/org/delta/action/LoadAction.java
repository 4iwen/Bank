package org.delta.action;

import org.delta.BankJsonData;
import org.delta.account.AccountInfoPrinterService;
import org.delta.account.AccountService;
import org.delta.account.BaseAccount;
import org.delta.person.Person;
import org.delta.person.PersonService;
import org.delta.serialization.*;
import org.delta.storage.FileSystemStorage;

import javax.inject.Inject;

public class LoadAction implements Action {
    @Inject
    private FileSystemStorage fileSystemStorage;
    @Inject
    private AccountDeserializer accountDeserializer;
    @Inject
    private PersonDeserializer personDeserializer;
    @Inject
    private GsonSerializationService gsonSerializationService;
    @Inject
    private AccountInfoPrinterService accountInfoPrinterService;
    @Inject
    private AccountService accountService;
    @Inject
    private PersonService personService;


    @Override
    public void processAction() {
        String jsonFile = fileSystemStorage.read("bank.json");
        // restore data from json
        BankJsonData bankJsonData = gsonSerializationService.deserialize(jsonFile, BankJsonData.class);
        for (PersonJsonSerializationObject personJsonSerializationObject : bankJsonData.persons) {
            Person person = personDeserializer.deserialize(personJsonSerializationObject);
            personService.addPerson(person);
        }
        for (AccountJsonSerializationObject accountJsonSerializationObject : bankJsonData.accounts) {
            BaseAccount account = accountDeserializer.deserialize(accountJsonSerializationObject);
            accountService.addAccount(account);
        }

    }
}

