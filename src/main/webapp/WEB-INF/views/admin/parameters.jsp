<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:adminwrapper>
<div class="container p-2">
<h2 class="pt-5">Payment Parameters</h2>
</div>
<div class="container pt-4">
	<c:forEach items="${parameters}" var="p">
		<div class="row p-4">
		    <p class="font-weight-bold col-2">${p.getParameter()}</p>
		    <div class="col-5">
		    <form action="/admin/parameters/update" method="post">
			    	<input type="number" step="1" min="${p.getMin()}" max="${p.getMax()}" class="form-control" name="Value" value="${p.getValue()}" required>
			      <input type="hidden" value="${p.getParameter()}" name="Parameter">
			    </div>
			    <div class="col-sm-2"></div>			    
			    <div class="col-sm-2">
			    	<button type="submit" class="btn btn-info mb-2">Update</button>
			    </div>
			</form>
		</div>
	</c:forEach>
</div>
</t:adminwrapper>