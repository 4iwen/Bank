package org.bank;
public class Bank {
    public void example() {
        InterestCalculator interestCalculator = new InterestCalculator();

        Person person = new Person("John", "Smith");
        Person person2 = new Person("Jane", "Doe");

        StudentAccount account = new StudentAccount(person, 420);
        BaseAccount account2 = new BaseAccount(person2, 6969);

        AccountBalancePrinterService abps = new AccountBalancePrinterService();

        abps.printInfo(account);
        abps.printInfo(account2);

        MoneyTransferService mts = new MoneyTransferService();
        mts.transferMoney(account, account2, 100);

        abps.printInfo(account);
        abps.printInfo(account2);
    }
}
