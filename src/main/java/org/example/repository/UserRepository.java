package org.example.repository;

import org.example.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserRepository implements EntityRepository<User> {
    private final Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(User user) {
        String query = "INSERT INTO users (uuid, name, email, password) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setString(1, user.getId().toString());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<User> findById(UUID id) {
        String query = "SELECT * FROM users WHERE uuid = ?";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setString(1, id.toString());
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                User user = new User(
                        UUID.fromString(resultSet.getString("uuid")),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                );

                return Optional.of(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        String query = "SELECT * FROM users";
        ArrayList<User> users = new ArrayList<>();

        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                users.add(new User(
                        UUID.fromString(resultSet.getString("uuid")),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    @Override
    public void deleteById(UUID id) {
        String query = "DELETE FROM users WHERE uuid = ?";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setString(1, id.toString());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
