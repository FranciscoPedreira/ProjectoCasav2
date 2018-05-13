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
	
	<h1>Edit Employee</h1>
	
		<form action="DetailEmployeeSaveAction" method="get">
		
			<table>
				<tr>
					<td>
						<label for="employeeId">EmployeeId: </label>
						<input type='text' id='employeeId' name='employeeId' disabled value=<c:out value='${employeeId}'/>>
						<input type='hidden' id='employeeId' name='employeeId' value=<c:out value='${employeeId}'/>>
					</td>
				</tr>
				<tr>
					<td>
						<label for="firstName">First name: </label>
						<input type='text' id='firstName' name='firstName' value=<c:out value='${firstName}'/>>
					</td>
				</tr>
				<tr>
					<td>
						<label for="lastName">Last name: </label>
						<input type='text' id='lastName' name='lastName' value=<c:out value='${lastName}'/>>
					</td>
				</tr>
				<tr>
					<td>
						<label for="department">Department: </label>
						<input type='text' id='department' name='department' value=<c:out value='${department}'/>>
					</td>
				</tr>
				<tr>
					<td>
						<label for="salaryGroup">Salary Group: </label>
						<c:out value='${salaryGroup}'/>
					</td>
				</tr>
				
				<s:submit id="updateDetailEmployee" type="button" value="Update"/>
			
			</table>
		 	
	 	</form>
	
</body>
</html>