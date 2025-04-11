package org.example;

import org.example.repository.ProductRepository;
import org.example.view.MenuView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        MenuView view = new MenuView();
        Connection conn = null;
        ProductRepository listOfProducts = new ProductRepository(conn);

        String url = "jdbc:sqlite:database.sqlite";

        try {
            conn = DriverManager.getConnection(url);

            if (conn != null) {
                listOfProducts = new ProductRepository(conn);
            } else {
                System.out.println("Falha de conexão");
                System.exit(1);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            System.exit(1);
        }

        int option;

        do {
            option = view.showMainMenu();

            switch (option) {
                case 1:
                    listOfProducts.save(view.getProductData());
                    break;
                case 2:
                    view.showProducts(listOfProducts.findAll());
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (option != 6);
    }
}