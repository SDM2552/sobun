<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
</head>
<body>
<c:import url="header.jsp" />
	<h1>장바구니</h1>
	<hr>
	<table>
    <thead>
        <tr>

            <th>상품명</th>
            <th>상품 이미지</th>
            <th>가격</th>
            <th>수량</th>
        </tr>
    </thead>
    <tbody>
        <%-- Iterate through the list of cart items and display each item --%>
        <c:forEach var="cartItem" items="${carts}">
            <tr>

                <td><a href="/item/${cartItem.itemId}">${cartItem.name}</a></td>
                <td><img src="${cartItem.image}" width="100" height="100" alt="상품 이미지"></td>
                <td>${cartItem.price}</td>
                <td>${cartItem.quantity}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>