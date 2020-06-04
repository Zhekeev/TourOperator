<%--
  Created by IntelliJ IDEA.
  User: ergaz
  Date: 28.05.2020
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/index.jsp">Tour Operator</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <c:choose>
                <c:when test="${sessionScope.role == 'GUEST' || sessionScope.role == null}">
                </c:when>
                <c:otherwise>
                    <li class="nav-item active">
                        <a class="nav-link" href="/homepage.jsp">Кабинет<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/contract">Заказы<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Настройки
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="/edit_user_password.jsp">Сменить пароль</a>
                            <a class="dropdown-item" href="/edit_user.jsp">Редактировать данные</a>
                        </div>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
        <c:choose>
            <c:when test="${sessionScope.role == 'GUEST' || sessionScope.role == null}">
                <a class="nav-link" href="/login.jsp">Логин<span class="sr-only">(current)</span></a>
                <a class="nav-link" href="/registration.jsp">Регистрация<span class="sr-only">(current)</span></a>
            </c:when>
            <c:otherwise>
                <a class="nav-link" href="/logout">Выход<span class="sr-only">(current)</span></a>
            </c:otherwise>
        </c:choose>
    </div>
</nav>
