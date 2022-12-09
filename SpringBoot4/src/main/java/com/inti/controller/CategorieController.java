package com.inti.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Categorie;
import com.inti.model.User;
import com.inti.service.ICategorieService;
@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class CategorieController {

	@Autowired
	ICategorieService catService; 
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/categories")
	public List<Categorie> getAll()
	{
		List<Categorie> listes = catService.getAll();
		return listes; 
	}
	
	
	@GetMapping("/categories/{id}")
	public Categorie chercher(@PathVariable("id") int id )
	{
		 
		Categorie cat = catService.getById(id);
		return cat; 
	}
	
	
	
	@PostMapping("/categories")
	public void ajout(@RequestBody Categorie p)
	{

		catService.ajout(p);
	}

	@DeleteMapping("/categories/{id}")
	public void supprimer(@PathVariable("id") int id)
	{

		catService.supprimer(id);
	}

	@PutMapping("/categories/{id}")
	public void modifier(@RequestBody Categorie p)
	{
		catService.ajout(p);
	}
}
