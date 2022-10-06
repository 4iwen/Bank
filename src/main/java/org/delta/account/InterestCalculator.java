package org.delta.account;

public class InterestCalculator {

    public float calculateInterest(BaseAccount account) {
        if (!(account instanceof AccountWithInterest)) {
            throw new RuntimeException();
        }

        float interest = ((AccountWithInterest) account).getInterest();
        float balance = account.getBalance();

        return balance / 100 * interest;
    }

}
