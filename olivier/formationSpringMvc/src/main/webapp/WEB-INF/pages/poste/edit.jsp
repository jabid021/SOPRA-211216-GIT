<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<form:form action="${ctx}/poste/save" method="post"
			modelAttribute="poste">
			<div class="form-group">
				<form:label path="code">code:</form:label>
				<form:input path="code" cssClass="form-control" />
				<form:errors path="code" cssClass="alert alert-danger small" element="div"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="libelle">libelle:</form:label>
				<form:input path="libelle" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="salaireMin">salaire minimum:</form:label>
				<form:input type="number" path="salaireMin" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="salaireMax">salaire maximum:</form:label>
				<form:input type="number" path="salaireMax" cssClass="form-control" />
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-success">enregistrer</button>
				<a href="${ctx}/poste" class="btn btn-warning">annuler</a>
			</div>
		</form:form>
	</div>
</body>
</html>