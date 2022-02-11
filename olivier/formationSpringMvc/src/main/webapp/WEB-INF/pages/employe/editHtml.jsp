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
		<form action="${ctx}/employe/save" method="post">
			<div class="form-group">
				<label>id:</label> <input class="form-control" name="id"
					placeholder="generation automatique" readonly="readonly"
					value="${employe.id}">
			</div>
			<div class="form-group">
				<label>civilite</label> <select name="civilite" class="form-control">
					<c:forEach var="c" items="${civilites}">
						<c:choose>
							<c:when test="${employe.civilite==c}">
								<option value="${c}" selected="selected">${c.titre}</option>
							</c:when>
							<c:otherwise>
								<option value="${c}">${c.titre}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label>nom:</label> <input class="form-control" name="nom"
					value="${employe.nom}">
			</div>
			<div class="form-group">
				<label>poste:</label> <input class="form-control" name="poste"
					value="${employe.poste}">
			</div>
<!-- 			<div class="form-group"> -->
<!-- 				<label>embauche:</label> <input type="date" class="form-control" -->
<%-- 					name="dateEmbauche" value="${employe.dateEmbauche}"> --%>
<!-- 			</div> -->
			<div class="form-group">
				<label>numero:</label> <input type="number" class="form-control"
					name="adresse.numero" value="${employe.adresse.numero}">
			</div>
			<div class="form-group">
				<label>rue:</label> <input class="form-control" name="adresse.rue"
					value="${employe.adresse.rue}">
			</div>
			<div class="form-group">
				<label>code postal:</label> <input class="form-control"
					name="adresse.codePostal" value="${employe.adresse.codePostal}">
			</div>
			<div class="form-group">
				<label>ville:</label> <input class="form-control" name="adresse.ville"
					value="${employe.adresse.ville}">
			</div>
			<div class="form-group">
				<label>salaire:</label> <input type="number" class="form-control"
					name="salaire" value="${employe.salaire}">
			</div>
			<div class="form-group">
				<label>commission:</label> <input type="number" class="form-control"
					name="commission" value="${employe.commission}">
			</div>
			<div>
				<button type="submit" class="btn btn-success">enregistrer</button>
				<a href="${ctx}/employe" class="btn btn-warning">annuler</a>
			</div>
		</form>
	</div>
</body>
</html>