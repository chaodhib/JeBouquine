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

	<s:form action="Modify" namespace="/backoffice/publisher">
		<s:label>Modifier une catégorie :</s:label>
		<s:textfield name="publisher.name" value="%{publisher.name}" label="Nom" required="true" />
		<s:hidden name="publisher.id" value="%{publisher.id}"/>
		<s:submit />
	</s:form>
</body>
</html>