<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:adminwrapper>
<div class="container pt-5">
	<h2>List of all the ${role}</h2>
</div>
<div class="container">
	<div class="list-group p-2">
	  <c:forEach items="${users}" var="u">
	  	<div class="container p-2">
	  	<a href="/admin/users/${u.getUserID()}" class="list-group-item list-group-item-action flex-column align-items-start">
	  		<div class="d-flex w-100 justify-content-between">
	  			<h5 class="mb-1">User #${u.getUserID()}</h5>
	  		</div>
	  		 <p class="mb-1 mt-1">
	  		 Name: ${u.getName()}
	  		 </p>
	  		 <p class="mb-1 mt-1">
	  		 Email Address: ${u.getEmailAddress()}
	  		 </p>
	  		 <p>
	  		 Phone Number: ${u.getPhoneNumber()}
	  		 </p>
	  	</a>
	  	</div>
	  </c:forEach>
	</div>
</div>

</t:adminwrapper>
