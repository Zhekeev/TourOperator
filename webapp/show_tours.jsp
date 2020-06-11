<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<html>
<head>
    <jsp:include page="style.jsp"/>
    <title><fmt:message key="label.list.tour"/> </title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <c:choose>
        <c:when test="${sessionScope.role == 'GUEST' || sessionScope.role == null}">
            <p class="text-danger"><fmt:message key="error.guest.unlogin"/></p>
        </c:when>
    </c:choose>
            <table class="table table-sm">
                <thead>
                <tr>
                    <th scope="col"><fmt:message key="th.number"/> </th>
                    <th scope="col"><fmt:message key="th.name"/> </th>
                    <th scope="col"><fmt:message key="th.price"/> </th>
                    <th scope="col"><fmt:message key="th.duration"/> </th>
                    <th scope="col"><fmt:message key="th.description"/> </th>
                    <th scope="col"></th>
                    <th scope="col"></td>
                    <th scope="col"></td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.tour_list}" var="tour">
                    <tr>
                        <td>${tour.id}</td>
                        <td>
                            <c:if test="${sessionScope.language == 'ru_RU'}">
                            ${tour.nameRu}
                            </c:if>
                            <c:if test="${sessionScope.language == 'en_EN'}">
                             ${tour.nameEng}
                            </c:if>
                        </td>
                        <td>${tour.price} ₸</td>
                        <td>${tour.duration}</td>
                        <td>
                            <c:if test="${sessionScope.language == 'ru_RU'}">
                                ${tour.descriptionRu}
                            </c:if>
                            <c:if test="${sessionScope.language == 'en_EN'}">
                                ${tour.descriptionEng}
                            </c:if>
                        </td>
                        <c:choose>
                            <c:when test="${sessionScope.role == 'ADMIN'}">
                                <td>
                                    <form action="/edit_tour_but" method="post">
                                        <input type="hidden" name="id" value="${tour.id}">
                                        <button type="submit"
                                                class="btn btn-sm btn-warning"><fmt:message key="button.edit"/> </button>
                                    </form>
                                </td>
                                <td>
                                    <form action="/upload_image_parameter" method="post">
                                        <input type="hidden" name="id" value="${tour.id}">
                                        <button type="submit" style="width: 140px"
                                                class="btn btn-sm btn-warning"><fmt:message key="button.addImage"/> </button>
                                    </form>
                                </td>
                                <td>
                                    <form action="/delete_tour" method="post">
                                        <input type="hidden" name="id" value="${tour.id}">
                                        <button type="submit"
                                                class="btn btn-sm btn-danger"><fmt:message key="button.remove"/> </button>
                                    </form>
                                </td>
                                </tr>
                            </c:when>
                        </c:choose>
                    <c:choose>
                        <c:when test="${sessionScope.role == 'CLIENT'}">
                            <td>
                                <form action="/contract" method="post">
                                    <input type="hidden" name="id" value="${tour.id}">
                                    <button type="submit"
                                            class="btn btn-sm btn-warning"><fmt:message key="button.select"/> </button>
                                </form>
                            </td>
                        </c:when>
                    </c:choose>
                </c:forEach>
            </tbody>
            </table>
</div>
</body>
</html>
