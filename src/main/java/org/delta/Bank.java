package org.delta;

import com.google.gson.Gson;
import org.delta.account.*;
import org.delta.action.ActionListener;
import org.delta.action.HelpAction;
import org.delta.card.CardCreatorService;
import org.delta.io.IO;
import org.delta.menu.Menu;
import org.delta.menu.MenuChoices;
import org.delta.person.Person;
import org.delta.person.PersonFactory;
import org.delta.serialization.AccountDeserializer;
import org.delta.serialization.AccountJsonSerializationObject;
import org.delta.serialization.AccountJsonSerializationObjectFactory;
import org.delta.storage.FileSystemStorage;
import org.delta.storage.Storage;

import javax.inject.Inject;
import java.io.IOException;

public class Bank {

    @Inject
    private ActionListener actionListener;

    @Inject
    private AccountInfoPrinterService accountInfoPrinterService;

    @Inject
    private MoneyTransferService moneyTransferService;

    @Inject
    private InterestRunnerService interestRunnerService;

    @Inject
    private PersonFactory personFactory;

    @Inject
    private AccountFactory accountFactory;

    @Inject
    private CardCreatorService cardCreatorService;

    @Inject
    private AccountJsonSerializationObjectFactory accountJsonSerializationObjectFactory;

    @Inject
    private AccountDeserializer accountDeserializer;

    @Inject
    private FileSystemStorage fileSystemStorage;

    public void registerActions() {
        this.actionListener.registerAction(MenuChoices.HELP, new HelpAction());
        this.actionListener.registerAction(MenuChoices.DETAIL, new HelpAction());
        this.actionListener.registerAction(MenuChoices.ACCOUNTS, new HelpAction());
        this.actionListener.registerAction(MenuChoices.CREDIT, new HelpAction());
        this.actionListener.registerAction(MenuChoices.SAVING, new HelpAction());
        this.actionListener.registerAction(MenuChoices.INVALID_CHOICE, new HelpAction());
    }

    public void startTerminal() {
        System.out.println("Hello from bank application!");

        Menu menu = new Menu();
        menu.printMenu();

        while (true) {
            MenuChoices choice = menu.read();

            if (choice == MenuChoices.EXIT) {
                break;
            }

            this.actionListener.processAction(choice);
        }
    }

    public void example() {

        Person owner = this.personFactory.createPerson("id123123", "Tomas", "Pesek");

        BaseAccount accountOne = this.accountFactory.createAccount(AccountType.BASE, owner, 1000);
        BaseAccount accountTwo = this.accountFactory.createAccount(AccountType.SAVINGS, owner, 5000);
        BaseAccount accountThree = this.accountFactory.createAccount(AccountType.STUDENT, owner, 10000);

        this.accountInfoPrinterService.printAccountInfo(accountOne);
        this.accountInfoPrinterService.printAccountInfo(accountTwo);
        this.accountInfoPrinterService.printAccountInfo(accountThree);
        System.out.println();

        this.moneyTransferService.transferMoney(accountOne, accountTwo, 500);

        this.accountInfoPrinterService.printAccountInfo(accountOne);
        this.accountInfoPrinterService.printAccountInfo(accountTwo);
        System.out.println();

        BaseAccount[] accounts = new BaseAccount[3];
        accounts[0] = accountOne;
        accounts[1] = accountTwo;
        accounts[2] = accountThree;

        interestRunnerService.run(accounts);

        this.accountInfoPrinterService.printAccountInfo(accountOne);
        this.accountInfoPrinterService.printAccountInfo(accountTwo);
        this.accountInfoPrinterService.printAccountInfo(accountThree);
        System.out.println();

        this.cardCreatorService.createCardAndSetIntoAccount(accountOne);
        this.accountInfoPrinterService.printAccountInfo(accountOne);

        // serialization
        System.out.println();
        Gson gson = new Gson();
        String json = gson.toJson(accountJsonSerializationObjectFactory.create(accountOne));
        fileSystemStorage.save(json, "accounts.json");

        String jsonFile = fileSystemStorage.read("accounts.json");

        AccountJsonSerializationObject read = gson.fromJson(jsonFile, AccountJsonSerializationObject.class);
        BaseAccount readAccount = accountDeserializer.deserialize(read);

        System.out.println("==== READ ACCOUNT ====");
        accountInfoPrinterService.printAccountInfo(readAccount);
    }
}
