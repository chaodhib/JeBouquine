<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mon Compte</title>
</head>
<body bgcolor="#ffffff" style="font-family: Arial;">
	<s:action name="HeaderBand" executeResult="true"
		namespace="/frontoffice"></s:action>
	<s:action name="Header" executeResult="true" namespace="/frontoffice"></s:action>
	
	<s:url action="EditAccount" var="modif" namespace="/frontoffice/account" />
	
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


</body>
</html>