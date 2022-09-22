package org.bank;
public class MoneyTransferService {


    public void transferMoney(BaseAccount sourceAccount, BaseAccount targetAccount, float amount) {
        sourceAccount.subtractFromBalance(amount);
        targetAccount.addToBalance(amount);

        sourceAccount.subtractFromBalance(TransferFeeCalculator.calculateFee(sourceAccount));
    }
}
