<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Commande enregistrée - JeBouquine</title>
	<!-- Import CSS -->
	<s:head  template="css.ftl" templateDir="ressources/template" />
</head>
<body >
	<s:action name="Header" executeResult="true" namespace="/frontoffice"></s:action> 
	
	<div id="content">
	<h3>Merci pour votre commande!</h3><br>
	<h3>Votre réference de commande est :</h3><s:property value="orderRef"/>
	</div>

	<!-- Import JavaScript -->
	<s:head  template="js.ftl" templateDir="ressources/template" />
</body>
</html>