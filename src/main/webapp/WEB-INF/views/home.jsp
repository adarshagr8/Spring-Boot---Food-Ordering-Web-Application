<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:wrapper>
<script>
</script>
<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
  	<c:forEach items="${gallery}" var="g" varStatus="loop">
  	  <li data-target="#carouselExampleIndicators" data-slide-to="${loop.index}" class="active"></li>
  	</c:forEach>
  </ol>
  <div class="carousel-inner">
  	<c:forEach items="${gallery}" var="g" varStatus="loop">
  	<c:choose>
  		<c:when test="${loop.index == 0}">
		    <div class="carousel-item active" style="height: 600px;">
		      <img class="d-block w-100" src="<c:url value="${g.getImage()}"/>">
		       <div class="carousel-caption d-none d-md-block">
				    <h4>${g.getTag()}</h4>
			   </div>
		    </div>
	    </c:when>
	    <c:otherwise>
	    	<div class="carousel-item" style="height: 600px;">
		      <img class="d-block w-100" src="<c:url value="${g.getImage()}"/>">
		       <div class="carousel-caption d-none d-md-block">
				    <h4>${g.getTag()}</h4>
			   </div>
		    </div>
	    </c:otherwise>
    </c:choose>
    </c:forEach>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
</t:wrapper>