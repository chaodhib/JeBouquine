<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Résultat de recherche - JeBouquine</title>
	<!-- Import CSS -->
	<s:head  template="css.ftl" templateDir="ressources/template" />
</head>
<body >
	<s:action name="Header" executeResult="true" namespace="/frontoffice"></s:action> 
	
	<div id="content">
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


	<table style="width: 100%" class="table">
		<col width="50" />
		<col width="30" />
		<col width="30" />
		<col width="20" />
		<col width="20" />
		<thead>
		<tr>
			<th>Titre</th>
			<th>Auteur</th>
			<th>Editeur</th>
			<th>Prix</th>
			<th>Voir la Fiche</th>
		</tr>
		</thead>
		
		<tbody>
		<s:iterator value="searchResults">
			<tr>
				<td><s:property value="title" /></td>
				<td><s:property value="author.firstName" /> <s:property
						value="author.lastName" /></td>
				<td><s:property value="publisher.name" /></td>
				<td><s:number name="price"/> &euro;</td>
				<td>
					<s:url action="View" namespace="/frontoffice/book" var="bookPage">
							<s:param name="bookId" value="%{id}" />
					</s:url> 
					<s:a href="%{bookPage}">Voir</s:a>
				</td>
			</tr>
		</s:iterator>
		</tbody>

	</table>
	<br/>
	<a href=../Menu>Retour à l'accueil</a>
	</div>

	<!-- Import JavaScript -->
	<s:head  template="js.ftl" templateDir="ressources/template" />
</body>
</html>