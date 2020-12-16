<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<style><%@include file="/css/orderportal.css"%></style>
<script><%@include file="/js/orderportal.js"%></script>
<t:wrapper>
	<div id="mySidenav" class="sidenav">
	  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()" id="close">&times;</a>
  <a href="/user/items">List Items</a>
  <a href="/user/cart">Your Cart</a>
  <a href="/user/orders">Your Orders</a>
  <a href="/user/complaint">Raise a Complaint</a>
  <a href="/user/feedback">Give Feedback</a>
</div>
<span onclick="openNav()" id="open">
<div class="container pt-4">
<button class="btn btn-outline-primary btn-lg "> Show Menu</button>
</div>
</span>
<div class="container pt-4">
<jsp:doBody/>
</div>

</t:wrapper>