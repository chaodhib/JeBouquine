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
	<s:label>Modifier un livre :</s:label>
	<s:form action="Modify" namespace="backoffice/book">
		<s:textfield name="book.title" value="%{book.title}" label="Titre" required="true"/>
		 
		<s:select name="authorId" value="%{book.author.id}" label="Auteur" list="authorList" listKey="id" emptyOption="false"/>
		<s:select name="categoryId" value="%{book.category.id}" label="Catégorie" list="categoryList" listKey="id" listValue="name" emptyOption="false"/>
		<s:select name="publisherId" value="%{book.publisher.id}" label="Editeur" list="publisherList" listKey="id" listValue="name" emptyOption="false"/>

		<s:textfield name="book.isbn" value="%{book.isbn}" label="ISBN"/>
		<s:textfield name="book.year" value="%{book.year}" label="Année de Publication (4chiffres)"/>
		<s:textfield name="book.price" value="%{book.price}" label="Prix"/>
		<s:hidden name="book.id" value="%{book.id}"/>
		<s:submit />
	</s:form>
</body>
</html>