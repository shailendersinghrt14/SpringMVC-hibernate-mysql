package com.wells.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.wells.bean.User;
import com.wells.service.UserService;

@Controller
public class MainController {
	    @Autowired
	    private UserService userService;
	    
	    
	    @RequestMapping("/")
	    String redirectPage() {
			return "redirect:/login";}
	    @RequestMapping("/login")
	    ModelAndView doLogin(){
		List<User> listuser=userService.listUser();
		ModelAndView mv =new ModelAndView("index");
		mv.addObject("hello", "Hii this the login page.");
		mv.addObject("list", listuser);
		return mv ;
		
		
	}
	
	
	
	    @RequestMapping("/save")
        ModelAndView doSave(@ModelAttribute User user){
		userService.createUser(user);
		System.out.println("save method ");
		ModelAndView mv =new ModelAndView("redirect:/login");
		 return mv;
		}
		
	@RequestMapping(value = "/edit/{id}", method=RequestMethod.GET)
	public ModelAndView getEdit(@PathVariable Integer id){
		ModelAndView mv =new ModelAndView("edit");
		mv.addObject("id",id);
	    return mv;
	
	}
	
		@RequestMapping("/saveedit")
		ModelAndView doSaveEdit(@ModelAttribute User user) {
		ModelAndView mv =new ModelAndView("redirect:/login");
		userService.upadateUser(user);
		return mv;
		}
		
		
		@RequestMapping(value = "/delete/{id}", method=RequestMethod.GET)
		public ModelAndView getDeleter(@PathVariable Integer id){
			ModelAndView mv =new ModelAndView("redirect:/login");
			
			userService.delete(id);
			return mv;
		
		}
	
	
	
	
	
	
	
	
	
	
	
	

	

		
	

}
