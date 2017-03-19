package com.test.controller;
 

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;

import com.test.bean.Student;
import com.test.bean.User;
import com.test.bl.StudentLogic;


@Controller
@SessionAttributes({"admin","user"})
public class signInController {
	 
	@RequestMapping("/Admin")
	  public String signIn(ModelMap model,User user,HttpServletRequest request) throws ClassNotFoundException, IOException, SQLException{
			
		StudentLogic sl=new StudentLogic();
		Student student=sl.search(user.getUsername());
			 
			if(user.getUsername().equals("admin") && user.getPassword().equals("admin")){
			model.addAttribute("user",user);
			request.setAttribute("admin", "admin");
		    return "./Admin/adminSignIn";
			}
			else if(user.getUsername().equals(student.getUsername())){
				model.addAttribute("student", student);
				request.setAttribute("user",user.getUsername() );
				return "./Student/student";
			}
			else{
		    return "./lost";
			}
		} 
	   
	 
}

	 
