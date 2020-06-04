<%--
  Created by IntelliJ IDEA.
  User: ergaz
  Date: 27.05.2020
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="style.jsp"/>
    <title>Error</title>
</head>
<body>
Ошибка.<h3>${requestScope.message}</h3>
</body>
</html>
