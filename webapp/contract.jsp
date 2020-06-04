<%--
  Created by IntelliJ IDEA.
  User: ergaz
  Date: 03.06.2020
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
                <td>${requestScope.tour_list.nameRu}</td>
                <td>${requestScope.tour_list.price}</td>
                <td>${requestScope.tour_list.duration}</td>
        </tbody>
    </table>
    <div class="col" align="center">
        Выберите дату
    </div>
    <div class="form-group col-md-6">
        <label for="tourStartDate">Дата начала тура</label>
        <input type="date" class="form-control" id="tourStartDate" placeholder="" name="tourStartDate">
    </div>
    <div class="form-group col-md-6">
        <label for="tourFinishDate">Дата оконочания тура</label>
        <input type="date" class="form-control" id="tourFinishDate" placeholder="" name="tourFinishDate">
    </div>
    <form action="/contract" method="post">
        <input type="hidden" name="id" value="${tour.id}">
        <button type="submit"
                class="btn btn-sm btn-warning">Выбрать</button>
    </form>
    <div class="col" align="center">
        Дополнительные услуги
        <form action="/show_service_list_admin" method="post">
            <button type="submit"
                    class="btn btn-sm btn-warning">Выбрать</button>
        </form>
    </div>
</div>
</form>
</body>
</html>
