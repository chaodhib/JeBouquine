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
	<s:label>Rechercher un livre :</s:label>
	<s:form action="Search" namespace="/backoffice/client">
		<s:textfield name="searchClient.lastName" label="Nom" />
		<s:textfield name="searchClient.firstName" label="Prénom" />
		<s:textfield name="searchClient.login" label="Login" />
		<s:textfield name="searchClient.email" label="Email" />
		<s:submit />
	</s:form>

	<a href=PreAdd>Ajouter</a>
	<br>
	<a href=../Menu>Menu principal</a>
	<br>
	<br>

</body>
</html>
