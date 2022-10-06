package org.delta.account;

import org.delta.person.Person;

public class SavingAccount extends BaseAccount implements AccountWithInterest {

    public SavingAccount(String accountNumber, Person owner, float balance) {
        super(accountNumber, owner, balance);
    }

    @Override
    public float getInterest() {
        return 5;
    }
}
