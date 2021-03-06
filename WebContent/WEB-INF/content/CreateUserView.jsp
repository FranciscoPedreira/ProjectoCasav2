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
	
	<h1>Add New User</h1>
	
		<form action="UserViewAction" method="post">
			<table>
				<tr>
					<td><input type='hidden' name='isRegisterUser' value=<c:out value='${requestScope["isRegisterUser"]}'/>></td>
				</tr>
				<tr>
					<td>
						<label for="username">Username: </label>
						<input type='text' id='username' name='username'>
					</td>
				</tr>
				<tr>
					<td>
						<label for="password">Password: </label>
						<input type='password' id='password' name='password'>
					</td>
				</tr>
				<tr>
					<td>
						<label for="passwordConfirm">Confirm Password: </label>
						<input type='password' id='confirmPassword' name='confirmPassword'>
					</td>
				</tr>
			</table>
			
			<br/>
		 	
		 	<input type="submit" id="createUserButton" name="updateUser" value="Add" />
		    
		 	<br />
		 	<br />
		 	
	 	</form>

</body>
</html>