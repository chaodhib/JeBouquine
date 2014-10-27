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

	<s:form action="Modify"  namespace="/backoffice/language">
		<s:label>Modifier une langue :</s:label>
		<s:textfield name="language.name" value="%{language.name}" label="Nom" required="true" />
		<s:hidden name="language.id" value="%{language.id}"/>
		<s:submit />
	</s:form>
</body>
</html>