<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:wrapper>
<div class="container p2">
	<h2 >Frequently Asked Questions...</h2>
</div>
<div class="container">
	<div class="accordian">
		<c:forEach items="${questions}" var="q">
		
		<div class="card">
			<div class="card-header" id="headingOne">
				<h2 class="mb-0">
					<button class="btn btn-link btn-block text-left" type="button"
						data-toggle="collapse" data-target="#collapseOne"
						aria-expanded="true" aria-controls="collapseOne">
						${q.question}</button>
				</h2>	
			</div>

			<div id="collapseOne" class="collapse show"
				aria-labelledby="headingOne" data-parent="#accordionExample">
				<div class="card-body">${q.answer}</div>
			</div>
		</div>
		</c:forEach>
	</div>
</div>
</t:wrapper>
