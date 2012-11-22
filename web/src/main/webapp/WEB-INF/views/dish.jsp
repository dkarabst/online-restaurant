<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>                          
<c:forEach items="${listDishes}" var="dish" varStatus="rowCounter">
	<c:choose>
       <c:when test="${(rowCounter.count-1) % 3 == 0 }">
       		<div>
       			<div class="p2">
				<figure><a href="dishes/${dish.getId()}"><img src="${dish.getPhoto()}" alt=""></a></figure>
				<h5>${dish.getName()}</h5>
				 (Цена ${dish.getPrice()} грн.)
			</div>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${rowCounter.count % 3 == 0}">
					<figure><a href="dishes/${dish.getId()}"><img src="${dish.getPhoto()}" alt=""></a></figure>
					<h5>${dish.getName()}</h5>
					(Цена ${dish.getPrice()} грн.)
            		</div>
				</c:when>
					<c:otherwise>
					     <div class="p2">
							<figure><a href="dishes/${dish.getId()}"><img src="${dish.getPhoto()}" alt=""></a></figure>
							<h5>${dish.getName()}</h5>
							(Цена ${dish.getPrice()} грн.)
						</div>
					</c:otherwise>
           </c:choose>
		</c:otherwise>
	</c:choose>               
</c:forEach>