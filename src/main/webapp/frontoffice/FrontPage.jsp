<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Bienvenue sur JeBouquine</title>
	<style type="text/css">
		body {
 			font-family: Arial;
 			font-size: 1em;
 			background-color: white; 
/*  		line-height: 1.3em; */

		}
		
		/*
		h2 {
			color: #6699FF;
		}
		
		.cases{
 			background-color: #6699FF;
 			width: 200px;
 			float: left;
 			margin: 10px;} 
		}
		
		.BookCases{
			height: 250px;
 			width: 200px;
 			float:center;
			background-color: #FF0000;
			left-margin:auto;
			right-margin:auto;
		}
		*/
		.cell{
/*  			background-color: #0088dd;  */
			height: 275px;
		}
		
		.cellCount{
/*  			background-color: #FF0000;  */
			float: left;
			padding: 5px;
			/*
			position: relative;
			top: 0px;
			*/
		}
		
		.cellBook{
/* 			background-color: #00CC00; */ 
			float: left;
			width: 80%;
		}
		
		.miniImages{
		max-width: 100%;
		height: 150px;
		}
	</style>
</head>
<body >
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
		<s:iterator value="bestSales" status="iteratorStatus" >
			<td > 
			<s:div cssClass="cell">
				<s:div cssClass="cellCount">
					<s:property value="#iteratorStatus.count" />&#46;
				</s:div>
				
				<s:div cssClass="cellBook">
					<img class="miniImages" src="<s:property value="urlImageMini" />" alt="book cover"/> <br>
					<s:property value="title" /> <br>
					de <s:property value="author.firstName" /> <s:property value="author.lastName" /><br>
					<s:number name="price"/> &euro;<br>
					<s:form action="View" namespace="/frontoffice/book">
							<input type="submit" name="modifMap[<s:property value='id'/>]" value="Voir" />
					</s:form>
				</s:div>
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
		<s:iterator value="novelties" status="iteratorStatus" >
			<td > 
			<s:div cssClass="cell">
				<s:div cssClass="cellCount">
					<s:property value="#iteratorStatus.count" />&#46;
				</s:div>
				
				<s:div cssClass="cellBook">
					<img class="miniImages" src="<s:property value="urlImageMini" />" alt="book cover"/> <br>
					<s:property value="title" /> <br>
					de <s:property value="author.firstName" /> <s:property value="author.lastName" /><br>
					<s:number name="price"/> &euro;<br>
					<s:form action="View" namespace="/frontoffice/book">
							<input type="submit" name="modifMap[<s:property value='id'/>]" value="Voir" />
					</s:form>
				</s:div>
			</s:div>	
			</td>
		</s:iterator>
		</tr>
	</table>

<!-- 	 <img src="http://static.giantbomb.com/uploads/original/1/17172/1419618-unicorn2.jpg" width="100px"/> Signé Camille Leonard -->


</body>
</html>