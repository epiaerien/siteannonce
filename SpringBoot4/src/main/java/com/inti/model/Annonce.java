package com.inti.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Annonce {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	private String titre; 
	private String description; 
	private Date publication; 
	private Date expiration; 
	private String photo; 
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user; 
	
	@OneToMany(mappedBy="annonce")
	private List<Message> message; 
	
	@OneToMany(mappedBy="annonce")
	private List<Commentaire> commentaire; 
	
	@ManyToOne
	@JoinColumn(name="id_categorie")
	private Categorie categorie;

	public Annonce() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPublication() {
		return publication;
	}

	public void setPublication(Date publication) {
		this.publication = publication;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Message> getMessage() {
		return message;
	}

	public void setMessage(List<Message> message) {
		this.message = message;
	}

	public List<Commentaire> getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(List<Commentaire> commentaire) {
		this.commentaire = commentaire;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	} 
	
	
}
