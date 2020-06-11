<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<html>
<head>
    <jsp:include page="style.jsp"/>
    <title><fmt:message key="label.add.service"/> </title>
</head>
<body>
<form action="/create_service" method="post">
    <div class="container">
        <jsp:include page="header.jsp"/>
        <div class="row">
            <div class="col-sm">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="nameRu"><fmt:message key="label.name"/> </label>
                        <input type="text" class="form-control" id="nameRu" name="name">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="description"><fmt:message key="label.description"/> </label>
                        <input type="text" class="form-control" id="description" name="description">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="price"><fmt:message key="label.price"/> </label>
                        <input type="number" class="form-control" id="price" name="price">
                    </div>
                </div>
                <br/>
                <div class="form-row">
                    <button type="submit" class="btn btn-primary"><fmt:message key="button.add"/> </button>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
