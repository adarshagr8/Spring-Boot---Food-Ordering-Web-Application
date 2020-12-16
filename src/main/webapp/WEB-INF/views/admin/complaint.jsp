<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:adminwrapper>
<div class="container p-2">
<h2 class="pt-5">Complaints Received</h2>
</div>

<div class="container pt-5">
	<div class="list-group p-2">
	  <c:forEach items="${complaints}" var="c">
	  	<div class="container p-2">
	  	<a href="/admin/complaints/${c.getComplaintID()}" class="list-group-item list-group-item-action flex-column align-items-start">
	  		<div class="d-flex w-100 justify-content-between">
	  			<h5 class="mb-1">Complaint # ${c.getComplaintID()}</h5>
	  			<small>${c.getRecordedTime()}</small>
	  		</div>
	  		 <p class="mb-1 mt-1">
	  		 Subject: ${c.getSubject()}
	  		 </p>
	  		 <p>
	  		 Status: 
	  		 <c:choose>
		  		 <c:when test="${c.getStatus() == 'UNDER REVIEW'}">
		  		 	<span class="text-warning">${c.getStatus()}</span>
		  		 </c:when>
		  		 <c:otherwise>
		  		 	<span class="text-success">${c.getStatus()}</span>
		  		 </c:otherwise>
	  		 </c:choose>
	  		 </p>
	  		 <p>
	  		 User ID : ${c.getUserID()}
	  		 </p>
	  	</a>
	  	</div>
	  </c:forEach>
	</div>
</div>
</t:adminwrapper>

