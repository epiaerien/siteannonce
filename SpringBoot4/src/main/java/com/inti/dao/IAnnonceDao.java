package com.inti.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.Annonce;
import com.inti.model.User;

public interface IAnnonceDao extends JpaRepository<Annonce, Integer>{

	
	//public List<Annonce> findByCategorie(Categorie c);
	public List<Annonce> findByCategorie_id(int id);
	
	public List<Annonce> findByUser(User u);
	
}
