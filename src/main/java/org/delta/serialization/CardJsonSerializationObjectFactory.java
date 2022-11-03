package org.delta.serialization;

import org.delta.card.BaseCard;

import javax.inject.Singleton;

@Singleton
public class CardJsonSerializationObjectFactory {
    public CardJsonSerializationObject create(BaseCard card) {
        CardJsonSerializationObject cardJsonSerializationObject = new CardJsonSerializationObject(card);
        cardJsonSerializationObject.cardNumber = card.getCardNumber();
        cardJsonSerializationObject.expiration = card.getExpiration();
        cardJsonSerializationObject.cvc = card.getCvc();
        return cardJsonSerializationObject;
    }
}
