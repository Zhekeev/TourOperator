<%--
  Created by IntelliJ IDEA.
  User: ergaz
  Date: 29.05.2020
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Customer Register Form</h1>
<form action="/controller/create_tour" method="post">
    Введите название на русском: <br/>
    <input type = "text" name="nameRu" placeholder="nameRu"/>
    <br/>
    Введите название на английском: <br/>
    <input type = "text" name = "nameEng" placeholder="password" />
    <br/>
    Введите цену: <br/>
    <input type="text" name = "price" placeholder="name" />
    </br>
    Введите длительность: <br/>
    <input type="text" name = "duration" placeholder="last name">
    </br>
    Введите описание на русском <br/>
    <input type="text" name = "descriptionRu" placeholder="email">
    </br>
    Введите описание на английском: <br/>
    <input type="text" name = "descriptionEng" placeholder="phone number">
    </br>
    Введите id изображения: <br/>
    <input type="text" name = "id_image" placeholder="phone number">
    </br>
    <input type = "submit" value="Добавить"/>
</form>
</body>
</html>
