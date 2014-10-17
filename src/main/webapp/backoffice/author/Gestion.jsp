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
 
	<s:form action="Search" namespace="backoffice/author">
		<s:label>Recherche un auteur :</s:label>
		<s:textfield name="searchAuthor.firstName" label="Prénom" />
		<s:textfield name="searchAuthor.lastName" label="Nom" />
		<s:submit />
	</s:form>

 <a href=Add.jsp>Ajouter</a> <br>
 <a href=../Menu>Menu principal</a> <br>

</body>
</html>
