package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Publication;
import com.example.demo.service.IPublicationService;

import lombok.AllArgsConstructor;

@CrossOrigin
@RestController
@AllArgsConstructor
public class PublicationRestController {
	IPublicationService publicationService;

	@RequestMapping(value = "/publications", method = RequestMethod.GET)
	public List<Publication> findAllPublications() {
		return publicationService.findAll();
	}

	@GetMapping(value = "/publications/{id}")
	public Publication findPublicationById(@PathVariable Long id) {
		return publicationService.findPublication(id);
	}

	@PostMapping(value = "/publications")
	public Publication addPublication(@RequestBody Publication publication) {
		return publicationService.addPublication(publication);
	}

	@DeleteMapping(value = "/publications/{id}")
	public void deletePublication(@PathVariable Long id) {
		publicationService.deletePublication(id);
	}

	@PutMapping(value = "/publications/{id}")
	public Publication updatePublication(@PathVariable Long id, @RequestBody Publication publication) {
		publication.setId(id);
		return publicationService.updatePublication(publication);
	}
}
