package com.example.myanimelist.repository;

import com.example.myanimelist.model.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SerieRepository extends MongoRepository<Serie, UUID> {

    public Serie findByName(String name);
}
