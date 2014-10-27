<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulter les détails d'un livre</title>
<style type="text/css">
	th{
		text-align: left;
	}
</style>
</head>
<body>

<table border="1">
	<tr><th>Titre</th> <td><s:property value="book.title"/></td> </tr>
	<tr><th>Auteur</th> <td><s:property value="book.author"/></td> </tr>
	<tr><th>Catégorie</th> <td><s:property value="book.category.name"/></td> </tr>
	<tr><th>Editeur</th> <td><s:property value="book.publisher.name"/></td> </tr>
	<tr><th>ISBN</th> <td><s:property value="book.isbn"/></td> </tr>
	<tr><th>Année de Publication</th> <td><s:property value="book.year"/></td> </tr>
	<tr><th>Prix</th> <td><s:number name="book.price"/> &euro;</td> </tr>
	<tr><th>URL de l'image</th> <td><s:property value="book.urlImage"/></td> </tr>
	<tr><th>URL de l'image miniature</th> <td><s:property value="book.urlImageMini"/></td> </tr>
	<tr><th>Disponible</th> <td><s:property value="book.isAvailable"/></td> </tr>
	<tr><th>Nouveauté</th> <td><s:property value="book.isNovelty"/></td> </tr>
	<tr><th>Meilleur vente</th> <td><s:property value="book.isBestSales"/></td> </tr>
</table>
	 <a href= Menu>Retourner au menu de la section</a>
</body>
</html>