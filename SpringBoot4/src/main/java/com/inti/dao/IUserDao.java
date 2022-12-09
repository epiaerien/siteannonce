package com.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.User;

public interface IUserDao extends JpaRepository<User, Integer> {

	public User findByUsername(String user_name);
	
	public User findByAnnonce_id(int id); 
}
