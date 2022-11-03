package org.delta.action;

import org.delta.Bank;
import org.delta.BankJsonData;
import org.delta.account.AccountInfoPrinterService;
import org.delta.account.AccountService;
import org.delta.account.BaseAccount;
import org.delta.person.Person;
import org.delta.person.PersonService;
import org.delta.serialization.AccountDeserializer;
import org.delta.serialization.AccountJsonSerializationObject;
import org.delta.serialization.GsonSerializationService;
import org.delta.serialization.PersonJsonSerializationObject;
import org.delta.storage.FileSystemStorage;

import javax.inject.Inject;

public class SaveAction implements Action {
    @Inject
    private FileSystemStorage fileSystemStorage;
    @Inject
    private GsonSerializationService gsonSerializationService;
    @Inject
    private AccountService accountService;
    @Inject
    private PersonService personService;

    @Inject
    BankJsonData bankJsonData;

    @Override
    public void processAction() {

        for (Person person : personService.getPersons()) {
            PersonJsonSerializationObject personJsonSerializationObject = new PersonJsonSerializationObject(person);
            bankJsonData.persons.add(personJsonSerializationObject);
        }

        for (BaseAccount account : accountService.getAccounts()) {
            AccountJsonSerializationObject accountJsonSerializationObject = new AccountJsonSerializationObject();
            accountJsonSerializationObject.setAccountNumber(account.getAccountNumber());
            accountJsonSerializationObject.setBalance(account.getBalance());
            accountJsonSerializationObject.setOwner(account.getOwner());
            accountJsonSerializationObject.setCard(account.getCard());
            bankJsonData.accounts.add(accountJsonSerializationObject);
        }
        String data = gsonSerializationService.serialize(bankJsonData);
        fileSystemStorage.save(data, "bank.json");

    }
}

