package com.inti.service;

import java.util.List;
import java.util.Optional;

import com.inti.model.Role;

public interface IRoleService {
	public void ajout(Role r);
	
	public Role getById(int id );

	public List<Role> getAll();

	public void modifier(Role r);

	public void supprimer(int id);

}
