<%--
  Created by IntelliJ IDEA.
  User: ergaz
  Date: 02.06.2020
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <jsp:include page="style.jsp"/>
    <title>Список стран</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">

            <table class="table table-sm">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Название на русском</th>
                    <th scope="col">Название на английском</th>
                    <th scope="col">Номер изображения</th>
                    <th scope="col"></th>
                    <th scope="col"></td>

                </tr>
                </thead>
                <c:forEach items="${requestScope.country_list}" var="country">
                    <tr>
                        <td>${country.id}</td>
                        <td>${country.nameRu}</td>
                        <td>${country.nameEng}</td>
                        <td>${country.idImage}</td>
                        <c:choose>
                            <c:when test="${sessionScope.role == 'ADMIN' || sessionScope.role == null}">
                                <td>
                                    <form action="/edit_country" method="post">
                                        <input type="hidden" name="id" value="${country.id}">
                                        <button type="submit"
                                                class="btn btn-sm btn-warning">Редактировать</button>
                                    </form>
                                </td>
                                <td>
                                    <form action="/delete_country" method="post">
                                        <input type="hidden" name="id" value="${country.id}">
                                        <button type="submit"
                                                class="btn btn-sm btn-danger">Удалить</button>
                                    </form>
                                </td>
                            </c:when>
                            <c:otherwise>
                                <td>
                                    <form action="/controller/edit_tour_but" method="post">
                                        <input type="hidden" name="id" value="${tour.id}">
                                        <button type="submit"
                                                class="btn btn-sm btn-warning">Выбрать</button>
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
