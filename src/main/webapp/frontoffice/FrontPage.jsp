<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Bienvenue sur JeBouquine</title>
	<style type="text/css">
		body {
/* 			font-family: arial; */
/* 			background-color: rgb(185, 179, 175); */
		}
		
		h2 {
/* 			color: #6699FF; */
		}
		
		.cases{
/* 			background-color: #6699FF; */
/* 			width: 200px; */
/* 			float: left; */
/* 			margin: 10px;} */
		}
	</style>
</head>
<body bgcolor="#ffffff" style="font-family: Arial;">
	<s:action name="HeaderBand" executeResult="true" namespace="/frontoffice"></s:action>
	<s:action name="Header" executeResult="true" namespace="/frontoffice"></s:action>
	
	<h2>Meilleures ventes:</h2>
	
	<table style="width: 100%">
		<col width="20%" />
		<col width="20%" />
		<col width="20%" />
		<col width="20%" />
		<col width="20%" />
		<tr>
		<s:iterator value="bestSales">
			<td>
			<s:div style="float:left;">
				<img src="<s:property value="urlImageMini" />" alt="book cover"  style="height: 150px" /> <br>
				<s:property value="title" /> <br>
				<s:property value="author.firstName" /> <s:property value="author.lastName" /><br>
				<s:property value="price" /> &euro;<br>
				<s:form action="View" namespace="/frontoffice/book">
						<input type="submit" name="modifMap[<s:property value='id'/>]" value="Voir" />
				</s:form>
			</s:div>
			</td>
		</s:iterator>
		</tr>
	</table>
	
	


	<br />
	<br />
	<h2>Nouveautés:</h2>
	
	<table style="width: 100%">
		<col width="20%" />
		<col width="20%" />
		<col width="20%" />
		<col width="20%" />
		<col width="20%" />
		<tr>
		<s:iterator value="novelties">
			<td>
			<s:div style="float:left;">
				<img src="<s:property value="urlImageMini" />" alt="book cover"  style="height: 150px" /> <br>
				<s:property value="title" /> <br>
				<s:property value="author.firstName" /> <s:property value="author.lastName" /><br>
				<s:property value="price" /> &euro;<br>
				<s:form action="View" namespace="/frontoffice/book">
						<input type="submit" name="modifMap[<s:property value='id'/>]" value="Voir" />
				</s:form>
			</s:div>
			</td>
		</s:iterator>
		</tr>
	</table>

<!-- 	 <img src="http://static.giantbomb.com/uploads/original/1/17172/1419618-unicorn2.jpg" width="100px"/> Signé Camille Leonard -->


</body>
</html>