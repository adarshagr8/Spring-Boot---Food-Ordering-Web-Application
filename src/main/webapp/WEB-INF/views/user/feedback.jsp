<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:ordertemplate>
<div class="container p-2">
<h2 class="pt-5">Your Feedbacks</h2>
</div>
<div class="row">
	<div class="col-8"></div>
	<div class="col-3">
	<form action="/user/feedback/newfeedback">
		<button type="submit" class="btn btn-outline-info btn-block" style="widht: 50px; font-size: 24px;">
			Add a new Feedback
		</button>
	</form>
	</div>
	<div class="col"></div>
</div>
<div class="container pt-5">
	<div class="list-group p-2">
	  <c:forEach items="${comp}" var="c">
	  	<div class="container p-2">
	  	<a href="/user/feedback/${c.getFeedbackID()}" class="list-group-item list-group-item-action flex-column align-items-start">
	  		<div class="d-flex w-100 justify-content-between">
	  			<h5 class="mb-1">Feedback # ${c.getFeedbackID()}</h5>
	  			<small>${c.getRecordedTime()}</small>
	  		</div>
	  		 <p class="mb-1 mt-1">
	  		 Subject: ${c.getSubject()}
	  		 </p>
	  	</a>
	  	</div>
	  </c:forEach>
	</div>
</div>
</t:ordertemplate>

