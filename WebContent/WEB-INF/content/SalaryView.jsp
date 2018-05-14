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

	<h1>Company Salary List</h1>
	
	<s:submit id="createSalary" type="button" value="Create New Salary" onclick="location.href='/ProjectoCasa/content/CreateSalaryView.jsp';" />
	
	<br/>
	<br/>
	
	<table>
		<tr>
			<td><strong><label for="slaryGroup">Salary Group </label></strong></td>
			<td><strong><label for="value">Value </label></strong></td>
		</tr>
	</table>
	
	<c:forEach items="${listSalary}" var="s"> 
	
		<form action="DetailSalaryViewAction" method="get">
		
			<table>
				<tr>
					<td><input type='hidden' name='salaryId' value='${s.getSalaryId()}'></td>
				</tr>
				<tr>
					<td><input type='text' name='salaryGroup' value='${s.getSalaryGroup()}'></td>
					<td><input type='text' name='value' value='${s.getValue()}'></td>
				    <td><s:submit id="detailSalary" theme="simple" type="button" value="Detail" onclick="location.href='/ProjectoCasa/content/DetailSalaryView.jsp';" /> </td>
				</tr>
			</table>
		 	
	 	</form>
	 	
	</c:forEach>

</body>
</html>