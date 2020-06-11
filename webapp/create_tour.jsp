<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<html>
<head>
    <title><fmt:message key="label.add.tour"/> </title>
</head>
<body>
<form action="/create_tour" method="post">
    <fmt:message key="label.name.ru"/> <br/>
    <input type = "text" name="nameRu" placeholder="nameRu"/>
    <br/>
    <fmt:message key="label.name.en"/> <br/>
    <input type = "text" name = "nameEng" placeholder="password" />
    <br/>
    <fmt:message key="label.price"/> <br/>
    <input type="text" name = "price" placeholder="name" />
    </br>
    <fmt:message key="label.duration"/> <br/>
    <input type="text" name = "duration" placeholder="last name">
    </br>
    <fmt:message key="label.description.ru"/> <br/>
    <input type="text" name = "descriptionRu" placeholder="email">
    </br>
    <fmt:message key="label.description.en"/> <br/>
    <input type="text" name = "descriptionEng" placeholder="phone number">
    </br>
    <fmt:message key="button.addImage"/> <br/>
    <input type="text" name = "id_image" placeholder="phone number">
    </br>
    <input type = "submit" value="Добавить"/>
</form>
</body>
</html>
