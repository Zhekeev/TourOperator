<%--
  Created by IntelliJ IDEA.
  User: ergaz
  Date: 20.05.2020
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="style.jsp"/>
    <title>Настройки</title>
</head>
<body>
<h1>Редактировать профиль</h1>
<form action="/edit_user_by_admin" method="post">
    Enter login: <br/>
    <input type = "text" name="login" placeholder="username" id = "inputName"/>
    <br/>
    Enter password: <br/>
    <input type = "password" name = "password" placeholder="password" />
    <br/>
    Enter name: <br/>
    <input type="text" name = "firstName" placeholder="name" />
    </br>
    Enter last name: <br/>
    <input type="text" name = "lastName" placeholder="last name">
    </br>
    Enter email: <br/>
    <input type="text" name = "email" placeholder="example@touroperator.com">
    </br>
    Enter phone number: <br/>
    <input type="text" name = "phoneNumber" placeholder="+77011234555">
    </br>
    Enter address: <br/>
    <input type="text" name = "address" placeholder=" address">
    </br>
    Enter  gender: <br/>
    <label><input type="radio" checked name="gender" value="man"/> Муж. </label> <label><input type="radio" name="gender" value="woman"/> Жен</label>
    </br>
    Enter IIN: <br/>
    <input type="text" name = "iin" placeholder="123456789101">
    </br>
    Enter date of IIN: <br/>
    <input type="text" name = "dateOfIIN" placeholder="yyyy - mm - dd">
    </br>
    Enter admin: <br/>
    <label><input type="radio" checked name="isAdmin" value="true"/> Is Admin</label> <label><input type="radio" name="isAdmin" value="false"/> It is not a Admin</label>
    </br>

    <input type = "submit" value="Обновить"/>
</form>
</body>
</html>
