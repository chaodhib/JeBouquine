<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:label>Ajouter un nouveau livre :</s:label>
	<s:form action="Add" namespace="backoffice/book">
		<s:textfield name="book.title" label="Titre" required="true"/>
		
		<s:select name="authorId" label="Auteur" list="authorList" listKey="id" emptyOption="false"/>
		<s:select name="categoryId" label="Catégorie" list="categoryList" listKey="id" listValue="name" emptyOption="false"/>
		<s:select name="publisherId" label="Editeur" list="publisherList" listKey="id" listValue="name" emptyOption="false"/>
		
		<s:textfield name="book.isbn" label="ISBN" required="true"/>
		<s:textfield name="year" label="Année de Publication (4chiffres)" required="true"/>
		<s:textfield name="price" label="Prix" required="true"/>
		<s:submit/>
	</s:form>
	 <a href= Menu>Retourner au menu de la section</a>
</body>
</html>
