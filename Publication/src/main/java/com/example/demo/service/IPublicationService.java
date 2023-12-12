package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Publication;

public interface IPublicationService {
	Publication addPublication(Publication publication);

	Publication findPublication(Long id);

	List<Publication> findAll();

	void deletePublication(Long id);

	Publication updatePublication(Publication publication);
}
