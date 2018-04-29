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

	<h1>Company Salary List</h1>
	
	<c:url var="createSalaryUrl" context="/ProjectoCasa" scope="request" value="/CreateSalaryiew"/>
	<a href = "<c:out value="${createSalaryUrl}"/>">Create new salary registry</a>
	
	<br/>
	<br/>
	
	<c:forEach items="${listSalary}" var="s"> 
	
		<form action="SalaryViewAction" method="post">
			<table>
				<tr>
					<td>
						<label for="firstName">First name: </label>
						<input type='text' name='firstName' disabled value='${s.getId().getFirstName()}'>
					</td>
					<td><input type='hidden' name='firstName' value='${s.getId().getFirstName()}'>
					</td>
				</tr>
				<tr>
					<td>
						<label for="lastName">Last name: </label>
						<input type='text' name='lastName'  disabled value='${s.getId().getLastName()}'>
					</td>
					<td><input type='hidden' name='lastName' value='${s.getId().getLastName()}'></td>
				</tr>
				<tr>
					<td>
						<label for="step">step: </label>
						<input type='text' name='step' value='${s.getStep()}'>
					</td>
				</tr>
				<tr>
					<td>
						<label for="value">Value: </label>
						<input type='text' name='value' value='${s.getValue()}'>
					</td>
				</tr>
			</table>
		 
		 	<br/>
		 
		 	<table>
		 		<tr>
		 			<td id="labelSpace"></td>
				    <td id="actionButton" >
				        <s:submit theme="simple" action="SalaryDeleteAction" key="button.deleteSalary"/>
				        <s:submit theme="simple" action="SalaryViewAction" key="button.updateSalary"/>
				    </td>
				 </tr>
		 	</table>
		    
		 	<br />
		 	<br />
		 	
	 	</form>
	 	
	</c:forEach>

</body>
</html>