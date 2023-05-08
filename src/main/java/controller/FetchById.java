package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


import dao.StudentDao;
import dto.Student;
@WebServlet("/fetch")
public class FetchById extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
         int id=Integer.parseInt(req.getParameter("id"));
         StudentDao dao=new StudentDao();
         Student student=dao.find(id);
         
         if(student==null)
         {
        	// res.setContentType("html/text");
        	 //to check the given code is html or text
        	 res.getWriter().print("<h1>No data found with the id:"+id+"</h1>");
        	 req.getRequestDispatcher("Home.html").include(req, res);
        	 
         }
         else
         {
//        	 res.getWriter().print("<html><body>"
//     				+ "<table border='1'>"
//     				+ "<tr>"
//     				+ "<th>Id</th>"
//     				+ "<th>Name</th>"
//     				+ "<th>Mobile</th>"
//     				+ "<th>Email</th>"
//     				+ "<th>Gender</th>"
//     				+ "<th>Address</th>"
//     				+ "<th>Country</th>"
//     				+ "<th>DOB</th>"
//     				+ "<th>Language</th>"
//     				+ "</tr>");
//        	 
//        	 res.getWriter().print(
//						"<tr>"
//								+ "<th>"+student.getId()+"</th>"
//								+ "<th>"+student.getName()+"</th>"
//								+ "<th>"+student.getMobile()+"</th>"
//								+ "<th>"+student.getEmail()+"</th>"
//								+ "<th>"+student.getGender()+"</th>"
//								+ "<th>"+student.getAddress()+"</th>"
//								+ "<th>"+student.getCountry()+"</th>"
//								+ "<th>"+student.getDob()+"</th>"
//								+ "<th>"+Arrays.toString(student.getLanguage())+"</th>"
//								+ "</tr>");
//				
//		res.getWriter().print("</table>"
//				+ "<br>"
//				+ "<a href='Home.html'><button>Home</button></a>"
//				+ "</body></html>");s
        	// req.setAttribute("student", student);
        	 
        	 List<Student> list=new ArrayList();
        	 list.add(student);
        	 req.setAttribute("list", list);
        	 //no need to use fetchbyid.jsp fail know 
		 req.getRequestDispatcher("FetchAll.jsp").forward(req, res);
         }
		
	}
	

}
