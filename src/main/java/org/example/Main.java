package org.example;

import org.example.view.MenuView;

public class Main {
    public static void main(String[] args) {
        MenuView view = new MenuView();
        int option;

        do {
            option = view.showMainMenu();
        } while (option != 6);
    }
}