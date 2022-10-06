package org.delta.serialization;

import org.delta.card.BaseCard;

import java.util.LinkedList;
import java.util.List;

public class AccountJsonSerializationObject {
    public String accountNumber;
    public PersonJsonSerializationObject owner;
    public float balance;
    public String accountType;
    public List<CardJsonSerializationObject> cards = new LinkedList<>();
}
