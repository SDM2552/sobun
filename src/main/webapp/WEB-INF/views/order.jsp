<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 페이지</title>
</head>
<body>
<c:import url="header.jsp" />
	<h1>결제하기</h1>
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
        <c:forEach var="item" items="${selectedItems}">
            <tr>
                <td>${item.itemName}</td>
                <td><img src="${item.image}" width="100" height="100" alt="상품 이미지"></td>
                <td>${item.itemPrice}</td>
                <td>${item.itemCount}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
	
</body>
</html>