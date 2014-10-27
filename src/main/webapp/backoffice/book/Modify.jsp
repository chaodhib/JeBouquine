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
	<s:label>Modifier un livre :</s:label>
	<s:form action="Modify" namespace="/backoffice/book">
		<s:textfield name="book.title" value="%{book.title}" label="Titre" required="true"/>
		  
		<s:select name="authorId" value="%{book.author.id}" label="Auteur" list="authorList" listKey="id" emptyOption="false"/>
		<s:select name="categoryId" value="%{book.category.id}" label="Catégorie" list="categoryList" listKey="id" listValue="name" emptyOption="false"/>
		<s:select name="publisherId" value="%{book.publisher.id}" label="Editeur" list="publisherList" listKey="id" listValue="name" emptyOption="false"/>

		<s:textfield name="book.isbn" value="%{book.isbn}" label="ISBN" required="true"/>
		<s:textfield name="book.year" value="%{book.year}" label="Année de Publication (4chiffres)" required="true"/>
		
		<s:number id="formatedPrice" name="book.price"/> <!-- Permet d'éviter le bug d'input un prix en notation EN -->	 
		<s:textfield name="book.price" value="%{formatedPrice}" label="Prix"  required="true"/>
		<s:textfield name="book.urlImage" value="%{book.urlImage}" label="URL Image" />
		<s:textfield name="book.urlImageMini" value="%{book.urlImageMini}" label="URL Image Miniature (150px en hauteur)" />
		<s:checkbox name="book.isAvailable" label="Disponible" />
		<s:checkbox name="book.isNovelty" label="Nouveauté" />
		<s:checkbox name="book.isBestSales" label="Meilleur vente" />
		<s:hidden name="book.id" value="%{book.id}"/>
		<s:submit />
	</s:form>
</body>
</html>