package com.test.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.test.bl.SubjectLogic;
import com.test.bl.TestLogic;
import com.test.bean.Question;
import com.test.bean.Student;
import com.test.bean.Subject;
import com.test.bean.User;
@Controller
@SessionAttributes("student")
public class GiveTestController{
 
 
	private SubjectLogic sub=new SubjectLogic();
	private TestLogic lc=new TestLogic();
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
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		
		String username=(String)session.getAttribute("sessionUsername");
		try {
			int subject=Integer.parseInt(request.getParameter("subjectIdd"));
			List<Question> quest=new ArrayList<>();
			quest=lc.getQuestions(username, subject);
			session.setAttribute("Questions",quest);
			response.sendRedirect("./Test/giveTest.jsp");
		} catch (InterruptedException | ClassNotFoundException | SQLException | NullPointerException e) {
			session.setAttribute("message","Server Down!!!");
			session.setAttribute("message1","Please Contact The Administrator.");
			response.sendRedirect("./lost.jsp");
		}

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
*/
}
