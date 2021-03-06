<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Votre panier - JeBouquine</title>
	<!-- Import CSS -->
	<s:head  template="css.ftl" templateDir="ressources/template" />
</head>
<body >
	<s:action name="Header" executeResult="true" namespace="/frontoffice"></s:action> 
	
	<div id="content">
	<table style="width: 60%" class="table">
		<col width="40%">
		<col width="20%">
		<col width="20%">
		<col width="20%">
			<tr  style="border-bottom: 1px solid #000;">
			<td><h4>Titre</h4></td>
			<td><h4>Quantité</h4></td>
			<td><h4>Prix</h4></td>
			<td><h4></h4></td>
		</tr>
		
		<s:iterator value="cart.lines">
			<tr>
				<td><s:property value="bookTitle" /></td>
				<td><s:property value="quantity" /></td>
				<td><s:number name="subTotalPrice" maximumFractionDigits="2" /> &euro;</td>
				<s:hidden name="bookId" value="%{bookId}"></s:hidden>

				<td><s:form action="DeleteCartLine"
						namespace="/frontoffice/cart">
						<s:hidden name="bookId" value="%{bookId}"></s:hidden>
						<s:submit type="image" src="https://i.imgur.com/te8udff.png" style="height:35px;" value="Supprimer" />
					</s:form></td>
			</tr>
		</s:iterator>

	</table>
	Total :
	<s:number name="cart.totalPrice" maximumFractionDigits="2" /> &euro;
	<s:if test="#session.cart.nberLines!=0">
	
	<br>
	<s:a action="PrepModifyQuantity" namespace="/frontoffice/cart">Modifier les quantités</s:a>
	<br>
	<s:if test="#session.sessionAccount!=null">
		<s:a action="PrepStep1" namespace="/frontoffice/order">Passer la commande</s:a>
		<br>
	</s:if>
	<s:else>
		<s:a action="ToLogin" namespace="/frontoffice/log">Passer la commande</s:a>
		<br>
	</s:else>
		
	</s:if>
	<br>
	<s:a action="Menu" namespace="/frontoffice">Retourner à l'accueil</s:a>
	</div>

	<!-- Import JavaScript -->
	<s:head  template="js.ftl" templateDir="ressources/template" />
</body>
</html>