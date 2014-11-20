<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Se connecter - JeBouquine</title>
	<!-- Import CSS -->
	<s:head  template="css.ftl" templateDir="ressources/template" />
</head>
<body >
	<s:action name="Header" executeResult="true" namespace="/frontoffice"></s:action> 
	
	<div id="content">
	<s:div style="display: inline-block; height: 100%; width: 50%;"
		align="center">
		<h2>Identification</h2>
		<s:form action="Login" namespace="/frontoffice/log">
			<s:textfield name="login" label="Identifiant" required="true"/>
			<s:password name="password" label="Mot de passe" required="true"/>
			<s:submit />
		</s:form>
		<s:if test="errorLogin == true">
			<s:div style="color: red;">Mot de passe ou identifiant incorrects</s:div>
		</s:if>
	</s:div>

	<s:div style="float:right; height: 100%; width: 50%;" align="center">
		<h2>Pas encore inscrit?</h2>
		<s:a href="Register.jsp">
			<button type="button">Créer un compte!</button>
		</s:a>
	</s:div>
	</div>

	<!-- Import JavaScript -->
	<s:head  template="js.ftl" templateDir="ressources/template" />
</body>
</html>