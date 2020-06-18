<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<html>
<head>
    <jsp:include page="style.jsp"/>
    <title><fmt:message key="label.login"/></title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="col" align="center">
    <h1><fmt:message key="label.login"/> </h1>
    <form action="/login" method="post">
        <input type="hidden" name="command" value="forward">
        <fmt:message key="label.enter.login"/>: <br/>
        <input type = "text" name="login" placeholder="" />
        <br/>
        <fmt:message key="label.enter.password"/>: <br/>
        <input type = "text" name= "password" placeholder="" />
        <br/>
        <button type="submit" class="btn btn-primary"><fmt:message key="button.login"/> </button>
    </form>
</div>
</body>
</html>
