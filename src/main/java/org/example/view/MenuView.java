package org.example.view;

import org.example.model.Product;
import org.example.model.Sales;
import org.example.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

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

    public void showSale(Sales sales) {
        System.out.println("\nResumo de venda:");
        System.out.println("Cliente: " + sales.getUser().getName());
        System.out.println("Produtos: ");
        for (Product product : sales.getProducts()) {
            System.out.print("- " + product.getName() + "\n");
        }
        System.out.println("Pagamento: " + sales.getPaymentMethod());
        System.out.println("\nVenda registrada com sucesso!!");
    }

    public String getEmailSales() {
        scanner.nextLine();
        System.out.print("\nDigite o email do usuário: ");
        return scanner.nextLine();
    }

    public List<UUID> getProductIdForSale() {
        System.out.print("\n\nDigite os IDs dos produtos (separados por vírgula): ");
        String[] id = scanner.nextLine().split(",");
        List<UUID> productId = new ArrayList<>();

        for (String ids : id) {
            productId.add(UUID.fromString(ids));
        }

        return productId;
    }

    public String getPaymentMethod() {
        System.out.println("\nEscolha a forma de pagamento");
        System.out.println("1 - Dinheiro");
        System.out.println("2 - Cartão de Crédito");
        System.out.println("3 - Cartão de Débito");
        System.out.println("4 - Boleto");
        System.out.println("5 - Pix");
        System.out.print("Escolha a opção: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1: return "CASH";
            case 2: return "CREDIT_CARD";
            case 3: return "DEBIT_CARD";
            case 4: return "BILLET";
            case 5: return "PIX";
            default:
                System.out.println("Opção inválida. Usando Dinheiro como padrão.");
                return "CASH";
        }
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
