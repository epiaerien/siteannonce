package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Annonce;
import com.inti.model.Commentaire;
import com.inti.model.User;
import com.inti.service.IAnnonceService;
import com.inti.service.ICommentaireService;

@Controller
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class CommentaireController {

	
	@Autowired
	ICommentaireService comService; 
	
	@Autowired
	IAnnonceService annonceservice;
	
	/*
	@RequestMapping("/AfficheFormCommentaire")
	public String ajout(@RequestParam("id") int id, Model model)
	{
		Commentaire commentaire = new Commentaire(); 
		model.addAttribute("commentaire", commentaire); 
		model.addAttribute("idannonce", id);
		
		return"AjoutCommentaire";
	}
	
	
	@RequestMapping("/saveCommentaire")
	public String saveCommentaire(@ModelAttribute("commentaire") Commentaire c,@RequestParam("idannonce") int idannonce)
	
	{
		Annonce annonce=annonceservice.getById(idannonce);
		c.setAnnonce(annonce);
		comService.ajout(c);
		return "redirect:/Annonces";
	}*/
	
	
	
}
