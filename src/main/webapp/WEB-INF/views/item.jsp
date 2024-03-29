<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="header.jsp" />
	<h1>상품 정보</h1>
	<hr>
	<form action="#">
	<table>
    <tr>
        <th class="category">카테고리</th>
        <th class="name">상품명</th>
        <th class="image" >상품 이미지 </th>
        <th class="price" >가격 </th>
    </tr>
    <tr>
        <td>${item.category}</td>
        <td>${item.name} </td>
        <td>${item.image}</td>
        <td>${item.price}</td>
    </tr>
	</table>
	</form>
	<button onclick="location.href='#'">장바구니</button>
	<button onclick="location.href='#'">구매하기</button><br>
</body>
</html>