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
	
	<h1>Edit Salary</h1>
	
		<form action="DetailSalarySaveAction" method="post">
		
			<s:submit theme="simple" id="deleteEmployee" action="SalaryDeleteAction" key="button.deleteSalary"/>
		
			<table>
				<tr>
					<td><input type='hidden' id='salaryId' name='salaryId' value=<c:out value='${salaryId}'/>></td>
				</tr>
				<tr>
					<td>
						<label for="salaryGroup">Salary Group: </label>
						<input type='text' id='salaryGroup' name='salaryGroup' value=<c:out value='${salaryGroup}'/>>
					</td>
				</tr>
				<tr>
					<td>
						<label for="value">Value: </label>
						<input type='text' id='value' name='value' value=<c:out value='${value}'/>>
					</td>
				</tr>
			</table>
			
			<br/>
		 	
		 	<s:submit theme="simple" action="DetailSalarySaveAction" key="button.updateSalary"/>
		    
		 	<br />
		 	<br />
		 	
	 	</form>

		<s:select label="Select Employee"
		   name="employeesWithoutSalaryGroup"
		   headerValue="Select Employee"
		   list="employeesWithNoSalary"
		/>

</body>
</html>