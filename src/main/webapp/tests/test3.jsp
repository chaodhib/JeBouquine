<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%= request.getLocale().getCountry() %>
	
	<%   %>
	
	<s:form>
	<s:textfield name="a" value="" label="Prix"></s:textfield>
	<s:submit/>
	</s:form>
</body>
</html>