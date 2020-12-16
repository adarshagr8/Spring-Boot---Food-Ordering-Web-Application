<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:adminwrapper>
<div class="container p-2">
<h2 class="pt-5">Frequently Asked Questions</h2>
</div>
<div class="row">
	<div class="col-8"></div>
	<div class="col-3">
	<form action="/admin/faq/newfaq">
		<button type="submit" class="btn btn-outline-info btn-block" style="widht: 50px; font-size: 24px;">
			Add FAQ
		</button>
	</form>
	</div>
	<div class="col"></div>
</div>
<div class="container pt-5">
	<div class="list-group p-2">
	  <c:forEach items="${faq}" var="f">
	  	<div class="container p-2">
	  	<a href="/admin/faq/${f.getQuestionID()}" class="list-group-item list-group-item-action flex-column align-items-start">
	  		<div class="d-flex w-100 justify-content-between">
	  			<h5 class="mb-1 font-weight-bold">${f.getQuestion()}</h5>
	  		</div>
	  		 <p class="mb-1 mt-2">
	  		 ${f.getAnswer()}
	  		 </p>
	  	</a>
	  	</div>
	  </c:forEach>
	</div>
</div>
</t:adminwrapper>

