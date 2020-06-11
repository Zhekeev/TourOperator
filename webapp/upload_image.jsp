<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="tourListDAO" class="dao.impl.TourDaoImpl"/>
<jsp:useBean id="imageDAO" class="dao.impl.ImageDaoImpl"/>
<jsp:useBean id="imageEncoder" class="service.ImageEncoder"/>
<jsp:useBean id="tour" class="entity.Tour"/>

<html>
<head>
    <jsp:include page="style.jsp"/>
    <title>Добавить фото</title>
</head>
<body>
<div class="container">
    <jsp:include page="header.jsp"/>
<%--    <c:set var="tour" value="${tour = tourListDAO.getByID(sessionScope.get('id'))}"/>
    <c:set var="tourImages" value="${tourImages = imageDAO.getAllByTourId(tour.id)}"/>--%>

    <form action="/upload" method="post" enctype="multipart/form-data">
        <div class="row">
            <div class="col-md-6">
                <p class="featurette-heading">
                    ID: ${requestScope.tours.id}</br>
                    Название тура ${requestScope.tours.descriptionRu} </br>
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
