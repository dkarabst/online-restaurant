<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
    <title>Корзина</title>
</head>

<body>
    <div>
        <ul id="order_dishes">
            <li>
                <div>
                    Фото:
                </div>
                <div>
                    Название:
                </div>
                <div>
                    Описание:
                </div>
                <div>
                    Время приготовления:
                </div>
                <div>
                    Вес:
                </div>
                <div>
                    Цена:
                </div>
            </li>
        </ul>
    </div>
    <div>
        <button id="order_btn" type="submit" >Заказать</button>
    </div>
</body>

</html>