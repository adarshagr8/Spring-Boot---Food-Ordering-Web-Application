<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:wrapper>
<div class="container">
    <div class="row" style="margin-top: 50px;">
		<div class="col">
			<h1>
			Sorry, your order failed!
			</h1>
		</div>
		<div class="col" style="padding-bottom: 10px;">
	        <img class="float-right" style="width: 130px; height: 130px;"src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/cc/Cross_red_circle.svg/600px-Cross_red_circle.svg.png" >
	    </div>
	</div>
	<hr/>
	<h3>Order Details: </h3>
	<h5>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Order #
		</div>
		<div class="col-5">
			${order.getOrderID()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Order Time
		</div>
		<div class="col-5">
			${order.getOrderTime()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Order Date
		</div>
		<div class="col-5">
			${order.getOrderDate()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Item Total
		</div>
		<div class="col-5">
			${order.getAmount()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			GST Charges
		</div>
		<div class="col-5">
			${order.getGST()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Delivery Charges
		</div>
		<div class="col-5">
			${order.getDeliveryCharge()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Total Amount
		</div>
		<div class="col-5">
			${order.getTotalAmount()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Order Status
		</div>
		<div class="col-5">
			${order.getStatus()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Reason of failure
		</div>
		<div class="col-5">
			${message}
		</div>
	</div>
	<hr/>
	</div>
	</h5>	
</div>
</t:wrapper>