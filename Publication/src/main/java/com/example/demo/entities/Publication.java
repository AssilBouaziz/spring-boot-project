package com.example.demo.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Publication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String titre;
	@NonNull
	private String type;// article de journal/ manifestation/chapitre de livre/livre/poster
	@Temporal(TemporalType.DATE)
	@NonNull
	private Date date;
	@NonNull
	private String lien;
	@NonNull
	private String sourcePdf;

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	 * 
	 * @NonNull private String type;
	 * 
	 * @NonNull private String titre;
	 * 
	 * @NonNull private String lien;
	 * 
	 * @NonNull private Date date;
	 * 
	 * @NonNull private String sourcepdf;
	 * 
	 * @Builder
	 * 
	 * public Publication(Long id, @NonNull String type, @NonNull String
	 * titre, @NonNull String lien, @NonNull Date date,
	 * 
	 * @NonNull String sourcepdf) { this.id = id; this.type = type; this.titre =
	 * titre; this.lien = lien; this.date = date; this.sourcepdf = sourcepdf; }
	 */
}