<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 Il y a <s:property value="sizeOfList"/> éditeurs dans la DB :
 	<table>
	<s:form action="PreModifOrSuppr" namespace="/backoffice/publisher">
	<tr>
 		<th>Nom</th>
 		<th>Modifier</th>
 		<th>Supprimer</th>
 	</tr>
		<s:iterator value="publishers">
			<tr>
				<td><s:property value="name" /></td>
			
				<td>
				<input type="submit" name="modifMap[<s:property value='id'/>]" value="Modifier" />
				</td>
				<td>
				<input type="submit" name="modifMap[<s:property value='id'/>]" value= "Supprimer" />
				</td>
			</tr>
		</s:iterator>
	</s:form>
	</table>
	<br>

 <a href=Add.jsp>Ajouter</a><br>
 <a href=../Menu>Menu principal</a> <br> <br>

</body>
</html>
