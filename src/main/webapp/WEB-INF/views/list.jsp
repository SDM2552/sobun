<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ǰ ���</title>
</head>
<body>
<c:import url="header.jsp" />
	<h1>��ǰ ���</h1>
	<hr>
<table>
    <tr>
        <th class="category">ī�װ�</th>
        <th class="name">��ǰ��</th>
        <th class="image" >��ǰ �̹��� </th>
        <th class="price" >���� </th>

    </tr>
<c:forEach var="item" items="${list}">         
        <tr>
            <td>${item.category}</td>
            <td><a href="item?itemId=${item.itemId}">${item.name}</a>
            </td>
            <td>${item.image}</td>
            <td>${item.price}</td>
        </tr>
</c:forEach>
</table>
</body>
</html>