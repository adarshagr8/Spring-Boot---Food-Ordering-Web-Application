<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:adminwrapper>
<div class="container p-2">
<h2 class="pt-5">Items list</h2>
</div>
<div class="row">
	<div class="col-8"></div>
	<div class="col-3">
	<form action="/admin/items/newitem">
		<button type="submit" class="btn btn-outline-info btn-block" style="widht: 50px; font-size: 24px;">
			Add Item
		</button>
	</form>
	</div>
	<div class="col"></div>
</div>
<div class="container pt-5">
	<div class="list-group p-2">
	  <c:forEach items="${items}" var="i">
	  	<div class="container p-2">
	  	<a href="/admin/items/${i.getItemID()}" class="list-group-item list-group-item-action flex-column align-items-start">
	  		<div class="d-flex w-100 justify-content-between">
	  			<h5 class="mb-1 font-weight-bold">${i.getItemName()}</h5>
	  		</div>
	  		 <p class="mb-1 mt-1">
	  		 <strong>Item ID:</strong> # ${i.getItemID()}
	  		 </p>
	  		 <p>
	  		 <strong>Cost:</strong> ${i.getItemCost()} ₹
	  		 </p>
	  		 <c:choose>
	  		 	<c:when test="${i.getEnabled() == 1}">
	  		 		<p class="text-success">Enabled</p>
	  		 	</c:when>
	  		 	<c:otherwise>
	  		 	<p class="text-danger">Disabled</p>
	  		 	</c:otherwise>
	  		 </c:choose>
	  	</a>
	  	</div>
	  </c:forEach>
	</div>
</div>
</t:adminwrapper>

