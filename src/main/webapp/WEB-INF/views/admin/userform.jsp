<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:adminwrapper>
<div class="container pt-5">
<h2>Edit User Details</h2>
</div>
<div class="container pt-4">
	<form action="/admin/editdone" method="post">
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">User ID</p>
	    <div class="col-sm-7">
	      <input type="text" readonly class="form-control-plaintext" value="${u.getUserID()}" name="UserID">
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Name</p>
	    <div class="col-sm-7">
	      <input type="text" class="form-control" value="${u.getName()}" name="Name">
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Email</p>
	    <div class="col-sm-7">
	      <input type="text" readonly class="form-control-plaintext" value="${u.getEmailAddress()}" name="EmailAddress">
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Password (Encrypted)</p>
	    <div class="col-sm-7">
	      <input type="text" readonly class="form-control-plaintext" value="${u.getPassword()}" name="Password">
	    </div>
	    <div class="col-sum-2"></div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Phone Number</p>
	    <div class="col-sm-7">
	      <input type="text" class="form-control" value="${u.getPhoneNumber()}" name="PhoneNumber">
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Enabled</p>
	    <div class="col-sm-7">
	      <select class="form-control" value="${u.getEnabled()}" name="Enabled">
		      <option value="true">Yes</option>
		      <option value="false">No</option>
		    </select>
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Authority</p>
	    <div class="col-sm-7">
	      <input type="text" class="form-control" value="${u.getAuthority()}" name="Authority">
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Date Of Birth</p>
	    <div class="col-sm-7">
	      <input type="date" class="form-control" value="${u.getDOB()}" name="DOB">
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">House No</p>
	    <div class="col-sm-7">
	      <input type="text" class="form-control" value="${u.getHouseNo()}" name="HouseNo">
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Street</p>
	    <div class="col-sm-7">
	      <input type="text" class="form-control" value="${u.getStreet()}" name="Street">
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Locality</p>
	    <div class="col-sm-7">
	      <input type="text" class="form-control" value="${u.getLocality()}" name="Locality">
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Gender</p>
	    <div class="col-sm-7">
	      <input type="text" class="form-control" value="${u.getGender()}" name="Gender">
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Created Date</p>
	    <div class="col-sm-7">
	      <input type="date" readonly class="form-control-plaintext" value="${u.getCreatedDate()}" name="CreatedDate">
	    </div>
	  </div>
	  <hr/>
	  <div class="form-group row  float-right">
	  <button type="submit" class="btn btn-info" style="width:200px; height: 50px; margin-right: 50px;">Submit</button>
	  </div>
	</form>
</div>
</t:adminwrapper>