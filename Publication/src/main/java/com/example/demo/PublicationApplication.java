package com.example.demo;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.PublicationRepository;
import com.example.demo.entities.Publication;

import lombok.AllArgsConstructor;

@SpringBootApplication
@EnableDiscoveryClient
@AllArgsConstructor
public class PublicationApplication implements CommandLineRunner {

	PublicationRepository publicationRepository;

	public static void main(String[] args) {
		SpringApplication.run(PublicationApplication.class, args);
	}

	public void run(String... args) throws Exception {

		Publication pubs1 = new Publication("article", "an approach for testing soa systems", new Date(), "lien",
				"pdf");
		Publication pubs2 = new Publication("chapitre de livre", "towards cloud computing : issues and challenges",
				new Date(), "lien", "pdf");
		Publication pubs3 = new Publication("article", "introducing blochain systems", new Date(), "lien", "pdf");
		publicationRepository.save(pubs1);
		publicationRepository.save(pubs2);
		publicationRepository.save(pubs3);

		/*
		 * Publication publication1 =
		 * Publication.builder().type("type1").titre("1ere pub").lien("pub.com")
		 * .date(new Date()).sourcepdf("pdf1").build();
		 * System.out.println("inserting Pub1");
		 * publicationRepository.save(publication1);
		 */

		// Publication publication =
		// publicationRepository.findById(publication1.getId()).orElse(null);

		/*
		 * if (publication != null) { System.out.println("Type de la pub : " +
		 * publication.getType()); System.out.println("Titre de la pub : " +
		 * publication.getTitre()); System.out.println("Liende la pub : " +
		 * publication.getLien()); System.out.println("Date de la pub : " +
		 * publication.getDate()); System.out.println("Sourcepdf de la pub : " +
		 * publication.getSourcepdf());
		 * 
		 * } else { System.out.println("Pub non trouvé."); }
		 */
	}
}