package com.inti.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Annonce;
import com.inti.model.Message;
import com.inti.model.User;
import com.inti.service.IAnnonceService;
import com.inti.service.IMessageService;
import com.inti.service.IUserService;

@Controller
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class MessageController {

	
	@Autowired 
	IMessageService mService; 
	@Autowired
	IAnnonceService aService;
	@Autowired 
	IUserService uService; 
	@Autowired
    private JavaMailSender emailSender;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/AfficherFormMessage")
	public String afficherform(@RequestParam("id") int id, Model model)
	{
		Message message = new Message(); 
		model.addAttribute("message",  message); 
		model.addAttribute("idannonce", id);
		return "AjoutMessage"; 
	}
	
	@RequestMapping("/saveMessage")
	public String saveMessage(@ModelAttribute("message") Message m,@RequestParam("idannonce") int idannonce  )
	{
		Annonce annonce = aService.getById(idannonce); 
		User user = uService.chercherparidAnnonce(idannonce);
		User userex=(User)session.getAttribute("user");
		
		List<User> users=new ArrayList<>();
		
		users.add(userex);
		users.add(user);
		m.setUser(users);
		m.setAnnonce(annonce); 
		
		
		mService.ajout(m);
		
		
		return "redirect:/Annonces"; 
	}
	
	@RequestMapping("/mesmessages")
	public String mesmessages( Model model)
	{
		User user=(User)session.getAttribute("user");
		model.addAttribute("user",user);
		
		List<Message> messages = mService.chercherparUser(user);
		model.addAttribute("messages", messages);
		
		return "MessageUser";
	}
}
