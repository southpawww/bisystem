
package com.bisystem.web.controller;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bisystem.model.Login;
import com.bisystem.model.User;
import com.bisystem.service.LoginService;
import com.bisystem.service.UserService;
import com.bisystem.model.AppUser;

import org.springframework.security.core.userdetails.UserDetails;


@Controller
public class LoginController {
   /* 
    @Autowired(required=true)
    @Qualifier("loginDao")
	LoginService loginService;
   
*/
	@Autowired
   // @Qualifier("loginService")
	private LoginService loginService;
	/*
	public void setLoginDao(LoginService loginService) {
		this.loginService = loginService;
	}
	*/
	 @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("login") Login login,ModelMap model) {
	    ModelAndView mav = new ModelAndView();
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = SecurityContextHolder.getContext().getAuthentication().getName();
	    model.addAttribute("password",name);
      
	  AppUser user = loginService.validateLogin(login);
	  if (null != user) {
		    
		    mav.addObject("firstname", user.getFirstname());
		    mav.addObject("surname",user.getLastname());
		    
		    } else {
		    
		    mav.addObject("message", "Username or Password is wrong!!");
		    }
	    mav.setViewName("homePage");
	    return mav;
	  }
	
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		model.addObject("login", new Login());
		model.setViewName("/loginPage");
		return model;
	}

	@RequestMapping(value = { "/homePage"}, method = RequestMethod.GET)
	public ModelAndView homePage(@ModelAttribute("login") Login login,ModelMap modell) {
		ModelAndView model = new ModelAndView();
		model.setViewName("homePage");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
	    UserDetails userDetails = (UserDetails)auth.getPrincipal();
	    modell.addAttribute("password",userDetails.getUsername());
		return model;
	}
	
	@RequestMapping(value = {"/userPage"}, method = RequestMethod.GET)
	public ModelAndView userPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("userPage");
		return model;
	}
	
	@RequestMapping(value = {"/adminPage"}, method = RequestMethod.GET)
	public ModelAndView adminPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("adminPage");
		return model;
	}
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
	@RequestParam(value = "logout",	required = false) String logout, @ModelAttribute("login") Login login) {
		ModelAndView model = new ModelAndView();
		model.addObject("login", new Login());
		
		
		if (error != null) {
			model.addObject("error", "Invalid Credentials provided.");
		}

		if (logout != null) {
			model.addObject("message", "Logged out from BI system successfully.");
		}
	//	AppUser user = loginService.validateLogin(login);
		  
			  
		
		return model;
	}

	@RequestMapping(value = {"/usermanagement"}, method = RequestMethod.GET)
	public String userManagement() {
		ModelAndView model = new ModelAndView();
		model.addObject("user",new User());
		model.setViewName("index");
		return "redirect:/addusers";
	
		
	}
	
}
