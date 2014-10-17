<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenue sur JeBouquine</title>
</head>
<body bgcolor="#ffffff" style="font-family: Arial;">
	<s:action name="HeaderBand" executeResult="true"
		namespace="/frontoffice"></s:action>
	<s:action name="Header" executeResult="true" namespace="/frontoffice"></s:action>
	<h2>Meilleures ventes:</h2>
	<table style="width: 100%">
		<col width="20%" />
		<col width="20%" />
		<col width="20%" />
		<col width="20%" />
		<col width="20%" />
		<tr style="border-bottom: 1px solid #000;">
			<td><h4>Titre</h4></td>
			<td><h4>Auteur</h4></td>
			<td><h4>Année de publication</h4></td>
			<td><h4>Prix</h4></td>
			<td><h4>Voir la Fiche</h4></td>
		</tr>

		<s:iterator value="bestSales">
			<tr>

				<td><s:div style="float:left;">
						<img src="<s:property value="url" />" style="height: 100px" />
						<s:property value="title" />
					</s:div></td>
				<td><s:property value="author.firstName" /> <s:property value="author.lastName" /></td>
				<td><s:property value="year" /></td>
				<td><s:property value="price" /> euros</td>
				<td><s:form action="View" namespace="/frontoffice/book">
						<input type="submit" name="modifMap[<s:property value='id'/>]"
							value="Voir" />
					</s:form></td>
			</tr>
		</s:iterator>
	</table>

	<br />
	<br />
	<h2>Nouveautés:</h2>

	<!--  <img src="http://static.giantbomb.com/uploads/original/1/17172/1419618-unicorn2.jpg" width="100px"/> Signé Camille Leonard-->

	<table style="width: 100%">
		<col width="20%" />
		<col width="20%" />
		<col width="20%" />
		<col width="20%" />
		<col width="20%" />
		<tr>
			<td><h4>Titre</h4></td>
			<td><h4>Auteur</h4></td>
			<td><h4>Année de publication</h4></td>
			<td><h4>Prix</h4></td>
			<td><h4>Voir la Fiche</h4></td>
		</tr>
		<s:iterator value="novelties">
			<tr>
				<td><s:div style="float:left;">
						<img src="<s:property value="url" />" style="height: 100px" />
						<s:property value="title" />
					</s:div></td>
				<td><s:property value="author.firstName" /> <s:property value="author.lastName" /></td>
				<td><s:property value="year" /></td>
				<td><s:property value="price" /> euros</td>
				<td><s:form action="View" namespace="/frontoffice/book">
						<input type="submit" name="modifMap[<s:property value='id'/>]"
							value="Voir" />
					</s:form></td>

			</tr>
		</s:iterator>
	</table>

</body>
</html>