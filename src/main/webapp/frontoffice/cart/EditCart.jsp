<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#ffffff" style="font-family: Arial;">
	<s:action name="HeaderBand" executeResult="true" namespace="/frontoffice"></s:action>
	<s:action name="Header" executeResult="true" namespace="/frontoffice"></s:action>
	
	<s:form action="ModifyQuantity">
	<s:iterator value="cart.lines">
		<s:property value="bookTitle" />
		<s:textfield name="modifMap['%{bookId}']" value="%{quantity}" required="true"/>
		<br>
	</s:iterator>
	
	<s:submit value="Mettre à jour les quantités"/>
	</s:form>
</body>
</html>