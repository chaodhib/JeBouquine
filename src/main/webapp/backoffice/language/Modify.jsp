<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<s:form action="Modify"  namespace="backoffice/language">
		<s:label>Modifier une langue :</s:label>
		<s:textfield name="language.name" value="%{language.name}" label="Nom" required="true" />
		<s:hidden name="language.id" value="%{language.id}"/>
		<s:submit />
	</s:form>
</body>
</html>