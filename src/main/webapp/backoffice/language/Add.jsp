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

	<s:form action="Add" namespace="/backoffice/language">
		<s:label>Ajouter une nouvelle langue :</s:label>
		<s:textfield name="language.name" label="Nom" required="true" />
		<s:submit />
	</s:form>
	 <a href= Menu>Retourner au menu de la section</a>
</body>
</html>