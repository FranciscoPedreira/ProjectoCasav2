<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="pt.francisco.hibernate.model.User" %>
<%@ page import="pt.francisco.hibernate.model.Employee" %>
<%@ page import="pt.francisco.util.HibernateUtil" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.hibernate.Session" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/struts-tags" prefix="s" %>

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Welcome User</title>
		<link rel="stylesheet" type="text/css" href="<s:url value='/css/style.css'/>">
	</head>
	
	<body>
	
		<c:if test="${userName.equals(currentLoggedOnUser.get(0).getUsername()) && passWord.equals(currentLoggedOnUser.get(0).getPassword())}">
		
			<% System.out.println("Rendering message..."); %>
			
			<h1>${message}</h1>
			<table>
			
				<tr>
					<td>
						<c:url var="employeeListUrl" context="/ProjectoCasa" scope="request" value="/content/EmployeeView.jsp"/>
						<a href = "<c:out value="${employeeListUrl}"/>">Employee List</a>
					</td>
				</tr>
				
				<tr>
					<td>
						<c:url var="salaryListUrl" context="/ProjectoCasa" scope="request" value="/content/SalaryView.jsp"/>
						<a href = "<c:out value="${salaryListUrl}"/>">Company Salary List</a>	
					</td>
				</tr>
				
				<c:if test="${userName.equals('admin')}">
				
					<tr>
						<td>
							<c:url var="userManagementUrl" context="/ProjectoCasa" scope="request" value="/content/UserManagementView.jsp"/>
							<a href = "<c:out value="${userManagementUrl}"/>">User Management</a>	
						</td>
					</tr>
					
				</c:if>
				
			</table>
		
		</c:if>

	</body>
	

</html>