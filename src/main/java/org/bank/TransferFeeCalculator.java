package org.bank;
public class TransferFeeCalculator {
    public static float calculateFee(BaseAccount account) {
        if (account instanceof StudentAccount) {
            return 0;
        } else if (account instanceof SavingsAccount) {
            return 20;
        } else {
            return 10;
        }
    }
}
