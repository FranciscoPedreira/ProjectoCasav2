<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Employee</title>
<link rel="stylesheet" type="text/css" href="<s:url value='/css/style.css'/>">
</head>
<body>

	<jsp:include page="/WEB-INF/content/Menu.jsp" />
	
	<h1>Create A New Employee</h1>
	
		<form action="EmployeeViewAction" method="post">
			<table>
				<tr>
					<td>
						<label for="firstName">First name: </label>
						<input type='text' id='firstName' name='firstName'>
					</td>
				</tr>
				<tr>
					<td>
						<label for="lastName">Last name: </label>
						<input type='text' id='lastName' name='lastName'>
					</td>
				</tr>
				<tr>
					<td>
						<label for="country">Country: </label>
						<input type='text' id='country' name='country'>
					</td>
				</tr>
				<tr>
					<td>
						<label for="address">Address: </label>
						<input type='text' id='address' name='address'>
					</td>
				</tr>
				<tr>
					<td>
						<label for="department">Department: </label>
						<input type='text' id='department' name='department'>
					</td>
				</tr>
			</table>
			
			<br/>
		 
		 	<div id="labelSpace"></div>
		 	<input type="submit" id="createEmployeeButton" name="updateEmployee" value="Create New Employee" />
		    
		 	<br />
		 	<br />
		 	
	 	</form>

</body>
</html>