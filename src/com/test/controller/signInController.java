package com.test.controller;
 

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
 

import com.test.bean.Student;
import com.test.bean.User;
import com.test.bl.StudentLogic;


@Controller
@SessionAttributes({"admin","user"})
public class signInController {
	 
	@RequestMapping("/Admin")
	  public String signIn(ModelMap model,User user,HttpServletRequest request,HttpSession session) throws ClassNotFoundException, IOException, SQLException{
			
		StudentLogic sl=new StudentLogic();
		Student student=sl.search(user.getUsername());
		try
		{
			if(user.getUsername().equals("admin") && user.getPassword().equals("admin")){
			model.addAttribute("user",user);
			request.setAttribute("admin", "admin");
		    return "./Admin/adminSignIn";
			}
			else if(user.getUsername().equals(student.getUsername()) && user.getPassword().equals(student.getPassword())){
				
				model.addAttribute("student", student);
				request.setAttribute("user",user.getUsername() );
				session.setAttribute("sessionUserName",user.getUsername());
				return "./Student/student";
			}
		}
		catch(Exception ee)
		{
			Student studentNew=new Student();
			model.addAttribute("student", studentNew);
			User userNew=new User();
			model.addAttribute("user",userNew);
		   return "./home";
		}
		Student studentNew=new Student();
		model.addAttribute("student", studentNew);
		User userNew=new User();
		model.addAttribute("user",userNew);
		return "./home";
	} 
	  @RequestMapping("/LoginPage")
	 public String signout(ModelMap model)
	 {
		  Student student=new Student();
			model.addAttribute("student", student);
			User user=new User();
			model.addAttribute("user",user);
		 return "./home";
	 }
}

	 
