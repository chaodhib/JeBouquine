<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:label>Ajouter un nouveau livre :</s:label>
	<s:form action="Add" namespace="/backoffice/book">
		<s:textfield name="book.title" label="Titre" required="true"/>
		
		<s:select name="authorId" label="Auteur" list="authorList" listKey="id" emptyOption="false"/>
		<s:select name="categoryId" label="Catégorie" list="categoryList" listKey="id" listValue="name" emptyOption="false"/>
		<s:select name="publisherId" label="Editeur" list="publisherList" listKey="id" listValue="name" emptyOption="false"/>
		
		<s:textfield name="book.isbn" label="ISBN" required="true"/>
		<s:textfield name="book.year" label="Année de Publication (4chiffres)" required="true"/>
		<s:textfield name="book.price" label="Prix" required="true"/>
		<s:textfield name="book.urlImage" label="URL Image" />
		<s:textfield name="book.urlImageMini" label="URL Image Miniature (150px en hauteur)" />
		<s:checkbox name="book.isAvailable" label="Disponible" value="true" />
		<s:checkbox name="book.isNovelty" label="Nouveauté" value="false" />
		<s:checkbox name="book.isBestSales" label="Meilleur vente" value="false" />
		<s:submit/>
	</s:form>
	 <a href= Menu>Retourner au menu de la section</a>
</body>
</html>
