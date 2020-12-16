<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:adminwrapper>
<div class="container pt-5">
	<h2>Complaint Details</h2>
</div>
<div class="row">
	<div class="col-8"></div>
	<div class="col-3">
	<form action="/admin/complaints/resolve/${c.getComplaintID()}">
		<button type="submit" class="btn btn-outline-success btn-block" style="widht: 50px; font-size: 24px;">
			Mark as Resolved
		</button>
	</form>
	</div>
	<div class="col"></div>
</div>
<div class="container">
		
</div>
<div class="container pb-5">
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Complaint ID
		</div>
		<div class="col-2">
			${c.getComplaintID()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Subject
		</div>
		<div class="col-2">
			${c.getSubject()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Message
		</div>
		<div class="col-5">
			${c.getComplaintMessage()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Status
		</div>
		<div class="col-5">
			<c:choose>
		  		 <c:when test="${c.getStatus() == 'UNDER REVIEW'}">
		  		 	<span class="text-warning">${c.getStatus()}</span>
		  		 </c:when>
		  		 <c:otherwise>
		  		 	<span class="text-success">${c.getStatus()}</span>
		  		 </c:otherwise>
	  		 </c:choose>
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Recorded Time
		</div>
		<div class="col-5">
			${c.getRecordedTime()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Image
		</div>
		<div class="col-5">
			<img src="<c:url value="${c.getImage()}"/>" style="width:300px;height:200px;">
		</div>
	</div>
</div>
</t:adminwrapper>