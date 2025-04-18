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
        System.out.println("\n=========== Resumo da Nota ===========");
        System.out.println("Cliente: " + sales.getUser().getName());
        System.out.println("Produtos: ");

        double total = 0;

        for (Product product : sales.getProducts()) {
            System.out.print("- " + product.getName() + "\n");
            total += product.getPrice();
        }

        System.out.printf("Valor total: R$ %.2f%n", total);
        System.out.println("Pagamento: " + sales.getPaymentMethod());
        System.out.println("\nVenda registrada com sucesso!!");
        System.out.println("======================================\n");
    }

    public String getEmailSales() {
        scanner.nextLine();
        System.out.print("\nDigite o email do usuário: ");
        return scanner.nextLine().trim();
    }

    public List<UUID> getProductIdForSale(List<Product> allProducts) {
        System.out.print("\n\nDigite os IDs dos produtos (separados por vírgula): ");
        String[] idStr = scanner.nextLine().split(",");
        List<UUID> productId = new ArrayList<>();

        System.out.println("Produtos Encontrados:");

        for (String idsStr : idStr) {
            try {
                UUID id = UUID.fromString(idsStr);
                productId.add(id);

                allProducts.stream()
                        .filter(p -> p.getId().equals(id))
                        .findFirst()
                        .ifPresentOrElse(
                                p -> System.out.printf("- %s (R$ %.2f)%n", p.getName(), p.getPrice()),
                                () -> System.out.println("- Produto não encontrado.")
                        );
            } catch (IllegalArgumentException e) {
                throw new RuntimeException(e);
            }
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
        System.out.print("Opção: ");
        int option = scanner.nextInt();

        return switch (option) {
            case 1 -> "CASH";
            case 2 -> "CREDIT_CARD";
            case 3 -> "DEBIT_CARD";
            case 4 -> "BILLET";
            case 5 -> "PIX";
            default -> {
                System.out.println("Opção inválida. Usaremos Dinheiro como padrão.");
                yield "CASH";
            }
        };
    }

    public Product getProductData() {
        scanner.nextLine();
        System.out.print("\nDigite o nome do produto: ");
        String name = scanner.nextLine();
        System.out.print("Digite o preço do produto: ");
        double price = scanner.nextDouble();

        return new Product(name, price);
    }

    public User getUserData() {
        scanner.nextLine();
        System.out.print("\nDigite o nome do usuário: ");
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
