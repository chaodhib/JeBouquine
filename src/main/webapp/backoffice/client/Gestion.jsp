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
	<s:label>Rechercher un livre :</s:label>
	<s:form action="Search" namespace="backoffice/client">
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
