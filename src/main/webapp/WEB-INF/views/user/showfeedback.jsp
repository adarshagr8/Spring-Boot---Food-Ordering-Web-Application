<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:ordertemplate>
<div class="container pt-5">
	<h2>Feedback Details</h2>
</div>
<div class="container ">
		
</div>
<div class="container pb-5">
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Feedback ID
		</div>
		<div class="col-2">
			${c.getFeedbackID()}
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
			${c.getFeedbackMessage()}
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
</div>
</t:ordertemplate>