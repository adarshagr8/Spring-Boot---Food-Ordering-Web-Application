<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:adminwrapper>
<div class="container p-2">
<h2 class="pt-5">Add a new Item</h2>
</div>
<div class="container pt-4">
	<form action="/admin/items/process" method="post" enctype="multipart/form-data">
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Name</p>
	    <div class="col-sm-7">
	      <input type="text" class="form-control" name="ItemName" required>
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Category</p>
	    <div class="col-sm-7">
	      <select class="form-control" name="CategoryID">
	      	<c:forEach items="${cat}" var="c">
		      <option value="${c.getCategoryID()}">${c.getCategoryName()}</option>
		     </c:forEach>
		    </select>
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Cost</p>
	    <div class="col-sm-7">
	      <input type="number" class="form-control" name="ItemCost">
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Desciption</p>
	    <div class="col-sm-7">
	      <textarea class="form-control" name="ItemDescription"></textarea>
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Expiry Duration</p>
	    <div class="col-sm-7">
	      <input type="number" step="1" class="form-control" name="ExpiryDuration">
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Maximum Allowed Quantity</p>
	    <div class="col-sm-7">
	      <input type="number" step="1" class="form-control" name="MaxAllowedQty">
	    </div>
	  </div>
	  	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Maximum Temperature</p>
	    <div class="col-sm-7">
	      <input type="number" step="1" class="form-control" name="MaxTemperature">
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Minimum Temperature</p>
	    <div class="col-sm-7">
	      <input type="number" step="1" class="form-control" name="MinTemperature">
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Image</p>
	    <div class="col-sm-7">
	      <input type="file" class="form-control" name="image"/>
	    </div>
	  </div>
	  <hr/>
	  <div class="form-group row  float-right">
	  <button type="submit" class="btn btn-info" style="width:200px; height: 50px; margin-right: 50px;">Submit</button>
	  </div>
	</form>
</div>
</t:adminwrapper>