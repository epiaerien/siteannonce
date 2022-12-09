package com.inti.service;

import java.util.List;
import java.util.Optional;

import com.inti.model.Categorie;

public interface ICategorieService {
	public void ajout(Categorie c);

	public Categorie getById(int id );

	public List<Categorie> getAll();

	public void modifier(Categorie c);

	public void supprimer(int id);

public Categorie chercherParCat(String nom);
}
