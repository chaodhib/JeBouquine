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
Résultats de la recherche de livre : <br>
Nombre de résultat : <s:property value="numberOfResult" />
	<table>
	
	<s:form action="PreModifOrSuppr" namespace="/backoffice/book">
	<tr>
		<th>Titre</th>
		<th>Auteur</th>
		<th>ISBN</th>
		<th>Voir</th>
		<th>Modifier</th>
		<th>Supprimer</th>
	</tr>
		<s:iterator value="books">
			<tr>
			<td><s:property value="title" /></td>
			<td><s:property value="author" /></td>
			<td><s:property value="isbn" /></td>
		
			<td><input type="submit" name="modifMap[<s:property value='id'/>]"
				value="Voir" /></td>
			<td><input type="submit" name="modifMap[<s:property value='id'/>]"
				value="Modifier" /></td>
			<td><input type="submit" name="modifMap[<s:property value='id'/>]"
				value="Supprimer" /></td>
			<tr>
<!-- 			<br> -->
		</s:iterator>
	</s:form>
	</table>
	 <br>
	 <a href= Menu>Retourner au menu de la section</a>
</body>
</html>