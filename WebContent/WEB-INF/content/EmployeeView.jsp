<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List</title>
<link rel="stylesheet" type="text/css" href="<s:url value='/css/style.css'/>">
</head>
<body>
	
	<jsp:include page="/WEB-INF/content/Menu.jsp" />
	
	<h1>Employee List</h1>
	
	<s:submit id="createEmployee" type="button" value="Create New Employee" onclick="location.href='/ProjectoCasa/content/CreateEmployeeView.jsp';" /> 
	
	<c:url var="createEmployeeUrl" context="/ProjectoCasa" scope="request" value="/content/CreateEmployeeView.jsp"/>
	<a href = "<c:out value="${createEmployeeUrl}"/>">Create new employee</a>
	
	
	
	
	<br/>
	<br/>
	
	<table>
		<tr>
			<td id="labelTd"><strong><label for="firstName">First Name </label></strong></td>
			<td id="labelTd"><strong><label for="lastName">Last Name </label></strong></td>
			<td id="labelTd"><strong><label for="country">Country </label></strong></td>
			<td id="labelTd"><strong><label for="address">Address </label></strong></td>
			<td id="labelTd"><strong><label for="role">Role </label></strong></td>
		</tr>
	</table>
	
	<c:forEach items="${listEmployee}" var="e"> 
	
		<form action="EmployeeViewAction" method="post">
		
			<table>
				<tr>
					<td><input type='hidden' name='employeeId' value='${e.getEmployeeId()}'></td>
				</tr>
				<tr>
					<td><input type='text' name='firstName' value='${e.getFirstName()}'></td>
					<td><input type='text' name='lastName' value='${e.getLastName()}'></td>
					<td><input type='text' name='country' value='${e.getCountry()}'></td>
					<td><input type='text' name='address' value='${e.getAddress()}'></td>
					<td><input type='text' name='role' value='${e.getRole()}'></td>
				    <td><s:submit theme="simple" action="EmployeeDeleteAction" key="button.deleteEmployee"/></td>
				    <td><s:submit theme="simple" action="EmployeeViewAction" key="button.updateEmployee"/></td>
				</tr>
			</table>
		 	
	 	</form>
	 	
	</c:forEach>
	
</body>
</html>