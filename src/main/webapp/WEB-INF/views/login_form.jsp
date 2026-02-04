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
			<form action="/JWT/login" method="post">
				<input type="text" name="userId" placeholder="아이디"><br>
				<input type="text" name="userPw" placeholder="패스워드"><br>
				<input type="submit" value="로그인">
			</form>
		</div>
	</body>
</html>