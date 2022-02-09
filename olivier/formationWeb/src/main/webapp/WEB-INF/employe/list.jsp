<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>liste des employes</h1>
		<table class="table">
			<c:forEach items="${employes}" var="e">
				<tr>
					<td>${e.id}</td>
					<td>${e.nom}</td>
					<td>${e.poste}</td>
					<td>${e.civilite}</td>
					<td>${e.adresse.numero}&nbsp;${e.adresse.rue}</td>
					<td>${e.adresse.codePostal}</td>
					<td>${e.adresse.ville}</td>
					<td><fmt:parseDate value="${e.dateEmbauche}"
							pattern="yyyy-MM-dd" type="date" var="embauche"></fmt:parseDate>
						<fmt:formatDate value="${embauche}" pattern="dd/MM/yyyy" /></td>
					<td>${e.salaire}</td>
					<td>${e.commission}</td>
					<td><a href="?q=edit&id=${e.id}" class="btn btn-primary">editer</a></td>
					<td><a href="?q=delete&id=${e.id}" class="btn btn-danger">supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="?q=add" class="btn btn-link">nouvel employe</a>
	</div>
</body>
</html>