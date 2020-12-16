<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:wrapper>
<div class="container p-2">
<h2 class="p-3">User Details</h2>
</div>
<div class="row p-3">
	<div class="col-9"></div>
	<div class="col-2">
	<form action="/user/edit">
		<button type="submit" class="btn btn-outline-info btn-block" style="widht: 50px; font-size: 24px;">
			Edit Details
		</button>
	</form>
	</div>
	<div class="col"></div>
</div>
<div class="container">
	<table class="table">
	  <thead class="thead-light">
	    <tr>
	      <th scope="col">Field</th>
	      <th scope="col">Data</th>
	    </tr>
	  </thead>
	  <tbody>
	    <tr>
	      <th scope="row">Name</th>
	      <td>${user.getName()}</td>
	    </tr>
	    <tr>
	      <th scope="row">Phone Number</th>
	      <td>${user.getPhoneNumber()}</td>
	    </tr>
	    <tr>
	      <th scope="row">Email Address</th>
	      <td>${user.getEmailAddress()}</td>
	    </tr>
	    <tr>
	      <th scope="row">Date of Birth</th>
	      <td>${user.getDOB()}</td>
	    </tr>
	    <tr>
	      <th scope="row">House No</th>
	      <td>${user.getHouseNo()}</td>
	    </tr>
	    <tr>
	      <th scope="row">Street</th>
	      <td>${user.getStreet()}</td>
	    </tr>
	    <tr>
	      <th scope="row">Locality</th>
	      <td>${user.getLocality()}</td>
	    </tr>
	    <tr>
	      <th scope="row">Gender</th>
	      <td>${user.getGender()}</td>
	    </tr>
	    <tr>
	      <th scope="row">Date Created</th>
	      <td>${user.getCreatedDate()}</td>
	    </tr>
	  </tbody>
	</table>
</div>
</t:wrapper>

