package com.example.demo.entities;

import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@DiscriminatorValue("etd")
@Getter
@Setter
@NoArgsConstructor

public class Etudiant extends Membre {
	@ManyToOne
	EnseignantChercheur encadrant;
	@NonNull
	private String sujet;
	@NonNull
	private Date dateInscription;
	@NonNull
	private String diplome;

	@Builder
	public Etudiant(@NonNull String cin, @NonNull String nom, @NonNull String prenom, @NonNull Date dateNaissance,
			@NonNull String cv, @NonNull String email, @NonNull String password, @NonNull String sujet,
			@NonNull Date dateInscription, @NonNull String diplome) {
		super(cin, nom, prenom, dateNaissance, cv, email, password);
		this.sujet = sujet;
		this.dateInscription = dateInscription;
		this.diplome = diplome;
	}

}
