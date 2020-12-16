<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:wrapper>
<div class="container">
    <div class="row" style="margin-top: 50px;">
		<div class="col">
			<h1>
			Bingo, your order was placed successfully!
			</h1>
		</div>
		<div class="col" style="padding-bottom: 10px;">
	        <img class="float-right" style="width: 100px; height: 130px;"src="https://cdn3.iconfinder.com/data/icons/flat-actions-icons-9/792/Tick_Mark_Dark-512.png" >
	    </div>
	</div>
	<hr/>
	<h3>Order Details: </h3>
	<h5>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Order #
		</div>
		<div class="col-2">
			${order.getOrderID()}
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
			${order.getGST()} ₹
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
			Items:
		</div>
		<div class="col-2">
		</div>
	</div>
	<div class="row">
			<div class="col-3"></div>
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
		</div>
		<c:forEach items="${items}" var="q" varStatus="loop">
			<div class="row">
				<div class="col-3"></div>
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
					<p>${q.getPrice()} ₹</p>
				</div>
			</div>
		</c:forEach>
	<hr/>
	</div>
	</h5>
	<div class="container" style="padding-top: 50px; padding-bottom: 50px;">
			<form action="/downloadinvoice" method="post" target="_blank">
				<input name="tid" value="${txn.getTransactionID()}"  style="display: none;">
		 		<button type="submit" class="btn btn-outline-info btn-block " style="widht: 50px; font-size: 24px;">Download Invoice</button>
		 	</form>
	</div>
</div>
</t:wrapper>