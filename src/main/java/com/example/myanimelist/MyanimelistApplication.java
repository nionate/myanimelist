package com.example.myanimelist;

import com.example.myanimelist.model.Serie;
import com.example.myanimelist.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class MyanimelistApplication implements CommandLineRunner{

	@Autowired
	private SerieRepository serieRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyanimelistApplication.class, args);
	}

	@Override
	public void run(String... args) throws  Exception{

		serieRepository.deleteAll();

		Serie serie1 = new Serie(UUID.randomUUID(), "Naruto");
		Serie serie2 = new Serie(UUID.randomUUID(), "Bleach");
		Serie serie3 = new Serie(UUID.randomUUID(), "One Piece");

		serieRepository.save(serie1);
		serieRepository.save(serie2);
		serieRepository.save(serie3);

		for(Serie serie : serieRepository.findAll()) {

			System.out.println(serie.toString());
		}


	}
}
