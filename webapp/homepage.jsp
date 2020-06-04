<%--
  Created by IntelliJ IDEA.
  User: ergaz
  Date: 17.04.2020
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="style.jsp"/>
    <title>Tour Operator</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row">
        <c:choose>
            <c:when test="${sessionScope.role == 'GUEST' || sessionScope.role == null}">
            </c:when>
            <c:otherwise>
                <h3> Кабинет пользователя, ${sessionScope.user.firstName}.</h3>
            </c:otherwise>
        </c:choose>

    </div>
    <div class="col">
        <c:choose>
            <c:when test="${sessionScope.role == 'ADMIN'}">
                <jsp:include page="admin_right_panel.jsp"/>
            </c:when>
        </c:choose>
        <c:choose>
            <c:when test="${sessionScope.role == 'CLIENT' || sessionScope.role == null}">
                <a href="/controller/tour_list" type="button"
                   class="btn btn-secondary">Список туров</a>
                <a href="/show_country_list_admin" type="button"
                   class="btn btn-secondary">Список стран</a>
                <a href="/show_service_list_admin" type="button"
                   class="btn btn-secondary">Список услуг</a>
            </c:when>
        </c:choose>
        <c:choose>
            <c:when test="${sessionScope.role == 'GUEST' || sessionScope.role == null}">
                Войдите или зарегистрируйтесь чтобы войти в свой кабинет!
            </c:when>
        </c:choose>
    </div>
</div>
</body>
</html>

