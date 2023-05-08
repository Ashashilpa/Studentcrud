
package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dto.Student;

@WebServlet("/update")
public class Update extends HttpServlet{

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		
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
	     student.setId(Integer.parseInt(req.getParameter("id")));
	     student.setName(name);
	     student.setMobile(mobile);
	     student.setAddress(address);
	     student.setDob(dob);
	     student.setCountry(country);
	     student.setEmail(email);
	     student.setGender(gender);
	     student.setLanguage(language);
	     
	     StudentDao dao=new StudentDao();
	     dao.update(student);
	   
	     res.getWriter().print("<h1>Updated successfully</h1>");
	     
	     req.setAttribute("list",dao.fetchAll());
	 	req.getRequestDispatcher("FetchAll.jsp").include(req, res);
		
	}
}
