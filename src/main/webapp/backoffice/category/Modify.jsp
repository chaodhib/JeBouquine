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

	<s:form action="Modify" namespace="/backoffice/category">
		<s:label>Modifier une catégorie :</s:label>
		<s:textfield name="category.name" value="%{category.name}" label="Nom" required="true" />
		<s:hidden name="category.id" value="%{category.id}"/>
		<s:submit />
	</s:form>
</body>
</html>