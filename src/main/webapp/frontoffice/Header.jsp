<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<style type="text/css">
		.HeaderLinks:link {
			/* 			color: #2447B2; */
			text-decoration: none;
		}
		
		.HeaderLinks:visited {
			/* 			color: #2447B2; */
			text-decoration: none;
		}
		
		#HeaderBox {
			background-color: #cdf1ff;
			min-height: 135px;
		}
		
		.logo {
			display: inline-block;
			margin-top: 12px;
		}
		
		/*
		form {
			width: 500px;
			margin: 50px auto;
		}
				
		.search {
			padding: 8px 15px;
			background: rgba(50, 50, 50, 0.2);
			border: 0px solid #dbdbdb;
		}
		
		.button {
			position: relative;
			padding: 6px 15px;
			left: -8px;
			border: 2px solid #207cca;
			background-color: #207cca;
			color: #fafafa;
		}
		
		.button:hover {
			background-color: #fafafa;
			color: #207cca;
		}
		*/
</style>
</head>
<body>
	<s:url action="PrepAdvSearch" id="prepAdvSearch" namespace="/frontoffice/book" />
	<s:url action="Menu" id="return" namespace="/frontoffice" />

	<s:div id="HeaderBox">
	
		<s:div cssClass="logo">
			<s:a href="%{return}"> 
				<img src="http://i.imgur.com/8GVUFNq.png" width="150px" />
			</s:a>
		</s:div>

		<s:div align="center" style="display:inline-block;  position:absolute; left: 40%">
			<s:div>
				
					<s:form action="Search" namespace="/frontoffice/book">
							<s:textfield name="keywords" required="true" />
							<s:submit value="Go"></s:submit>
					</s:form>
				
<!-- 					<form> -->
<!--                                 <input class="search" type="text" placeholder="Search..." required> -->
<!--                                 <input class="button" type="button" value="Search"> -->
<!-- 					</form> -->
			</s:div>

			<s:a cssClass="HeaderLinks" href="%{prepAdvSearch}">Recherche avancée</s:a>

			<s:div>
				<table style="background-color: #E6E6FA" border="1">
					<tr>

						<s:iterator value="categories">
							<td><s:form action="Search" namespace="/frontoffice/book">
									<s:hidden name="categoryId" value="%{id}" />
									<s:submit value="%{name}"></s:submit>
								</s:form></td>
						</s:iterator>
					</tr>
				</table>
			</s:div>

		</s:div>

	</s:div>
<!-- 	<HR> -->
</body>
</html>