package com.inti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.dao.IAnnonceDao;
import com.inti.model.Annonce;
import com.inti.model.User;

@Service
public class AnnonceService implements IAnnonceService {

	@Autowired
	IAnnonceDao aDao;

	public IAnnonceDao getaDao() {
		return aDao;
	}

	public void setaDao(IAnnonceDao aDao) {
		this.aDao = aDao;
	} 
	
	public List<Annonce> chercherParUser(User u)
	{
		return aDao.findByUser(u);
	}
	
	public List<Annonce> chercherParIdCat(int id)
	{
		return aDao.findByCategorie_id(id); 
	}
	public void ajout(Annonce a)
	{
		aDao.save(a); 
	}
	
	public void modifier(Annonce a )
	{
		aDao.save(a);
	}
	
	public Annonce getById(int id )
	{
		Optional<Annonce> opt = aDao.findById(id); 
		return opt.get(); 
	}

	public List<Annonce> getAll()
	{
		List<Annonce> annonces = aDao.findAll(); 
		return annonces; 
		
	}
	public void supprimer(int id)
	{
		aDao.deleteById(id); 
	}
}
