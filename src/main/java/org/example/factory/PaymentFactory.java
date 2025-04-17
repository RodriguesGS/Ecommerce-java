package org.example.factory;

import org.example.model.PaymentMethod;
import org.example.strategy.PaymentStrategy;

public class PaymentFactory {
    public static PaymentStrategy newStrategy(PaymentMethod method) {
        return switch (method) {
            case CASH -> new CashPayment();
            case CREDIT_CARD -> new CreditCardPayment();
            case DEBIT_CARD -> new DebitCardPayment();
            case BILLET -> new BilletPayment();
            case PIX -> new PixPayment();
            default -> throw new IllegalArgumentException("Tipo de pagamento inválido: " + method);
        };
    }
}
