<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello World</title>
    </head>
    <body>
    
    	<h1>Login</h1>
    
        <s:form action="welcomeUserAction">
            <s:textfield name="userName" label="User Name" />
            <s:password name="passWord" label="Password" />
            <s:submit type="button">
    			<s:text name="Login" />
			</s:submit>
        </s:form>
    </body>
</html>