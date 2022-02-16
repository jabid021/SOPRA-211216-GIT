<%@page import="java.util.List"%>
<%@page import="formation.sopra.springBoot.model.Departement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
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
		<table class="table">
			<tr>
				<th>code:</th>
				<th>libelle:</th>
				<th>salaire minimum</th>
				<th>salaire maximum</th>
			</tr>
			<c:forEach items="${postes}" var="poste">
				<tr>
					<td>${poste.code}</td>
					<td>${poste.libelle}</td>
					<td>${poste.salaireMin}</td>
					<td>${poste.salaireMax}</td>
					<td><a href="${ctx}/poste/edit?code=${poste.code}"
						class="btn btn-primary">editer</a></td>
					<td><a href="${ctx}/poste/delete?code=${poste.code}"
						class="btn btn-danger"> supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="${ctx}/poste/add" class="btn btn-link">nouveau poste </a>
	</div>
</body>
</html>