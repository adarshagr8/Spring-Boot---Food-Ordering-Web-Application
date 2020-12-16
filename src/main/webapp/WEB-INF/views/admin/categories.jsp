<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:adminwrapper>
<div class="container p-2">
<h2 class="pt-5">Categories list</h2>
</div>
<div class="row">
	<div class="col-8"></div>
	<div class="col-3">
	<form action="/admin/categories/newcategory">
		<button type="submit" class="btn btn-outline-info btn-block" style="widht: 50px; font-size: 24px;">
			Add Category
		</button>
	</form>
	</div>
	<div class="col"></div>
</div>
<div class="container pt-5">
	<div class="list-group p-2">
	  <c:forEach items="${cat}" var="c">
	  	<div class="container p-2">
	  	<a href="/admin/categories/${c.getCategoryID()}" class="list-group-item list-group-item-action flex-column align-items-start">
	  		<div class="d-flex w-100 justify-content-between">
	  			<h5 class="mb-1 font-weight-bold">${c.getCategoryName()}</h5>
	  		</div>
	  		 <p class="mb-1 mt-1">
	  		 <strong>Category ID:</strong> # ${c.getCategoryID()}
	  		 </p>
	  		 <p>
	  		 <strong>Manager Name:</strong> Mr. ${c.getManagerName()}
	  		 </p>
	  	</a>
	  	</div>
	  </c:forEach>
	</div>
</div>
</t:adminwrapper>

