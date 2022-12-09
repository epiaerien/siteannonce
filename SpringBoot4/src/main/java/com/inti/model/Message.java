package com.inti.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	
	private String nom; 
	private Date envoi; 
	
	@ManyToOne
	@JoinColumn(name = "id_annonce")
	private Annonce annonce; 
	
	
	@ManyToMany(mappedBy="message")
	private List<User> user;


	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}


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


	public Date getEnvoi() {
		return envoi;
	}


	public void setEnvoi(Date envoi) {
		this.envoi = envoi;
	}


	public Annonce getAnnonce() {
		return annonce;
	}


	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}


	public List<User> getUser() {
		return user;
	}


	public void setUser(List<User> user) {
		this.user = user;
	} 
	
	
}
