package com.example.myanimelist.model;

import org.springframework.data.annotation.Id;

import java.util.UUID;

public class Serie {

    @Id
    private UUID id;

    private String name;

    public Serie(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
