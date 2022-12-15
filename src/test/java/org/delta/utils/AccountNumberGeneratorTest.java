package org.delta.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountNumberGeneratorTest {

    @Test
    void generateAccountNumber() {
        AccountNumberGenerator generator = new AccountNumberGenerator();
        String accountNumber = generator.generateAccountNumber();
            assertEquals(11, accountNumber.length());
        assertEquals('-', accountNumber.charAt(3));
        assertEquals('-', accountNumber.charAt(7));
    }
}