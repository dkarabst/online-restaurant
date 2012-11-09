<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

  <head>
    <title>Профиль пользователя</title>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap/bootstrap-responsive.css">
    <link rel="stylesheet" type="text/css" href="/css/user-info.css">
  </head>

  <body>
  <form  id="fileuploadForm" action="/userinfo.html" method="POST" enctype="multipart/form-data">
        <div class="UserInfo">
            <div class="header">
                <h2>Профиль пользователя</h2>
                <hr>
            </div>
            <div class="body">

                <div>
                    <label>Логин:</label>
                    <input type="text"/>
                    <input id="file" type="file" name="file"/>
                </div>
                <div>
                    <label>Новый пароль</label>
                    <input type="text"/>
                    <button type="submit">Upload</button>
                </div>
                <div>
                    <label>Подтверждение нового пароля:</label>
                    <input type="text"/>
                </div>
                <div>
                    <label>Имя:</label>
                    <input type="text"/>
                </div>
                <div>
                    <label>Фамилия:</label>
                    <input type="text"/>
                </div>
                <div>
                    <label>E-Mail:</label>
                    <input type="text"/>
                </div>
                <div>
                    <label>Телефон:</label>
                    <input type="text"/>
                </div>
                <div>
                    <input id="save_btn" type="button" value="Сохранить" class="btn btn-small btn-success"/>
                </div>
            </div>
        </div>
    </form>
  </body>

</html>