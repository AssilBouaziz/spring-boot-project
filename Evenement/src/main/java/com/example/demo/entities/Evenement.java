package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor

public class Evenement implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String titre;
	@NonNull
	private Date dateJourJ;
	@NonNull
	private String lieu;

	@Builder
	public Evenement(@NonNull String titre, @NonNull Date dateJourJ, @NonNull String lieu) {
		this.titre = titre;
		this.dateJourJ = dateJourJ;
		this.lieu = lieu;
	}
}
