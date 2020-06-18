<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<html>
<head>
    <jsp:include page="style.jsp"/>
    <title><fmt:message key="label.error"/></title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-sm">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label><fmt:message key="label.error"/></label>
                        <label><h3>${requestScope.message}</h3></label>
                    </div>
                </div>
        </div>
    </div>
</div>
</body>
</html>
