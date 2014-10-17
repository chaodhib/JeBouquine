<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifier mes données personnelles</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
    <!-- Load jQuery JS -->
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <!-- Load jQuery UI Main JS  -->
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
    <!-- Load SCRIPT.JS which will create datepicker for input field  -->
    <script src="datepickerScript.js"></script>
</head>

<body bgcolor="#ffffff" style="font-family: Arial;">
	<s:action name="HeaderBand" executeResult="true"
		namespace="/frontoffice"></s:action>
	<s:action name="Header" executeResult="true" namespace="/frontoffice"></s:action>


	<s:div style=" left:50%" align="center">
		<s:form action="ReloadAccount" namespace="/frontoffice/account">
			<s:textfield name="client.email" value="%{client.email}"
				label="Email" requiredLabel="true" required="true" />
			<s:textfield name="client.lastName" value="%{client.lastName}"
				label="Nom" requiredLabel="true" required="true" />
			<s:textfield name="client.firstName" value="%{client.firstName}"
				label="Prénom" requiredLabel="true" required="true" />

			<s:if test="client.adress != null">
				<s:textfield name="client.adress" value="%{client.adress}"
					label="Adresse" />
			</s:if>
			<s:else>
				<s:textfield name="client.adress" value="" label="Adresse" />
			</s:else>
			<s:if test="client.phoneNumber != null">
				<s:textfield name="client.phoneNumber" value="%{client.phoneNumber}"
					label="Numéro de téléphone" />
			</s:if>
			<s:else>
				<s:textfield name="client.phoneNumber" value=""
					label="Numéro de téléphone" />
			</s:else>

			<s:textfield name="client.birthdate" value="%{client.birthdate}"
				id="datepicker" label="Date de Naissance" />

			<s:password name="client.password" value=""
				label="Mot de passe" />
			<s:password name="checkPassword" label="Confirmer votre mot de passe" />
			<s:hidden name="client.login" value="%{client.login}"/>
			<s:submit value="Confirmer les modifications"/>
		</s:form>
	</s:div>
</body>
</html>