<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a href="/">메인으로</a>
<c:choose>
    <c:when test="${not empty loggedInMember}">
        <span>${loggedInMember.name} 님 환영합니다. <button id="logout">로그아웃</button></span>
    </c:when>
    <c:otherwise>
        <button onclick="location.href='/loginForm'">로그인</button>
    </c:otherwise>
</c:choose>
<hr>

<script>
document.getElementById('logout').addEventListener('click', ()=> {window.location.href = '/logout';});
</script>