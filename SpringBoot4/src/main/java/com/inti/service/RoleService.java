package com.inti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.dao.IRoleDao;
import com.inti.model.Role;

@Service
public class RoleService implements IRoleService {

	@Autowired 
	IRoleDao rDao;

	public IRoleDao getrDao() {
		return rDao;
	}

	public void setrDao(IRoleDao rDao) {
		this.rDao = rDao;
	} 
	
	public void ajout(Role r)
	{
		rDao.save(r);
	}
	
	public Role getById(int id )
	{
		Optional<Role> optu = rDao.findById(id); 
		return optu.get(); 
	}

	public List<Role> getAll()
	{
		List<Role> roles = rDao.findAll(); 
		return roles; 
		
	}

	public void modifier(Role r)
	{
		rDao.save(r);
		
	}

	public void supprimer(int id)
	{
		rDao.deleteById(id); 
	}
	
}
