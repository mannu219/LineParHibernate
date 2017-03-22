package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

 
import com.test.bean.Student;
import com.test.bean.User;

@Controller
public class HomePageController {
	
	/*------------------------------- Redirect Home Page ----------------------------*/
	
	@RequestMapping("/")
	  public String homepage(ModelMap model){
		Student student=new Student();
		model.addAttribute("student", student);
		User user=new User();
		model.addAttribute("user",user);
		    return "./home";
	  }

	/*------------------------------- Redirect Home Page ----------------------------*/
	
	@RequestMapping("/back")
	public String back(ModelMap model){
		Student student=new Student();
		model.addAttribute("student", student);
		User user=new User();
		model.addAttribute("user",user);
		return "./home";
	}
}
