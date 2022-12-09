package com.inti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.inti.dao.IMessageDao;
import com.inti.model.Message;
import com.inti.model.User;

@Service
public class MessageService implements IMessageService {

	
	@Autowired 
	IMessageDao mDao;
	
	@Autowired
	JavaMailSender mailSender;

	public IMessageDao getmDao() {
		return mDao;
	}

	public void setmDao(IMessageDao mDao) {
		this.mDao = mDao;
	} 
	
	public List<Message> chercherparUser(User u )
	{
		return mDao.findByUser(u);
	}
	public void ajout(Message m)
	{
		SimpleMailMessage message = new SimpleMailMessage(); 
		 
        message.setFrom("maureen.cobert@gmail.com");
        message.setTo(m.getUser().get(1).getEmail()); 
        message.setSubject("Demande d'information"); 
        String me=m.getNom()+" mail envoyé par "+m.getUser().get(0).getEmail();
        message.setText(me);
        mailSender.send(message);
		mDao.save(m);
	}
	
	public Message getById(int id )
	{
		Optional<Message> opt = mDao.findById(id); 
		return opt.get(); 
	}

	public List<Message> getAll()
	{
		List<Message> Messages = mDao.findAll(); 
		return Messages; 
		
	}

	public void modifier(Message m)
	{
		mDao.save(m);
		
	}

	public void supprimer(int id)
	{
		mDao.deleteById(id); 
	}
}
