package org.bank;
public class SavingsAccount extends BaseAccount implements AccountWithInterest {

    private final float interestRate;

    public SavingsAccount(Person owner, float balance, float interestRate) {
        super(owner, balance);

        this.interestRate = interestRate;
    }

    public float getInterest() {
        return interestRate;
    }
}
