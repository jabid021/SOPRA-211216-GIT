<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<form action="" method="post">
			<div class="form-group">
				<label>id:</label> <input class="form-control" name="id"
					value="${departement.id}" readonly="readonly">
			</div>
			<div class="form-group">
				<label>nom:</label> <input class="form-control" name="nom"
					value="${departement.nom}">
			</div>
			<div class="form-group">
				<button class="btn btn-success">enregistrer</button>
				<a href="?" class="btn btn-warning">annuler</a>
			</div>
		</form>
	</div>
</body>
</html>