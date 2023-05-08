<%@page import="java.util.Arrays"%>
<%@page import="dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% Student student=(Student)request.getAttribute("student"); %>
<table border="1">
    <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Mobile</th>
    <th>Email</th>
    <th>Gender</th>
    <th>DOB</th>
    <th>Address</th>
    <th>Country</th>
    <th>Language known</th>
    <th>Delete</th>
     <th>Edit</th>
    </tr>
    
     <tr>
    <th><%= student.getId() %></th>
    <th><%= student.getName() %></th>
    <th><%= student.getMobile() %></th>
    <th><%= student.getEmail() %></th>
    <th><%= student.getGender() %></th>
    <th><%= student.getDob()%></th>
    <th><%= student.getAddress() %></th>
    <th><%= student.getCountry() %></th>
    <th><%= Arrays.toString(student.getLanguage()) %></th>
  
     
    </tr>

</table>
<br>
    <a href="Home.html"><button>Home</button></a>

</body>
</html>