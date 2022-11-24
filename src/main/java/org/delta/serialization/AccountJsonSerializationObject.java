package org.delta.serialization;

import org.delta.card.BaseCard;
import org.delta.person.Person;

import java.util.LinkedList;
import java.util.List;

public class AccountJsonSerializationObject {
    public String accountNumber;
    public PersonJsonSerializationObject owner;
    public float balance;
    public String accountType;
    public List<CardJsonSerializationObject> cards = new LinkedList<>();

    public String getId() {
        return this.accountNumber;
    }

    public float getBalance() {
        return this.balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setOwner(Person owner) {
        this.owner = new PersonJsonSerializationObject(owner);
    }

    public void setInterest(Object interest) {
        this.accountType = interest.getClass().getSimpleName();
    }

    public void setCards(List<BaseCard> card) {
        this.cards.add(new CardJsonSerializationObject((BaseCard) card));
    }
}
