package com.test.controller;

 
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.bean.Question;
import com.test.bean.Result;
import com.test.bean.Student;
import com.test.bean.User;
import com.test.bl.ResultLogic;
import com.test.bl.StudentLogic;
@Controller 
public class AdminStudentController   {
	private StudentLogic lc=new StudentLogic(); 
	private StudentLogic sl=new StudentLogic();
	private ResultLogic rc=new ResultLogic(); 
	
	/*-------------------------------Deleting Student ----------------------------*/
	
	@RequestMapping("/AdminStudentHelperDisplay")
	public String display(ModelMap model) throws ClassNotFoundException, IOException, SQLException
	{
		List<Student> stu=lc.displayAll();
		if(stu!=null)
		{
		model.addAttribute("studentDisplay", stu);
		return "./Admin/AdminStudent/deleteStudent";
		}
		return "./Admin/adminSignIn";
	}
	
	/*------------------------------- Searching Student ----------------------------*/
	
	@RequestMapping("/AdminStudentHelperSearch")
	public String search(ModelMap model) throws ClassNotFoundException, IOException, SQLException
	{
		List<Student> stu=lc.displayAll();
		if(stu!=null)
		{
			model.addAttribute("studentDisplay", stu);
			return "./Admin/AdminStudent/searchStudent";
		}
		return "./Admin/adminSignIn";
	}
	
	/*-------------------------------Displaying Student ----------------------------*/
	
	@RequestMapping("/AdminStudentHelperDisplayAll")
	public String dispaly(ModelMap model) throws ClassNotFoundException, IOException, SQLException
	{
		List<Student> stu=lc.displayAll();
		if(stu!=null)
		{
			model.addAttribute("studentDisplay", stu);
			return "./Admin/AdminStudent/viewAllStudents";
		}
		return "./Admin/adminSignIn";
	} 
	
	/*------------------------------- Updating Student ----------------------------*/
	
	@RequestMapping("/StudentHelperUpdate")
	public String updateInfo(ModelMap model,Student student,HttpServletRequest request,HttpSession session) throws ClassNotFoundException, IOException, SQLException
	{
		String username=(String)session.getAttribute("sessionUserName");
		student=lc.search(username);
		System.out.println(student);
		session.setAttribute("sessionUserName",username);
		model.addAttribute("student", student);
		return "./Student/studentUpdateInfo";
		
	}
	@RequestMapping("/StudentUpdate")
	public String saveRegistration(@Valid Student student,
			BindingResult result, ModelMap model,HttpSession session,HttpServletRequest request) throws ClassNotFoundException, IOException, SQLException {

		if (result.hasErrors()) {
			model.addAttribute("student",student);
			return "./Student/student";
		}
		String username=(String)session.getAttribute("sessionUserName"); 
 
		if(lc.update(username, student))
			{
				model.addAttribute("student",student);
				model.addAttribute("studentUpdate","Successfully Updated.");
		 	    return "./Student/updateStudent";	 
			}
		model.addAttribute("student",student);
		return "./Student/student";
	}
	
	/*-------------------------------Inserting New Student ----------------------------*/
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveRegistration(@Valid Student student,
			BindingResult result, ModelMap model) throws ClassNotFoundException, IOException, SQLException {

		if (result.hasErrors()) {
			User user=new User();
			model.addAttribute("user",user);
			return "./home";
		}
		if(sl.insert(student))
		{
			model.addAttribute("success", "Dear " + student.getName()
			+ " , your Registration completed successfully");
			return "./Student/success";
		}
	
		model.addAttribute("student", student);
		User user=new User();
		model.addAttribute("user",user);
		return "./home";
	}
	
	/*------------------------------- Back in Student Home Page ----------------------------*/
	
	@RequestMapping("/StudentBack")
	public String back(ModelMap model,Student student)
	{
 
		model.addAttribute("student", student);
		return "./Student/student";
	}
	
	/*-------------------------------Student Helper Controller ----------------------------*/
	
