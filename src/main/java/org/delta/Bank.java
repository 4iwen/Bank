package org.delta;

import org.delta.account.*;
import org.delta.action.ActionProcessService;
import org.delta.atm.ATMFactory;
import org.delta.atm.ATMInfoPrinterService;
import org.delta.atm.ATMService;
import org.delta.atm.BaseATM;
import org.delta.card.BaseCard;
import org.delta.card.CardCreatorService;
import org.delta.menu.Menu;
import org.delta.menu.MenuChoices;
import org.delta.person.Person;
import org.delta.person.PersonFactory;
import org.delta.serialization.AccountDeserializer;
import org.delta.serialization.AccountJsonSerializationObject;
import org.delta.serialization.AccountJsonSerializationObjectFactory;
import org.delta.serialization.GsonSerializationService;
import org.delta.storage.FileSystemStorage;

import javax.inject.Inject;

public class Bank {
    @Inject
    ActionProcessService actionProcessService;

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

    @Inject
    private GsonSerializationService gsonSerializationService;

    @Inject
    private BankJsonData bankJsonData;

    @Inject
    private QuartzScheduler quartzScheduler;

    @Inject
    private ATMFactory atmFactory;

    @Inject
    private ATMService atmService;

    @Inject
    private ATMInfoPrinterService atmInfoPrinterService;

    public void startTerminal() {


        quartzScheduler.registerJobs();

        System.out.println("Hello from bank application!");

        Menu menu = new Menu();
        menu.printMenu();

        while (true) {
            MenuChoices choice = menu.read();

            System.out.println("choice: " + choice);

            if (choice == MenuChoices.EXIT) {
                break;
            }

            this.actionProcessService.processAction(choice);
        }
    }


    public void example() {

        Person owner = this.personFactory.createPerson("id123123", "Tomas", "Pesek");

        //bankJsonData.persons.add(owner);

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
        String json = gsonSerializationService.serialize(accountJsonSerializationObjectFactory.create(accountOne));
        fileSystemStorage.save(json, "accounts.json");

        String jsonFile = fileSystemStorage.read("accounts.json");

        AccountJsonSerializationObject read = gsonSerializationService.deserialize(jsonFile, AccountJsonSerializationObject.class);
        BaseAccount readAccount = accountDeserializer.deserialize(read);

        System.out.println("==== READ ACCOUNT ====");
        accountInfoPrinterService.printAccountInfo(readAccount);
    }

    public void atmExample() {
        // create person, account, add a card, create an atm, insert card and withdraw money
        Person owner = this.personFactory.createPerson("id123123", "Tomas", "Pesek");
        BaseAccount account = this.accountFactory.createAccount(AccountType.BASE, owner, 1000);
        this.cardCreatorService.createCardAndSetIntoAccount(account);

        BaseATM atm = this.atmService.addATM(this.atmFactory.createATM("ATM 1", "Prague"));
        BaseCard card = account.getCards().get(0);
        this.atmService.withdraw(atm, card, 500);
        this.atmService.insertCard(atm, card);
        this.atmService.withdraw(atm, card, 500);
        this.atmService.balance(atm, card);
        this.atmService.ejectCard(atm);
    }
}
