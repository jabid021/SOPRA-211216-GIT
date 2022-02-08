<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<%
		if (request.getAttribute("error") != null) {
		%>
		<div style="color: red;">${error}</div>
		<%
		}
		%>
		<form action="hello" method="post">
			<input type="hidden" name="q" value="hello">
			<input name="user">
			<button type="submit">envoyer</button>
		</form>
	</div>
</body>
</html>