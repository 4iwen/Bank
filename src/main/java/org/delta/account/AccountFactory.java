package org.delta.account;

import org.delta.person.Person;
import org.delta.utils.AccountNumberGenerator;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.LinkedList;
import java.util.List;

@Singleton
public class AccountFactory {
    @Inject
    private AccountService accountService;

    @Inject
    private AccountNumberGenerator accountNumberGenerator;

    private List<BaseAccount> accounts  = new LinkedList<>();

    public BaseAccount createAccount(AccountType accountType, Person person, float balance) {

        BaseAccount account = switch (accountType) {
            default -> new BaseAccount(accountNumberGenerator.generateAccountNumber(), person, balance);
            case STUDENT ->
                    new StudentAccount(accountNumberGenerator.generateAccountNumber(), person, balance);
            case SAVINGS ->
                    new SavingAccount(accountNumberGenerator.generateAccountNumber(), person, balance);
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
