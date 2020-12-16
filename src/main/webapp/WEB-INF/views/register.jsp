<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:wrapper>
	<h3 class="text-center">Register yourself...</h3>
	<div class="d-flex justify-content-center">
	<form action="register" method="post">
	  <div class="form-group ">
	    <label for="exampleInputEmail">Email address</label>
	    <input name="emailAddress" type="email" class="form-control" id="exampleInputEmail" aria-describedby="emailHelp" required>
	    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
	  </div>
	  <div class="form-group ">
	    <label for="exampleInputName">Name</label>
	    <input name="Name" type="text" class="form-control" id="exampleInputName" required>
	  </div>
	  <div class="form-group ">
	    <label for="exampleInputName">Phone Number</label>
	    <input name="PhoneNumber" type="tel" class="form-control" id="exampleInputPhone" required>
	  </div>
	  <div class="form-group">
	    <label for="exampleInputPassword1">Password</label>
	    <input name="Password" type="password" class="form-control" id="exampleInputPassword1">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputDOB">Date of Birth</label>
	    <input name="DOB" type="date" class="form-control" id="exampleInputDOB">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputHouseNo">House No.</label>
	    <input name="HouseNo" type="text" class="form-control" id="exampleHouseNo">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputStreet">Street</label>
	    <input name="Street" type="text" class="form-control" id="exampleInputStreet">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputLocality">Locality</label>
	    <input name="Locality" type="text" class="form-control" id="exampleInputLocality">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputZipcode">Zipcode</label>
	    <input name="Zipcode" type="text" pattern="[0-9]{6}" class="form-control" id="exampleInputZipcode">
	  </div>
	  <div class="form-group">
	    <label for="exampleFormInputGender">Gender</label>
	    <select name="Gender" class="form-control" id="exampleInputGender">
	      <option value="M">Male</option>
	      <option value="F">Female</option>
	    </select>
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
	</div>

</t:wrapper>

