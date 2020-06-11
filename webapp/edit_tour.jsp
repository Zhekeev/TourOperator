<%--
  Created by IntelliJ IDEA.
  User: ergaz
  Date: 01.06.2020
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="style.jsp"/>
    <title>Редактирование тура</title>
</head>
<body>
<div class="container">
    <jsp:include page="header.jsp"/>
    <div class="row">
        <div class="col-sm">
            <form action="/edit_tour" method="post">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="nameRu">Название на русском</label>
                        <input type="text" class="form-control" id="nameRu" name="name_ru">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="nameEng">Название на английском</label>
                        <input type="text" class="form-control" id="nameEng" name="name_eng">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="price">Цена</label>
                        <input type="number" class="form-control" id="price" name="price">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="duration">Длительность</label>
                        <input type="number" class="form-control" id="duration" placeholder="" name="duration">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="descriptionRu">Описание тура на русском</label>
                        <input type="text" class="form-control" id="descriptionRu" placeholder="" name="description_ru">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="descriptionEng">Описание тура на английском</label>
                        <input type="text" class="form-control" id="descriptionEng" placeholder="" name="description_eng">
                    </div>
                </div>
                <br/>
                <div class="form-row">
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
