package org.example.factory;

import org.example.strategy.PaymentStrategy;

public class CashPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("\nAguarde, efetuando pagamento...");
        System.out.println("Pagamento confirmado com sucesso via Dinheiro.");
    }
}
