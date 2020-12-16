<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:adminwrapper>
<div class="container pt-5">
	<h2>Photo Details</h2>
</div>
<div class="row">
	<div class="col-7"></div>
	<div class="col-2">
	<form action="/admin/gallery/edit/${g.getPhotoID()}">
		<button type="submit" class="btn btn-outline-info btn-block" style="widht: 50px; font-size: 24px;">
			Edit Photo
		</button>
	</form>
	</div>
	<div class="col-2">
	<form action="/admin/gallery/delete/${g.getPhotoID()}">
		<button type="submit" class="btn btn-outline-danger btn-block" style="widht: 50px; font-size: 24px;">
			Delete Photo
		</button>
	</form>
	</div>
	<div class="col"></div>
</div>
<div class="container ">
		
</div>
<div class="container pb-5">
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Photo ID
		</div>
		<div class="col-2">
			${g.getPhotoID()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Tag
		</div>
		<div class="col-2">
			${g.getTag()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Image
		</div>
			<img class = "float-right" src="<c:url value="${g.getImage()}"/>" style="width:300px;height:200px;">
	</div>
</div>
</t:adminwrapper>