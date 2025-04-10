package org.example.factory;

import org.example.strategy.PaymentStrategy;

public class DebitCardPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("O pagamento de R$" + amount + " foi processado utilizando Cartão de Débito");
        System.out.println("Transação aprovada!!");
    }
}
