package com.inti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inti.model.Role;
import com.inti.model.User;

@Service
public class CustemUserDetailService implements UserDetailsService {

	@Autowired
	IUserService userService; 
	
	
	
	
	
	private List<GrantedAuthority> getGrantedAuthority(User u)
	{
		List<GrantedAuthority> liste = new ArrayList<>(); 
		Role role = u.getRole(); 
		liste.add(new SimpleGrantedAuthority(role.getNom_role()));

		return liste; 
	}

	


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
User user = userService.chercherparUsernname(username);
		
		if (user == null)
		{
			throw new UsernameNotFoundException(username); 
		}
		
		List<GrantedAuthority> autho = getGrantedAuthority(user);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), autho); 
	}
}
