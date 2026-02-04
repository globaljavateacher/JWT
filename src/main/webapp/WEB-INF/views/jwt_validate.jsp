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
		<div>
			<h3>
				<span>signature : <%=request.getAttribute("signature") %></span><br>
				<span>exp : <%=request.getAttribute("exp") %></span>
			</h3>
		</div>
	</body>
</html>