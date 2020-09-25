<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<html>
<head>
    <jsp:include page="style.jsp"/>
    <title><fmt:message key="label.main"/></title>
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
            <h2><fmt:message key="label.tour"/></h2>
            <p><fmt:message key="label.list.tour"/></p>
            <p><a class="btn btn-link" href="/tour_list"><fmt:message key="label.more"/>... &raquo;</a></p>
        </div>
        <div class="col-lg-4">
            <div class="wrapper"><img src="/img/country.jpg" class="rounded-circle" alt="" width="300" height="300"></div>
            <h2><fmt:message key="label.country"/></h2>
            <p><fmt:message key="label.list.country"/></p>
            <p><p><a class="btn btn-link" href="/show_country"><fmt:message key="label.more"/>... &raquo;</a></p>
        </div>
        </div>
    </div>
</div>
</body>
</html>