<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매하기</title>
</head>
<body>

	<c:choose>
    <c:when test="${empty loggedInMember}">
         <script>
            alert('로그인이 필요합니다');
            window.location.href = '/loginForm'; <%-- 로그인 페이지로 이동 --%>
        </script>
    </c:when>
    <c:otherwise>
<c:import url="header.jsp" />
	<h1>구매하기</h1>
	<hr>
    </c:otherwise>
</c:choose>
</body>
</html>