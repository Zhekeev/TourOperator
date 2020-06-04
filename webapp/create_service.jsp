<%--
  Created by IntelliJ IDEA.
  User: ergaz
  Date: 02.06.2020
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="style.jsp"/>
    <title>Добавить сервис</title>
</head>
<body>
<form action="/create_service" method="post">
    <div class="container">
        <jsp:include page="header.jsp"/>
        <div class="row">
            <div class="col-sm">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="nameRu">Название</label>
                        <input type="text" class="form-control" id="nameRu" name="name">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="description">Описание</label>
                        <input type="text" class="form-control" id="description" name="description">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="price">Цена</label>
                        <input type="number" class="form-control" id="price" name="price">
                    </div>
                </div>
                <br/>
                <div class="form-row">
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
