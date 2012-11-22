<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" session="true" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
<head>
	<link href="/academy/resources/css/style.css" rel="stylesheet" type="text/css">
	<link href="/academy/resources/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="/academy/resources/css/bootstrap-responsive.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/academy/resources/js/bootstrap.js"></script>
        <script type="text/javascript" src="/academy/resources/js/jquery.js"></script>
</head>
<body>
<div class="center">
	<header>
		<a href="homepage.jsp"><img src="#" alt=""></a>
		<form method="POST" commandName="user" class="login_form">
			<input type="text" placeholder="Логин" name="login"><br>
			<input type="password" placeholder="Пароль" name="pass"><br>
			<input type="submit" value="Войти">
		</form>
	</header>

	<ul class="main_menu">
		<li><a href="#"><div><p class="well">Home</p></div></a></li>
		<li><a href="order"><div><p class="well">Order</p></div></a></li>
		<li><a href="category"><div><p class="well">Categories</p></div></a></li>
		<li><a href="#"><div><p class="well">About</p></div></a></li>
		<li><a href="userinfo.html"><div><p class="well">UserInfo</p></div></a></li>
		<li><a href="/register"><div><p class="well">Register</p></div></a></li>
	</ul>

	<div class="categories">
		<div ref="/academy/resources/images/vine.jpg" class="category"></div><div>Vine</div>
		<div ref="/dish/category/2" class="category"></div><div></div>
		<div ref="/dish/category/3" class="category"></div><div></div>
		<div ref="/dish/category/4" class="category"></div><div></div>
	</div>

	<footer>

	</footer>
</div>
</body>

