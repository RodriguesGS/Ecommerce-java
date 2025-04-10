package org.example.view;

import java.util.Scanner;

public class MenuView {
    private final Scanner scanner = new Scanner(System.in);

    public int showMainMenu() {
        System.out.println("=========== Menu do Mercado ===========");
        System.out.println("1 - Cadastrar Produto");
        System.out.println("2 - Lista dos Produtos");
        System.out.println("3 - Cadastrar Usuário");
        System.out.println("4 - Lista dos Usuários");
        System.out.println("5 - Realizar venda");
        System.out.println("6 - Sair");
        System.out.println("=======================================");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }
}
