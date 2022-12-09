package com.inti.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Role;
import com.inti.model.User;
import com.inti.service.IRoleService;
import com.inti.service.IUserService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class UserController {

	@Autowired
	IUserService serviceUser;
	
	@Autowired
	IRoleService serviceRole;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	HttpSession session;
	
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    CustomDateEditor dateEditor = new CustomDateEditor(dateFormat, true);
	    binder.registerCustomEditor(Date.class, dateEditor);
	}
	
	
	
	@GetMapping("/users")
	public List<User> getAll()
	{
		List<User> listes = serviceUser.getAll();
		return listes; 
	}
	
	
	@GetMapping("/users/{id}")
	public User chercher(@PathVariable("id") int id )
	{
		 
		User user = serviceUser.getById(id);
		return user; 
	}
	
	
	
	@PostMapping("/users")
	public void ajout(@RequestBody User p)
	{

		serviceUser.ajout(p);
	}

	@DeleteMapping("/users/{id}")
	public void supprimer(@PathVariable("id") int id)
	{

		serviceUser.supprimer(id);
	}

	@PutMapping("/users/{id}")
	public void modifier(@RequestBody User p)
	{
		serviceUser.ajout(p);
	}
	/*@RequestMapping("/User")
	public String afficher(Model model)
	{
		List<User> users = serviceUser.getAll(); 
		model.addAttribute("users", users); 
		User user = new User(); 
		model.addAttribute("user", user);
		List<Role> roles = serviceRole.getAll(); 
		model.addAttribute("roles", roles);
		return "AjoutUser";
	}
	
	
	@RequestMapping("/saveUser")
	public String ajouterUser(@ModelAttribute("user") User u, @RequestParam("id_role") int id_role)
	{
		u.setPassword(encoder.encode(u.getPassword()));
		Role r = serviceRole.getById(id_role);
		u.setRole(r);
		serviceUser.ajout(u);
		
		return "redirect:/User"; 
	}
	
	@RequestMapping("/supprimerUser")
	public String supprimerUser(@RequestParam("id") int id)
	{
		
		serviceUser.supprimer(id);
		return "redirect:/User"; 
	}
	
	@RequestMapping("/modifierUser")
	public String modif(@RequestParam("id") int id, Model model)
	{
		List<User> users = serviceUser.getAll(); 
		model.addAttribute("users", users); 
		User user = new User(); 
		model.addAttribute("user", user);
		List<Role> roles = serviceRole.getAll(); 
		model.addAttribute("roles", roles);
		return "AjoutUser";
	}
	
	@RequestMapping("/afficherForm")
	public String ajouterUser(Model model)
	{
		User user= new User();
		model.addAttribute("user",user);
		return "InscriptionUser";
		
	}
	
	@RequestMapping("/inscription")
	public String inscription(@ModelAttribute("user") User u )
	{
		u.setPassword(encoder.encode(u.getPassword()));
		Role role=serviceRole.getById(2);
		u.setRole(role);
		serviceUser.ajout(u); 
		return "redirect:/afficherLogin"; 
	}
	
	@RequestMapping("/utilisateur")
	public String utilisateur(Model model )
	{
		User user=(User)session.getAttribute("user");
		model.addAttribute("user",user);
		
		//List<User> users = serviceUser.getAll(); 
		//model.addAttribute("users", users); 
		
		return "DetailUser"; 
	}
	*/
	
	
	
	
}


