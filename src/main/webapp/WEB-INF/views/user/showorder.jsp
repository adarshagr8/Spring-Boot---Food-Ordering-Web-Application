<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:ordertemplate>
<link rel="stylesheet" href="/css/rating.css"/>
<script src="/js/rating.min.js"></script>
<div class="container p-2">
<h3>Order # ${order.getOrderID()}</h3>
</div>
<div class="container">
	<c:choose>
		<c:when test="${order.getStatus() == 'SUCCESS'}">
			<div class="container" style="padding-top: 50px; padding-bottom: 50px;">
					<form action="/downloadinvoice" method="post" target="_blank">
						<input name="tid" value="${txn.getTransactionID()}"  style="display: none;">
				 		<button type="submit" class="btn btn-outline-info float-right" style="widht: 50px; font-size: 24px;">Download Invoice</button>
				 	</form>
			</div>
		</c:when>
	</c:choose>
	<h5>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Order Status
		</div>
		<div class="col-2">
			<c:choose>
		  		 <c:when test="${order.getStatus() == 'SUCCESS'}">
		  		 	<span class="text-success">SUCCESS</span>
		  		 </c:when>
		  		 <c:otherwise>
		  		 	<span class="text-danger">${order.getStatus()}</span>
		  		 </c:otherwise>
	  		 </c:choose>
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Order Time
		</div>
		<div class="col-2">
			${order.getOrderTime()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Order Date
		</div>
		<div class="col-2">
			${order.getOrderDate()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Item Total
		</div>
		<div class="col-2">
			${order.getAmount()} ₹
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			GST Charges
		</div>
		<div class="col-2">
			${order.getGST()} %
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Delivery Charges
		</div>
		<div class="col-2">
			${order.getDeliveryCharge()} ₹
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Total Amount
		</div>
		<div class="col-2">
			${order.getTotalAmount()} ₹
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Payement Method
		</div>
		<div class="col-2">
			${txn.getPaymentMethod()} 
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Delivery Address
		</div>
		<div class="col-4">
			${user.getHouseNo()}, ${user.getStreet()}
			${user.getLocality()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Customer Phone Number
		</div>
		<div class="col-2">
			${user.getPhoneNumber()}
		</div>
	</div>
	<c:choose>
		<c:when test="${order.getStatus() == 'SUCCESS'}">
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Items:
		</div>
		<div class="col-2">
		</div>
	</div>
	<div class="row pt-4">
			
			<div class="col">
				<p class="font-weight-bold">#</p>
			</div>
			<div class="col-2">
				<p class="font-weight-bold">Item Name</p>
			</div>
			<div class="col">
				<p class="font-weight-bold">Category</p>
			</div>
			<div class="col">
				<p class="font-weight-bold">Quantity</p>
			</div>
			<div class="col">
				<p class="font-weight-bold">Cost</p>
			</div>
			<div class="col-2">
				<p class="font-weight-bold">Rating</p>
			</div>
			<!-- <div class="col-2">
				<p class="font-weight-bold">Submit Rating</p>
			</div> -->
		</div>
		<c:forEach items="${items}" var="q" varStatus="loop">
			<div class="row">
				
				<div class="col">
					<p>${loop.count}</p>
				</div>
				<div class="col-2">
					<p>${q.getItemName()}</p>
				</div>
				<div class="col">
					<p>${q.getCategory()}</p>
				</div>
				<div class="col">
					<p>${q.getQuantity()}</p>
				</div>
				<div class="col">
					<p>${q.getPrice()} ₹</p>
				</div>
				<div class="col-2">
					    <fieldset class="rate">
						    <input type="radio" id="rating10" name="rating" value="10" /><label for="rating10" title="5 stars"></label>
						    <input type="radio" id="rating9" name="rating" value="9" /><label class="half" for="rating9" title="4 1/2 stars"></label>
						    <input type="radio" id="rating8" name="rating" value="8" /><label for="rating8" title="4 stars"></label>
						    <input type="radio" id="rating7" name="rating" value="7" /><label class="half" for="rating7" title="3 1/2 stars"></label>
						    <input type="radio" id="rating6" name="rating" value="6" /><label for="rating6" title="3 stars"></label>
						    <input type="radio" id="rating5" name="rating" value="5" /><label class="half" for="rating5" title="2 1/2 stars"></label>
						    <input type="radio" id="rating4" name="rating" value="4" /><label for="rating4" title="2 stars"></label>
						    <input type="radio" id="rating3" name="rating" value="3" /><label class="half" for="rating3" title="1 1/2 stars"></label>
						    <input type="radio" id="rating2" name="rating" value="2" /><label for="rating2" title="1 star"></label>
						    <input type="radio" id="rating1" name="rating" value="1" /><label class="half" for="rating1" title="1/2 star"></label>
						    <input type="radio" id="rating0" name="rating" value="0" /><label for="rating0" title="No star"></label>
						</fieldset>
				</div>
				<!-- <div class="col-2">
					
				</div> -->
			</div>
		</c:forEach>
		</c:when>
		</c:choose>
	<hr/>
	</h5>
	</div>
</div>
<!-- rating.js file -->
</t:ordertemplate>

