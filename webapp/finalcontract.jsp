<%--
  Created by IntelliJ IDEA.
  User: ergaz
  Date: 04.06.2020
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="style.jsp"/>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="col" align="center">
        Выбранный тур
    </div>
    <table class="table table-sm">
        <thead>
        <tr>
            <th scope="col">Название на русском языке</th>
            <th scope="col">Цена</th>
            <th scope="col">Длительность</th>
            <th scope="col"></th>
            <th scope="col"></td>
            <th scope="col"></td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${requestScope.tours.nameRu}</td>
            <td>${requestScope.tours.price} ₸</td>
            <td>${requestScope.tours.duration}</td>
        </tbody>
    </table>
    <div class="col" align="center">
        Выбранная услуга
    </div>
    <table class="table table-sm">
        <thead>
        <tr>
            <th scope="col">Название</th>
            <th scope="col">Описание</th>
            <th scope="col">Цена</th>
            <th scope="col"></th>
            <th scope="col"></td>
            <th scope="col"></td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${requestScope.services.nameRu}</td>
            <td>${requestScope.services.descriptionRu}</td>
            <td>${requestScope.services.price} ₸</td>
        </tbody>
    </table>
    <div class="col" align="center">
        Общая цена ${requestScope.price} ₸
    </div>
    <form action="/cashbox" method="post">
        <button type="submit"
                class="btn btn-sm btn-warning">Оплатить</button>
    </form>
</div>
</body>
</html>
