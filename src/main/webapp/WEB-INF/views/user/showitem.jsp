<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:ordertemplate>
<div class = "container m-4">
<h1>Item Details</h1>
</div>
<hr/>
<div class="container">
	<div class="row">
		<div class="col">
		<img src="<c:url value="${item.getItemImage()}"/>" style="width:500px;height:300px;">
		</div>
		<div class="col">
			<div class="container">
				<h2>${item.getItemName() }</h2>
			</div>
			<p class="blockquote-footer" style="font-size: 18px;">
				${item.getItemDescription() }
			</p>
			<div class="container" style="font-size: 17px;">
				<span class="text-info text-weight-bold">Maximum Quantity Allowed: </span> ${item.getMaxAllowedQty()} Kg
			</div>
			<div class="container" style="font-size: 17px;">
				<span class="text-info text-weight-bold">Maximum Temperature: </span> ${item.getMaxTemperature()}<sup>o</sup> C
			</div>
			<div class="container" style="font-size: 17px;">
				<span class="text-info text-weight-bold">Minimum Temperature: </span> ${item.getMinTemperature()}<sup>o</sup> C
			</div>
			<div class="container" style="font-size: 17px;">
				<span class="text-info text-weight-bold">Expiry Duration: </span> ${item.getExpiryDuration()} days
			</div>
			<hr/>
			<div class="container" style="font-size:25px;">
				<span class="text-info text-weight-bold">Price: </span> ${item.getItemCost()} ₹ per KG
			</div>
			<form class = "form-inline" action="/user/additem" method="post">
				<div class="form-group p-2 m-2">
					<input type="number" class="form-control input-lg" style="width: 160px;"name="Qty" step="0.25" id="Qty" placeholder="Enter Quantity" min="0.25" max="${item.getMaxAllowedQty()}"/>
				</div>
				<input name="ItemID" value="${item.getItemID()}" style="display: none;"/>
				<input name="UserID" value="${userid}" style="display: none;"/>
				<button type="submit" class="btn btn-primary btn-lg">Add to Cart!</button>
			</form>
		</div>
	</div>
</div>
</t:ordertemplate>