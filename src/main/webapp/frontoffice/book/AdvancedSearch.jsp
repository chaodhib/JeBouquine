<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recherche avancée</title>
</head>
<body style="font-family: Arial;">
	<s:action name="HeaderBand" executeResult="true" namespace="/frontoffice"></s:action>
	<s:action name="Header" executeResult="true" namespace="/frontoffice"></s:action>
	<s:label>Rechercher un livre :</s:label>
	<s:form action="Search" namespace="/frontoffice/book">
		<s:textfield name="searchBook.title" label="Titre"/>
		<s:select name="authorId" label="Auteur" list="authorList" listKey="id" emptyOption="true"/>
		<s:select name="categoryId" label="Catégorie" list="categoryList" listKey="id" listValue="name" emptyOption="true"/>
		<s:select name="publisherId" label="Editeur" list="publisherList" listKey="id" listValue="name" emptyOption="true"/>
		<s:textfield name="searchBook.isbn" label="ISBN"/>
		<s:textfield name="searchBook.year" label="Année de Publication (4chiffres)"/>
		<s:submit/>
	</s:form>
 	<a href=../Menu>Retour à l'accueil</a>
</body>
</html>