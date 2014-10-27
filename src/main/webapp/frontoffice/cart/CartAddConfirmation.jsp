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
	
	Cet ajout a bien été intégré à votre panier! <br>
	<s:a action="View" namespace="/frontoffice/cart">Aller au panier</s:a> <br>
	<s:a action="Menu" namespace="/frontoffice">Retourner à l'accueil</s:a>
</body>
</html>