package com.inti.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.Message;
import com.inti.model.User;

public interface IMessageDao extends JpaRepository<Message, Integer> {

	public List<Message> findByUser(User u); 
}
