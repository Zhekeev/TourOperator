<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<html>
<head>
    <jsp:include page="style.jsp"/>
    <title><fmt:message key="label.add.tour"/> </title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <div class="container">
        <div class="row">
            <div class="col-sm">
                <form action="/manage/create_tour" method="post">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="nameRu"><fmt:message key="label.name.ru"/></label>
                            <input type="text" class="form-control" id="nameRu" name="name_ru">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="nameEng"><fmt:message key="label.name.en"/> </label>
                            <input type="text" class="form-control" id="nameEng" name="name_eng">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="price"><fmt:message key="label.price"/> </label>
                            <input type="number" class="form-control" id="price" name="price">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="duration"><fmt:message key="label.duration"/> </label>
                            <input type="number" class="form-control" id="duration" placeholder="" name="duration">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="descriptionRu"><fmt:message key="label.description.ru"/> </label>
                            <input type="text" class="form-control" id="descriptionRu" placeholder="" name="description_ru">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="descriptionEng"><fmt:message key="label.description.en"/> </label>
                            <input type="text" class="form-control" id="descriptionEng" placeholder="" name="description_eng">
                        </div>
                    </div>
                    <br/>
                    <div class="form-row">
                        <button type="submit" class="btn btn-primary"><fmt:message key="button.save"/></button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
