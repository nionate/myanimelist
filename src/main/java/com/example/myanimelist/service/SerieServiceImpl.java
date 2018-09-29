package com.example.myanimelist.service;

import com.example.myanimelist.model.Serie;
import com.example.myanimelist.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieServiceImpl implements SerieService {

    @Autowired
    private SerieRepository serieRepository;

    @Override
    public List<Serie> findAll() {
        return serieRepository.findAll();
    }

    @Override
    public Serie findOneByName(String name) {
        return serieRepository.findByName(name);
    }
}
