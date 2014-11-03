<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<style>
		.HeaderBandBody{
			background-color:#5974a2; 
			min-height: 35px;
		}
	
		.HeaderBandLinks:link{
			color:white;
			text-decoration: none;
		}
		
		.HeaderBandLinks:visited{
			color:white;
			text-decoration: none;
		}
		a img
      	{
        	border: none;
      	}
		
		.login{
			float:right; 
			color:white; 
			padding:8px;
		}
		
		.welcome{
			float:right; 
			color:white; 
			padding:8px;
		}
		
		.cart{
			
		}
	</style>
</head>
<body>
	<s:url action="View" id="viewCart" namespace="/frontoffice/cart" />
	<s:url action="ToLogin" var="toLogin" namespace="/frontoffice/log" />
	<s:url action="ToRegister" var="toRegister" namespace="/frontoffice/log" />
	<s:url action="Logout" var="logout" namespace="/frontoffice/log" />
	<s:url action="LoadAccount" var="loadAccount" namespace="/frontoffice/account" />
	
	<s:div cssClass="HeaderBandBody">
		
		<!-- DEBUT Msg d'accueil perso & Log -->
		<s:if test="#session.sessionAccount!=null">
			<s:div cssClass="login" >
				<s:a cssClass="HeaderBandLinks" href="%{loadAccount}">Mon Compte</s:a>
				<s:a cssClass="HeaderBandLinks" href="%{logout}">Déconnexion</s:a>
			</s:div>
			
			<s:div cssClass="welcome" >
				Bonjour <s:property value="#session.sessionAccount.name"/>!
			</s:div>
		</s:if>
		<s:else>
			<s:div cssClass="login" >
				<s:a cssClass="HeaderBandLinks" href="%{toLogin}">Se connecter</s:a>
				<s:a cssClass="HeaderBandLinks" href="%{toRegister}">S'inscrire</s:a>
			</s:div>
		</s:else>
		<!-- FIN Msg d'accueil perso & Log -->
		
		<!-- DEBUT Panier -->
		<s:if test="#session.cart!=null">
			<s:a cssClass="cart" href="%{viewCart}">
				<s:if test="#session.cart.nberLines == 0">
					<img src="http://i.imgur.com/L5GjpFK.png" height="35px" />
				</s:if>
				<s:else>
					<img src="http://i.imgur.com/DJqUCU6.png" height="35px" />
				</s:else>
				<s:div  style="float:left; color:white; padding:8px; ">
					(<s:property value="#session.cart.nberLines"/>)
				</s:div>
			</s:a>
		</s:if>
		<s:else> 
			<s:a cssClass="cart" href="%{viewCart}">
				<s:div style="float:left; color:white; padding:8px;">(0)</s:div>
				<img src="http://i.imgur.com/L5GjpFK.png" height="35px" />
			</s:a>
		</s:else>
		<!-- FIN Panier -->
		
	</s:div>
</body>
</html>