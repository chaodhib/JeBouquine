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
		
		#HeaderBox{
			background-color:#cdf1ff;  
			min-height: 135px;
		}
	</style>
</head>
<body>
	<s:url action="PrepAdvSearch" id="prepAdvSearch"
		namespace="/frontoffice/book" />

	<s:div id="HeaderBox">
		<s:div cssStyle="display: inline-block; margin-top: 12px;" >
			<s:url action="Menu" id="return" />
			<s:a cssStyle="" href="%{return}">
				<img src="http://i.imgur.com/8GVUFNq.png" width="150px" />
			</s:a>
		</s:div>

		<s:div align="center" style="display:inline-block;  position:absolute; left: 40%">
			<s:div>
				<table>
					<s:form action="Search" namespace="/frontoffice/book">
						<tr>
							<td><s:textfield name="keywords" required="true" /></td>
							<td><s:submit value="Rechercher"></s:submit></td>
						</tr>
					</s:form>
				</table>
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