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
Titre : <s:property value="book.title"/> <br>
Auteur : <s:property value="book.author"/> <br>
Catégorie : <s:property value="book.category.name"/> <br>
Editeur : <s:property value="book.publisher.name"/> <br>
ISBN : <s:property value="book.isbn"/> <br>
Année de Publication : <s:property value="book.year"/> <br>
Prix : <s:property value="book.price"/> <br>
URL de l'image : <s:property value="book.urlImage"/> <br>
URL de l'image miniature : <s:property value="book.urlImageMini"/> <br>
	 <a href= Menu>Retourner au menu de la section</a>
</body>
</html>