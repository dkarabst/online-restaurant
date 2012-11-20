<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true" %>

<!DOCTYPE HTML>
<html>
<head>
	<link href="css/style.css" rel="stylesheet">
	<link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
    <script type="text/javascript" src="js/bootstrap.js"></script>
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
		<li><a href="#"><div><p class="well">Order</p></div></a></li>
		<li><a href="#"><div><p class="well">######</p></div></a></li>
		<li><a href="#"><div><p class="well">About</p></div></a></li>
	</ul>

	<div class="categories">
		<div ref="/dish/category/1" class="category"><div></div></div>
		<div ref="/dish/category/2" class="category"><div></div></div>
		<div ref="/dish/category/3" class="category"><div></div></div>
		<div ref="/dish/category/4" class="category"><div></div></div>
	</div>

	<footer>

	</footer>
</div>
</body>

