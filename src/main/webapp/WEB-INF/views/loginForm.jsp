<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<a href="/">메인으로</a>
	<hr>
	<h1>로그인</h1>
	<hr>
	<form action="login" method="post">
	아이디: <input type="text" name="userId" placeholder="ID 입력">
	비밀번호: <input type="text" name="password" placeholder="비밀번호 입력">
	<button type="submit">로그인</button>
	</form>
</body>
</html>