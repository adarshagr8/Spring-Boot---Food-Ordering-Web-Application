<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:adminwrapper>
<div class="container p-2">
<h2 class="pt-5">Feedbacks Received</h2>
</div>

<div class="container pt-5">
	<div class="list-group p-2">
	  <c:forEach items="${feedback}" var="f">
	  	<div class="container p-2">
	  	<a href="/admin/feedbacks/${f.getFeedbackID()}" class="list-group-item list-group-item-action flex-column align-items-start">
	  		<div class="d-flex w-100 justify-content-between">
	  			<h5 class="mb-1 font-weight-bold">Feedback ID # ${f.getFeedbackID()}</h5>
	  			<small>${f.getRecordedTime()}</small>
	  		</div>
	  		 <p class="mb-1 mt-2">
	  		 Subject: ${f.getSubject()}
	  		 </p>
	  		  <p class="mb-1 mt-2">
	  		 Status: <c:choose>
				<c:when test="${f.getStatus() == 0}">
					<span class="text-warning">Not Yet Resolved</span>
				</c:when>
				<c:otherwise>
					<span class="text-success">Resolved</span>
				</c:otherwise>
			</c:choose>
	  		 </p>
	  	</a>
	  	</div>
	  </c:forEach>
	</div>
</div>
</t:adminwrapper>

