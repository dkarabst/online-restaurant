<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="row-top">
	<div class="main">
		<div class="wrapper">
			<h1 style="top: -20px;">
				<a href="index"> OnRest <span>.com</span></a>
			</h1>
			<nav>
				<ul class="menu">
					<li><a class="active" href="index"> 
					<fmt:message key="index" />
					</a></li>
					<li><a href="menu"> <fmt:message key="menu" />
					</a></li>
					<li><a href="catalogue"><fmt:message key="catalogue" /></a></li>
					<li><a href="shipping"><fmt:message key="shipping" /></a></li>
					<li><a href="faq"><fmt:message key="faq" /></a></li>
					<li><a href="contact"><fmt:message key="contact" /></a></li>
				</ul>
			</nav>
			<span style="float: right"> Language : <a href="?language=en">English</a>|<a
				href="?language=ru_RU">RUS</a>
			</span>
		</div>
	</div>
</div>