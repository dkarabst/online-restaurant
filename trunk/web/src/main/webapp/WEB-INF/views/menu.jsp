<%@ page language="java" contentType="text/html; charset=utf8" 	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<head>
    <title>Menu</title>
    <meta charset="utf-8">
    
	<link rel="stylesheet" href="css/reset.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/layout.css" type="text/css" media="screen"> 
    <link rel="stylesheet" href="css/prettyPhoto.css" type="text/css" media="screen">
    <script src="js/jquery-1.7.1.min.js" type="text/javascript"></script>
    <script src="js/cufon-yui.js" type="text/javascript"></script>
    <script src="js/cufon-replace.js" type="text/javascript"></script> 
    <script src="js/Dynalight_400.font.js" type="text/javascript"></script>
    <script src="js/FF-cash.js" type="text/javascript"></script>  
    <script src="js/jquery.prettyPhoto.js" type="text/javascript"></script> 
    <script src="js/hover-image.js" type="text/javascript"></script>
    <script src="js/jquery.easing.1.3.js" type="text/javascript"></script>  
    <script src="js/jquery.bxSlider.js" type="text/javascript"></script>
    
    <script type="text/javascript">
		$(document).ready(function() {
			$('#slider').bxSlider({
				pager: true,
				controls: false,
				moveSlideQty: 1,
				displaySlideQty: 3
			});
		}); 
	</script>
	<!--[if lt IE 8]>
    <div style=' clear: both; text-align:center; position: relative;'>
        <a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
        	<img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
        </a>
    </div>
	<![endif]-->
    <!--[if lt IE 9]>
   		<script type="text/javascript" src="js/html5.js"></script>
	<![endif]-->
</head>
<body id="page2">
	<!--==============================header=================================-->
    <header>
    	<div class="row-top">
        	<div class="main">
            	<div class="wrapper">
                	<h1><a href="index">Restaurant<span>.com.ua</span></a></h1>
                    <nav>
                        <ul class="menu">
                            <sec:authorize ifAllGranted="ROLE_ANONYMOUS">
									<li><a href="spring_security_login">Войти</a></li>
							</sec:authorize>
							<sec:authorize ifAnyGranted="ROLE_ADMIN, ROLE_USER">
									<li><a href="j_spring_security_logout">Выйти</a></li>
							</sec:authorize>
                            <li><a class="active" href="">Меню</a></li>
                            <li><a href="user">Личный кабинет</a></li>
                            <li><a href="card">Корзина</a></li>
                            <li><a href="history"> История заказов </a></li>
 
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
        <div class="row-bot">
        	<div class="row-bot-bg">
            	<div class="main">
                	<h2>Online <span>Restaurant</span></h2>
                </div>
            </div>
        </div>
    </header>
    
	<!--==============================content================================-->
    <section id="content"><div class="ic"></div>
        <div class="main">
            <div class="wrapper">
            	<article class="col-1">
                	<div class="indent-left">
                        <h3 class="p1">Меню</h3>
                            <div id="slider">
                            <jsp:include page="dish.jsp"  />
                    </div>
                </article>
                <article class="col-2">
                	<jsp:include page="category.jsp"  />
                </article>
 
            </div>
        </div>
    </section>
    
	<!--==============================footer=================================-->
    <footer>
        <div class="main">
        	<div class="aligncenter">
            	<span> DP-026 JAVA &copy; 2012</span>
            </div>
        </div>
    </footer>
    <script type="text/javascript"> Cufon.now(); </script>
</body>
</html>
