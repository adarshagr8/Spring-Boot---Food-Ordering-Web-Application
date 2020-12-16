<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:adminwrapper>
<div class="container p-2">
<h2 class="pt-5">Order Details</h2>
</div>
<div class="container pt-5">
	<div class="list-group p-2">
	  <c:forEach items="${orders}" var="o">
	  	<div class="container p-2">
	  	<a href="/admin/orders/${o.getOrderID()}" class="list-group-item list-group-item-action flex-column align-items-start">
	  		<div class="d-flex w-100 justify-content-between">
	  			<h5 class="mb-1">Order # ${o.getOrderID()}</h5>
	  			<small>${o.getOrderDate()}</small>
	  		</div>
	  		 <p class="mb-1 mt-1">
	  		 Total Amount: ${o.getTotalAmount()}
	  		 </p>
	  		 <p>
	  		 Status: 
	  		 <c:choose>
		  		 <c:when test="${o.getStatus() == 'SUCCESS'}">
		  		 	<span class="text-success">SUCCESS</span>
		  		 </c:when>
		  		 <c:otherwise>
		  		 	<span class="text-danger">${o.getStatus()}</span>
		  		 </c:otherwise>
	  		 </c:choose>
	  		 </p>
	  	</a>
	  	</div>
	  </c:forEach>
	</div>
</div>
</t:adminwrapper>

