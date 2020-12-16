<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:adminwrapper>
<div class="container pt-5">
	<h2>${role} Details</h2>
</div>
<div class="row">
	<div class="col-7"></div>
	<div class="col-2">
	<form action="/admin/users/deleteuser/${user.getUserID()}">
		<button type="submit" class="btn btn-outline-danger btn-block" style="widht: 50px; font-size: 24px;">
			Delete User
		</button>
	</form>
	</div>
	<div class="col-2">
	<form action="/admin/users/edit/${user.getUserID()}">
		<button type="submit" class="btn btn-outline-info btn-block" style="widht: 50px; font-size: 24px;">
			Edit User
		</button>
	</form>
	</div>
	<div class="col"></div>
</div>
<div class="container pb-5">
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			User ID
		</div>
		<div class="col-2">
			${user.getUserID()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Name
		</div>
		<div class="col-2">
			${user.getName()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Email Address
		</div>
		<div class="col-2">
			${user.getEmailAddress()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Phone Number
		</div>
		<div class="col-2">
			${user.getPhoneNumber()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Date of Birth
		</div>
		<div class="col-2">
			${user.getDOB()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Authority
		</div>
		<div class="col-2">
			${user.getAuthority()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			House No
		</div>
		<div class="col-2">
			${user.getHouseNo()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Street
		</div>
		<div class="col-2">
			${user.getStreet()} 
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Locality
		</div>
		<div class="col-4">
			${user.getLocality()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Gender
		</div>
		<div class="col-2">
			${user.getGender()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			CreatedDate
		</div>
		<div class="col-2">
			${user.getCreatedDate()}
		</div>
	</div>
	
</div>
</t:adminwrapper>