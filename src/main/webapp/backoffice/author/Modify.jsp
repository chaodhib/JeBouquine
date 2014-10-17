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

	<s:form action="Modify" namespace="backoffice/author">
		<s:label>Modifier un auteur :</s:label>
		<s:textfield name="author.firstName" value="%{author.firstName}" label="Prénom" required="true" />
		<s:textfield name="author.lastName" value="%{author.lastName}" label="Nom" required="true" />
		<s:hidden name="author.id" value="%{author.id}"/>
		<s:submit />
	</s:form>
</body>
</html>