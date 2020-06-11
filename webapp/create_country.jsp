<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<html>
<jsp:include page="background.jsp"/>
<head>
    <jsp:include page="style.jsp"/>
    <title><fmt:message key="label.add.country"/> </title>
</head>
<body>
<form action="/create_country" method="post">
<div class="container">
    <jsp:include page="header.jsp"/>
    <div class="row">
        <div class="col-sm">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="nameRu"><fmt:message key="label.name.ru"/> </label>
                        <input type="text" class="form-control" id="nameRu" name="name_ru">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="nameEng"><fmt:message key="label.name.en"/> </label>
                        <input type="text" class="form-control" id="nameEng" name="name_eng">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="idImage"><fmt:message key="button.addImage"/> </label>
                        <input type="number" class="form-control" id="idImage" name="id_image">
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
