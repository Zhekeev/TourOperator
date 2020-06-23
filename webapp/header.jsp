<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/index.jsp">Tour Operator</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <c:choose>
                <c:when test="${sessionScope.role == 'GUEST' || sessionScope.role == null}">
                </c:when>
                <c:otherwise>
                    <li class="nav-item active">
                        <a class="nav-link" href="/homepage.jsp"><fmt:message key="button.cabinet"/> <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/show_my_contract"><fmt:message key="button.order"/> <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <fmt:message key="button.setting"/>
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="/edit_user_password.jsp"><fmt:message key="button.setting.edit.password"/> </a>
                            <a class="dropdown-item" href="/edit_user.jsp"><fmt:message key="button.setting.edit.user"/> </a>
                        </div>
                    </li>
                </c:otherwise>
            </c:choose>
            <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                 <img src="/img/global1.png" width="30" height="30" alt="">
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <form action="/change_language" method="post">
                        <input type="hidden" name="id" value="${"en_EN"}">
                        <button type="submit" class="btn btn-link" >English</>
                    </form>
                    <form action="/change_language" method="post">
                        <input type="hidden" name="id" value="${"ru_RU"}">
                        <button type="submit" class="btn btn-link" >Русский</button>
                    </form>
                </div>
            </li>
        </ul>
        <c:choose>
            <c:when test="${sessionScope.role == 'GUEST' || sessionScope.role == null}">
                <a class="nav-link" href="/login.jsp"><fmt:message key="button.login"/> <span class="sr-only">(current)</span></a>
                <a class="nav-link" href="/registration.jsp"><fmt:message key="button.registration"/> <span class="sr-only">(current)</span></a>
            </c:when>
            <c:otherwise>
                <a class="nav-link" href="/logout"><fmt:message key="button.logout"/> <span class="sr-only">(current)</span></a>
            </c:otherwise>
        </c:choose>
    </div>
</nav>
