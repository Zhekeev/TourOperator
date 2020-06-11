<%--
  Created by IntelliJ IDEA.
  User: ergaz
  Date: 02.06.2020
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<html>
<head>
    <jsp:include page="style.jsp"/>
    <title>Список услуг</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
     <table class="table table-sm">
                <thead>
                <tr>
                    <th scope="col"><fmt:message key="th.number"/> </th>
                    <th scope="col"><fmt:message key="th.name"/> </th>
                    <th scope="col"><fmt:message key="th.description"/> </th>
                    <th scope="col"><fmt:message key="th.price"/> </th>
                    <th scope="col"></th>
                    <th scope="col"></td>
                    <th scope="col"></td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.my_contract}" var="service">
                    <tr>
                        <td>${service.id}</td>
                        <td>
                            <c:if test="${sessionScope.language == 'ru_RU'}">
                                ${service.nameRu}
                            </c:if>
                            <c:if test="${sessionScope.language == 'en_EN'}">
                                ${service.nameEng}
                            </c:if></td>
                        <td><c:if test="${sessionScope.language == 'ru_RU'}">
                            ${service.descriptionRu}
                        </c:if>
                            <c:if test="${sessionScope.language == 'en_EN'}">
                                ${service.descriptionEng}
                            </c:if>
                               </td>
                        <td>${service.price} ₸</td>
                    <c:choose>
                        <c:when test="${sessionScope.role == 'ADMIN' || sessionScope.role == null}">
                            <td>
                                <form action="/edit_service" method="post">
                                    <input type="hidden" name="id" value="${service.id}">
                                    <button type="submit"
                                            class="btn btn-sm btn-warning"><fmt:message key="button.edit"/> </button>
                                </form>
                            </td>
                            <td>
                                <form action="/delete_service" method="post">
                                    <input type="hidden" name="id" value="${service.id}">
                                    <button type="submit"
                                            class="btn btn-sm btn-danger"><fmt:message key="button.remove"/> </button>
                                </form>
                            </td>
                        </c:when>
                        <c:otherwise>
                            <td>
                                <form action="/final_contract" method="post">
                                    <input type="hidden" name="id" value="${service.id}">
                                    <button type="submit"
                                            class="btn btn-sm btn-warning"><fmt:message key="button.select"/> </button>
                                </form>
                            </td>
                        </c:otherwise>
                    </c:choose>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
</div>
</body>
</html>
