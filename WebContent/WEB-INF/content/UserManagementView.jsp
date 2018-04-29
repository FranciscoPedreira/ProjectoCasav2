<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Company Salary List</title>
<link rel="stylesheet" type="text/css" href="<s:url value='css/style.css' />">
</head>
<body>

	<h1>User Management</h1>
	
	<c:url var="createUserUrl" context="/ProjectoCasa" scope="request" value="/content/CreateUserView.jsp"/>
	<a href = "<c:out value="${createUserUrl}"/>">Create new user</a>
	
	<br/>
	<br/>
	
	<c:forEach items="${listUsers}" var="u"> 
	
		<form action="UserManagementViewAction" method="post">
			<table>
				<tr>
					<td>
						<label for="username">Username: </label>
						<input type='text' name='username' disabled value='${u.getUsername()}'>
					</td>
					<td><input type='hidden' name='username' value='${u.getUsername()}'>
					</td>
				</tr>
				<tr>
					<td>
						<label for="password">Password: </label>
						<input type='password' name='password' value='${u.getPassword()}'>
					</td>
				</tr>
			</table>
		 
		 	<br/>
		 
		 	<table>
		 		<tr>
		 			<td id="labelSpace"></td>
				    <td id="actionButton" >
				        <s:submit theme="simple" action="UserManagementDeleteAction" key="button.deleteUser"/>
				        <s:submit theme="simple" action="UserManagementViewAction" key="button.updateUser"/>
				    </td>
				 </tr>
		 	</table>
		    
		 	<br />
		 	<br />
		 	
	 	</form>
	 	
	</c:forEach>

</body>
</html>