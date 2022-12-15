package org.delta.card;

import com.google.inject.Guice;
import com.google.inject.Inject;
import org.delta.BankInjectorTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardDataGeneratorServiceTest {
    @Inject
    private CardCreatorService cardCreatorService;

    @BeforeEach
    void setUp() {
        Guice.createInjector(new BankInjectorTest()).injectMembers(this);
    }

    @Test
    void generateCardNumber() {
        CardDataGeneratorService generator = new CardDataGeneratorService();
        String cardNumber = generator.generateCardNumber();
        assertEquals(19, cardNumber.length());
        assertEquals('-', cardNumber.charAt(4));
        assertEquals('-', cardNumber.charAt(9));
        assertEquals('-', cardNumber.charAt(14));
    }

    @Test
    void generateExpirationDate() {
        CardDataGeneratorService generator = new CardDataGeneratorService();
        String expirationDate = generator.generateExpirationDate();
        assertEquals(7, expirationDate.length());
        assertEquals('/', expirationDate.charAt(2));
    }

    @Test
    void generateCvc() {
        CardDataGeneratorService generator = new CardDataGeneratorService();
        String cvc = generator.generateCvc();
        assertEquals(3, cvc.length());
    }
}