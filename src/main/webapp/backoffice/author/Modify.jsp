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

	<s:form action="Modify" namespace="/backoffice/author">
		<s:label>Modifier un auteur :</s:label>
		<s:textfield name="author.firstName" value="%{author.firstName}" label="Prénom" required="true" />
		<s:textfield name="author.lastName" value="%{author.lastName}" label="Nom" required="true" />
		<s:hidden name="author.id" value="%{author.id}"/>
		<s:submit />
	</s:form>
</body>
</html>