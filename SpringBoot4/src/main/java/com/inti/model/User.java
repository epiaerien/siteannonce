package com.inti.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	private String nom; 
	private String prenom;
	private Date age; 
	private String email; 
	private String username; 
	private String password; 
	
	@ManyToOne
	@JoinColumn(name = "id_role")
	@JsonIgnore
	private Role role;
	
	@OneToMany(mappedBy="user")
	@JsonIgnore
	private List<Annonce> annonce; 

	@ManyToMany
	@JoinTable( name = "Message_User_Associations",
    joinColumns = @JoinColumn( name = "id_user" ),
    inverseJoinColumns = @JoinColumn( name = "id_message" ) )
	@JsonIgnore
	private List<Message> message; 
	
	
	
	public List<Annonce> getAnnonce() {
		return annonce;
	}



	public void setAnnonce(List<Annonce> annonce) {
		this.annonce = annonce;
	}



	public List<Message> getMessage() {
		return message;
	}



	public void setMessage(List<Message> message) {
		this.message = message;
	}



	public Date getAge() {
		return age;
	}



	public void setAge(Date age) {
		this.age = age;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public User() {
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	} 
	
	
}
