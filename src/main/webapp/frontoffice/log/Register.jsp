<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>S'inscrire - JeBouquine</title>
	<!-- Import CSS -->
	<s:head  template="css.ftl" templateDir="ressources/template" />
</head>
<body >
	<s:action name="Header" executeResult="true" namespace="/frontoffice"></s:action> 
	
	<div id="content">
	<s:div style="height: 100%; width: 100%;" align="center">
		<h2>Identification</h2>
		<s:form action="Register" namespace="/frontoffice/log">
			<s:textfield name="client.login" label="Votre login" required="true"/>
			<s:password name="client.password" label="Votre mot de passe" required="true"/>
			<s:password name="checkPassword" label="Retaper votre mot de passe" required="true"/>
			<s:textfield name="client.email" label="Votre email" required="true"/>
			<s:textfield name="client.firstName" label="Votre prénom" required="true"/>
			<s:textfield name="client.lastName" label="Votre nom" required="true"/>
			<s:submit />
		</s:form>
	</s:div>
	</div>

	<!-- Import JavaScript -->
	<s:head  template="js.ftl" templateDir="ressources/template" />
</body>
</html>