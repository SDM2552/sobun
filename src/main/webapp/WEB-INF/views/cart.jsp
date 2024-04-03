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
        <th>선택</th>
    </tr>
</thead>
<tbody id="cartItems">
    <c:forEach var="item" items="${itemsInCart}">
        <tr>
            <td>${item.name}</td>
            <td><img src="${item.image}" width="100" height="100" alt="상품 이미지"></td>
            <td>${item.price}</td>
            <td>${item.cartItemQuantity}</td>
            <td><input type="checkbox" class="itemCheckbox" data-price="${item.price}" data-quantity="${item.cartItemQuantity}" checked></td>
        </tr>
        </c:forEach>
    </tbody>
</table>

<div id="summary">
    총 수량: <span id="totalQuantity">0</span><br>
    총 금액: <span id="totalPrice">0</span>
</div>

<script>
    // 각 아이템의 수량과 가격을 가져와서 총 수량과 총 금액을 계산하는 함수
    function calculateTotal() {
        let totalQuantity = 0;
        let totalPrice = 0;
        const items = document.querySelectorAll("#cartItems tr");
        items.forEach(function(itemRow) {
            const isChecked = itemRow.querySelector(".itemCheckbox").checked;
            if (isChecked) {
                const quantity = parseInt(itemRow.querySelector("td:nth-child(4)").textContent);
                const price = parseFloat(itemRow.querySelector("td:nth-child(3)").textContent);
                totalQuantity += quantity;
                totalPrice += quantity * price;
            }
        });
        // 계산된 총 수량과 총 금액을 HTML 요소에 반영
        document.getElementById("totalQuantity").textContent = totalQuantity;
        document.getElementById("totalPrice").textContent = totalPrice.toFixed(2); // 소수점 2자리까지 표시
    }

    // 페이지 로드 시 총 수량과 총 금액 계산
    window.onload = calculateTotal;

    // 체크박스 상태 변경 시 총 수량과 총 금액 재계산
    const checkboxes = document.querySelectorAll(".itemCheckbox");
    checkboxes.forEach(function(checkbox) {
        checkbox.addEventListener("change", function() {
            calculateTotal();
        });
    });
</script>
</body>
</html>