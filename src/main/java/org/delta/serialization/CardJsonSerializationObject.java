package org.delta.serialization;

import org.delta.card.BaseCard;

public class CardJsonSerializationObject {
    public String cardNumber;
    public String expiration;
    public String cvc;

    public CardJsonSerializationObject(BaseCard card) {
        this.cardNumber = card.getCardNumber();
        this.expiration = card.getExpiration();
        this.cvc = card.getCvc();
    }
}
