package org.example.model;

import java.util.List;
import java.util.UUID;

public class Sales extends Entity {
    private final User user;
    private final List<Product> products;
    private final double total;
    private final PaymentMethod paymentMethod;


    public Sales (UUID id, User user, List<Product> products, double total, PaymentMethod paymentMethod) {
        super(id);
        this.user = user;
        this.products = products;
        this.total = total;
        this.paymentMethod = paymentMethod;
    }

    public Sales (User user, List<Product> products, double total, PaymentMethod paymentMethod) {
        this.user = user;
        this.products = products;
        this.total = total;
        this.paymentMethod = paymentMethod;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotal() {
        return total;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
}
