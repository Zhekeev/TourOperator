<%--
  Created by IntelliJ IDEA.
  User: ergaz
  Date: 01.06.2020
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="tourListDAO" class="dao.impl.TourDaoImpl"/>
<jsp:useBean id="imageDAO" class="dao.impl.ImageDaoImpl"/>
<jsp:useBean id="imageEncoder" class="service.ImageEncoder"/>
<jsp:useBean id="tour" class="entity.Tour"/>
<html>
<head>
    <title>Добавить фото</title>
</head>
<body>
<div class="container">
    <jsp:include page="header.jsp"/>

    <c:set var="tour" value="${tour = tourListDAO.getByID(sessionScope.get('id'))}"/>
    <c:set var="tourImages" value="${tourImages = imageDAO.getAllByTourId(tour.id)}"/>

    <form action="/upload" method="post" enctype="multipart/form-data">
        <div class="row">
            <div class="col-md-6">
                <p class="featurette-heading">${room.roomClassRu} номер
                    ID: ${room.id}</br>
                    Номер комнаты №${room.price} </br>
                </p>
                Добавить фото
                <div class="input-group mb-6">
                    <div class="custom-file">
                        <input type="file" name="file" class="">
                    </div>
                </div>
                <br/>
                <div class="form-row">
                    <button type="submit" value="upload" class="btn btn-primary">Загрузить</button>
                </div>
            </div>
            <div class="col-md-6">
                <c:if test="${room.images.size() > 0}">
                    <ul>
                        <li>
                            <p>
                                Отметьте чтобы загрузить еще одно фото
                                <input type="radio" value="0" name="room_image_id_radio">
                            </p>
                        </li>
                        <c:forEach items="${room.imageList}" var="image">
                            <li>
                                <p>
                                    Фото ID: ${image.id}<br/>
                                    Отметьте чтобы заменить фото
                                    <input type="radio" value="${image.id}" name="room_image_id_radio"><br/>
                                    <input type="hidden" name="room_image_radio" value="${image.id}">
                                    <img width="200" height="200" src="${imageEncoder.encode(image.image)}"/><br/>
                                    <a href="${pageContext.request.contextPath}/controller/delete_room_image?image_id=${image.id}" type="button" style="width: 200px" class="btn btn-warning">Удалить фото</a>
                                </p>
                            </li>
                        </c:forEach>
                    </ul>

                </c:if>
            </div>

        </div>
    </form>
</div>
</body>
</html>
