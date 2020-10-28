<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:wrapper>
	<h3 class="text-center">Please enter your details here</h3>
	<div class="d-flex justify-content-center">
	<form action="processLogin" method="post">
	  <div class="form-group ">
	    <label for="exampleInputEmail1">Email address</label>
	    <input name="emailAddress" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
	    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
	  </div>
	  <div class="form-group">
	    <label for="exampleInputPassword1">Password</label>
	    <input name="Password" type="password" class="form-control" id="exampleInputPassword1">
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
	</div>

</t:wrapper>

