<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:adminwrapper>
<div class="container p-2">
<h2 class="pt-5">Add a new FAQ</h2>
</div>
<div class="container pt-4">
	<form action="/admin/faq/newfaq/process" method="post">
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Question</p>
	    <div class="col-sm-7">
	      <input type="text" class="form-control" name="Question" required />
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Answer</p>
	    <div class="col-sm-7">
	      <textarea class="form-control" name="Answer"></textarea>
	    </div>
	  </div>
	  <div class="form-group row  float-right">
	  <button type="submit" class="btn btn-info" style="width:200px; height: 50px; margin-right: 50px;">Submit</button>
	  </div>
	</form>
</div>
</t:adminwrapper>