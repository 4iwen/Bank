package org.delta.account;

import javax.inject.Singleton;

@Singleton
public class MoneyTransferService {

    private BankFeeCalculator bankFeeCalculator;

    public MoneyTransferService() {
        this.bankFeeCalculator = new BankFeeCalculator();
    }

    public void transferMoney(BaseAccount sourceAccount, BaseAccount targetAccount, float amount) {

        // check

        sourceAccount.subFromBalance(amount);
        targetAccount.addToBalance(amount);

        float transferFee = this.bankFeeCalculator.calculateTransferFee(sourceAccount);
        sourceAccount.subFromBalance(transferFee);
    }

}
