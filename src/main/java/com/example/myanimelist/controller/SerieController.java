package com.example.myanimelist.controller;

import com.example.myanimelist.model.Serie;
import com.example.myanimelist.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/serie")
public class SerieController {

    @Autowired
    private SerieService serieService;

    @GetMapping("all")
    public ResponseEntity<List<Serie>> all() {
        return ResponseEntity.ok().body(serieService.findAll());
    }

    @GetMapping("{name}")
    public ResponseEntity<Serie> getOneByName(@PathVariable String name) {

        if (name.isEmpty())
            return ResponseEntity.noContent().build();

        Serie foundedSerie = serieService.findOneByName(name);

        if(foundedSerie == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(foundedSerie);
    }
}
