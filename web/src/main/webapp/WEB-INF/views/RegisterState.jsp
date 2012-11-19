 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page session="true" %>
<html>
<head>
	<title>Register State</title>
<style>
   .colortext {
     color: blue; /* color of use */
     font-size: 150%;
   }
  </style>

</head>
<body>
<P> You just register new user:  <span class="colortext">${user.name}</span> </P>
  <button><img src="login.png" style="vertical-align: middle">Login</button>
</body>

</html>
