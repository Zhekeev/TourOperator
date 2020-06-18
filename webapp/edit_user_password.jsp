<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<html>
<head>
    <jsp:include page="style.jsp"/>
    <title><fmt:message key="label.edit"/></title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <h2><fmt:message key="label.edit"/></h2>
    <div class="row">
        <div class="col-sm">
            <form action="/update_password" method="post">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="password"><fmt:message key="label.enter.password"/></label>
                        <input type="password" class="form-control" id="password" name="password">
                    </div>
                </div>
                <div class="form-row">
                    <button type="submit" class="btn btn-primary"><fmt:message key="button.save"/></button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
