package com.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.Commentaire;

public interface ICommentaireDao extends JpaRepository<Commentaire, Integer> {

}
