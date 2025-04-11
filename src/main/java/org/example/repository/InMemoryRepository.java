package org.example.repository;

import org.example.model.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class InMemoryRepository <T extends Entity> implements EntityRepository <T> {
    private final ArrayList<T> dataStore = new ArrayList<>();

    @Override
    public void save(T entity) {
        this.dataStore.removeIf(e -> e.getId().equals(entity.getId()));
        this.dataStore.add(entity);
    }

    @Override
    public Optional<T> findById(UUID id) {
        return this.dataStore.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(this.dataStore);
    }

    @Override
    public void deleteById(UUID id) {
        this.dataStore.removeIf(e -> e.getId().equals(id));
    }
}
