<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--<fmt:setLocale value="${sessionScope.language}"/>--%>
<fmt:setBundle basename="language"/>

<html>
<head>
    <jsp:include page="style.jsp"/>
    <title>Main Page</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="col">

    </div>
    <div class="jumbotron text-center" style="background-image: url(img/background.jpg)" >
        <h1><p class="text-white"><fmt:message key="label.main"/></p> </h1>
        <p class="text-white"><fmt:message key="label.main.header"/> </p>
    </div>
    <div class="container">
        <div class="row justify-content-center">
        <div class="col-lg-4">
                <div class="wrapper"><img src="/img/tour.jpg" class="rounded-circle" alt="" width="300" height="300"/></div>
            <h2>Туры</h2>
            <p>Список тур</p>
            <p><a class="btn btn-link" href="/tour_list">Подробнее... &raquo;</a></p>
        </div>
        <div class="col-lg-4">
            <div class="wrapper"><img src="/img/country.jpg" class="rounded-circle" alt="" width="300" height="300"></div>
            <h2>Страны</h2>
            <p>Выбрать тур по стране</p>
            <p><p><a class="btn btn-link" href="/show_country_list_admin">Подробнее... &raquo;</a></p>
        </div>
        </div>
    </div>
</div>
</body>
</html>