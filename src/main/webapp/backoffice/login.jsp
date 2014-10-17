<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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