package com.test.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.bean.Subject;
import com.test.bl.SubjectLogic;
 @Controller
public class SubjectHelper {
	 
	 private SubjectLogic lc=new SubjectLogic();
	 @RequestMapping("/SubjectHelperDelete")
	 public String deleteSub(ModelMap model) throws ClassNotFoundException, IOException, SQLException
	 {
		 List<Subject> sub=lc.displayAll();
		 if(sub!=null)
		 {
			model.addAttribute("subjectDisplay", sub);//use this attribute to display data 
			return "./Admin/AdminSubject/deleteSubject";
			}
		 return "./Admin/adminSignIn";
	 }
	 @RequestMapping("/SubjectHelperDisplay")
	 public String displaySub(ModelMap model) throws ClassNotFoundException, IOException, SQLException
	 {
		 List<Subject> sub=lc.displayAll();
		 if(sub!=null)
			{
			model.addAttribute("subjectDisplay", sub);//use this attribute to display data 
			return "./Admin/AdminSubject/displaySubject";
			}
		 return "./Admin/adminSignIn";
	 }
	 @RequestMapping("/SubjectHelperUpdate")
	 public String updateSub(ModelMap model) throws ClassNotFoundException, IOException, SQLException
	 {
		 List<Subject> sub=lc.displayAll();
		 if(sub!=null)
			{
			model.addAttribute("subjectDisplay", sub);//use this attribute to display data 
			return "./Admin/AdminSubject/updateSubject";
			}
		 return "./Admin/adminSignIn";
	 }
	 @RequestMapping("/SubjectHelperSearch")
	 public String searchSub(ModelMap model) throws ClassNotFoundException, IOException, SQLException
	 {
		 List<Subject> sub=lc.displayAll();
		 if(sub!=null)
			{
			model.addAttribute("subjectDisplay", sub);//use this attribute to display data 
			return "./Admin/AdminSubject/searchSubject";
			}
		 return "./Admin/adminSignIn";
	 }
 }
/*	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		
			try {
				List<Subject> sub=lc.displayAll();
				if(sub!=null)
				{
					session.setAttribute("subjectDisplay", sub);//use this attribute to display data
					if (request.getParameter("display") != null){
				response.sendRedirect("./Admin/AdminSubject/deleteSubject.jsp");
				}
					else if (request.getParameter("display1") != null){
						response.sendRedirect("./Admin/AdminSubject/displaySubject.jsp");
						}
					else if (request.getParameter("display2") != null){
						response.sendRedirect("./Admin/AdminSubject/updateSubject.jsp");
						}
					else if (request.getParameter("display3") != null){
						response.sendRedirect("./Admin/AdminSubject/searchSubject.jsp");
						}
				}
				else
				{
				 
					request.setAttribute("subjectDisplay","Error.");//use this attribute to abstract info
					RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");//change this to appropriate path
					dispatch.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException | NullPointerException e) {
				System.out.println("hell3");
				e.printStackTrace();
			}  
		}
		
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		doGet(request, response);
	}

}
*/