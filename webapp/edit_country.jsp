<%--
  Created by IntelliJ IDEA.
  User: ergaz
  Date: 02.06.2020
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="style.jsp"/>
    <title>Редактированить страну</title>
</head>
<body>
<form action="/edit_country_parameter" method="post">
    <div class="container">
        <jsp:include page="header.jsp"/>
        <div class="row">
            <div class="col-sm">
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
