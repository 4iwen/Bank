package org.bank;
public class InterestCalculator {
    public static float calculateInterest(BaseAccount account) {
        if (account instanceof SavingsAccount) {
            return account.getBalance() * 100 / ((SavingsAccount) account).getInterest();
        } else {
            return 0;
        }
    }
}
