package org.example.view;

import org.example.model.Product;
import org.example.model.User;

import java.util.List;
import java.util.Scanner;

public class MenuView {
    private final Scanner scanner = new Scanner(System.in);

    public int showMainMenu() {
        System.out.println("=========== Menu do Mercado ===========");
        System.out.println("1 - Cadastrar Produto");
        System.out.println("2 - Listar Produtos");
        System.out.println("3 - Cadastrar Usuário");
        System.out.println("4 - Listar Usuários");
        System.out.println("5 - Realizar venda");
        System.out.println("6 - Sair");
        System.out.println("=======================================");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public Product getProductData() {
        scanner.nextLine();
        System.out.print("Digite o nome do produto: ");
        String name = scanner.nextLine();
        System.out.print("Digite o preço do produto: ");
        double price = scanner.nextDouble();

        return new Product(name, price);
    }

    public User getUserData() {
        scanner.nextLine();
        System.out.print("Digite o nome do usuário: ");
        String name = scanner.nextLine();
        System.out.print("Digite o email do usuário: ");
        String email = scanner.nextLine();
        System.out.print("Digite a senha do usuário: ");
        String password = scanner.nextLine();

        return new User(name, email, password);
    }

    public void showAllProducts(List<Product> products) {
        System.out.println("\n=========== Lista de Produtos ===========");
        products.forEach(System.out::println);
        System.out.println("=========================================\n");
    }

    public void showAllUsers(List<User> users) {
        System.out.println("\n=========== Lista de Usuários ===========");
        users.forEach(System.out::println);
        System.out.println("========================================\n");
    }
}
