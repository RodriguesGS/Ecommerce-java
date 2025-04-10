package org.example.model;

import java.util.UUID;

public abstract class Entity {
    private final UUID id;

    public Entity() {
        this.id = UUID.randomUUID();
    }

    public Entity(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
