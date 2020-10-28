<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:ordertemplate>
<div class = "container m-4">
<h1>Select the category..</h1>
</div>
<div class="container">
<c:forEach items="${categories}" var="ci">
<div class="border border-primary rounded p-2 m-2 text-left">
	<h3>${ci.getCategoryName()}</h3>
	<br>
	<div class="container text-right">
	<span>Manager Name: </span>
	<span class="mark">${ci.getManagerName()} </span></div>
	<a href="/user/items/${ci.getCategoryID()}"><button class="btn btn-primary">Click Here</button></a>
</div>	
</c:forEach>
</div>
</t:ordertemplate>