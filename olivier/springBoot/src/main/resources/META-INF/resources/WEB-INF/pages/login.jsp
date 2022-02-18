<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="" method="post">
		login:<input name="username"><br> passd:<input
			name="password"><br> <input name="${_csrf.parameterName}"
			value="${_csrf.token}">
		<button type="submit">envoyer</button>
	</form>
</body>
</html>