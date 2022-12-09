package com.inti.service;

import java.util.List;
import java.util.Optional;

import com.inti.dao.IUserDao;
import com.inti.model.User;

public interface IUserService {
	public User chercherparUsernname(String user_name);

	
	public void ajout(User u);
	
	public User getById(int id );

	public List<User> getAll();

	public void modifier(User u);

	public void supprimer(int id);
	
	public User chercherparidAnnonce(int id);
}
