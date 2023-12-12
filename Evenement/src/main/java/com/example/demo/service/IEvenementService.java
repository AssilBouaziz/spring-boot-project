package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Evenement;

public interface IEvenementService {
	// Crud sur les Evenements
	public Evenement addEvenement(Evenement m);

	public void deleteEvenement(Long id);

	public Evenement updateEvenement(Evenement p);

	public Evenement findEvenement(Long id);

	public List<Evenement> findAll();
}
