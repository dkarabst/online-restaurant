
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://ajax.microsoft.com/ajax/jquery.validate/1.8.1/jquery.validate.js"></script>
    
	<link rel="stylesheet" href="/mvc/resources/base.css" type="text/css" media="screen"/>
	<link rel="stylesheet" href="/mvc/resources/form.css" type="text/css" media="screen"/>
    <script type="text/javascript" src="/mvc/resources/script.js" ></script>
     
		<title>Registration Page</title>
	</head>
	<body>
		<h2>Register</h2>
	
		<form id="signup"  method="POST" commandName="user">
<div>
					<label for="name">Enter you Name:</label>
					<input type="text" id="name" name="name">
					</div>
					<div>
					<label for="email">E-mail Address:</label>
					<input type="text" id="email" name="email" >
					</div>
					<div>
					<label for="password">Enter a Password:</label>
					<input type="password" id="password" name="password">
					</div>
					<div>
					<label for="phone">Enter a Phone:</label>
					<input type="text" id="phone" name="phone" >
					</div>
		
				<input type="submit" value="Register" name="submit" id="submit"  >
			</form>
	</body>
</html>