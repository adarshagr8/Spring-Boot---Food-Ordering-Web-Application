<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<t:ordertemplate>
<div class = "container m-4">
<h3>${category.getCategoryName()}</h3>
<p class="font-weight-light font-italic">
${category.getCategoryDescription()}
</p>
<hr/>
</div>
<div class="container">
<div class="row">
<c:forEach items="${items}" var="item" varStatus="loop">
	<c:if test="${loop.index % 3 == 0}">
		</div>
		<div class="row">
	</c:if>
  <div class="col-sm-6">
    <div class="card w-75">
    <img class="card-img-top w-75" src="<c:url value="${item.getItemImage()}"/>" alt="Card image">
      <div class="card-body">
        <h6 class="card-title">${item.getItemName()}</h6>
        <p class="card-text blockquote-footer">${item.getItemDescription()}</p>
        <a href="/user/items/${category.getCategoryID()}/${item.getItemID()}" class="btn btn-primary">Click Here</a>
      </div>
    </div>
  </div>
</c:forEach>
</div>
</t:ordertemplate>