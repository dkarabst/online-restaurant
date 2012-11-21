<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" session="true" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>About</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/academy/resources/css/reset.css" type="text/css" media="screen">
    <link rel="stylesheet" href="/academy/resources/css/style.css" type="text/css" media="screen">
    <link rel="stylesheet" href="/academy/resources/css/layout.css" type="text/css" media="screen"> 
    <script src="/academy/resources/js/jquery.js" type="text/javascript"></script>
    <script src="/academy/resources/js/cufon-yui.js" type="text/javascript"></script>
    <script src="/academy/resources/js/cufon-replace.js" type="text/javascript"></script> 
    <script src="/academy/resources/js/Dynalight_400.font.js" type="text/javascript"></script>
    <script src="/academy/resources/js/FF-cash.js" type="text/javascript"></script>
    <script src="/academy/resources/js/tms-0.3.js" type="text/javascript"></script>
    <script src="/academy/resources/js/tms_presets.js" type="text/javascript"></script>
    <script src="/academy/resources/js/jquery.easing.1.3.js" type="text/javascript"></script>
    <script src="/academy/resources/js/jquery.equalheights.js" type="text/javascript"></script>    
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
<body id="page1">
	<!--==============================header=================================-->
    <header>
    	<form method="POST" commandName="user" class="login_form">
			<input type="text" placeholder="логин" name="login"><br>
			<input type="password" placeholder="Пароль" name="pass"><br>
			<input type="submit" value="Войти">
		</form>
		
    	<div class="row-top">
        	<div class="main">
            	<div class="wrapper">
                	<h1><a href="index.jsp">Catering<span>.com</span></a></h1>
                    <nav>
                        <ul class="menu">
                            <li><a class="active" href="index.jsp">About</a></li>
                            <li><a href="menu.jsp">Menu</a></li>
                            <li><a href="catalogue.jsp"> Catalogue </a></li>
                            <li><a href="shipping.jsp">Shipping</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
        <div class="row-bot">
        	<div class="row-bot-bg">
            	<div class="main">
                	<h2>Impressive Selection <span>for any Occasion</span></h2>
                    <div class="slider-wrapper">
                        <div class="slider">
                            <ul class="items">
                                <li>
                                    <img src="/academy/resources/images/slider-img1.jpg" alt="" />
                                </li>
                                <li>
                                    <img src="/academy/resources/images/slider-img2.jpg" alt="" />
                                </li>
                                <li>
                                    <img src="/academy/resources/images/slider-img3.jpg" alt="" />
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
    
	<!--==============================content================================-->
    <section id="content"><div class="ic">More Website Templates @ TemplateMonster.com - January 23, 2012!</div>
        <div class="main">
            <div class="wrapper img-indent-bot">
                <article class="col-1">
                	<a href="#"><img class="img-border" src="images/banner-1.jpg" alt=""></a>
                </article>
                <article class="col-1">
                	<a href="#"><img class="img-border" src="images/banner-2.jpg" alt=""></a>
                </article>
                <article class="col-2">
                	<a href="#"><img class="img-border" src="images/banner-3.jpg" alt=""></a>
                </article>
            </div>
            <div class="wrapper">
            	<article class="column-1">
                	<div class="indent-left">
                        <div class="maxheight indent-bot">
                            <h3>Our Services</h3>
                            <ul class="list-1">
                                <li><a href="#">Duis autem vel eum iriure dolor</a></li>
                                <li><a href="#">Hendrerit in vulputate velit esse molestie </a></li>
                                <li><a href="#">Consequat vel illum dolore</a></li>
                                <li><a href="#">Feugiat nulla facilisis at vero eros</a></li>
                                <li><a href="#">Accumsan et iusto odio dignissim qui</a></li>
                                <li><a href="#">Blandit praesent luptatum azril</a></li>
                                <li><a href="#">Delenit augue duis dolore te feugait</a></li>
                            </ul>
                        </div>
                        <a class="button-1" href="#">Read More</a>
                    </div>
                </article>
                <article class="column-2">
                	<div class="maxheight indent-bot">
                        <h3 class="p1">About the Catering</h3>
                        <h6 class="p2">Catering is one of <a class="color-3" href="http://blog.templatemonster.com/free-website-templates/" target="_blank">free website templates</a> created by TemplateMonster.com team. This website template is optimized for 1280X1024 screen resolution. It is also XHTML &amp; CSS valid.</h6>
                        <p class="p2">This <a href="http://blog.templatemonster.com/2012/01/23/free-website-template-jquery-slider-food-delivery-project/" target="_blank">Catering Template</a> goes with two packages â with PSD source files and without them. PSD source files are available for free for the registered members of TemplatesMonster.com. The basic package (without PSD source) is available for anyone without registration.</p>
                        This website template has several pages: <a href="index.html">About</a>, <a href="menu.html">Menu</a>, <a href="catalogue.html">Catalogue</a>, <a href="shipping.html">Shipping</a>, <a href="faq.html">FAQ</a>, <a href="contact.html">Contact</a> (note that contact us form â doesnât work).
                    </div>
                    <a class="button-2" href="#">Read More</a>
                </article>
            </div>
        </div>
    </section>
    
	<!--==============================footer=================================-->
    <footer>
        <div class="main">
        	<div class="aligncenter">
            	<span>Catering.com &copy; 2012</span>
                <a rel="nofollow" class="link" target="_blank" href="http://www.templatemonster.com/">Website Template</a> by TemplateMonster.com
            </div>
        </div>
    </footer>
    <script type="text/javascript"> Cufon.now(); </script>
    <script type="text/javascript">
		$(window).load(function() {
			$('.slider')._TMS({
				duration:1000,
				easing:'easeOutQuint',
				preset:'slideDown',
				slideshow:7000,
				banners:false,
				pauseOnHover:true,
				pagination:true,
				pagNums:false
			});
		});
    </script>
</body>
</html>
