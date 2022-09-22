package org.bank;
public class StudentAccount extends BaseAccount {

    private boolean isActiveStudent;

    public StudentAccount(Person owner, float balance) {
        super(owner, balance);

        this.isActiveStudent = true;
    }
}
