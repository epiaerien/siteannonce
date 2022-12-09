package com.inti.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categorie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	private String nom; 
	
	@OneToMany(mappedBy="categorie")
	private List<Annonce> annonce;

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

	public List<Annonce> getAnnonce() {
		return annonce;
	}

	public void setAnnonce(List<Annonce> annonce) {
		this.annonce = annonce;
	}

	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
}
