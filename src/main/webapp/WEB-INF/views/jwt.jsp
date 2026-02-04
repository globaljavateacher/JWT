<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JWT</title>
	</head>
	<body>
		<div>
			<h1>Hello JWT</h1>
		</div>
		<h3>
			<span>headerJson : <%=request.getAttribute("headerJson") %></span><br>
			<span>payloadJson : <%=request.getAttribute("payloadJson") %></span><br>
			<span>JWT : <%=request.getAttribute("JWT") %></span>
		</h3>
		<div>
			<form action="/JWT/validate" method="post">
				<input type="text" name="jwt" value="<%=request.getAttribute("JWT") %>"><br>
				<input type="submit" value="검증">
			</form>
		</div>
	</body>
</html>