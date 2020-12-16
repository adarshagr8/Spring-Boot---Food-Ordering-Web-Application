<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:adminwrapper>
<div class="container pt-5">
	<h2>Feedback Details</h2>
</div>
<div class="row">
	<div class="col-8"></div>
	<div class="col-3">
	<form action="/admin/feedbacks/resolve/${f.getFeedbackID()}">
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
			Feedback ID
		</div>
		<div class="col-2">
			${f.getFeedbackID()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Status
		</div>
		<div class="col-2">
			<c:choose>
				<c:when test="${f.getStatus() == 0}">
					<span class="text-warning">Not Yet Resolved</span>
				</c:when>
				<c:otherwise>
					<span class="text-success">Resolved</span>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Subject
		</div>
		<div class="col-2">
			${f.getSubject()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Feedback Message
		</div>
		<div class="col-2">
			${f.getFeedbackMessage()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Submitted by Used ID
		</div>
		<div class="col-2">
			${f.getUserID()}
		</div>
	</div>
</div>
</t:adminwrapper>