package org.example.model;

import java.util.UUID;

public class Product extends Entity {
    private final String name;
    private final double price;

    public Product(UUID id, String name, double price) {
        super(id);
        this.name = name;
        this.price = price;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.name, this.price);
    }
}
