<%--
  Created by IntelliJ IDEA.
  User: ergaz
  Date: 29.05.2020
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<html>
<head>
    <jsp:include page="style.jsp"/>
    <title>Users</title>
</head>
<body>
<div class="container">
    <jsp:include page="header.jsp"/>
    <div class="row">
        <div class="col-9">
            <table class="table table-sm">
                <thead>
                <tr>
                    <th scope="col"><fmt:message key="th.number"/> </th>
                    <th scope="col"><fmt:message key="th.login"/> </th>
                    <th scope="col"><fmt:message key="th.password"/> </th>
                    <th scope="col"><fmt:message key="th.firstname"/> </th>
                    <th scope="col"><fmt:message key="th.lastname"/> </th>
                    <th scope="col"><fmt:message key="th.email"/> </th>
                    <th scope="col"><fmt:message key="th.phonenumber"/> </th>
                    <th scope="col"><fmt:message key="th.address"/> </th>
                    <th scope="col"><fmt:message key="th.gender"/> </th>
                    <th scope="col"><fmt:message key="th.iin"/> </th>
                    <th scope="col"><fmt:message key="th.dateofiin"/> </th>
                    <th scope="col"><fmt:message key="th.admin"/> </th>
                    <th scope="col"></th>
                    <th scope="col"></td>

                </tr>
                </thead>
             <c:forEach items="${requestScope.userList}" var="user">
                 <tr>
                     <td>${user.id}</td>
                     <td>${user.login}</td>
                     <td>${user.password}</td>
                     <td>${user.firstName}</td>
                     <td>${user.lastName}</td>
                     <td>${user.email}</td>
                     <td>${user.phoneNumber}</td>
                     <td>${user.address}</td>
                     <td>${user.gender}</td>
                     <td>${user.IIN}</td>
                     <td>${user.dateOfIIN}</td>
                     <td>${user.admin}</td>
                     <td>
                         <form action="/edit_user_by_admin_button" method="post">
                             <input type="hidden" name="id" value="${user.id}">
                             <button type="submit"
                                     class="btn btn-sm btn-warning"><fmt:message key="button.edit"/> </button>
                         </form>
                     </td>
                     <td>
                         <form action="/delete_user_by_admin" method="post">
                             <input type="hidden" name="id" value="${user.id}">
                             <button type="submit"
                                     class="btn btn-sm btn-danger"><fmt:message key="button.remove"/> </button>
                         </form>
                     </td>
                 </tr>
             </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
