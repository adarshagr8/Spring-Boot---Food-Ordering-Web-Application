<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:adminwrapper>
<div class="container p-2">
<h2 class="pt-5">Edit Photo</h2>
</div>
<div class="container pt-4">
	<form action="/admin/gallery/edit/process" method="post" enctype="multipart/form-data">
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Photo ID</p>
	    <div class="col-sm-7">
	      <input type="text" class="form-control-plaintext" readonly name="PhotoID" value="${g.getPhotoID()}">
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Image</p>
	    <div class="col-sm-7">
	      <div class="col-sm-7">
	      <input type="file" class="form-control" name="photo"/>
	    </div>
	    </div>
	  </div>
	  <div class="form-group row pt-4">
	    <p class="font-weight-bold col-sm-2 col-form-label">Tag</p>
	    <div class="col-sm-7">
	      <input type="text" class="form-control" name="Tag" value="${g.getTag()}"/>
	    </div>
	  </div>
	  <div class="form-group row  float-right">
	  <button type="submit" class="btn btn-info" style="width:200px; height: 50px; margin-right: 50px;">Submit</button>
	  </div>
	</form>
</div>
</t:adminwrapper>