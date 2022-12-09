package com.inti.service;

import java.util.List;

import com.inti.model.Annonce;
import com.inti.model.User;

public interface IAnnonceService {
	public void ajout(Annonce a);
	public void modifier(Annonce a );
	
	public Annonce getById(int id );

	public List<Annonce> getAll();
	public void supprimer(int id);
	public List<Annonce> chercherParIdCat(int id); 

	public List<Annonce> chercherParUser(User u);
	
}
