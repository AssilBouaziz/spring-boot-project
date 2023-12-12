package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Evenement;
import com.example.demo.service.IEvenementService;

public class EvenementRestController {
	@Autowired
	IEvenementService evenementService;

	@RequestMapping(value = "/evenements", method = RequestMethod.GET)
	public List<Evenement> findEvenements() {
		return evenementService.findAll();
	}

	@PostMapping(value = "/evenements/evenement")
	public Evenement addEvenement(@RequestBody Evenement e) {
		return evenementService.addEvenement(e);
	}

	@DeleteMapping(value = "/evenements/{id}")
	public void deleteEvenement(@PathVariable Long id) {
		evenementService.deleteEvenement(id);
	}

	@PutMapping(value = "/evenements/{id}")
	public Evenement updatevenement(@PathVariable Long id, @RequestBody Evenement e) {
		e.setId(id);
		return evenementService.updateEvenement(e);
	}
}
