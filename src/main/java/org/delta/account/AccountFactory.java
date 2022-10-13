package org.delta.account;

import org.delta.person.Person;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.LinkedList;
import java.util.List;

@Singleton
public class AccountFactory {
    @Inject
    private AccountService accountService;

    private List<BaseAccount> accounts  = new LinkedList<>();

    public BaseAccount createAccount(AccountType accountType, Person person, float balance) {

        BaseAccount account = switch (accountType) {
            default -> new BaseAccount(accountService.generateAccountNumber(), person, balance);
            case STUDENT ->
                    new StudentAccount(accountService.generateAccountNumber(), person, balance);
            case SAVINGS ->
                    new SavingAccount(accountService.generateAccountNumber(), person, balance);
        };

        accountService.addAccount(account);

        return account;
    }

    public BaseAccount getAccountByAccountNumber(String accountNumber) {
        if (accounts.stream()
                    .anyMatch(account -> account.getAccountNumber().equals(accountNumber))) {
            return accounts.stream().filter(account -> account.getAccountNumber().equals(accountNumber)).findFirst().get();
        }
        return null;
    }

    public void addAccount(BaseAccount account) {
        this.accounts.add(account);
    }
}
