package com.inti.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inti.model.Annonce;
import com.inti.model.Categorie;
import com.inti.model.User;
import com.inti.service.IAnnonceService;
import com.inti.service.ICategorieService;
import com.inti.service.ICommentaireService;
import com.inti.service.IUserService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class AnnonceController {
	
	@Autowired
    IAnnonceService aService; 
    
    @Autowired
    IUserService uService; 
    
    @Autowired
    ICategorieService catService;
    
    @Autowired
    ICommentaireService comService; 
    
    @Autowired
	HttpSession session;
    
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    CustomDateEditor dateEditor = new CustomDateEditor(dateFormat, true);
	    binder.registerCustomEditor(Date.class, dateEditor);
	}
	
/*	@RequestMapping("/Annonces")
	public String afficher(Model model)
	{
		User user=(User)session.getAttribute("user");
		model.addAttribute("user",user);
		List<Annonce> annonces = aService.getAll(); 
		model.addAttribute("annonces", annonces); 
		
		List<User> users = uService.getAll(); 
		model.addAttribute("users", users);
		
		List<Categorie> categories = catService.getAll(); 
		model.addAttribute("categories", categories); 
		List<Commentaire> commentaires = comService.getAll(); 
		model.addAttribute("commentaires", commentaires); 
		
		return "AfficherAnnonce";
	}
	
	@RequestMapping("/chercherParCat")
	public String chercher(@RequestParam("id_categorie") int id,Model model)
	{
	List<Annonce> annonces=	aService.chercherParIdCat(id);
	model.addAttribute("annonces", annonces); 
	List<Categorie> categories = catService.getAll(); 
	model.addAttribute("categories", categories); 
		
	return "AfficherAnnonce";
	}
	
	
	@RequestMapping("/DetailAnnonce")
	public String detail(@RequestParam("id") int id, Model model)
	{
		Annonce annonce = aService.getById(id); 
		model.addAttribute("annonce", annonce); 
		//List<Commentaire> commentaires = comService.getAll(); 
		//model.addAttribute("commentaires", commentaires);
		return "DetailAnnonce"; 
	}
	@RequestMapping("/afficherFormAnnonce")
	public String ajouter(Model model)
	
	{
		List<Categorie> categories = catService.getAll(); 
		model.addAttribute("categories", categories); 
		Annonce annonce = new Annonce(); 
		model.addAttribute("annonce",annonce);
		return "AjoutAnnonce";
		
	}
	
	@RequestMapping("/saveAnnonce")
	public String entregistrer(@ModelAttribute("annonce") Annonce a,@RequestParam("file") MultipartFile file,HttpSession session)
	{
		String path=session.getServletContext().getRealPath("/");  
		
		String filename= file.getOriginalFilename();
		
		a.setPhoto("/dossierimage/"+filename);
		

		try{  
	        byte barr[]=file.getBytes();  
	          
	        BufferedOutputStream bout=new BufferedOutputStream(  
	                 new FileOutputStream(path+"/dossierimage/"+filename));  
	        bout.write(barr);  
	        bout.flush();  
	        bout.close();  
	          
	        }catch(Exception e){System.out.println(e);} 
		
		aService.ajout(a);
		
		return  "redirect:/Annonces";
	}
	
	@RequestMapping("/mesannonces")
	public String utilisateur(Model model )
	{
		User user=(User)session.getAttribute("user");
		model.addAttribute("user",user);
		
		List<Annonce> annonces = aService.chercherParUser(user);
		model.addAttribute("annonces", annonces);
		
	
		return "AnnonceUser"; 
	}
	
	@RequestMapping("/supprimerAnnonce")
	public String supprimerAnnonce(@RequestParam("id") int id)
	{
		
		aService.supprimer(id);
		return "redirect:/mesannonces"; 
	}
	*/
	
	@GetMapping("/annonces")
	public List<Annonce> getAll()
	{
		List<Annonce> listes = aService.getAll();
		return listes;
	}
	
	@GetMapping("/annonces/{id}")
	public Annonce chercher(@PathVariable("id") int id)
	{
		Annonce annonce = aService.getById(id);
		return annonce; 
	}
	
	@PostMapping("/annonces")
	public void ajout(@RequestBody Annonce a )
	{ aService.ajout(a);
	}
	
	@DeleteMapping("/annonces/{id}")
	public void supprimer(@PathVariable("id") int id)
	{
		aService.supprimer(id);
	}
	
	
}
