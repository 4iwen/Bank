package org.delta.card;

import org.delta.account.BaseAccount;

public class CreditCard extends BaseCard {
    public float credit;
    public float creditLimit = 5000.0f;

    public CreditCard(BaseAccount baseAccount, String cardNumber, String expiration, String cvc) {
        super(baseAccount, cardNumber, expiration, cvc);

        // TODO: create input for this
        this.credit = 1000;
    }
}
