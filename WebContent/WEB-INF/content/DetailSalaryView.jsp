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

		<div id="selectEmployeeWithoutSalary">
		
			<form>
				<s:select label="Select Employee"
				   headerKey="-1"
				   name="employeeWithoutSalaryGroup"
				   headerValue="Select Employee"
				   list="EmployeesWithoutSalaryList"
				   value="defaultSearchEngine"
				/>
				<input type='hidden' name='salaryId' value='${salaryId}'>
				<s:submit theme="simple" action="EmployeeSalarySaveAction" key="button.addEmployee"/>
			</form>
			
			<c:forEach items="${EmployeesWithSalaryList}" var="e">
			
				<table>
					<tr>
						<td><input type='hidden' name='username' value='${e[1]} ${e[2]}'></td>
						<td><input type='hidden' name='userId' value='${e[0]}'></td>
					</tr>
					<tr>
					
						<td>
							<s:form>
								<input type="hidden" name="employeeIdToDelete" value="${e[0]}"/>
								<c:out value="${e[0]} ${e[1]} ${e[2]}"/>
								<s:submit id="removeEmployeeFromGroup" theme="simple" action="EmployeeSalaryDeleteAction" key="button.remove"/>
							</s:form>
						</td>
						
						<%-- <td><input type='text' name='username' disabled value='${u.getUsername()}'></td>
						<td><input type='password' name='password' value='${u.getPassword()}'></td>
						<td><s:submit theme="simple" action="UserManagementDeleteAction" key="button.deleteUser"/></td>
						<td><s:submit theme="simple" action="UserManagementViewAction" key="button.updateUser"/></td> --%>
					</tr>
				</table>
			
			</c:forEach>
			
			
			
		</div>
		

</body>
</html>