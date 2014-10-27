<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:property value="book.title" /></title>
<style type="text/css">
	.images{
	max-height: 500px;
	max-width: 500px;
	}
</style>
</head>
<body bgcolor="#ffffff" style="font-family: Arial;">
	<s:action name="HeaderBand" executeResult="true" namespace="/frontoffice"></s:action>
	<s:action name="Header" executeResult="true" namespace="/frontoffice"></s:action>

	<s:div style="left:50%">
		<table>

			<tr>
				<td><div align="left" style="margin-left: 50px">
						<img class="images" src="<s:property value="book.urlImage" />"/>
					</div></td>
				<td>
					<div align="left" style="margin-left: 50px">
						Titre :
						<s:property value="book.title" />
						<br> Auteur :
						<s:property value="book.author" />
						<br> Catégorie :
						<s:property value="book.category.name" />
						<br> Editeur :
						<s:property value="book.publisher.name" />
						<br> ISBN :
						<s:property value="book.isbn" />
						<br> Année de Publication :
						<s:property value="book.year" />
						<br> Prix :
						<s:number name="book.price"/> &euro;
						<br>
					</div>
				</td>

			</tr>
		</table>
		<br>
		<br>
<%-- 		<%=  book.title%> --%>
		<s:if test="book.isAvailable">
			<s:form action="AddBookIntoCart" namespace="/frontoffice/cart">
				<s:select name="desiredQtt" label="Quantité" list="qttChoice"
					emptyOption="false" />
				<s:hidden name="bookId" value="%{book.id}" />
				<s:submit type="image" src="http://i.imgur.com/Hzc0zkg.png"
					style="height:45px;" value="Ajouter au panier"></s:submit>
			</s:form>
		</s:if>
		<s:else>
		Ce livre n'est actuellement pas disponible à la commande.<br>
		</s:else>
	</s:div>
	<a href=../Menu>Retour au menu</a>
	
	<br><br> Commentaires : <br>
	<s:if test="comments.size()==0">Il n'y a pour l'instant aucun commentaire client. </s:if>
	<s:iterator value="comments">
		<table>
			<tr>
				<td><s:property value="client.login" /></td>
				<td><s:property value="content" /></td>
			</tr>
		</table>
	</s:iterator>
	<br>
	<br>
	<s:if test="#session.sessionAccount!=null">
	Ajouter un commentaire :
	<s:form action="AddCommentAndRefresh" namespace="/frontoffice/book">
			<s:textarea name="commentToAdd.content" value=""
				style="width:500px;height:150px;"></s:textarea>
			<s:hidden name="bookId" value="%{book.id}" />
			<s:submit value="Envoyez"></s:submit>
		</s:form>
	</s:if>
	<s:else>
	Connectez vous pour poster un commentaire.
	</s:else>

</body>
</html>