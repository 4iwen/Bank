package org.delta;

import com.google.inject.AbstractModule;
import org.delta.card.CardDataGeneratorService;
import org.delta.card.CardDataGeneratorServiceMock;

public class BankInjectorTest extends AbstractModule {
    @Override
    protected void configure() {
        bind(CardDataGeneratorService.class).to(CardDataGeneratorServiceMock.class);
    }
}
