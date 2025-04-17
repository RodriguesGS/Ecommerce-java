package org.example.services;

import org.example.model.PaymentMethod;
import org.example.model.Product;
import org.example.model.Sales;
import org.example.model.User;
import org.example.repository.ProductRepository;
import org.example.repository.SalesRepository;
import org.example.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class SalesService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final SalesRepository salesRepository;

    public SalesService(UserRepository userRepository, ProductRepository productRepository, SalesRepository salesRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.salesRepository = salesRepository;
    }

    public Sales createSale(String email, List<UUID> product, String paymentMethod) {
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("Email não encontrado");
        }

        User user = optionalUser.get();

        List<Product> products = new ArrayList<>();

        for (UUID id : product) {
            Optional<Product> optionalProduct = productRepository.findById(id);

            if (optionalProduct.isEmpty()) {
                throw new RuntimeException("Produto não encontrado");
            }

            products.add(optionalProduct.get());
        }

        double total = products.stream().mapToDouble(Product::getPrice).sum();

        PaymentMethod paymentMethods = PaymentMethod.valueOf(paymentMethod);

        return new Sales(UUID.randomUUID(), user, products, total, paymentMethods);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
