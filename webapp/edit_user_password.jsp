<%--
  Created by IntelliJ IDEA.
  User: ergaz
  Date: 29.05.2020
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="style.jsp"/>
    <title>Title</title>
</head>
<body>
<h1>Редактировать профиль</h1>
<form action="/update_password" method="post">
    Enter password: <br/>
    <input type = "password" name = "password" placeholder="password" />
    <input type = "submit" value="Обновить"/>
</form>
</body>
</html>
