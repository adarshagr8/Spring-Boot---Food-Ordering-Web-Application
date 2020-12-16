<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:adminwrapper>
<div class="container p-2">
<h2 class="pt-5">Transaction Details</h2>
</div>
<div class="container pt-5">
	<div class="list-group p-2">
	  <c:forEach items="${txn}" var="t">
	  	<div class="container p-2">
	  	<a href="/admin/transactions/${t.getTransactionID()}" class="list-group-item list-group-item-action flex-column align-items-start">
	  		<div class="d-flex w-100 justify-content-between">
	  			<h5 class="mb-1">Transaction # ${t.getTransactionID()}</h5>
	  			<small>${t.getTransactionTime()}</small>
	  		</div>
	  		 <p class="mb-1 mt-1">
	  		 Invoice Amount: ${t.getInvoiceAmount()}
	  		 </p>
	  		 <p>
	  		 Status: 
	  		 <c:choose>
		  		 <c:when test="${fn:contains(t.getStatus(),'SUCCESS')}">
		  		 	<span class="text-success">SUCCESS</span>
		  		 </c:when>
		  		 <c:otherwise>
		  		 	<span class="text-danger">${t.getStatus()}</span>
		  		 </c:otherwise>
	  		 </c:choose>
	  		 </p>
	  	</a>
	  	</div>
	  </c:forEach>
	</div>
</div>
</t:adminwrapper>

