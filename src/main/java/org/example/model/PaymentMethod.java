package org.example.model;

public enum PaymentMethod {
    CASH,
    CREDIT_CARD,
    DEBIT_CARD,
    BILLET,
    PIX;

    @Override
    public String toString() {
        return switch (this) {
            case CASH -> "Dinheiro";
            case CREDIT_CARD -> "Cartão de Crédito";
            case DEBIT_CARD -> "Cartão de Débito";
            case BILLET -> "Boleto";
            case PIX -> "Pix";
        };
    }
}
