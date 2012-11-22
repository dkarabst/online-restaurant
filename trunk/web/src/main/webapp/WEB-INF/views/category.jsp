<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   

<h3>Категории</h3>
<ul class="price-list p2">                       
<c:forEach items="${listCategory}" var="category" varStatus="rowCounter">
 	<li><span></span><a href="category/${category.getId()}">${category.getName()}</a></li>
</c:forEach>
</ul>