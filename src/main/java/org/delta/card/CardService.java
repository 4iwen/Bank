package org.delta.card;


import java.util.LinkedList;
import java.util.List;

public class CardService {
    private List<BaseCard> cards = new LinkedList<>();

    public void addCard(BaseCard card) {
        this.cards.add(card);
    }
}
