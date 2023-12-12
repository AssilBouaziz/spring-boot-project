package com.example.demo.beans;

import java.util.Date;

import lombok.Data;

@Data
public class evenementBean {

	private Long id;

	private String titre;

	private Date dateJourJ;

	private String lieu;
}
