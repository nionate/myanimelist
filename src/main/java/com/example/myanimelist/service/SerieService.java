package com.example.myanimelist.service;

import com.example.myanimelist.model.Serie;

import java.util.List;

public interface SerieService {

    List<Serie> findAll();
    Serie findOneByName(String name);
}
