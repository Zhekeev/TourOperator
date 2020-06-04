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
<html>
<head>
    <jsp:include page="style.jsp"/>
    <title>Title</title>
</head>
<body>
<div class="container">
    <jsp:include page="header.jsp"/>
    <div class="row">
        <div class="col-9">
            <table class="table table-sm">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Логин</th>
                    <th scope="col">Пароль</th>
                    <th scope="col">Имя</th>
                    <th scope="col">Фамилия</th>
                    <th scope="col">Почта</th>
                    <th scope="col">Номер телефона</th>
                    <th scope="col">Адрес</th>
                    <th scope="col">Пол</th>
                    <th scope="col">ИИН</th>
                    <th scope="col">Дата выдачи ИИН</th>
                    <th scope="col">Админка</th>
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
                                     class="btn btn-sm btn-warning">Редактировать</button>
                         </form>
                     </td>
                     <td>
                         <form action="/delete_user_by_admin" method="post">
                             <input type="hidden" name="id" value="${user.id}">
                             <button type="submit"
                                     class="btn btn-sm btn-danger">Удалить</button>
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
