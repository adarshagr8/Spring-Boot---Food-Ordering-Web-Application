<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:ordertemplate>
<c:choose>
<c:when test="${itemtotal > 0}">
	<div class = "container m-4">
	<h1>Here is your cart!</h1>
	</div>
	<hr/>
	<div class="container">
		<div class="row">
			<div class="col">
				<p class="font-weight-bold">#</p>
			</div>
			<div class="col">
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
			<div class="col"></div>
		</div>
		<c:forEach items="${cart}" var="q" varStatus="loop">
			<div class="row">
				<div class="col">
					<p>${loop.count}</p>
				</div>
				<div class="col">
					<p>${q.getItemName()}</p>
				</div>
				<div class="col">
					<p>${q.getCategory()}</p>
				</div>
				<div class="col">
					<p>${q.getQuantity()}</p>
				</div>
				<div class="col">
					<p>${q.getPrice()}</p>
				</div>
				<div class="col">
					<a href="/user/delete/${q.getItemID()}"><button type="button" class="btn btn-danger btn-sm">
			          <i class="glyphicon glyphicon-trash"></i> Trash  
			        </button></a>
				</div>
			</div>
		</c:forEach>
		<hr/>
		<div class="row mt-5">
			<div class="col-7">
			</div>
			<div class="col">
				<p class="text-info text-weight-bold">Item Total: </p>
			</div>
			<div class="col">
			 	${itemtotal} ₹
			 </div>
		</div>
		<div class="row">
			<div class="col-7">
			</div>
			<div class="col">
				<p class="text-info text-weight-bold">GST: </p>
			</div>
			<div class="col">
			 	${gst} %
			 </div>
		</div>
		<div class="row">
			<div class="col-7">
			</div>
			<div class="col">
				<p class="text-info text-weight-bold">Delivery Charge: </p>
			</div>
			<div class="col">
			 	${delivery} ₹
			 </div>
		</div>
		<div class="row">
			<div class="col-7">
			</div>
			<div class="col">
				<p class="text-info text-weight-bold">Total Amount: </p>
			</div>
			<div class="col">
			 	${total} ₹
			 </div>
		</div>
		<div class="row mb-5">
			<div class="col-7">
			</div>
			<div class="col">
				<form action="/user/payment/submitPaymentDetail" method="post">
			 		<a href="/user/buy"><button class="btn btn-danger btn-block " style="widht: 200px;">Buy Now!</button></a>
			 	</form>
			 </div>
		</div>
	</div>
</c:when>
<c:otherwise>
	<div class = "container m-4">
	<h1>Alas! The cart is empty. Add items to find them in cart...</h1>
	</div>
</c:otherwise>
</c:choose>
</t:ordertemplate>