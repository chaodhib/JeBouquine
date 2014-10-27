<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Commande : étape 2</title>
</head>
<body bgcolor="#ffffff" style="font-family: Arial;">
	<s:action name="HeaderBand" executeResult="true" namespace="/frontoffice"></s:action>
	<s:action name="Header" executeResult="true" namespace="/frontoffice"></s:action>
	
	<s:form action="PrepStep3" namespace="/frontoffice/order">
		<s:textfield name="paymentInfos" value="%{paymentInfos}" label="Informations de payement" required="true" />
		<s:submit value="Aller à l'étape suivante"/>
	</s:form>
</body>
</html>