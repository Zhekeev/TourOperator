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
                    <th scope="col">ID</th>
                    <th scope="col">Название</th>
                    <th scope="col">Описание</th>
                    <th scope="col">Цена</th>
                    <th scope="col"></th>
                    <th scope="col"></td>
                    <th scope="col"></td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.my_contract}" var="service">
                    <tr>
                        <td>${service.id}</td>
                        <td>${service.name}</td>
                        <td>${service.description}</td>
                        <td>${service.price}</td>
                    <c:choose>
                        <c:when test="${sessionScope.role == 'ADMIN' || sessionScope.role == null}">
                            <td>
                                <form action="/edit_service" method="post">
                                    <input type="hidden" name="id" value="${service.id}">
                                    <button type="submit"
                                            class="btn btn-sm btn-warning">Редактировать</button>
                                </form>
                            </td>
                            <td>
                                <form action="/delete_service" method="post">
                                    <input type="hidden" name="id" value="${service.id}">
                                    <button type="submit"
                                            class="btn btn-sm btn-danger">Удалить</button>
                                </form>
                            </td>
                        </c:when>
                        <c:otherwise>
                            <td>
                                <form action="/finalcontract" method="post">
                                    <input type="hidden" name="id" value="${service.id}">
                                    <button type="submit"
                                            class="btn btn-sm btn-warning">Выбрать</button>
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
