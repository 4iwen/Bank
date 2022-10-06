package org.delta.account;

import org.delta.person.Person;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AccountFactory {
    @Inject
    private AccountService accountService;

    public BaseAccount createAccount(AccountType accountType, Person person, float balance) {

        BaseAccount account = switch (accountType) {
            default -> new BaseAccount(accountService.generateAccountNumber(), person, balance);
            case STUDENT ->
                    new StudentAccount(accountService.generateAccountNumber(), person, balance);
            case SAVINGS ->
                    new SavingAccount(accountService.generateAccountNumber(), person, balance);
        };;

        accountService.addAccount(account);

        return account;
    }
}
