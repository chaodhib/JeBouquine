<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Livre(s) ajouté(s) à votre panier - JeBouquine</title>
	<!-- Import CSS -->
	<s:head  template="css.ftl" templateDir="ressources/template" />
</head>
<body >
	<s:action name="Header" executeResult="true" namespace="/frontoffice"></s:action> 
	
	<div id="content">
	Cet article a bien été intégré à votre panier! <br>
	<s:a action="View" namespace="/frontoffice/cart">Aller au panier</s:a> <br>
	<s:a action="Menu" namespace="/frontoffice">Retourner à l'accueil</s:a>
	</div>

	<!-- Import JavaScript -->
	<s:head  template="js.ftl" templateDir="ressources/template" />
</body>
</html>