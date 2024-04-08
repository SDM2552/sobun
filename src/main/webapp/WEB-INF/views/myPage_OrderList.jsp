<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지 - 주문 정보</title>
</head>
<body>
<c:import url="header.jsp" />
	<h1>주문 정보</h1>
	<hr>
	<h2>주문 내역</h2>
	<table>
        <thead>
            <tr>
                <th>주문 번호</th>
                <th>주문 일자</th>
                <th>총 상품 수량</th>
                <th>총 결제 금액</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${orderList}" var="order">
                <tr>
                    <td>${order.orderId}</td>
                    <td>${order.createDate}</td>
                    <td>${order.totalItemCount} 개 </td>
                    <td>${order.totalAmount} 원</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>