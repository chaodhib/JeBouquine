<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test du DAO GlobalParam</title>
</head>
<body bgcolor="#ffffff" style="font-family: Arial;">
	
	<s:form action="GlobalParamDAO" namespace="/tests">
	Persister un nouveau parametre : <br>
<%-- 		<s:textfield name="param.name" label="Nom du parametre" required="false" /> --%>
<%-- 		<s:textfield name="param.value" label="Valeur du parametre" required="false" /> --%>
		<s:submit value="Valider"/>
	</s:form>
</body>
</html>