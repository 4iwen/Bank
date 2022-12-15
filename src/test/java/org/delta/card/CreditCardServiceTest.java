package org.delta.card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardServiceTest {

    @Test
    void withdraw() {
        CreditCard card = new CreditCard(null, "1234", "12/12", "123");
        CreditCardService service = new CreditCardService();
        service.withdraw(card, 1000);
        assertEquals(0, card.credit);
    }

    @Test
    void interest() {
        CreditCard card = new CreditCard(null, "1234", "12/12", "123");
        CreditCardService service = new CreditCardService();
        service.interest(card);
        assertEquals(1000, card.credit);
        service.withdraw(card, 2000);
        service.interest(card);
        assertEquals(-1100, card.credit);
    }

    @Test
    void deposit() {
        CreditCard card = new CreditCard(null, "1234", "12/12", "123");
        CreditCardService service = new CreditCardService();
        service.deposit(card, 1000);
        assertEquals(2000, card.credit);
    }
}