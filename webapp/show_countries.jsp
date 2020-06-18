<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<html>
<head>
    <jsp:include page="style.jsp"/>
    <title><fmt:message key="label.list.country"/></title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">

            <table class="table table-sm">
                <thead>
                <tr>
                    <th scope="col"><fmt:message key="th.number"/> </th>
                    <th scope="col"><fmt:message key="th.name"/> </th>
                    <th scope="col"></th>
                    <th scope="col"></td>

                </tr>
                </thead>
                <c:forEach items="${requestScope.country_list}" var="country">
                    <tr>
                        <td>${country.id}</td>
                        <td><c:if test="${sessionScope.language == 'ru_RU'}">
                            ${country.nameRu}
                        </c:if>
                            <c:if test="${sessionScope.language == 'en_EN'}">
                                ${country.nameEng}
                            </c:if></td>
                        <c:choose>
                            <c:when test="${sessionScope.role == 'ADMIN'}">
                                <td>
                                    <form action="/edit_country" method="post">
                                        <input type="hidden" name="id" value="${country.id}">
                                        <button type="submit"
                                                class="btn btn-sm btn-warning"><fmt:message key="button.edit"/></button>
                                    </form>
                                </td>
                                <td>
                                    <form action="/manage/delete_country" method="post">
                                        <input type="hidden" name="id" value="${country.id}">
                                        <button type="submit"
                                                class="btn btn-sm btn-danger"><fmt:message key="button.remove"/></button>
                                    </form>
                                </td>
                            </c:when>
                            <c:otherwise>
                                <td>
                                    <form action="/tour_list_by_country" method="post">
                                        <input type="hidden" name="id" value="${country.id}">
                                        <button type="submit"
                                                class="btn btn-sm btn-warning"><fmt:message key="button.select"/></button>
                                    </form>
                                </td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>
            </table>
</div>
</body>
</html>
