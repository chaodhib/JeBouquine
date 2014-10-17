<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<s:div style="background-color:#cdf1ff;  min-height: 120px;">
		<s:div style="display: inline-block;">
			<s:url action="Menu" id="return" />
			<s:a href="%{return}">
				<img src="http://i.imgur.com/8GVUFNq.png" width="150px" />
			</s:a>
		</s:div>

		<s:div align="center"
			style="display:inline-block;  position:absolute; left: 40%">
			<s:div>
				<s:form action="Search" namespace="/frontoffice/book">
					<s:textfield name="keywords" required="true" />
					<s:submit value="Rechercher"></s:submit>
				</s:form>
			</s:div>
			
			<a href=/frontoffice/book/prepAdvSearch>Recherche
				avancée</a>
				
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
		<HR>
	</s:div>
</body>
</html>