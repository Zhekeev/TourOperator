<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<html>
<head>
    <jsp:include page="style.jsp"/>
    <title><fmt:message key="label.contract"/></title>
</head>
<body>
<form action="/my_contract" method="post">
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="col" align="center">
        <fmt:message key="label.selected.tour"/>
    </div>
    <table class="table table-sm">
        <thead>
        <tr>
            <th scope="col"><fmt:message key="th.name"/> </th>
            <th scope="col"><fmt:message key="th.price"/> ₸</th>
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
                <td>${requestScope.tour.price}</td>
                <td>${requestScope.tour.duration}</td>
        </tbody>
    </table>
    <div class="col" align="center">
        <fmt:message key="label.date"/>
    </div>
    <form action="/tour_contract" method="post">
    <div class="form-group col-md-6">
        <label for="tourStartDate"><fmt:message key="label.date.tourstart"/> </label>
        <input type="date" class="form-control" id="tourStartDate" name="tourStartDate" value="tourStartDate">
    </div>
        <input type="hidden" name="id" value="${tour.id}">
        <button type="submit"
                class="btn btn-sm btn-warning"><fmt:message key="button.select"/> </button>
    </form>
</div>
</form>
</body>
</html>
