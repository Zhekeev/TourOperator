<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<html>
<jsp:include page="background.jsp"/>
<head>
    <jsp:include page="style.jsp"/>
    <title>Ваши заказы</title>
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
            <th scope="col"><fmt:message key="th.price"/> </th>
            <th scope="col"><fmt:message key="th.duration"/> </th>
            <th scope="col"></th>
            <th scope="col"></td>
            <th scope="col"></td>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td>${requestScope.tour_list.nameRu}</td>
                <td>${requestScope.tour_list.price}</td>
                <td>${requestScope.tour_list.duration}</td>
        </tbody>
    </table>
    <div class="col" align="center">
        <fmt:message key="label.date"/>
    </div>
    <form action="/contract_without_service" method="post">
    <div class="form-group col-md-6">
        <label for="tourStartDate"><fmt:message key="label.date.tourstart"/> </label>
        <input type="date" class="form-control" id="tourStartDate" name="tourStartDate" value="tourStartDate">
    </div>
    <div class="form-group col-md-6">
        <label for="tourFinishDate"><fmt:message key="label.date.tourfinish"/> </label>
        <input type="date" class="form-control" id="tourFinishDate" name="tourFinishDate" value="tourFinishDate">
    </div>
        <input type="hidden" name="id" value="${tour.id}">
        <button type="submit"
                class="btn btn-sm btn-warning"><fmt:message key="button.select"/> </button>
    </form>
    <c:if test="${sessionScope.tour.id != null}">
      <%--  <div class="col" align="center">
            <fmt:message key="label.service"/>
            <form action="/show_service_list_admin" method="post">
                <button type="submit"
                        class="btn btn-sm btn-warning"><fmt:message key="button.select"/></button>
            </form>
        </div>--%>
    </c:if>
</div>
</form>
</body>
</html>
