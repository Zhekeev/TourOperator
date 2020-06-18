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
    <h1><fmt:message key="label.edit"/></h1>
    <div class="row">
        <div class="col-sm">
            <form action="/manage/edit_user_by_admin" method="post">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="login"><fmt:message key="label.enter.login"/></label>
                        <input type="text" class="form-control" id="login" name="login">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="password"><fmt:message key="label.enter.password"/></label>
                        <input type="password" class="form-control" id="password" name="password">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="firstName"><fmt:message key="label.enter.firstname"/></label>
                        <input type="text" class="form-control" id="firstName" name="firstName">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="lastName"><fmt:message key="label.enter.lastname"/> </label>
                        <input type="text" class="form-control" id="lastName" placeholder="" name="lastName">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="email"><fmt:message key="label.enter.email"/></label>
                        <input type="text" class="form-control" id="email" placeholder="" name="email">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="phoneNumber"><fmt:message key="label.enter.phonenumber"/></label>
                        <input type="text" class="form-control" id="phoneNumber" placeholder="+77000000000" name="phoneNumber">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="address"><fmt:message key="label.enter.address"/></label>
                        <input type="text" class="form-control" id="address" placeholder="" name="address">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="address"><fmt:message key="label.enter.gender"/></label>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="gender" id="inlineRadio1" value="man">
                            <label class="form-check-label" for="inlineRadio1"><fmt:message key="label.enter.gender.man"/></label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="gender" id="inlineRadio2" value="woman">
                            <label class="form-check-label" for="inlineRadio2"><fmt:message key="label.enter.gender.woman"/></label>
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="iin"><fmt:message key="label.enter.iin"/></label>
                        <input type="text" class="form-control" id="iin" placeholder="" name="iin">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="dateOfIIN"><fmt:message key="label.enter.dateofiin"/></label>
                        <input type="text" class="form-control" id="dateOfIIN" placeholder="" name="dateOfIIN">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="address"><fmt:message key="label.admin"/></label>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" name="isAdmin" id="inlineRadio" value="true">
                            <label class="form-check-label" for="inlineRadio"><fmt:message key="label.admin.true"/></label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" name="isAdmin" id="inlineRadio3" value="false">
                            <label class="form-check-label" for="inlineRadio3"><fmt:message key="label.admin.false"/></label>
                        </div>
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
