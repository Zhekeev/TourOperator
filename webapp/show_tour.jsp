<%--
  Created by IntelliJ IDEA.
  User: ergaz
  Date: 02.06.2020
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="style.jsp"/>
    <title>Туры</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/index.jsp">Tour Operator</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/homepage.jsp">Кабинет<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/homepage.jsp">Заказы<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Настройки
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Сменить пароль</a>
                    <a class="dropdown-item" href="#">Редактировать данные</a>
                </div>
            </li>
        </ul>
                <c:choose>
                <c:when test="${sessionScope.role == 'GUEST' || sessionScope.role == null}">
                        <a class="nav-link" href="/login.jsp">Логин<span class="sr-only">(current)</span></a>
                        <a class="nav-link" href="/registration.jsp">Регистрация<span class="sr-only">(current)</span></a>
            </c:when>
            <c:otherwise>
                <a class="nav-link" href="/homepage.jsp">Выход<span class="sr-only">(current)</span></a>
            </c:otherwise>
            </c:choose>
    </div>
</nav>
</body>
</html>
