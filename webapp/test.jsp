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
    </div>
</form>
</body>
</html>
