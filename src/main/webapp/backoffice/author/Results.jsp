<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Résultats de la recherche d'auteur : <br>
Nombre de résultat : <s:property value="numberOfResult" />
	<s:form action="PreModifOrSuppr" namespace="backoffice/author">
		<s:iterator value="authors">
			<s:property value="firstName" />
			<s:property value="lastName" />
		
			<input type="submit" name="modifMap[<s:property value='id'/>]"
				value="Modifier" />
			<input type="submit" name="modifMap[<s:property value='id'/>]"
				value="Supprimer" />
			
			<br>
		</s:iterator>
	</s:form> <br>
	 <a href= Gestion.jsp>Retourner au menu de la section</a>
</body>
</html>