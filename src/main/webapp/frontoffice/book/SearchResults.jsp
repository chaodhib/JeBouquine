<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Je Bouquine, résultats de la recherche</title>
</head>
<body bgcolor="#ffffff" style="font-family: Arial;">
	<s:action name="HeaderBand" executeResult="true" namespace="/frontoffice"></s:action>
	<s:action name="Header" executeResult="true" namespace="/frontoffice"></s:action>
	Critères de la recherche :
	<br>

	<s:if test="searchBook.title!=null">
		<s:if test="searchBook.title!=''">
			Titre :	<s:property value="searchBook.title" /> 
			<br>
		</s:if>
	</s:if>
	<s:if test="searchBook.author!=null">
		Auteur :	<s:property value="searchBook.author" />
		<br>
	</s:if>
	<s:if test="searchBook.editor!=null">
		Editeur :	<s:property value="searchBook.editor" />
		<br>
	</s:if>
	<s:if test="searchBook.category!=null">
		Catégorie :	<s:property value="searchBook.category" />
		<br>
	</s:if>
	<s:if test="searchBook.isbn!=null">
		<s:if test="searchBook.isbn!=''">
			ISBN :	<s:property value="searchBook.isbn" /> 
			<br>
		</s:if>
	</s:if>
	<s:if test="searchBook.year!=null">
		Année de Publication :	<s:property value="searchBook.year" />
		<br>
	</s:if>
	<s:if test="keywords!=null">
		Mot(s) clé(s) :	<s:property value="keywords" />
		<br>
	</s:if>
	Nombre de résultat :
	<s:property value="numberOfResult" />


	<table style="width: 100%" border="1">
		<col width="50" />
		<col width="30" />
		<col width="30" />
		<col width="20" />
		<col width="20" />
		<tr>
			<td><h3>Titre</h3></td>
			<td><h3>Auteur</h3></td>
			<td><h3>Editeur</h3></td>
			<td><h3>Prix</h3></td>
			<td><h3>Voir la Fiche</h3></td>
		</tr>

		<s:iterator value="searchResults">
			<tr>
				<td><s:property value="title" /></td>
				<td><s:property value="author.firstName" /> <s:property
						value="author.lastName" /></td>
				<td><s:property value="publisher.name" /></td>
				<td><s:property value="price" /> euros</td>
				<td><s:form action="View" namespace="/frontoffice/book">
						<input type="submit" name="modifMap[<s:property value='id'/>]"
							value="Voir" />
					</s:form></td>
			</tr>
		</s:iterator>

	</table>
	<a href=../Menu>Retour à l'accueil</a>
</body>
</html>