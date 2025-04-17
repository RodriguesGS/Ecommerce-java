package org.example.factory;

import org.example.strategy.PaymentStrategy;

import java.util.Random;

public class BilletPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        StringBuilder code = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 48; i++) {
            code.append(random.nextInt(10));
        }

        System.out.println("\nAguarde, efetuando pagamento...");
        System.out.println("Pagamento confirmado com sucesso via Boleto. Código gerado: " + code);
    }
}
