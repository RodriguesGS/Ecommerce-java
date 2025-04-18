package org.example;

import org.example.factory.PaymentFactory;
import org.example.model.PaymentMethod;
import org.example.model.Product;
import org.example.model.Sales;
import org.example.model.User;
import org.example.repository.ProductRepository;
import org.example.repository.SalesRepository;
import org.example.repository.UserRepository;
import org.example.services.PaymentProcessor;
import org.example.services.SalesService;
import org.example.strategy.PaymentStrategy;
import org.example.view.MenuView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        MenuView view = new MenuView();
        Connection conn;
        ProductRepository listOfProducts = new ProductRepository(null);
        UserRepository listOfUsers = new UserRepository(null);
        SalesRepository salesRepository;
        SalesService salesService = null;

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
                    Optional<User> optionalUser = salesService.findByEmail(email);

                    if (optionalUser.isPresent()) {
                        User user = optionalUser.get();

                        System.out.print("Usuário encontrado: " + user.getName());
                    } else {
                        System.out.println("Usuário para esse email não encontrado");
                    }

                    List<Product> allProducts = listOfProducts.findAll();
                    List<UUID> product = view.getProductIdForSale(allProducts);

                    String payment = view.getPaymentMethod();
                    PaymentMethod paymentMethod = PaymentMethod.valueOf(payment);
                    PaymentStrategy strategy = PaymentFactory.newStrategy(paymentMethod);
                    PaymentProcessor processor = new PaymentProcessor(strategy);

                    double total = product.stream()
                            .map(listOfProducts::findById)
                            .filter(Optional::isPresent)
                            .mapToDouble(p -> p.get().getPrice())
                            .sum();

                    processor.process(total);

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