package com.bisystem.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.bisystem.model.Login;


@Controller
public class ErrorController {
/*
	@ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		model.addObject("login", new Login());
		model.setViewName("/loginPage");
		return model;
	}
	*/
	
	
	 @RequestMapping(value = "errors", method = RequestMethod.GET)
	    public ModelAndView renderErrorPage(@ModelAttribute("login") Login login,HttpServletRequest httpRequest) {
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
	        ModelAndView errorPage = new ModelAndView("errorPage");
	        
	        String errorMsg = "";
	        int httpErrorCode = getErrorCode(httpRequest);
	 
	        switch (httpErrorCode) {
	            case 400: {
	                errorMsg = "Http Error Code: 400. Bad Request";
	          
	                break;
	            }
	            case 401: {
	                errorMsg = "Http Error Code: 401. Unauthorized";
	                break;
	            }
	            case 404: {
	              if(!(auth instanceof AnonymousAuthenticationToken))
	            	  errorPage.setViewName("homePage");
	              else errorPage.setViewName("loginPage");
	                break;
	            }
	            case 500: {
	                errorMsg = "Http Error Code: 500. Internal Server Error";
	                break;
	            }
	        }
	       
	        return errorPage;
	    }
	     
	    private int getErrorCode(HttpServletRequest httpRequest) {
	        return (Integer) httpRequest
	          .getAttribute("javax.servlet.error.status_code");
	    }
	   
}
