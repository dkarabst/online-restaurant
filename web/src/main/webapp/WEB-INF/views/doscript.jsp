<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style type="text/css"> 
body,table,hr { 
   color: black; 
   background: silver; 
   font-family: Verdana, sans-serif; 
   font-size: 13px; 
} 



</style>
<title>SQL</title>
</head>
<body>




<form:form method="post" action="do">

	<table>
  
  <tr>
			<td><input type="text" name="script" style="width:400px" /></td>
		</tr>
  
  
  <tr>
    <td><input type="submit"  value="Submit"></td>
    </tr>
  <tr>
  
	</table>
	
</form:form>



</body>
</html>