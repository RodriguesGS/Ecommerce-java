package org.example.factory;

import org.example.strategy.PaymentStrategy;

import java.util.UUID;

public class PixPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("\nAguarde, efetuando pagamento...");

        String pixKey = generatePixKey();

        System.out.println("Pagamento confirmado com sucesso via PIX. Chave de Autenticação: " + pixKey);
    }

    private String generatePixKey() {
        String raw = UUID.randomUUID().toString().replace("-", "");
        return raw.substring(0, 8) + "-" +
                raw.substring(8, 12) + "-" +
                raw.substring(12, 16) + "-" +
                raw.substring(16, 24);
    }
}
