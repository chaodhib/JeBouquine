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
Résultats de la recherche d'auteur : <br>
Nombre de résultat : <s:property value="numberOfResult" />
	<table>
	<s:form action="PreModifOrSuppr" namespace="/backoffice/author">
		<tr>
			<th>Prénom</th>
			<th>Nom</th>
			<th>Modifier</th>
			<th>Supprimer</th>
		</tr>
		<s:iterator value="authors">
		<tr>
			<td><s:property value="firstName" /></td>
			<td><s:property value="lastName" /></td>
		
			<td><input type="submit" name="modifMap[<s:property value='id'/>]"
				value="Modifier" /></td>
			<td><input type="submit" name="modifMap[<s:property value='id'/>]"
				value="Supprimer" /></td>
			
		</tr>
		</s:iterator>
	</s:form>
	</table>
	<br>
	<a href= Gestion.jsp>Retourner au menu de la section</a>
</body>
</html>