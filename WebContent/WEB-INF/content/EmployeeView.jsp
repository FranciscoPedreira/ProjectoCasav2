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
	
	<br/>
	<br/>
	
	<table>
		<tr>
			<td id="labelTd"><strong><label for="Department">Department</label></strong></td>
			<td id="labelTd"><strong><label for="Name">Name</label></strong></td>
		</tr>
	</table>
	
	<c:forEach items="${listEmployee}" var="e"> 
	
		<form action="DetailEmployeeViewAction" method="get">
		
			<table>
				<tr>
					<td><input type='hidden' name='employeeId' value='${e.getEmployeeId()}'></td>
				</tr>
				<tr>
					<td id="labelTd"><c:out value='${e.getDepartment()}'/></td>
					<td id="labelTd"><c:out value='${e.getEmployeeId()} - ${e.getFirstName()} ${e.getLastName()}'/></td>
					<td><s:submit theme="simple" id="detailEmployee" type="button" value="Detail" onclick="location.href='/ProjectoCasa/content/DetailEmployeeView.jsp';" /> </td>
				</tr>
			</table>
		 	
	 	</form>
	 	
	 	
	 	
	</c:forEach>
	
</body>
</html>