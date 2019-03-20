package com.bisystem.web.controller;


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
import com.bisystem.service.UserProfileService;
import org.hibernate.SessionFactory;
@Controller
public class UserController {
	
	

	
	
	
	private UserService userService;
	private UserProfileService  userProfileService;
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService ps){
		this.userService = ps;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listUsers(Model model,@RequestParam("action")	 String requestParam){
		model.addAttribute("user", new User());
		model.addAttribute("listUsers", this.userService.listUsers());
		
		model.addAttribute("message","User successfully " +requestParam+".");
		
		return "admin/userAdministration";
	}
	
	@RequestMapping(value = "/admin/addusers", method = RequestMethod.GET)
	public String loadUsers(Model model) {
		model.addAttribute("user", new User());
	
		 model.addAttribute("showprofile", "true");
		// test show profile
		 
		model.addAttribute("listUsers", this.userService.listUsers());
	    model.addAttribute("name",this.userService.listUsers().get(0).getUserProfile().getName());
	    model.addAttribute("surname",this.userService.listUsers().get(0).getUserProfile().getSurname());
	    model.addAttribute("email",this.userService.listUsers().get(0).getUserProfile().getEmail());
		
		return "admin/userAdministration";
	}
	
	
	
	//For add and update user both
	@RequestMapping(value= "/user/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User p){
		
		UserProfile up = p.getUserProfile();
		up.setUser(p);
		p.setUserProfile(up);
		if(p.getId() == 0){
			//new person, add it
		
			this.userService.addUser(p);
			return "redirect:/users?action=added";
		}else{
			//existing person, call update
			
			this.userService.updateUser(p);
			return "redirect:/users?action=edited";
		}
		
	
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id){
		
        this.userService.removeUser(id);
        return "redirect:/users";
    }
 
    @RequestMapping("/profile/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.listUsers());
        model.addAttribute("showprofile", "true");
        return "admin/userAdministration";
    }
   
    
    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");

		return model;

	}
    /*
    //controllers for test:
    @RequestMapping(value = {"/adminPage"}, method = RequestMethod.GET)
	public ModelAndView adminPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("adminPage");
		return model;
	}
    */
   
}
    
    
