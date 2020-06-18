<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<html>
<head>
    <jsp:include page="style.jsp"/>
    <title><fmt:message key="label.cashbox"/></title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="col" align="center">
        <fmt:message key="label.selected.tour"/>
    </div>
    <table class="table table-sm">
        <thead>
        <tr>
            <th scope="col"><fmt:message key="th.name"/> </th>
            <th scope="col"><fmt:message key="th.price"/> </th>
            <th scope="col"><fmt:message key="th.duration"/> </th>
            <th scope="col"></th>
            <th scope="col"></td>
            <th scope="col"></td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <c:if test="${sessionScope.language == 'ru_RU'}">
                    ${requestScope.tour.nameRu}
                </c:if>
                <c:if test="${sessionScope.language == 'en_EN'}">
                    ${requestScope.tour.nameEng}
                </c:if>
            </td>
            <td>${requestScope.tour.price} ₸</td>
            <td>${requestScope.tour.duration}</td>
        </tbody>
    </table>
    <div class="col" align="center">
        <fmt:message key="label.cheque"/>
    </div>
    <form action="/cashbox" method="post">
        <button type="submit"
                class="btn btn-sm btn-warning"><fmt:message key="button.save"/></button>
    </form>
</div>
</body>
</html>
