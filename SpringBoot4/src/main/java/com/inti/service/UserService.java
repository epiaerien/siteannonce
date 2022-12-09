package com.inti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.dao.IUserDao;
import com.inti.model.User;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	public User chercherparidAnnonce(int id)
	{
		return userDao.findByAnnonce_id(id);
	}
	
	public User chercherparUsernname(String user_name)
	{
		return userDao.findByUsername(user_name);
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	} 
	
	public void ajout(User u)
	{
		userDao.save(u);
	}
	
	public User getById(int id )
	{
		Optional<User> optu = userDao.findById(id); 
		return optu.get(); 
	}

	public List<User> getAll()
	{
		List<User> users = userDao.findAll(); 
		return users; 
		
	}

	public void modifier(User u)
	{
		userDao.save(u);
		
	}

	public void supprimer(int id)
	{
		userDao.deleteById(id); 
	}
	
}
