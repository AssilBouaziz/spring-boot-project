package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.EvenementRepository;
import com.example.demo.entities.Evenement;

@SpringBootApplication
@EnableDiscoveryClient
public class EvenementApplication implements CommandLineRunner {
	@Autowired
	EvenementRepository evenementService;

	public static void main(String[] args) {
		SpringApplication.run(EvenementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// evenement 1
		Evenement event1 = Evenement.builder().titre("LoremIpsum").dateJourJ(new Date()).dateJourJ(new Date())
				.lieu("darna").build();
		System.out.println("inserting");

	}
}
