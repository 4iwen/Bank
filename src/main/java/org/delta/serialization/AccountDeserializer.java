package org.delta.serialization;

import org.delta.account.BaseAccount;
import org.delta.card.BaseCard;
import org.delta.person.Person;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class AccountDeserializer {
    public BaseAccount deserialize(AccountJsonSerializationObject json) {
        Person owner = new Person(json.owner.id, json.owner.firstName, json.owner.lastName);
        BaseAccount account = new BaseAccount(json.accountNumber, owner, json.balance);
        // read cards
        BaseCard[] cards = new BaseCard[json.cards.size()];
        for (int i = 0; i < json.cards.size(); i++) {
            CardJsonSerializationObject cardJson = json.cards.get(i);
            cards[i] = new BaseCard(account, cardJson.cardNumber, cardJson.expiration, cardJson.cvc);
        }
        account.setCards(List.of(cards));

        return account;
    }
}
