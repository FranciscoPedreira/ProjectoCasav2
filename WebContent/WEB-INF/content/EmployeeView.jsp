<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Empregados</title>
</head>
<body>
	
	<h1>Employee List</h1>
	
	<c:forEach items="${listEmployee}" var="e"> 
	
		<form action="EmployeeUpdateAction" method="post">
			<table>
				<tr>
					<td><input type='text' name='firstName' value='${e.getId().getFirstName()}'></td>
				</tr>
				<tr>
					<td><input type='text' name='lastName' value='${e.getId().getLastName()}'></td>
				</tr>
				<tr>
					<td><input type='text' name='country' value='>${e.getCountry()}'></td>
				</tr>
				<tr>
					<td><input type='text' name='address' value='${e.getAddress()}'></td>
				</tr>
				<tr>
					<td><input type='text' name='role' value='${e.getRole()}'></td>
				</tr>
			</table>
		 
		 	<input type="submit" name="updateUser" value="Update User Info" />
		    
		 	<br />
		 	<br />
		 	<br />
		 	
	 	</form>
	 	
	</c:forEach>
	
</body>
</html>