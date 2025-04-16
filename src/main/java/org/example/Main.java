package org.example;

import org.example.model.Sales;
import org.example.repository.ProductRepository;
import org.example.repository.SalesRepository;
import org.example.repository.UserRepository;
import org.example.services.SalesService;
import org.example.view.MenuView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        MenuView view = new MenuView();
        Connection conn = null;
        ProductRepository listOfProducts = new ProductRepository(conn);
        UserRepository listOfUsers = new UserRepository(conn);
        SalesService salesService = null;
        SalesRepository salesRepository = null;

        String url = "jdbc:sqlite:database.sqlite";

        try {
            conn = DriverManager.getConnection(url);

            if (conn != null) {
                listOfProducts = new ProductRepository(conn);
                listOfUsers = new UserRepository(conn);
                salesRepository = new SalesRepository(conn);
                salesService = new SalesService(listOfUsers, listOfProducts, salesRepository);

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
                    view.showAllProducts(listOfProducts.findAll());
                    break;
                case 3:
                    listOfUsers.save(view.getUserData());
                    break;
                case 4:
                    view.showAllUsers(listOfUsers.findAll());
                    break;
                case 5:
                    String email = view.getEmailSales();
                    List<UUID> product = view.getProductIdForSale();
                    String payment = view.getPaymentMethod();

                    Sales sales = salesService.createSale(email, product, payment);
                    view.showSale(sales);
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