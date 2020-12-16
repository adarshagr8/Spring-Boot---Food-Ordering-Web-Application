<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:adminwrapper>
<div class="container p-2">
<h2 class="pt-5">Edit FAQ</h2>
</div>
<div class="row">
	<div class="col-8"></div>
		<div class="col-3">
		<form action="/admin/faq/delete/${f.getQuestionID()}">
			<button type="submit" class="btn btn-outline-danger btn-block" style="widht: 50px; font-size: 20px;">
			Delete Question
			</button>
		</form>
		</div>
	<div class="col"></div>
</div>
<div class="container pt-4">
	<form action="/admin/faq/edit/process" method="post">
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Question ID</p>
	    <div class="col-sm-7">
	      <input type="text" class="form-control-plaintext" readonly name="QuestionID" value="${f.getQuestionID()}">
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Question</p>
	    <div class="col-sm-7">
	      <input type="text" class="form-control" name="Question" value="${f.getQuestion()}">
	    </div>
	  </div>
	  <div class="form-group row">
	    <p class="font-weight-bold col-sm-2 col-form-label">Answer</p>
	    <div class="col-sm-7">
	      <textarea class="form-control" name="Answer">${f.getAnswer()}</textarea>
	    </div>
	  </div>
	  <div class="form-group row  float-right">
	  <button type="submit" class="btn btn-info" style="width:200px; height: 50px; margin-right: 50px;">Submit</button>
	  </div>
	</form>
</div>
</t:adminwrapper>