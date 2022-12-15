package org.delta.card;

import com.google.inject.Guice;
import org.delta.BankInjectorTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CardCreatorServiceTest {

    @BeforeEach
    void setUp() {
        Guice.createInjector(new BankInjectorTest()).injectMembers(this);
    }

    @Test
    void createCardAndSetIntoAccount() {

    }
}