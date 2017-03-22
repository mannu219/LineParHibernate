package com.test.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.test.bean.PrintResult;
import com.test.bean.Question;
import com.test.bean.Result;
import com.test.bean.Student;
import com.test.bean.Subject;
import com.test.bean.User;
import com.test.bl.QuestionLogic;
import com.test.bl.ResultLogic;
import com.test.bl.SubjectLogic;
import com.test.bl.TestLogic;

 @Controller
 @SessionAttributes("student")
public class TestController  {
	 
		private QuestionLogic qLogic = new QuestionLogic();
		private ResultLogic rLogic = new ResultLogic();
		private TestLogic lc = new TestLogic();
		private SubjectLogic sub=new SubjectLogic();
		
		@RequestMapping("/StudentHelperGiveTest")
		public String giveTest(ModelMap model,HttpServletRequest request,HttpSession session) throws ClassNotFoundException, IOException, SQLException
		{
			List<Subject> subList=sub.displayAll();
			Subject subject=new Subject();
			User user=(User)request.getAttribute("user");
			/*session.setAttribute("user",user);*/
			model.addAttribute("user",user);
			model.addAttribute("subject",subject);
			model.addAttribute("subjectDisplay",subList);
			return "./Student/studentGiveTest";
		}
		
		@RequestMapping("/GiveTest")
		public String onlineTest(ModelMap model,HttpServletRequest request,HttpSession session) throws ClassNotFoundException, SQLException, InterruptedException
		{
			String username=(String)session.getAttribute("sessionUserName");
			String subString=(String)session.getAttribute("sessionSubjectId");
			String first=null;
			int subject=Integer.parseInt(subString);
			Question question=new Question();
			model.addAttribute("question", question);
			List<Question> quest=new ArrayList<>();
			quest=lc.getQuestions(username, subject);
			model.addAttribute("question", question);
			model.addAttribute("Questions",quest);
			session.setAttribute("sessionUserName", username);
			session.setAttribute("Questions",quest);
			session.setAttribute("sessionSubjectId", subString);
			session.setAttribute("dontGive",first);
			return "./Test/giveTest";
		}
		
	@RequestMapping("/Test")
	public String giveTest1(ModelMap model,Subject subject, HttpServletRequest  request,HttpSession session) throws ClassNotFoundException, SQLException, InterruptedException, IOException, NullPointerException
	{
	 	TestLogic lc=new TestLogic();
		int subjectId=Integer.parseInt(request.getParameter("subjectId"));
		String subString=Integer.toString(subjectId);
		User user=(User)session.getAttribute("user");
		String username=user.getUsername();
		List<Result> result=new ArrayList<>();
		List<Result> resu=lc.giveTest(username, subjectId);
		System.out.println(resu);
		if(lc.giveTest(username, subjectId).equals(result))
		{
			if(lc.check_questions(subjectId, username))
			{
				if(lc.dateCheck(subjectId))
				{		
					session.setAttribute("sessionUserName",username);
					session.setAttribute("sessionSubjectId",subString);	
						return "./Test/Rules"; 
					 				
				}
				else	 
				{ 
					 return "./lost";
				}
			}
		}
			 return "./Student/student";
		 
		  
	}
	@RequestMapping("/Result")
	public String result(ModelMap model,HttpSession session,HttpServletRequest request) throws ClassNotFoundException, SQLException, IOException, NumberFormatException, InterruptedException
	{
		String username = (String)session.getAttribute("sessionUserName");	
		ArrayList<Question> ques = (ArrayList<Question>) session.getAttribute("Questions");
		List<PrintResult> resultList1 = new ArrayList<>();
		String subId=(String)session.getAttribute("sessionSubjectId");
		int subjectId=Integer.parseInt(subId);
		if(lc.giveTest(username,subjectId).equals(resultList1)){
			List<PrintResult> resultList = new ArrayList<>();
			int count = 0;
			Question questtt = null;
			Enumeration<String> questions = request.getParameterNames();
			while (questions.hasMoreElements())
			{
				String question = questions.nextElement();
				int questionId = Integer.parseInt(question);
				questtt = qLogic.search(questionId);
				String ans = questtt.getAns();
				System.out.println(ans+ "====" + request.getParameter(question));
				System.out.println(request.getParameter(question));
				PrintResult rest = new PrintResult(username, questtt.getSubjectId(), questionId, questtt.getQuestion(),
				questtt.getAns(), request.getParameter(question));
				resultList.add(rest);
				if (request.getParameter(question).equals(ans)) {
						count++;
				}
				System.out.println(count);
			}
			String Coun = Integer.toString(count*10).concat("%");
			System.out.println(Coun);
			model.addAttribute("modelUserName", username);
			model.addAttribute("modelSubjectId", subjectId);
			model.addAttribute("modelResultSet", resultList);
			model.addAttribute("modelResult", count);
			model.addAttribute("message","You Scored"); 
			model.addAttribute("message1",Coun);
			Question questt = ques.get(0);
			int subjId = questt.getSubjectId();
			System.out.println(subId);
			rLogic.set(username, subjId, count*10);
			if (session.getAttribute("dontGive")==null)
				return"./Student/printResult";
			else {
					return"./Student/printBack";
				}
			} 
				
		return "./Student/studentGiveTest";
	}
 }
