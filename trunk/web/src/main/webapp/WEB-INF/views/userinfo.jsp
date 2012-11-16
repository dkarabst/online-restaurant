<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>Профиль пользователя</title>
    <script type="text/javascript" src="<spring:url value="/resources/js/jquery.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/resources/js/bootstrap.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/resources/js/userinfo.js"/>"></script>
    <link type="text/css" href="<spring:url value="/resources/css/user-info.css"/>" rel="stylesheet"/>
    <link type="text/css" href="<spring:url value="/resources/css/bootstrap.css"/>" rel="stylesheet"/>
    <link type="text/css" href="<spring:url value="/resources/css/bootstrap-responsive.css"/>" rel="stylesheet"/>
</head>

<body>
<div class="UserInfo">
    <div class="header">
        <h2>Профиль пользователя</h2>
        <hr>
    </div>
    <div class="body">
        <table id="userinfo_table" class="table">
            <tr>
                <th>Логин:</th>
                <th>
                    <small>Petrovan</small>
                </th>
            </tr>
            <tr>
                <th>Имя:</th>
                <th>
                    <small>Иван</small>
                </th>
            </tr>
            <tr>
                <th>Фамилия:</th>
                <th>
                    <small>Петров</small>
                </th>
            </tr>
            <tr>
                <th>E-mail:</th>
                <th>
                    <small>ivan.petrov@gmail.com</small>
                </th>
            </tr>
            <tr>
                <th>Телефон:</th>
                <th>
                    <small>099-515-424-2</small>
                </th>
            </tr>
        </table>

        <span id="images_title"><strong>Загруженные изображения</strong></span>

        <form id="fileuploadForm" action="/userinfo.html" method="POST" enctype="multipart/form-data" onsubmit="return Validate();">

            <div id="choose_image" class="fileupload fileupload-new" data-provides="fileupload">
                <div class="fileupload-new thumbnail" style="width: 200px; height: 150px;">
                    <img src="http://www.placehold.it/200x150/EFEFEF/AAAAAA&amp;text=no+image">
                </div>
                <div id="uploaded_image" class="fileupload-preview fileupload-exists thumbnail"
                     style="max-width: 225px; max-height: 150px; line-height: 20px;">
                </div>
                <div>
                    <span id="choose_btn" class="btn btn-small btn-file ">
                        <span class="fileupload-new">Выбрать изображение</span>
                        <span class="fileupload-exists">Изменить</span>
                        <input id="file" type="file" name="file" onchange="UpdBtnEnable()">
                    </span>
                    <a href="#" class="btn btn-small fileupload-exists" data-dismiss="fileupload" onclick="UpdBtnDisable()">Удалить</a>
                </div>
            </div>
            <div>
                <button name="upl_btn" id="upload_btn" disabled="disabled"  type="submit" class="btn btn-small">Сохранить изображение</button>
            </div>
        </form>

        <div id="myModal" class="modal hide fade" tabindex="1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h3 id="myModalLabel">Ошибка</h3>
            </div>
            <div class="modal-body">
                <p>Вы пытаетесь сохранить не изображение</p>
            </div>
            <div class="modal-footer">
                <button class="btn" data-dismiss="modal" aria-hidden="true">Закрыть</button>
            </div>
        </div>

        <div id="image_pos">
            <ul id="image_list" class="unstyled">
                <c:if test="${not empty userAttachmentList}">
                <c:forEach items="${userAttachmentList}" var="attachment">
                <li>
                    <img id="image_item" src="${attachment.path}" class="img-polaroid">
                </li>
                </c:forEach>
                </c:if>
                <c:if test="${empty userAttachmentList}">
                Нет загруженных изображений.
                </c:if>
        </div>

    </div>
</div>

</body>

</html>