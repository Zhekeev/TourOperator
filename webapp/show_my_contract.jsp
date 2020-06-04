<%--
  Created by IntelliJ IDEA.
  User: ergaz
  Date: 03.06.2020
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="style.jsp"/>
    <title>Мои заказы</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <table class="table table-sm">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Название на русском языке</th>
            <th scope="col">Название на английском языке</th>
            <th scope="col">Цена</th>
            <th scope="col">Длительность</th>
            <th scope="col">Описание на русском языке</th>
            <th scope="col">Описание на английском языке</th>
            <th scope="col"></th>
            <th scope="col"></td>
            <th scope="col"></td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.tour_list}" var="tour">
            <tr>
            <td>${tour.id}</td>
            <td>${tour.nameRu}</td>
            <td>${tour.nameEng}</td>
            <td>${tour.price}</td>
            <td>${tour.duration}</td>
            <td>${tour.descriptionRu}</td>
            <td>${tour.descriptionEng}</td>
            <c:choose>
                <c:when test="${sessionScope.role == 'ADMIN' || sessionScope.role == null}">
                    <td>
                        <form action="/controller/edit_tour_but" method="post">
                            <input type="hidden" name="id" value="${tour.id}">
                            <button type="submit"
                                    class="btn btn-sm btn-warning">Редактировать</button>
                        </form>
                    </td>
                    <td>
                        <form action="/controller/upload_image_button" method="post">
                            <input type="hidden" name="id" value="${room.id}">
                            <button type="submit" style="width: 140px"
                                    class="btn btn-sm btn-warning">Добавить фото</button>
                        </form>
                    </td>
                    <td>
                        <form action="/controller/delete_tour" method="post">
                            <input type="hidden" name="id" value="${tour.id}">
                            <button type="submit"
                                    class="btn btn-sm btn-danger">Удалить</button>
                        </form>
                    </td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <td>
                        <form action="/contract" method="post">
                            <input type="hidden" name="id" value="${tour.id}">
                            <button type="submit"
                                    class="btn btn-sm btn-warning">Выбрать</button>
                        </form>
                    </td>
                </c:otherwise>
            </c:choose>

        </c:forEach>
        </tbody>
    </table>
</body>
</html>
