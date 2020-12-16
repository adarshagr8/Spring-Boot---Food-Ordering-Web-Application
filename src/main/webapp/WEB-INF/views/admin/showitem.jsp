<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:adminwrapper>
<div class="container pt-5">
	<h2>Item Details</h2>
</div>
<div class="row">
	<div class="col-7"></div>
	<div class="col-2">
	<form action="/admin/items/edit/${item.getItemID()}">
		<button type="submit" class="btn btn-outline-info btn-block" style="widht: 50px; font-size: 24px;">
			Edit Item
		</button>
	</form>
	</div>
	<c:choose>
		<c:when test="${item.getEnabled() == 1}">
			<div class="col-2">
			<form action="/admin/items/disable/${item.getItemID()}">
				<button type="submit" class="btn btn-outline-danger btn-block" style="widht: 50px; font-size: 24px;">
					Disable Item
				</button>
			</form>
			</div>
		</c:when>
		<c:otherwise>
			<div class="col-2">
			<form action="/admin/items/enable/${item.getItemID()}">
				<button type="submit" class="btn btn-outline-success btn-block" style="widht: 50px; font-size: 24px;">
					Enable Item
				</button>
			</form>
			</div>
		</c:otherwise>
	</c:choose>
	<div class="col"></div>
</div>
<div class="container ">
		
</div>
<div class="container pb-5">
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Item ID
		</div>
		<div class="col-2">
			${item.getItemID()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Item Name
		</div>
		<div class="col-2">
			${item.getItemName()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Status
		</div>
		<div class="col-2">
			<c:choose>
	  		 	<c:when test="${item.getEnabled() == 1}">
	  		 		<p class="text-success">Enabled</p>
	  		 	</c:when>
	  		 	<c:otherwise>
	  		 	<p class="text-danger">Disabled</p>
	  		 	</c:otherwise>
	  		 </c:choose>
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Item Cost
		</div>
		<div class="col-2">
			${item.getItemCost()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Item Image
		</div>
			<img class = "float-right" src="<c:url value="${item.getItemImage()}"/>" style="width:300px;height:200px;">
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Expiry Duration
		</div>
		<div class="col-2">
			${item.getExpiryDuration()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Maximum Allowed Quanitity
		</div>
		<div class="col-2">
			${item.getMaxAllowedQty()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Maximum Temperature
		</div>
		<div class="col-2">
			${item.getMaxTemperature()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Minimum Temperature
		</div>
		<div class="col-2">
			${item.getMinTemperature()} 
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Category
		</div>
		<div class="col-4">
			${cat.getCategoryName()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Item Description
		</div>
		<div class="col-5">
			${item.getItemDescription()}
		</div>
	</div>
</div>
</t:adminwrapper>