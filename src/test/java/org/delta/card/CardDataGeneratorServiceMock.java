package org.delta.card;

public class CardDataGeneratorServiceMock extends CardDataGeneratorService {
    @Override
    public String generateCardNumber() {
        return "123-456-789";
    }

    @Override
    public String generateExpirationDate() {
        return "12/25";
    }

    @Override
    public String generateCvc() {
        return "123";
    }
}
