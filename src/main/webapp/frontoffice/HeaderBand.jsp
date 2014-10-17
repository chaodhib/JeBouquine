<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<s:url action="View" id="viewCart" namespace="/frontoffice/cart" />
	<s:url action="ToLogin" var="toLogin" namespace="/frontoffice/log" />
	<s:url action="ToRegister" var="toRegister" namespace="/frontoffice/log" />
	<s:url action="Logout" var="logout" namespace="/frontoffice/log" />
	<s:url action="LoadAccount" var="loadAccount" namespace="/frontoffice/account" />
	
	<s:div style="background-color:#5974a2; min-height: 35px;">
		<s:if test="#session.cart!=null">
			<s:a href="%{viewCart}">
				<s:if test="#session.cart.nberLines == 0">
					<img src="http://i.imgur.com/L5GjpFK.png" height="35px" />
				</s:if>
				<s:else>
					<img src="http://i.imgur.com/DJqUCU6.png" height="35px" />
				</s:else>
				<s:div style="border-left-width:10%; float:left; color:white; padding:8px; ">(<s:property
						value="#session.cart.nberLines"/>)</s:div></s:a>
		</s:if>
		<s:else>
			<s:a href="%{viewCart}">
				<s:div
					style="border-left-width: 50px; float:left; color:white; position:relative; padding:8px;">(0)</s:div>
				<img src="http://i.imgur.com/L5GjpFK.png" height="35px" />
			</s:a>
		</s:else>
		<s:if test="#session.sessionAccount!=null">
			<s:div align="center"
				style="display:inline-block; color:white; position:relative; padding:8px;">
				Bonjour 
				<s:property value="#session.sessionAccount.name"/>!</s:div>
				
			<s:div
				style="display:inline-block; color:white; position:relative; padding:8px;">
				<s:a href="%{loadAccount}">Mon Compte</s:a>
				<s:a href="%{logout}">Déconnexion</s:a>
			</s:div>
		</s:if>
		<s:else>
			<s:div
				style="float:right; color:white; position:relative; padding:8px;">
				<s:a href="%{toLogin}">Se connecter</s:a>
				<s:a href="%{toRegister}">S'inscrire</s:a>
			</s:div>
		</s:else>
	</s:div>

</body>
</html>