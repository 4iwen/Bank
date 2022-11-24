package org.delta.card;

import org.delta.account.BaseAccount;

public class BaseCard {

    private BaseAccount baseAccount;

    private String cardNumber;

    private String expiration;

    private String cvc;

    public BaseCard(BaseAccount baseAccount, String cardNumber, String expiration, String cvc) {
        this.baseAccount = baseAccount;
        this.cardNumber = cardNumber;
        this.expiration = expiration;
        this.cvc = cvc;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpiration() {
        return expiration;
    }

    public String getCvc() {
        return cvc;
    }

    public BaseAccount getAccount() {
        return baseAccount;
    }
}