	@RequestMapping("/StudentBackFromPrevResult")
	public String backhome(ModelMap model,Student student,HttpServletRequest request) throws ClassNotFoundException, IOException, SQLException
	{
		String user=(String)request.getParameter("username");
		student=sl.search(user);
		model.addAttribute("student", student);
		return "./Student/student";
	}
	
	/*------------------------------- Successful Student Delete Operation  ----------------------------*/
	
	@RequestMapping("/StudentControllerDelete")
	public String delete(ModelMap model,HttpServletRequest request ) throws ClassNotFoundException, IOException, SQLException
	{
		StudentLogic lc=new StudentLogic(); 
		String username=request.getParameter("username");
		System.out.println(username);
		if(lc.delete(username))
		{
			model.addAttribute("studentDelete","Successfully Deleted.");
			 
			return "./Admin/AdminStudent/adminStudent";
		}
		else{
			return "./Admin/adminSignIn";
		}
		 
	}
	
	/*------------------------------- Successful Student Search Operation  ----------------------------*/
	
	@RequestMapping("/StudentControllerSearch")
	public String search(ModelMap model,HttpServletRequest request ) throws ClassNotFoundException, IOException, SQLException,NullPointerException
	{
		StudentLogic lc=new StudentLogic();  
		String suname=(String)request.getParameter("username");
		Student stu=new Student();
		try
		{
		 stu=lc.search(suname);
		if(stu.getUsername().equals(suname))
			{
				model.addAttribute("studentSearch",stu);
				 
				return "./Admin/AdminStudent/adminStudentSearch";
			}
		 
		}
		catch(Exception ee)
		{
			List<Student> stud=lc.displayAll();
			if(stud!=null)
			{
				
				model.addAttribute("studentDisplay", stud);
				return "./Admin/AdminStudent/searchStudent";
			}
		}
		return "./Admin/adminSignIn";
	}
	
	/*------------------------------- Successful Student Previous Result Operation  ----------------------------*/
	
