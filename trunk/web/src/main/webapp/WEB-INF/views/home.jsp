<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<a href="helloPage">Hello page here</a><br>
<a href="dishes/getDishes">Dishes page here</a><br>
<a href="dishes/1">Dish by id</a><br>
<a href="1.json">LOOKUP HERE</a><br>
<a href="2.json">LOOKUP HERE</a><br>
<a href="3.json">LOOKUP HERE</a><br>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
