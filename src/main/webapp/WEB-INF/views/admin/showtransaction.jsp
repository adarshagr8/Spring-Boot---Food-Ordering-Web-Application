<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<t:adminwrapper>
<link rel="stylesheet" href="/css/rating.css"/>
<script src="/js/rating.min.js"></script>
<div class="container pt-4">
<h2>Transaction # ${t.getTransactionID()}</h2>
</div>
<div class="container">
	<h5>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Transaction Status
		</div>
		<div class="col-2">
			<c:choose>
		  		 <c:when test="${fn:contains(t.getStatus(),'SUCCESS')}">
		  		 	<span class="text-success">SUCCESS</span>
		  		 </c:when>
		  		 <c:otherwise>
		  		 	<span class="text-danger">${t.getStatus()}</span>
		  		 </c:otherwise>
	  		 </c:choose>
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Transaction ID
		</div>
		<div class="col-2">
			${t.getTransactionID()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Bank Transaction ID
		</div>
		<div class="col-2">
			${t.getBankTransactionID()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Invoice Amount
		</div>
		<div class="col-2">
			${t.getInvoiceAmount()} ₹
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Payement Method
		</div>
		<div class="col-2">
			${t.getPaymentMethod()} 
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			User ID
		</div>
		<div class="col-2">
			${t.getUserID()} 
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Customer Name
		</div>
		<div class="col-2">
			${u.getName()} 
		</div>
	</div>
</div>
<!-- rating.js file -->
</t:adminwrapper>

