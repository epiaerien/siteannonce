package com.inti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.dao.ICategorieDao;
import com.inti.model.Categorie;

@Service
public class CategorieService implements ICategorieService {
@Autowired
ICategorieDao cDao;

public ICategorieDao getcDao() {
	return cDao;
}

public void setcDao(ICategorieDao cDao) {
	this.cDao = cDao;
} 

public Categorie chercherParCat(String nom)
{
	return cDao.findByNom(nom);
}
public void ajout(Categorie c)
{
	cDao.save(c);
}

public Categorie getById(int id )
{
	Optional<Categorie> opt = cDao.findById(id); 
	return opt.get(); 
}

public List<Categorie> getAll()
{
	List<Categorie> categories = cDao.findAll(); 
	return categories; 
	
}

public void modifier(Categorie c)
{
	cDao.save(c);
	
}

public void supprimer(int id)
{
	cDao.deleteById(id); 
}

}
