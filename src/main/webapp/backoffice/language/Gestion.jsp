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
 Il y a <s:property value="sizeOfList"/> langues dans la DB :
	<s:form action="PreModifOrSuppr" namespace="backoffice/language">
		<s:iterator value="languages">
			<s:property value="name" />
		
			<input type="submit" name="modifMap[<s:property value='id'/>]"
				value="Modifier" />
			<input type="submit" name="modifMap[<s:property value='id'/>]"
				value="Supprimer" />
			
			<br>
		</s:iterator>
	</s:form> <br>

 <a href=Add.jsp>Ajouter</a><br>
 <a href=../Menu>Menu principal</a> <br> <br>

</body>
</html>
