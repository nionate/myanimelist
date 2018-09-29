package com.example.myanimelist.model;

import org.springframework.data.annotation.Id;

import java.util.UUID;

public class Serie {

    @Id
    private UUID id;

    private String name;
    private String state;
    private String synopsis;
    private int episodes;

    public Serie() {
    }

    public Serie(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public Serie(UUID id, String name, String state, String synopsis, int episodes) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.synopsis = synopsis;
        this.episodes = episodes;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
