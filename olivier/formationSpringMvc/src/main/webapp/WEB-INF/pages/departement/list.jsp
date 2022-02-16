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
				<th>id:</th>
				<th>nom:</th>
			</tr>
			<c:forEach items="${departements}" var="dept">
				<tr>
					<td>${dept.id}</td>
					<td>${dept.nom}</td>
					<td><a href="${ctx}/departement/edit?id=${dept.id}"
						class="btn btn-primary">editer</a></td>
					<td><a href="${ctx}/departement/delete?id=${dept.id}"
						class="btn btn-danger"> supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="${ctx}/departement/add" class="btn btn-link">nouveau
			departement </a>
	</div>
</body>
</html>