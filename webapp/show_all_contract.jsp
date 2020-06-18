<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<html>
<head>
    <jsp:include page="style.jsp"/>
    <title><fmt:message key="label.contract"/></title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-9">
            <table class="table table-sm">
                <thead>
                <tr>
                    <th scope="col"><fmt:message key="th.firstname"/> </th>
                    <th scope="col"><fmt:message key="th.lastname"/> </th>
                    <th scope="col"><fmt:message key="th.name.tour"/> </th>
                    <th scope="col"><fmt:message key="th.date.tour.start"/> </th>
                    <th scope="col"><fmt:message key="th.date.tour.finish"/> </th>
                    <th scope="col"><fmt:message key="th.price"/> </th>
                    <th scope="col"></th>
                    <th scope="col"></td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.contract_list}" var="contract">
                    <tr>
                        <td>${contract.firstNameClient}</td>
                        <td>${contract.lastNameClient}</td>
                        <td>${contract.nameTour}</td>
                        <td>${contract.tourStartDate}</td>
                        <td>${contract.tourFinishDate}</td>
                        <td>${contract.price}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
