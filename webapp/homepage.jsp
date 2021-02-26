<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

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
                <h3> <fmt:message key="label.user.cabinet"/>, ${sessionScope.user.firstName} ${sessionScope.user.lastName}.</h3>
                <h1> ${sessionScope.user.address}</h1>
                <h1> ${sessionScope.user.phoneNumber}</h1>
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
            <c:when test="${sessionScope.role == 'CLIENT'}">
                <div class="btn-group-vertical " role="group" aria-label="Basic example">
                <a href="/tour_list" type="button"
                   class="btn btn-secondary"><fmt:message key="label.list.tour"/></a>
                <a href="/show_country" type="button"
                   class="btn btn-secondary"><fmt:message key="label.list.country"/></a>
                </div>
            </c:when>
        </c:choose>
        <c:choose>
            <c:when test="${sessionScope.role == 'GUEST' || sessionScope.role == null}">
                <fmt:message key="error.guest.unlogin.homepage"/>
            </c:when>
        </c:choose>
    </div>
</div>
</body>
</html>

