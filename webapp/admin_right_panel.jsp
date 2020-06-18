<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<html>
<body>
<p>
<div class="btn-group-vertical " role="group" aria-label="Basic example">
    <a href="/manage/show_user_list" type="button"
       class="btn btn-secondary"><fmt:message key="label.list.user"/> </a>
    <a href="/tour_list" type="button"
       class="btn btn-secondary"><fmt:message key="label.list.tour"/> </a>
    <a href="/create_tour.jsp" type="button"
       class="btn btn-secondary"><fmt:message key="label.add.tour"/> </a>
    <a href="/create_country.jsp" type="button"
       class="btn btn-secondary"><fmt:message key="label.add.country"/> </a>
    <a href="/show_country" type="button"
       class="btn btn-secondary"><fmt:message key="label.list.country"/> </a>
    <a href="/manage/show_all_contract" type="button"
       class="btn btn-secondary">Все контракты </a>
</div>
</p>
</body>
</html>
