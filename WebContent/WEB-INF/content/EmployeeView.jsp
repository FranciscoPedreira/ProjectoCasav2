<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List</title>
<link rel="stylesheet" type="text/css" href="<s:url value='css/style.css' />">
</head>
<body>
	
	<h1>Employee List</h1>
	
	<c:url var="createEmployeeUrl" context="/ProjectoCasa" scope="request" value="/CreateEmployeeView"/>
	<a href = "<c:out value="${createEmployeeUrl}"/>">Create new employee</a>
	
	<br/>
	<br/>
	
	<c:forEach items="${listEmployee}" var="e"> 
	
		<form action="EmployeeViewAction" method="post">
			<table>
				<tr>
					<td>
						<label for="firstName">First name: </label>
						<input type='text' name='firstName' disabled value='${e.getId().getFirstName()}'>
					</td>
					<td><input type='hidden' name='firstName' value='${e.getId().getFirstName()}'>
					</td>
				</tr>
				<tr>
					<td>
						<label for="lastName">Last name: </label>
						<input type='text' name='lastName'  disabled value='${e.getId().getLastName()}'>
					</td>
					<td><input type='hidden' name='lastName' value='${e.getId().getLastName()}'></td>
				</tr>
				<tr>
					<td>
						<label for="country">Country: </label>
						<input type='text' name='country' value='${e.getCountry()}'>
					</td>
				</tr>
				<tr>
					<td>
						<label for="address">Address: </label>
						<input type='text' name='address' value='${e.getAddress()}'>
					</td>
				</tr>
				<tr>
					<td>
						<label for="role">Role: </label>
						<input type='text' name='role' value='${e.getRole()}'>
					</td>
				</tr>
			</table>
		 
		 	<br/>
		 
		 	<!-- <div id="labelSpace"></div>  -->
		 	<s:submit id="labelSpace" action="EmployeeDeleteAction" key="button.deleteEmployee"/>
		 	<input type="submit" name="updateEmployee" value="Update Employee Info" />
		    
		 	<br />
		 	<br />
		 	
	 	</form>
	 	
	</c:forEach>
	
</body>
</html>