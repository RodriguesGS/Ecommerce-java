package org.example.model;

import java.util.UUID;

public class User extends Entity {
    private final String name;
    private final String email;
    private final String password;

    public User (UUID id, String name, String email, String password) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public String toString() {
        return String.format("Usuário: %s - Email: %s", this.name, this.email);
    }
}
