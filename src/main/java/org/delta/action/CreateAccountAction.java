package org.delta.action;

import org.delta.account.AccountService;
import org.delta.account.BaseAccount;
import org.delta.person.Person;
import org.delta.person.PersonService;

import javax.inject.Inject;
import java.util.Scanner;

public class CreateAccountAction implements Action {

    @Inject
    private AccountService accountService;
    @Inject
    private PersonService personService;

    @Override
    public void processAction() {
        String accountNumber;
        Person owner;
        float balance;
        // read accountNumber, owner, balance from user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number: ");
        accountNumber = scanner.nextLine();
        System.out.print("Enter owner id: ");
        String ownerId = scanner.nextLine();
        owner = personService.getPersonById(ownerId);
        System.out.print("Enter balance: ");
        balance = scanner.nextFloat();
        // create account
        BaseAccount account = new BaseAccount(accountNumber, owner, balance);
        // add account to account service
        accountService.addAccount(account);
        System.out.println("Account created - owner - " + account.getOwner().getFullName() + " - id - " + account.getOwner().getId());
    }
}

