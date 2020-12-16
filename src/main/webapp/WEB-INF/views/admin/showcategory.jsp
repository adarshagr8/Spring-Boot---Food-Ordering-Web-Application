<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:adminwrapper>
<div class="container pt-5">
	<h2>Category Details</h2>
</div>
<div class="row">
	<div class="col-6"></div>
	<div class="col-2">
	<form action="/admin/categories/edit/${cat.getCategoryID()}">
		<button type="submit" class="btn btn-outline-info btn-block" style="widht: 50px; font-size: 24px;">
			Edit Category
		</button>
	</form>
	</div>
		<div class="col-3">
		<form action="/admin/categories/delete/${cat.getCategoryID()}">
			<button type="submit" class="btn btn-outline-danger btn-block" style="widht: 50px; font-size: 24px;">
			Delete Category
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
			Category ID
		</div>
		<div class="col-2">
			${cat.getCategoryID()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Category Name
		</div>
		<div class="col-2">
			${cat.getCategoryName()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Manager Name
		</div>
		<div class="col-2">
			Mr. ${cat.getManagerName()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Category Description
		</div>
		<div class="col-5">
			${cat.getCategoryDescription()}
		</div>
	</div>
	<div class="row pt-4">
		<div class="col-3 font-weight-bold">
			Items Count
		</div>
		<div class="col-5">
			${count}
		</div>
	</div>
</div>
</t:adminwrapper>