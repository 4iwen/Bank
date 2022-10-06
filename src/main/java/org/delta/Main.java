package org.delta;

import com.google.gson.Gson;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.delta.account.BaseAccount;
import org.delta.io.IO;
import org.delta.serialization.AccountJsonSerializationObjectFactory;

import javax.inject.Inject;
import java.io.IOException;

public class Main {

    @Inject
    private AccountJsonSerializationObjectFactory accountJsonSerializationObjectFactory;

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new BankInjector());

        Bank bank = injector.getInstance(Bank.class);
        bank.example();


        //Bank bank = new Bank();
        //bank.startTerminal();
        //bank.example();

        /*
        Gson gson = new Gson();
        String json = gson.toJson(accountJsonSerializationObjectFactory.create());

        System.out.println(json);

        try {
            IO.writeFile("accounts.json", json);

            String jsonFile = IO.readFile("accounts.json");
            System.out.println(jsonFile);

            BaseAccount readAccount = gson.fromJson(jsonFile, BaseAccount.class);
            readAccount.printBalance();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        */
     }
}