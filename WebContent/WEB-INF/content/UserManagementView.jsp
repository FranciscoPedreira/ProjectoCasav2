<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Company Salary List</title>
<link rel="stylesheet" type="text/css" href="<s:url value='/css/style.css'/>">
</head>
<body>

	<jsp:include page="/WEB-INF/content/Menu.jsp" />

	<h1>User Management</h1>
	
	<%--<c:url var="createUserUrl" context="/ProjectoCasa" scope="request" value="/content/CreateUserView.jsp"/>
	<a href = "<c:out value="${createUserUrl}"/>">Add new user</a>--%>
	
	<s:submit id="addUser" type="button" value="Add new user" onclick="location.href='/ProjectoCasa/content/CreateUserView.jsp';" /> 
	
	<br/>
	<br/>
	
	<table>
		<tr>
			<%-- <td id="labelTd"><strong><label for="username">Username: </label></strong></td>
			<td id="labelTd"><strong><label for="password">Password: </label></strong></td> --%>
		</tr>
	</table>
	
	<c:forEach items="${listUsers}" var="u"> 
	
		<form action="UserManagementViewAction" method="post">
			<table>
				<tr>
					<td><input type='hidden' name='username' value='${u.getUsername()}'></td>
					<td><input type='hidden' name='userId' value='${u.getUserId()}'></td>
				</tr>
				<tr>
				
					<td>
						<c:url var="editUserURL" context="/ProjectoCasa" scope="request" value="/content/EditUserView.jsp">
							<c:param name = "username" value ='${u.getUsername()}'/>
							<c:param name = "userId" value ='${u.getUserId()}'/>
						</c:url>
						<a href = "<c:out value="${editUserURL}"/>">${u.getUserId()} - ${u.getUsername()}</a>
					</td>
					
					<%-- <td><input type='text' name='username' disabled value='${u.getUsername()}'></td>
					<td><input type='password' name='password' value='${u.getPassword()}'></td>
					<td><s:submit theme="simple" action="UserManagementDeleteAction" key="button.deleteUser"/></td>
					<td><s:submit theme="simple" action="UserManagementViewAction" key="button.updateUser"/></td> --%>
				</tr>
			</table>
		 	
	 	</form>
	 	
	</c:forEach>

</body>
</html>