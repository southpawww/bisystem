package com.bisystem.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bisystem.model.User;
import com.bisystem.service.UserService;

@Controller
public class UserController {
	
	
	private UserService userService;
	
	@Autowired(required=true)
	public void setUserService(UserService ps){
		this.userService = ps;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listUsers(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("listUsers", this.userService.listUsers());
		return "index";
	}
	
	//For add and update user both
	@RequestMapping(value= "/user/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User p){
		
		if(p.getId() == 0){
			//new person, add it
			this.userService.addUser(p);
		}else{
			//existing person, call update
			this.userService.updateUser(p);
		}
		
		return "redirect:/users";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id){
		
        this.userService.removeUser(id);
        return "redirect:/users";
    }
 
    @RequestMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUser", this.userService.listUsers());
        return "user";
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
    
    