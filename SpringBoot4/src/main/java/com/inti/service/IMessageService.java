package com.inti.service;

import java.util.List;
import java.util.Optional;

import com.inti.model.Message;
import com.inti.model.User;

public interface IMessageService {
	public void ajout(Message m);
	
	public Message getById(int id );

	public List<Message> getAll();
	public void modifier(Message m);

	public void supprimer(int id);

	public List<Message> chercherparUser(User u ); 
}
