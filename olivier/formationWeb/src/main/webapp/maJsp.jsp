<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%-- commentaire jsp --%>
<!-- commentaire html  -->
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
		<h1>hello de la jsp</h1>
		<div>
			le parametre prenom avec request.getParameter:<%=request.getParameter("prenom").toUpperCase() %><br>
			le parametre prenom avec une el:${param.prenom}
		</div>
		<%
		//scriptlet
		//java pur
		out.write("du texte genere en java dans la page");
		%>
		<%
		for (int i = 10; i < 50; i=i+10) {
		%>
		<div style="font-size: <%=i%>px">
			la valeur de i:<%=i%>
		</div>
		<%
		}
		%>
	</div>
</body>
</html>