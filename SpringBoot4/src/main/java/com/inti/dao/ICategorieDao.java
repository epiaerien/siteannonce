package com.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.Categorie;

public interface ICategorieDao extends JpaRepository<Categorie, Integer> {
public Categorie findByNom(String nom); 
}
