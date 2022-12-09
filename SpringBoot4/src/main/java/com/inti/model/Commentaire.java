package com.inti.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Commentaire {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	
	private String nom; 
	
	
	@ManyToOne
	@JoinColumn(name = "id_annonce")
	private Annonce annonce;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public Annonce getAnnonce() {
		return annonce;
	}


	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}


	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
}
