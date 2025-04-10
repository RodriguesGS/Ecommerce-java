package org.example.factory;

import org.example.strategy.PaymentStrategy;

public class CashPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("O pagamento de R$" + amount + " foi processado utilizando Dinheiro");
        System.out.println("Transação aprovada!!");
    }
}
