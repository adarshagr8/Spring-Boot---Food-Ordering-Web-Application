<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:adminwrapper>
<div class="container p-2">
<h2 class="pt-5">Edit Item Details</h2>
</div>
<div class="container pt-4">
	<form action="/admin/items/edit/process" method="post" enctype="multipart/form-data">
      <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Item ID</p>
	    <div class="col-sm-7">
	      <input type="text" class="form-control-plaintext" readonly name="ItemID" value="${item.getItemID()}">
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Name</p>
	    <div class="col-sm-7">
	      <input type="text" class="form-control" name="ItemName" value="${item.getItemName()}" required>
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Status</p>
	    <div class="col-sm-7">
	      <select class="form-control" name="Enabled">
	      <c:choose>
		      	<c:when test="${item.getEnabled() == 1}">
		      		<option value="1" selected>Enabled</option>
		      		<option value="0">Disabled</option>
		      	</c:when>
		      	<c:otherwise>
			      <option value="1">Enabled</option>
		      	  <option value="0" selected>Disabled</option>
			    </c:otherwise>
		   	</c:choose>
	      </select>
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Category</p>
	    <div class="col-sm-7">
	      <select class="form-control" name="CategoryID">
	      	<c:forEach items="${cat}" var="c">
	      	<c:choose>
		      	<c:when test="${item.getCategoryID() == c.getCategoryID()}">
		      		<option value="${c.getCategoryID()}" selected>${c.getCategoryName()}</option>
		      	</c:when>
		      	<c:otherwise>
			      <option value="${c.getCategoryID()}">${c.getCategoryName()}</option>
			    </c:otherwise>
		   	</c:choose>
		     </c:forEach>
		    </select>
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Cost</p>
	    <div class="col-sm-7">
	      <input type="number" class="form-control" name="ItemCost" value="${item.getItemCost()}">
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Desciption</p>
	    <div class="col-sm-7">
	      <textarea class="form-control" name="ItemDescription">${item.getItemDescription()}</textarea>
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Expiry Duration</p>
	    <div class="col-sm-7">
	      <input type="number" step="1" class="form-control" name="ExpiryDuration" value="${item.getExpiryDuration()}">
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Maximum Allowed Quantity</p>
	    <div class="col-sm-7">
	      <input type="number" step="1" class="form-control" name="MaxAllowedQty" value="${item.getMaxAllowedQty()}">
	    </div>
	  </div>
	  	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Maximum Temperature</p>
	    <div class="col-sm-7">
	      <input type="number" step="1" class="form-control" name="MaxTemperature" value="${item.getMaxTemperature()}">
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Minimum Temperature</p>
	    <div class="col-sm-7">
	      <input type="number" step="1" class="form-control" name="MinTemperature" value="${item.getMinTemperature()}">
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Image</p>
	    <div class="col-sm-7">
	      <input type="file" class="form-control" name="image" value="<c:url value="${item.getItemImage()}"/>">
	    </div>
	  </div>
	  <hr/>
	  <div class="form-group row  float-right">
	  <button type="submit" class="btn btn-info" style="width:200px; height: 50px; margin-right: 50px;">Submit</button>
	  </div>
	</form>
</div>
</t:adminwrapper>