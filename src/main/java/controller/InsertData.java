package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import dao.StudentDao;
import dto.Student;

@WebServlet("/insert")
public class InsertData extends GenericServlet {

	private static final String Student = null;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String name=req.getParameter("name");
	     long mobile=Long.parseLong(req.getParameter("mobile"));
	     String email=req.getParameter("email");
	     String gender=req.getParameter("gender");
	     Date dob=Date.valueOf(req.getParameter("dob"));
	     
	     String[] language=req.getParameterValues("language");
	     
	     String address=req.getParameter("address");
	     String country=req.getParameter("country");
	     
//	     res.getWriter().print("<h1>"
//	     		+ "Name:"+name
//	     		+ "<br>Mobile:"+mobile
//	     		+ "<br>Email:"+email
//	     		+ "<br>Gende:"+gender
//	     		+ "<br>dob:"+dob
//	     		+ "<br>Language:"+Arrays.toString(language)
//	     		+ "<br>Address:"+address
//	     		+"<br>Country:"+country
//	     		+ "</h1>");
//	         
	     
	     Student student=new Student();
	     // student.setName(req.getParameter("name"));-->short cut

	     student.setName(name);
	     student.setMobile(mobile);
	     student.setAddress(address);
	     student.setDob(dob);
	     student.setCountry(country);
	     student.setEmail(email);
	     student.setGender(gender);
	     student.setLanguage(language);
	     
	     StudentDao dao=new StudentDao();
	     dao.save(student);
	   
	     res.getWriter().print("<h1>Data saved successfully</h1>");
	     
	     req.getRequestDispatcher("Home.html").include(req, res);
		
	}

}
