package com.bisystem.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bisystem.dao.UserDao;
import com.bisystem.model.AppUser;


@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private UserService userService;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		AppUser user = userService.getUserInfo(username);
		GrantedAuthority authority = new SimpleGrantedAuthority(user.getPassword());
		UserDetails userDetails = (UserDetails)new User(user.getUsername(), 
				user.getPassword(), Arrays.asList(authority));
	
		
		return userDetails;
		
	}

}