/*	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		try {
			int subjectId=Integer.parseInt(request.getParameter("subjectId"));
		String username=(String) session.getAttribute("sessionUsername");
		if (request.getParameter("giveTest") != null) {//check the parameter name			 
			try {
				List<Result> result=new ArrayList<>();
//				System.out.println(result);
				System.out.println(subjectId);
				System.out.println(username);
				System.out.println(result);
				if(lc.giveTest(username, subjectId).equals(result) )
				{
					if(lc.check_questions(subjectId,username))
					{
						if(lc.dateCheck(subjectId))
						{		
								request.setAttribute("sessionSubjectId", subjectId);
								RequestDispatcher dispatch=request.getRequestDispatcher("./Test/Rules.jsp");//change this to appropriate path
								dispatch.forward(request, response);				
						}
						else	 
						{ 
							session.setAttribute("message","Please check Test Time Period");
							session.setAttribute("message1","Please Try Again");
							response.sendRedirect("./lost.jsp");
						}
					}
					else	 
					{
						session.setAttribute("message","Questions Yet To Be Updated.");
						session.setAttribute("message1","Please Try Again");
						response.sendRedirect("./lost.jsp");
					}
				}
				else	 
				{
					session.setAttribute("message","Test Already Given");
					session.setAttribute("message1","Please Try Again");
					response.sendRedirect("./lost.jsp");
				}
			}
			catch (ClassNotFoundException | InterruptedException |SQLException e) {
				session.setAttribute("message","Server Down!!!");
				session.setAttribute("message1","Please Contact The Administrator.");
				response.sendRedirect("./lost.jsp");
				}
		}
			else	 
			{
				session.setAttribute("message","Test Error");
				session.setAttribute("message1","Please Try Again");
				response.sendRedirect("./lost.jsp");
			}
		}
		catch(NullPointerException | NumberFormatException e){
			session.setAttribute("message","Please Select A Subject!");
			session.setAttribute("message1","Oops");
			response.sendRedirect("./lost.jsp");
		}
	
		
		 if(request.getParameter("result") != null)//check the parameter name
		{
			String suname=request.getParameter("suname");
			int subid=Integer.parseInt(request.getParameter("subid"));
			try {
				int res=lc.result(suname, subid);
				if(res>0)
				{
					request.setAttribute("testResult", res);//use this attribute to abstract info
					RequestDispatcher dispatch=request.getRequestDispatcher("./student.jsp");
					dispatch.forward(request, response);
				}
				else	 
				{
					session.setAttribute("message","Test Error");
					session.setAttribute("message1","");
					response.sendRedirect("./lost.jsp");
				}
			} catch (ClassNotFoundException | SQLException e) {
				session.setAttribute("message","Server Down!!!");
				session.setAttribute("message1","Please Contact The Administrator.");
				response.sendRedirect("./lost.jsp");
			}
		      
		}
		else if (request.getParameter("check") != null) {//check the parameter name
			int subid=Integer.parseInt(request.getParameter("subid"));
			try {
				if(lc.check(subid))
				{
				request.setAttribute("testCheck","Checked");//use this attribute to abstract data and use it in proper place
				RequestDispatcher dispatch=request.getRequestDispatcher("./student.jsp");
				dispatch.forward(request, response);
				}
				else
				{
					session.setAttribute("message","Test Error");
					session.setAttribute("message1","Please Login Again");
					response.sendRedirect("./lost.jsp");
				}
			} catch (ClassNotFoundException | SQLException e) {
			 
				e.printStackTrace();
			}
		  
		}
		else if (request.getParameter("datecheck") != null) {//check the parameter name
			int subid=Integer.parseInt(request.getParameter("subid"));
			try {
				 
				if(lc.dateCheck(subid))
				{
				request.setAttribute("testDateCheck","checked");//use this attribute to display data
				RequestDispatcher dispatch=request.getRequestDispatcher("./student.jsp");
				dispatch.forward(request, response);
				}
				else
				{
					session.setAttribute("message","Test Error");
					session.setAttribute("message1","Please Login Again");
					response.sendRedirect("./lost.jsp");
				}
			} catch (ClassNotFoundException | SQLException e) {
				session.setAttribute("message","Server Down!!!");
				session.setAttribute("message1","Please Contact The Administrator.");
				response.sendRedirect("./lost.jsp");
			}
		  
		}
		else if (request.getParameter("resultstudent") != null) {//check the parameter name
			String suname=request.getParameter("suname");
			try {
				if(lc.result_student(suname))
				{
					request.setAttribute("testResult","Student Result.");//use this attribute to display data
					RequestDispatcher dispatch=request.getRequestDispatcher("./student.jsp");
					dispatch.forward(request, response);
				}
				else	 
				{
					session.setAttribute("message","Error");
					session.setAttribute("message1","Please Login Again");
					response.sendRedirect("./lost.jsp");
				}
			} catch (ClassNotFoundException | SQLException e) {
				session.setAttribute("message","Server Down!!!");
				session.setAttribute("message1","Please Contact The Administrator.");
				response.sendRedirect("./lost.jsp");
			}
		  
		}
		 
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		doGet(request, response);
	}*/
