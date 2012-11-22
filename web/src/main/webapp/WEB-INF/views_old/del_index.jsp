<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>


<html>
<head>
<title>About</title>
<meta charset="utf-8">
<jsp:include page="includes.jsp" flush="true" />

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



		<jsp:include page="header.jsp" flush="true" />
		
		<div class="row-bot">
			<div class="row-bot-bg">
				<div class="main">
					<h2>
						Impressive Selection <span>for any Occasion</span>
					</h2>
					<div class="slider-wrapper">
						<div class="slider">
							<ul class="items">
								<li><img src="images/slider-img1.jpg" alt="" /></li>
								<li><img src="images/slider-img2.jpg" alt="" /></li>
								<li><img src="images/slider-img3.jpg" alt="" /></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!--==============================content================================-->
	<section id="content">
		<div class="ic">More Website Templates @ TemplateMonster.com -
			January 23, 2012!</div>
		<div class="main">
			<div class="wrapper img-indent-bot">
				<article class="col-1">
					<a href="#"><img class="img-border" src="images/banner-1.jpg"
						alt=""></a>
				</article>
				<article class="col-1">
					<a href="#"><img class="img-border" src="images/banner-2.jpg"
						alt=""></a>
				</article>
				<article class="col-2">
					<a href="#"><img class="img-border" src="images/banner-3.jpg"
						alt=""></a>
				</article>
			</div>
			<div class="wrapper">
				<article class="column-1">
					<div class="indent-left">
						<div class="maxheight indent-bot">
							<h3>Our Services</h3>
							<ul class="list-1">
								<li><a href="#">Duis autem vel eum iriure dolor</a></li>
								<li><a href="#">Hendrerit in vulputate velit esse
										molestie </a></li>
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
						<h6 class="p2">
							Catering is one of <a class="color-3"
								href="http://blog.templatemonster.com/free-website-templates/"
								target="_blank">free website templates</a> created by
							TemplateMonster.com team. This website template is optimized for
							1280X1024 screen resolution. It is also XHTML &amp; CSS valid.
						</h6>
						<p class="p2">
							This <a
								href="http://blog.templatemonster.com/2012/01/23/free-website-template-jquery-slider-food-delivery-project/"
								target="_blank">Catering Template</a> goes with two packages â
							with PSD source files and without them. PSD source files are
							available for free for the registered members of
							TemplatesMonster.com. The basic package (without PSD source) is
							available for anyone without registration.
						</p>
						This website template has several pages: <a href="index.html">About</a>,
						<a href="menu.html">Menu</a>, <a href="catalogue.html">Catalogue</a>,
						<a href="shipping.html">Shipping</a>, <a href="faq.html">FAQ</a>,
						<a href="contact.html">Contact</a> (note that contact us form â
						doesnât work).
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
				<span>Catering.com &copy; 2012</span> <a rel="nofollow" class="link"
					target="_blank" href="http://www.templatemonster.com/">Website
					Template</a> by TemplateMonster.com
			</div>
		</div>
	</footer>
	<script type="text/javascript">
		Cufon.now();
	</script>
	<script type="text/javascript">
		$(window).load(function() {
			$('.slider')._TMS({
				duration : 1000,
				easing : 'easeOutQuint',
				preset : 'slideDown',
				slideshow : 7000,
				banners : false,
				pauseOnHover : true,
				pagination : true,
				pagNums : false
			});
		});
	</script>
</body>
</html>
