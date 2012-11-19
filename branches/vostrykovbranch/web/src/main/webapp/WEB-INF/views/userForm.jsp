
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
	<head>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
    <script type="text/javascript" src="http://www.jstoolbox.com/js/jquery.validate.min.js"></script>

	<script>
	jQuery(document).ready(function(){
		jQuery("#signup").validate({
			  rules: {
		            name:	"required",
		            email:	{ required: true, email: true },
		            password: "required"
		         },
		         messages: {
		            name:  "Enter name",
		            email: "Enter correct  E-mail",
		            password: "enter correct pass"
		         }
			  });
	});
	</script>

		<title>Registration Page</title>
	</head>
	<body>
		<h2>Register</h2>
	
		<form id="signup" action="" method="POST" commandName="user">
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
					<div class="note"><span id="note-password">Should be at least 6 chars</span>
					</div>
					</div>
					<div>
					<label for="phone">Enter a Phone:</label>
					<input type="text" id="phone" name="phone" >
					<div class="note"><span id="note-phone">example: 067-999-99-99</span>
					</div>
					</div>
		
				<input type="submit" value="Sign Up!" name="submit" id="submit"  >
			</form>
	</body>
</html>