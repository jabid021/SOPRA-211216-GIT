<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${error!=null}">
		<div>infos obligatoires</div>
	</c:if>
	<form action="bonjour" method="post">
		<div>
			prenom:<input name="prenom" value="${personne.prenom}">
		</div>
		<div>
			nom:<input name="nom" value="${personne.nom}">
		</div>
		<div>
			<button type="submit">ok</button>
		</div>
	</form>
</body>
</html>