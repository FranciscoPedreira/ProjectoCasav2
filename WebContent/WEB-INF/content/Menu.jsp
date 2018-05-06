<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

<ul id="menu">
    <c:forEach items="${menu}" var="item">
        <li>
            <c:choose>
                <c:when test="${pageContext.request.servletPath == item.value}">
                	<b>${item.key}</b>
                </c:when>
                <c:when test="${!userName.equals('admin') && item.key == 'User Management'}"> 
                	
                </c:when>
                <c:otherwise>
                	<a href="${item.value}">${item.key}</a>
                </c:otherwise>
            </c:choose>
        </li>
    </c:forEach>
</ul>

</body>
</html>