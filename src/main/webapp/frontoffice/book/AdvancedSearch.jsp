<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Recherche avancée - JeBouquine</title>
	<!-- Import CSS -->
	<s:head  template="css.ftl" templateDir="ressources/template" />
</head>
<body >
	<s:action name="Header" executeResult="true" namespace="/frontoffice"></s:action> 

	<div id="content">
	<h3>Rechercher un livre :</h3>
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
 	</div>

	<!-- Import JavaScript -->
	<s:head  template="js.ftl" templateDir="ressources/template" />
</body>
</html>