<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="pt.francisco.hibernate.model.User" %>
<%@ page import="pt.francisco.hibernate.model.Employee" %>
<%@ page import="pt.francisco.hibernate.util.HibernateUtil" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.hibernate.Session" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Welcome User</title>
	</head>
	
	<body>
		
		<c:url var="url" context="/ProjectoCasa" scope="request" value="/EmployeeView"/>
			
		<a href = "<c:out value="${url}"/>">Listagem Empregados</a>
	
		<c:if test="${userName.equals(listUser.get(0).getUsername()) && passWord.equals(listUser.get(0).getPassword())}">
		
			<% System.out.println("Rendering message..."); %>
			
			<h1>${message}</h1>
			
			<c:forEach items="${listEmployee}" var="e"> 
			  <tr>
			    <td>${e.getId().getFirstName()}</td>
			    <td>${e.getId().getLastName()}</td>
			    <td>${e.getCountry()}</td>
			    <td>${e.getAddress()}</td>
			    <td>${e.getRole()}</td>
			  </tr>
			  <br />
			</c:forEach>
		
		</c:if>
		
		<h1><span style="background-color: #FFFFcc">Access Request and Response Example!</span></h1>
  		<b>Request: </b>${listUser}<br>
  		<b>Response: </b><%=response%><br>
	
	</body>
	

</html>