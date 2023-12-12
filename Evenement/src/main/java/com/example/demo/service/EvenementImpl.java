package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EvenementRepository;
import com.example.demo.entities.Evenement;

@Service
public class EvenementImpl implements IEvenementService {
	@Autowired
	EvenementRepository evenementRepository;

	@Override
	public Evenement addEvenement(Evenement e) {
		evenementRepository.save(e);
		return e;
	}

	@Override
	public void deleteEvenement(Long id) {
		evenementRepository.deleteById(id);

	}

	@Override
	public Evenement updateEvenement(Evenement e) {
		return evenementRepository.saveAndFlush(e);
	}

	@Override
	public Evenement findEvenement(Long id) {
		return (Evenement) evenementRepository.findById(id).get();
	}

	@Override
	public List<Evenement> findAll() {
		return evenementRepository.findAll();
	}

}
