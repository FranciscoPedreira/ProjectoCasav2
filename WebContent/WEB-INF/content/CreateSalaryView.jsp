<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Employee</title>
<link rel="stylesheet" type="text/css" href="<s:url value='css/style.css' />">
</head>
<body>
	
	<h1>Create A New Salary Record</h1>
	
		<form action="SalaryViewAction" method="post">
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
						<label for="step">step: </label>
						<input type='text' id='step' name='step'>
					</td>
				</tr>
				<tr>
					<td>
						<label for="value">Value: </label>
						<input type='text' id='value' name='value'>
					</td>
				</tr>
			</table>
			
			<br/>
		 	
		 	<div id="labelSpace"></div>
		 	<input type="submit" id="createSalaryButton" name="updateSalary" value="Create New Salary Record" />
		    
		 	<br />
		 	<br />
		 	
	 	</form>

</body>
</html>