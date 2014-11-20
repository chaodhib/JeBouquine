<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Mon compte - JeBouquine</title>
	<!-- Import CSS -->
	<s:head  template="css.ftl" templateDir="ressources/template" />
</head>
<body >
	<s:action name="Header" executeResult="true" namespace="/frontoffice"></s:action> 
	
	<s:url action="EditAccount" var="modif" namespace="/frontoffice/account" />
	
	<div id="content">
	<s:div style=" left:50%" align="center">
		<h2>Mon Compte</h2>
		<table style="width: 50%">
			<col width="30%" />
			<col width="20%" />
			<tr>
				<td><b>Identifiant :</b></td>
				<td><s:property value="client.login" /></td>
			</tr>
			<tr>
				<td><b>Email :</b></td>
				<td><s:property value="client.email" /></td>
			</tr>
			<tr>
				<td><b>Nom :</b></td>
				<td><s:property value="client.lastName" /></td>
			</tr>
			<tr>
				<td><b>Prénom :</b></td>
				<td><s:property value="client.firstName" /></td>
			</tr>
			<tr>
				<td><b>Adresse :</b></td>
				<td><s:if test="client.adress != null">
						<s:property value="client.adress" />
					</s:if></td>
			</tr>
			<tr>
				<td><b>Date de naissance :</b></td>
				<td><s:if test="client.birthdate != null">
						<s:property value="client.birthdate" />
					</s:if></td>
			</tr>
			<tr>
				<td><b>Numéro de téléphone :</b></td>
				<td><s:if test="client.phoneNumber != null">
						<s:property value="client.phoneNumber" />
					</s:if></td>
			</tr>

		</table>
		<s:a href="%{modif}"><button type="button">Modifier</button></s:a>
	</s:div>
	</div>

	<!-- Import JavaScript -->
	<s:head  template="js.ftl" templateDir="ressources/template" />
</body>
</html>