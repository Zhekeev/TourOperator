<%--
  Created by IntelliJ IDEA.
  User: ergaz
  Date: 15.04.2020
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <jsp:include page="style.jsp"/>
    <title>Login</title>
</head>
<body>
    <form action="/controller/login" method="post">
        <input type="hidden" name="command" value="forward">
        Enter login: <br/>
        <input type = "text" name="login" placeholder="username" />
        <br/>
        Enter password: <br/>
        <input type = "text" name= "password" placeholder="password" />
        <br/>
        <input type = "submit" value="login" />
        <p><a href="login.jsp">forgot password?</a> </p>
    </form>
</body>
</html>
