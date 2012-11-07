<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="order/addDish">
		To add dish :<br>
		  Dish id: <input type="text" name="dish_id"/><br>
		Quantity : <input type="text" name="quantity"/><br>
		<input	type="submit" value="add dish" />
	</form>
	<br>
	<form method="post" action="order/deleteDish">
		To remove dish :<br>
		  Dish id: <input type="text" name="dish_id"/><br>
		Quantity : <input type="text" name="quantity"/><br>
		<input	type="submit" value="remove dish" />
	</form>
	<br>
	<br>
	<form method="get" action="order/makeOrder">
		to make order plz press: <input	type="submit" value="Make order" />
	</form>

</body>
</html>