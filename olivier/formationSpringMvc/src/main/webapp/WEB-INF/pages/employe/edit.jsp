<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<form:form action="${ctx}/employe/save" method="get"
			modelAttribute="employe">
			<div class="form-group">
				<form:label path="id">id:</form:label>
				<form:input path="id" placeholder="generation auto" readonly="true"
					cssClass="form-control" />

			</div>
			<div class="form-group">
				<form:label path="civilite">civilite</form:label>
				<form:select path="civilite" cssClass="form-control"
					items="${civilites}" itemLabel="titre">
				</form:select>
			</div>
			<div class="form-group">
				<form:label path="nom">nom:</form:label>
				<form:input path="nom" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="poste">poste:</form:label>
				<form:select path="poste.code" cssClass="form-control"
					items="${postes}" itemLabel="libelle" itemValue="code" />

			</div>
			<div class="form-group">
				<form:label path="dateEmbauche">date embauche:</form:label>
				<form:input type="date" path="dateEmbauche" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="adresse.numero">numero:</form:label>
				<form:input path="adresse.numero" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="adresse.rue">rue:</form:label>
				<form:input path="adresse.rue" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="adresse.codePostal">code postal:</form:label>
				<form:input path="adresse.codePostal" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="adresse.ville">ville:</form:label>
				<form:input path="adresse.ville" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="salaire">salaire:</form:label>
				<form:input path="salaire" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="commission">commission:</form:label>
				<form:input path="commission" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="departement">departement:</form:label>
				<form:select path="departement.id" cssClass="form-control">
					<form:options items="${departements}" itemLabel="nom"
						itemValue="id" />
				</form:select>
			</div>
			<div>
				<form:label path="manager">manager:</form:label>
				<form:select path="manager.id" cssClass="form-control">
					<form:option value="">pas de manager</form:option>
					<form:options items="${employes}" itemLabel="infos" itemValue="id" />
				</form:select>
			</div>
			<div>
				<button type="submit" class="btn btn-success">enregistrer</button>
				<a href="${ctx}/employe" class="btn btn-warning">annuler</a>
			</div>
		</form:form>
	</div>
</body>
</html>