	@RequestMapping("/StudentPrevResult")
	public String prevResult(ModelMap model,HttpSession session,Student student,HttpServletRequest request) throws ClassNotFoundException, SQLException, IOException
	{
			String username=(String)session.getAttribute("sessionUserName");
			 
			try
			{
				List<Result> result1=rc.show(username);
				List<Question> result2=new ArrayList<>(); 
			if(!result1.equals(result2))
			{
				model.addAttribute("student", student);
				model.addAttribute("username", username);
				model.addAttribute("testResult",result1);//use this attribute to display data
				return "./Student/studentPrevResult";
			}
			}
			catch(Exception ee)
			{
			model.addAttribute("student", student);
			model.addAttribute("student", username);
			return "./Student/student";
			}
			model.addAttribute("student", student);
			model.addAttribute("student", username);
			return "./Student/student";
	}
}



	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		if (request.getParameter("insert") != null)
		{
		 
			StudentLogic lc=new StudentLogic(); 
			String username=request.getParameter("username");
			String userpass=request.getParameter("password");
			String name=request.getParameter("name");
			String phone=request.getParameter("phone");
			String email=request.getParameter("email");
			Student student=new Student(username, userpass, name, phone, email);
			try {
				if(lc.insert(student))
				{
					request.setAttribute("studentinsert","Successfully Inserted.");
					BasicConfigurator.configure();
				 	logger.info("Sign up working!!");
					response.sendRedirect("./Student/success.jsp");
				}
				else	 
				{
					request.setAttribute("studentinsert"," Error.");
					BasicConfigurator.configure();
				 	logger.info("Sign up not working!!");
					RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");//change this to appropriate path
					dispatch.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				BasicConfigurator.configure();
			 	logger.info("Sign up not working!!");
				e.printStackTrace();
			}
		} 
		else if(request.getParameter("delete") != null)
		{
			String username=request.getParameter("username");
			StudentLogic lc=new StudentLogic(); 
			try {
				if(lc.delete(username))
				{
					session.setAttribute("studentDelete","Successfully Deleted.");
					BasicConfigurator.configure();
				 	logger.info("Student delete working!!");
					response.sendRedirect("./Admin/AdminStudent/adminStudent.jsp");
				}
				else	 
				{
					request.setAttribute("studentDelete","Error.");
					BasicConfigurator.configure();
				 	logger.info("Student delete not working!!");
					RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");//change this to appropriate path
					dispatch.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				BasicConfigurator.configure();
			 	logger.info("Student delete not working!!");
			    e.printStackTrace();
			}
		      
		}
		else if (request.getParameter("search") != null) {
			String suname=request.getParameter("username");
			StudentLogic lc=new StudentLogic(); 
			try {
				Student stu=lc.search(suname);
				if(stu.getUsername().equals(suname))
				{
					session.setAttribute("studentSearch",stu);
					BasicConfigurator.configure();
				 	logger.info("Student search working!!");
					response.sendRedirect("./Admin/AdminStudent/adminStudentSearch.jsp");
				}
				else
				{
					request.setAttribute("studentDelete","Error.");
					BasicConfigurator.configure();
				 	logger.info("Student search not working!!");
					RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");//change this to appropriate path
					dispatch.forward(request, response);
				}
			} 
			catch(NullPointerException e){
				request.setAttribute("message","Please Select a Valid Username");
		    	 request.setAttribute("message1","Visit lenskart for better vision.");
		    	 RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");
		    	 dispatch.forward(request, response);
		    	 
			}
			catch (ClassNotFoundException | SQLException e) {
				BasicConfigurator.configure();
			 	logger.info("Student search not working!!");
				e.printStackTrace();
			}
		  
		}
		else if (request.getParameter("display") != null) {
			 
			StudentLogic lc=new StudentLogic(); 
			try {
				List<Student> stu=lc.displayAll();
				if(stu!=null)
				{
				request.setAttribute("studentdisplay", stu);
				RequestDispatcher dispatch=request.getRequestDispatcher("./student.jsp");
				dispatch.forward(request, response);
				}
				else
				{
					request.setAttribute("studentDelete","Error.");
					RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");//change this to appropriate path
					dispatch.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
			 
				e.printStackTrace();
			}
		  
		}
		else if (request.getParameter("update") != null) {
			String suname=request.getParameter("suname");
			String spass=request.getParameter("spass");
			String sname=request.getParameter("sname");
			String sphone=request.getParameter("sphone");
			String semail=request.getParameter("semail");
			Student student=new Student(suname, spass, sname, sphone, semail);
			StudentLogic lc=new StudentLogic(); 
			try {
				if(lc.update(suname, student))
				{
					request.setAttribute("studentUpdate","Successfully Updated.");
					BasicConfigurator.configure();
				 	logger.info("Student Update working!!");
					RequestDispatcher dispatch=request.getRequestDispatcher("./student.jsp");
					dispatch.forward(request, response);
				}
				else	 
				{
					request.setAttribute("studentUpdate","Error.");
					BasicConfigurator.configure();
				 	logger.info("Student Update not working!!");
					RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");//change this to appropriate path
					dispatch.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				BasicConfigurator.configure();
			 	logger.info("Student Update not working!!");
				e.printStackTrace();
			}
		  
		}
		else if (request.getParameter("updatepass") != null) {
		 
			String spass=request.getParameter("spass");
			String semail=request.getParameter("semail");
			StudentLogic lc=new StudentLogic(); 
			try {
				if(lc.updatePass(semail, spass))
				{
					request.setAttribute("studentUpdate","Successfully Updated.");
					RequestDispatcher dispatch=request.getRequestDispatcher("./student.jsp");
					dispatch.forward(request, response);
				}
				else	 
				{
					request.setAttribute("studentUpdate","Error.");
					RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");//change this to appropriate path
					dispatch.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		}
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		doGet(request, response);
	}*/


