package org.delta.card;

import org.delta.account.BaseAccount;

import javax.inject.Singleton;

@Singleton
public class CardFactory {

    public BaseCard createBaseCard(BaseAccount baseAccount, String cardNumber, String expiration, String cvc) {
        return new BaseCard(baseAccount, cardNumber, expiration, cvc);
    }
}
