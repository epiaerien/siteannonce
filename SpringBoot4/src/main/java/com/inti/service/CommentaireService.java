package com.inti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.dao.ICommentaireDao;
import com.inti.model.Commentaire;

@Service
public class CommentaireService implements ICommentaireService {

	
	@Autowired
	ICommentaireDao cDao;

	public ICommentaireDao getcDao() {
		return cDao;
	}

	public void setcDao(ICommentaireDao cDao) {
		this.cDao = cDao;
	} 
	
	public void ajout(Commentaire c)
	{
		cDao.save(c);
	}
	
	public Commentaire getById(int id )
	{
		Optional<Commentaire> opt = cDao.findById(id); 
		return opt.get(); 
	}

	public List<Commentaire> getAll()
	{
		List<Commentaire> Commentaires = cDao.findAll(); 
		return Commentaires; 
		
	}

	public void modifier(Commentaire c)
	{
		cDao.save(c);
		
	}

	public void supprimer(int id)
	{
		cDao.deleteById(id); 
	}
}
