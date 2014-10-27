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
	<s:action name="HeaderBand" executeResult="true"
		namespace="/frontoffice"></s:action>
	<s:action name="Header" executeResult="true" namespace="/frontoffice"></s:action>


	<s:div style="height: 100%; width: 100%;" align="center">
		<h2>Identification</h2>
		<s:form action="Register" namespace="/frontoffice/log">
			<s:textfield name="client.login" label="Votre login" requiredLabel="true" required="true"/>
			<s:password name="client.password" label="Votre mot de passe" requiredLabel="true" required="true"/>
			<s:password name="checkPassword" label="Retaper votre mot de passe" requiredLabel="true" required="true"/>
			<s:textfield name="client.email" label="Votre email" requiredLabel="true" required="true"/>
			<br>
			<s:textfield name="client.firstName" label="Votre prénom" requiredLabel="true" required="true"/>
			<s:textfield name="client.lastName" label="Votre nom" requiredLabel="true" required="true"/>
			<s:submit />
		</s:form>
	</s:div>

</body>
</html>