<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:url action="Menu" 			var="return" namespace="/frontoffice"/>
<s:url action="PrepAdvSearch" 	var="prepAdvSearch" namespace="/frontoffice/book"/>
<s:url action="View" 			var="viewCart" namespace="/frontoffice/cart" />
<s:url action="ToLogin" 		var="toLogin" namespace="/frontoffice/log" />
<s:url action="ToRegister" 		var="toRegister" namespace="/frontoffice/log" />
<s:url action="Logout" 			var="logout" namespace="/frontoffice/log" />
<s:url action="LoadAccount" 	var="loadAccount" namespace="/frontoffice/account" />

<nav class="navbar navbar-default navbar-custom " role="navigation">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<s:a cssClass="navbar-brand" href="%{return}">JeBouquine</s:a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		
			<!-- Recherche Simple -->
			<form class="navbar-form navbar-left" action="/jebouquine/frontoffice/book/Search" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Rechercher" name="keywords" required="required">
				</div>	
				<button type="submit" class="btn btn-default" title="Rechercher">
						<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
				</button>
			</form>
			

			<!-- Recherche Avancée -->
			<s:a href="%{prepAdvSearch}">
			<button type="button" class="btn btn-default navbar-btn navbar-left" title="Recherche avancée" onclick="">
				<img style="height: 18px;" src="<s:url value="/ressources/images/binoculars2.PNG"/>">
			</button>
			</s:a>


			<ul class="nav navbar-nav navbar-right">
				<!-- Partie Panier -->
				<s:if test="#session.cart!=null">
				<li>
					<s:a cssClass="cart" href="%{viewCart}">
					<s:number currency="EUR" type="currency" name="#session.cart.totalPrice"/>  
					(<s:property value="#session.cart.nberLines"/>)
					<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
					</s:a>
				</li>
				</s:if>
				<s:else> 
				<li>
					<s:a cssClass="cart" href="%{viewCart}">
					<s:number currency="EUR" type="currency" name="0"/>  
					(0)
					<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
					</s:a>
				</li>
				</s:else>
				
				<!-- Partie Compte -->
				<s:if test="#session.sessionAccount!=null">
				<li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Votre Compte <span class="caret"></span></a>
			          <ul class="dropdown-menu" role="menu">
			            <li><s:a href="%{loadAccount}">Paramètres</s:a></li>
			            <li><s:a href="%{logout}">Déconnexion</s:a></li>
			          </ul>
			    </li>
				</s:if>
				<s:else>
					<li><s:a href="%{toLogin}">Se connecter</s:a></li>
					<li><s:a href="%{toRegister}">S'inscrire</s:a></li>
				</s:else>
			</ul>
		</div>
	</div>

	<div class="container-fluid collapse navbar-collapse">
		<ul class="nav navbar-nav">
			<s:iterator value="categories">
				<li>
				<s:url action="Search" namespace="/frontoffice/book" var="catSearch">
						<s:param name="categoryId" value="%{id}" />
				</s:url> 
				<s:a href="%{catSearch}"> <s:property value="name" /> </s:a>
				</li>
			</s:iterator>
		</ul>
	</div>
</nav>