package org.delta.account;

import org.delta.person.Person;

public class StudentAccount extends BaseAccount implements AccountWithInterest {

    private boolean isActiveStudent;

    public StudentAccount(String accountNumber, Person owner, float balance) {
        super(accountNumber, owner, balance);

        this.isActiveStudent = true;
    }

    @Override
    public float getInterest() {
        return 1;
    }
}
