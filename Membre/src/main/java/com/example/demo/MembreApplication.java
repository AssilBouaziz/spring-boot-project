package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.example.demo.dao.MemberRepository;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.service.IMemberService;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@EnableConfigServer
public class MembreApplication implements CommandLineRunner {

	@Autowired
	MemberRepository memberRepo;
	IMemberService memberService;

	public static void main(String[] args) {
		SpringApplication.run(MembreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// etudiant 1
		Etudiant etd1 = Etudiant.builder().cin("123456").dateInscription(new Date()).dateNaissance(new Date())
				.diplome("mastère").email("etd1@gmail.com").password("pass1").cv("cv1").nom("bouaziz").prenom("assil")
				.sujet("blockchain").build();
		System.out.println("inserting");

		memberRepo.save(etd1);
		System.out.println("inserted");
		// Etudiant 2
		Etudiant etd2 = Etudiant.builder().cin("22222222").dateInscription(new Date()).dateNaissance(new Date())
				.diplome("mastère").email("etd2@gmail.com").password("pass2").cv("cv2").nom("FLEN").prenom("FOULENI")
				.sujet("Cloud").build();
		System.out.println("inserting");

		memberRepo.save(etd2);
		System.out.println("inserted");

		// Enseignat
		EnseignantChercheur ens1 = EnseignantChercheur.builder().cin("126496").nom("Riadh").prenom("Salah")
				.dateNaissance(new Date()).cv("skssslsmm").email("sjskslsms").password("passs3").grade("Docteur")
				.etablissement("ENIS").build();
		System.out.println("inserting");

		memberRepo.save(ens1);
		System.out.println("inserted");
		/*
		 * // affecter des pubs a des auteurs
		 * memberService.affecterauteurTopublication(1L, 1L);
		 * memberService.affecterauteurTopublication(2L, 2L);
		 * memberService.affecterauteurTopublication(3L, 3L);
		 */
	}
}