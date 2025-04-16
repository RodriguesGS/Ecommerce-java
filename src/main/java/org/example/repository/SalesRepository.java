package org.example.repository;

import org.example.model.Product;
import org.example.model.Sales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalesRepository {
    private final Connection connection;

    public SalesRepository (Connection connection) {
        this.connection = connection;
    }

    public void save(Sales sales) {
        String querySale = "INSERT INTO SALES (id, user_id, payment_method) VALUES (?, ?, ?)";
        String queryProductSale = "INSERT INTO sale_products (sale_id, product_id) VALUES (?, ?)";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(querySale);
            stmt.setString(1, sales.getId().toString());
            stmt.setString(2, sales.getUser().getId().toString());
            stmt.setString(3, sales.getPaymentMethod().name());
            stmt.executeUpdate();

            PreparedStatement stmtProduct = this.connection.prepareStatement(queryProductSale);

            for (Product product : sales.getProducts()) {
                stmtProduct.setString(1, sales.getId().toString());
                stmtProduct.setString(2, product.getId().toString());
                stmtProduct.addBatch();
            }

            stmtProduct.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
