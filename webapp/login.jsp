<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <jsp:include page="style.jsp"/>
    <title>Login</title>
</head>
<body>
<div class="col" align="center">
<jsp:include page="header.jsp"/>
    <h1><fmt:message key="label.login"/> </h1>
    <form action="/login" method="post">
        <input type="hidden" name="command" value="forward">
        <fmt:message key="label.enter.login"/>: <br/>
        <input type = "text" name="login" placeholder="" />
        <br/>
        <fmt:message key="label.enter.password"/>: <br/>
        <input type = "text" name= "password" placeholder="" />
        <br/>
        <button type="submit" class="btn btn-primary btn-sm"><fmt:message key="button.login"/> </button>
    </form>
</div>
</body>
</html>
