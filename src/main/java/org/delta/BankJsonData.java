package org.delta;

import org.delta.serialization.AccountJsonSerializationObject;
import org.delta.serialization.PersonJsonSerializationObject;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class BankJsonData {

    public List<PersonJsonSerializationObject> persons = new ArrayList<>();
    public List<AccountJsonSerializationObject> accounts = new ArrayList<>();

    public AccountJsonSerializationObject[] getAccounts() {
        return accounts.toArray(new AccountJsonSerializationObject[0]);
    }

    public PersonJsonSerializationObject[] getPersons() {
        return persons.toArray(new PersonJsonSerializationObject[0]);
    }
}
