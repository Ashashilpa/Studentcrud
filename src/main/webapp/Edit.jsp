<%@page import="dto.Student"%>
<%@page import="dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% int id=Integer.parseInt(request.getParameter("id"));
StudentDao dao=new StudentDao();
Student student=dao.find(id);
%>
<form action="update" method="post">
    
      <table cellpadding="5px" cellspacing="5px">
                  <tr>
                    <td>
                        <label for="i">Id :</label>
                    </td>
                    <td>
                        <input type="text" id="i" name="id" value="<%=id%>" readonly="readonly">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="name">Name :</label>
                    </td>
                    <td>
                        <input type="text" id="name" placeholder="Enter name" name="name" value="<%=student.getName()%>">
                    </td>
                </tr>
    
               <tr>
                    <td>
                        <label for="num">Mobile no :</label>
                    </td>
                    <td>
                    
                        <input type="tel" id="num"  name="mobile" pattern="{0-9}[10]" value="<%=student.getMobile()%>">
                    </td>
                </tr>
                
                 <tr>
                    <td>
                        <label for="mail">Email :</label>
                    </td>
                    <td>
                        <input type="email" id="mail" name="email" value="<%=student.getEmail()%>">
                    </td>
                </tr>
                
                 <tr>
                    <td>
                        <label for="g">Gender :</label>
                    </td>
                    <%if(student.getGender().equals("male")){%>
                    
                    <td>
                        <input type="radio" id="g" name="gender" value="male" checked="checked">Male
                         <input type="radio" id="g" name="gender" value="female">Female
                    </td>
                    <%}else{ %>
                    <td>
                        <input type="radio" id="g" name="gender" value="male">Male
                         <input type="radio" id="g" name="gender" value="female" checked="checked">Female
                    </td>
                    <%} %>
                </tr>
                
                 <tr>
                    <td>
                        <label for="date">DOB :</label>
                    </td>
                    <td>
                        <input type="date" id="date" name="dob" value="<%=student.getDob()%>">
                    </td>
                </tr>
                
                
                <tr>
                    <td>
                        <label for="address">Address :</label>
                    </td>
                    <td>
                        <textarea name="address" id="address" cols="30" rows="5" placeholder="Enter Address"><%=student.getAddress()%></textarea>
                    </td>
                </tr>
                
                 <tr>
                    <td>
                        <label for="skill">Languages Known :</label>
                    </td>
                    
                    <td>
                        <input type="checkbox" id="skill" name="language" value="kannada">Kannada
                         <input type="checkbox" id="skill" name="language" value="english">English
                          <input type="checkbox" id="skill" name="language" value="hindi">Hindi
                      
                    </td>
                </tr>
                
                 <tr>
                    <td>
                        <label for="con">Country :</label>
                    </td>
                    <td>
                       <select id="con" name="country">
                       <option>India</option>
                       <option>South Korea</option>
                       <option>USA</option>
                        </select>
                    </td>
                </tr>
                
                <tr>
                <td><button type="reset">Cancel</button> </td>
                <td><button>Update</button> </td>
                </tr>
</table>

</form>
</body>
</html>