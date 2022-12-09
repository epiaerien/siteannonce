package com.inti.service;

import java.util.List;
import java.util.Optional;

import com.inti.model.Commentaire;

public interface ICommentaireService {
	public void ajout(Commentaire c);
	public Commentaire getById(int id );

	public List<Commentaire> getAll();

	public void modifier(Commentaire c);

	public void supprimer(int id);
}
