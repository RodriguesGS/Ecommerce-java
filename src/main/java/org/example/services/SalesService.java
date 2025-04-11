package org.example.services;

import org.example.model.User;
import org.example.repository.ProductRepository;
import org.example.repository.UserRepository;

import java.util.Optional;

public class SalesService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public SalesService(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
