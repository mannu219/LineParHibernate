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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.test.bean.Question;
import com.test.bean.Subject;
import com.test.bl.QuestionLogic;
import com.test.bl.SubjectLogic;

 @Controller

 public class AdminQuestionController   {
	private SubjectLogic lc=new SubjectLogic();
	private SubjectLogic sLogic=new SubjectLogic();
	private Subject sub=null;
	private QuestionLogic qLogic=new QuestionLogic();
	 
	/*-------------------------------Deleting Question ----------------------------*/
	
	 @RequestMapping("/AdminQuestionDelete")
       public String getSubject(ModelMap model,HttpSession session) throws ClassNotFoundException, IOException, SQLException
       {
		 
		 List<Subject> sub=lc.displayAll();
		 if(sub!=null)
		 {
			 model.addAttribute("subject", new Subject());
			session.setAttribute("call","delete");
			model.addAttribute("subjectDisplay", sub);//use this attribute to display data
			return("./Admin/AdminQuestion/Question");
			} 
			 
		return("./lost");
			 
       }
	 
	 /*-------------------------------Viewing Question ----------------------------*/
	 
	 @RequestMapping("/AdminQuestionView")
     public String getSubjectView(ModelMap model,HttpSession session) throws ClassNotFoundException, IOException, SQLException
     {
		 
		 List<Subject> sub=lc.displayAll();
		 if(sub!=null)
		 {
			 model.addAttribute("subject", new Subject());
			session.setAttribute("call","display");
			model.addAttribute("subjectDisplay", sub);//use this attribute to display data
			return("./Admin/AdminQuestion/Question");
			} 
			 
		return("./lost");
			 
     }
	 
	 /*-------------------------------Updating Question ----------------------------*/
	 
	 @RequestMapping("/AdminQuestionUpdate")
     public String getSubjectUpdate(ModelMap model,HttpSession session) throws ClassNotFoundException, IOException, SQLException
     {
		 
		 List<Subject> sub=lc.displayAll();
		 if(sub!=null)
		 {
			model.addAttribute("subject", new Subject());
			session.setAttribute("call","update");
			model.addAttribute("subjectDisplay", sub);//use this attribute to display data
			return("./Admin/AdminQuestion/Question");
			} 
			 
		return("./lost");
			 
     }
	 
	 /*-------------------------------Inserting Question ----------------------------*/
	 
	 @RequestMapping("/AdminQuestionInsert")
     public String insertSubject(ModelMap model,HttpSession session) throws ClassNotFoundException, IOException, SQLException
     {
		 
		 List<Subject> sub=lc.displayAll();
		 if(sub!=null)
		 {
			model.addAttribute("subject", new Subject());
			session.setAttribute("call","insert");
			model.addAttribute("subjectDisplay", sub);//use this attribute to display data
			return("./Admin/AdminQuestion/Question");
			} 
			 
		return("./lost");
			 
     }
	 
	 /*------------------------------- Question Related Task ----------------------------*/
	 
	 @RequestMapping("/QuestionController")
		public String deleteQuestion(ModelMap model,HttpSession session,Subject subject,HttpServletRequest request) throws ClassNotFoundException, IOException, SQLException
		{
			
		   if (session.getAttribute("call").equals("delete"))
			 { 
				 	String subString=request.getParameter("subjectId");
				 	subString=subString.trim();
				 	int subjectId=Integer.parseInt(subString);
					session.setAttribute("sessionSubjectId", subjectId);
					sub=sLogic.search(subjectId);
					List<Question> ques=qLogic.displayAll(sub.getSubjectId());
					if(ques!=null){
							model.addAttribute("sessionQuestionAll",ques); 
							session.setAttribute("call", "deleteQues");
							return("./Admin/AdminQuestion/deleteQuestion");
					}
			 }
			 else if(session.getAttribute("call").equals("deleteQues"))
			 {
				 	String quesString=request.getParameter("questionId");
				 	quesString=quesString.trim();
					int questionId=Integer.parseInt(quesString);
					if(qLogic.delete(questionId))
					{
						model.addAttribute("message","Deleted Successfully");
						return "./Admin/AdminQuestion/final";
					}
				}
			 else if (session.getAttribute("call").equals("display"))
			 { 
				 	String subString=request.getParameter("subjectId");
				 	subString=subString.trim();
				 	int subjectId=Integer.parseInt(subString);
					session.setAttribute("sessionSubjectId", subjectId);
					sub=sLogic.search(subjectId);
					List<Question> ques=qLogic.displayAll(sub.getSubjectId());
					if(ques!=null){
							model.addAttribute("modelSubject", sub );
							model.addAttribute("sessionQuestionAll",ques); 
							return"./Admin/AdminQuestion/viewAllQuestion";
					}
			 }else if (session.getAttribute("call").equals("update"))
			 { 
				 	String subString=request.getParameter("subjectId");
				 	subString=subString.trim();
				 	int subjectId=Integer.parseInt(subString);
					session.setAttribute("sessionSubjectId", subjectId);
					sub=sLogic.search(subjectId);
					List<Question> ques=qLogic.displayAll(sub.getSubjectId());
					if(ques!=null){
							model.addAttribute("modelSubject", sub );
							model.addAttribute("sessionQuestionAll",ques); 
							session.setAttribute("call", "updateQues");
							return"./Admin/AdminQuestion/updateQuestion";
					}
					 
						 
			 }else  if (session.getAttribute("call").equals("insert"))
			 {
				 	String subString=request.getParameter("subjectId");
				 	subString=subString.trim();
				 	int subjectId=Integer.parseInt(subString);
					session.setAttribute("sessionSubjectId", subjectId);
					sub=sLogic.search(subjectId);
					model.addAttribute("modelSubject", sub );//use this attribute to abstract info
					session.setAttribute("call", "insertIntoTable");
					 return "./Admin/AdminQuestion/insertQuestion";
					 
				}else if(session.getAttribute("call").equals("insertIntoTable")){
					String subString=request.getParameter("subjectId");
				 	subString=subString.trim();
				 	int subjectId=Integer.parseInt(subString); //subject is subjectId
					session.setAttribute("sessionSubjectId", subjectId);
					String quesString=request.getParameter("questionId");
					quesString=quesString.trim();
					int questionId=Integer.parseInt(quesString);
					String question=request.getParameter("question");
					String op1=request.getParameter("op1");
					String op2=request.getParameter("op2");
					String op3=request.getParameter("op3");
					String op4=request.getParameter("op4");
					String ansString=request.getParameter("answer");
					ansString=ansString.trim();
					int answer=Integer.parseInt(ansString);
					Question ques=new Question(questionId, subjectId, question, answer, op1, op2, op3, op4, op1);
					if(qLogic.insert(ques))
					{
							session.setAttribute("message","Inserted Successfully");
							return "./Admin/AdminQuestion/final";
					}
				}else if(session.getAttribute("call").equals("updateQues")){
					String subString=request.getParameter("subjectId");
				 	subString=subString.trim();
				 	int subjectId=Integer.parseInt(subString); //subject is subjectId
					session.setAttribute("sessionSubjectId", subjectId);
					String quesString=request.getParameter("questionId");
					quesString=quesString.trim();
					int questionId=Integer.parseInt(quesString);
						Question qu=qLogic.search(questionId);
						String question=qu.getQuestion();
						String op1=qu.getChoice1();	
						String op2=qu.getChoice2();
						String op3=qu.getChoice3();
						String op4=qu.getChoice4();
						int answer=qu.getAnswer();
						Question ques=new Question(questionId, subjectId, question, answer, op1, op2, op3, op4, op1);
						model.addAttribute("modelQuestion", ques);
						session.setAttribute("call", "finalQues"); 
						return "./Admin/AdminQuestion/finalUpdate";
				}
				else if (session.getAttribute("call").equals("finalQues")) {
					int questionId=Integer.parseInt(request.getParameter("questionId"));
					int subjectId=Integer.parseInt(request.getParameter("subject"));
					String question=request.getParameter("question");
					String op1=request.getParameter("op1");
					String op2=request.getParameter("op2");
					String op3=request.getParameter("op3");
					String op4=request.getParameter("op4");
					int answer=Integer.parseInt(request.getParameter("answer"));
					Question ques=new Question(questionId, subjectId, question, answer, op1, op2, op3, op4, op1);
				 			if(qLogic.update(questionId, ques)){
								session.setAttribute("sessionQuestionAll",ques);
								session.setAttribute("message", "Update Successful");
							return "./Admin/AdminQuestion/final";
						}
					}
		 return "./Admin/AdminQuestion/Question";
		}
 }
/*	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
			SubjectLogic lc=new SubjectLogic();
			try {
				List<Subject> sub=lc.displayAll();
				if(sub!=null)
				{
					if (request.getParameter("delete") != null) {
						session.setAttribute("call","delete");
					}
					else if (request.getParameter("insert") != null) {
						session.setAttribute("call","insert");
					}
					else if (request.getParameter("update") != null) {
						session.setAttribute("call","update");
					}
					else if (request.getParameter("viewAll") != null) {
						session.setAttribute("call","displayAll");
					}
				session.setAttribute("subjectDisplay", sub);//use this attribute to display data
				response.sendRedirect("../Admin/AdminQuestion/Question.jsp");
				}
				else
				{
					session.setAttribute("message","");
					session.setAttribute("message1","");
					response.sendRedirect("./lost.jsp");
				}
			} catch (ClassNotFoundException | SQLException | NullPointerException e) {
				session.setAttribute("message","Server Down!!!");
				session.setAttribute("message1","Please Contact The Administrator.");
				response.sendRedirect("./lost.jsp");
			}  
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}*/
