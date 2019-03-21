package com.bisystem.web.controller;


import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bisystem.model.User;
import com.bisystem.model.UserProfile;
import com.bisystem.service.UserService;

@Controller
public class UserController {

	private UserService userService;
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService ps){
		this.userService = ps;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listUsers(Model model,@RequestParam(required = false, name="action")	 String requestParam ){
		model.addAttribute("user", new User());
		model.addAttribute("listUsers", this.userService.listUsers());
		
		model.addAttribute("message","User successfully " +requestParam+".");
		
		return "admin/userAdministration";
	}
	
	@RequestMapping(value = "/admin/addusers", method = RequestMethod.GET)
	public String loadUsers(Model model) {
		
		model.addAttribute("user", new User()); 
		model.addAttribute("listUsers", this.userService.listUsers());
	   		
		return "admin/userAdministration";
	}
	
	
	
	//For add and update user both
	@RequestMapping(value= "/user/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User p){
		UserProfile up = p.getUserProfile();
		up.setUser(p);
		p.setUserProfile(up);
		
			//new person, add it
		
			this.userService.addUser(p);
	    	return "redirect:/users?action=added";
		
	}
	
	@RequestMapping(value= "/user/edit", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("userProfile") User p){
		
			
			//existing person, call update
	    	UserProfile up = p.getUserProfile();
	    	up.setUser(p);
		    p.setUserProfile(up);
			this.userService.upUser(p);
			return "redirect:/users?action=edited";
		
	}

	
	
	
	@RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id, Model model,@ModelAttribute("user") User p){
		
        this.userService.removeUser(id);
        
        return "redirect:/users?action=deleted";
    }
 
    @RequestMapping("/profile/{id}")
    public String editUser(@PathVariable("id") int id, Model model,@ModelAttribute("user") User p){
        model.addAttribute("userProfile", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.listUsers());
        model.addAttribute("showprofile", "true");
        return "admin/userAdministration";
    }
   
  
  
}
    
    
