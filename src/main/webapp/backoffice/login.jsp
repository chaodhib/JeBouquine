<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BackOffice jeBouquine</title>
</head>
<body>

	<s:form action=".action">
		<s:label>Veuillez entrer vos identifiants :</s:label>
		<s:textfield name="login" label="Log" />
		<s:textfield name="password" label="Pass" />
		<s:submit />
	</s:form>
</body>
</html>