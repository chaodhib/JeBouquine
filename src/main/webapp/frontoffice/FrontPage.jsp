<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>JeBouquine - Vente de livre en ligne</title>
	<!-- Import CSS -->
	<s:head  template="css.ftl" templateDir="ressources/template" />
</head>
<body >
	<s:action name="Header" executeResult="true" namespace="/frontoffice"></s:action> 
	
	<div id="content">
	<h2>Meilleures ventes:</h2>
	<table style="width: 100%" class="table">
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
					<s:url action="View" namespace="/frontoffice/book" var="bookPage">
							<s:param name="bookId" value="%{id}" />
					</s:url> 
					
					<s:a href="%{bookPage}">
					<img class="miniImages" src="<s:property value="urlImageMini" />" alt="book cover"/> <br>
					<s:property value="title" /> <br>
					</s:a>
					de <s:property value="author.firstName" /> <s:property value="author.lastName" /><br>
					<s:number name="price"/> &euro;<br>
				</s:div>
			</s:div> 
			</td>
		</s:iterator>
		</tr>
	</table>
	
	


	<br />
	<br />
	<h2>Nouveautés:</h2>
	<table style="width: 100%" class="table">
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
					<s:url action="View" namespace="/frontoffice/book" var="bookPage">
							<s:param name="bookId" value="%{id}" />
					</s:url> 
					
					<s:a href="%{bookPage}">
					<img class="miniImages" src="<s:property value="urlImageMini" />" alt="book cover"/> <br>
					<s:property value="title" /> <br>
					</s:a>
					de <s:property value="author.firstName" /> <s:property value="author.lastName" /><br>
					<s:number name="price"/> &euro;<br>
				</s:div>
			</s:div> 
			</td>
		</s:iterator>
		</tr>
	</table>
	</div>

	<!-- Import JavaScript -->
	<s:head  template="js.ftl" templateDir="ressources/template" />
</body>
</html>