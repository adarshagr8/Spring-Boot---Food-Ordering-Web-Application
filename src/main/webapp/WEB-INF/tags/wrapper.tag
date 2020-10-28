<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="css/mdb.min.css" rel="stylesheet">
    <!-- Your custom styles (optional) -->
    <link href="css/style.css" rel="stylesheet">

    <title>Madhuram Sweets</title>
  </head>
  <body>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <nav class="navbar navbar-light bg-light">
          <a class="navbar-brand" href="/">
            <img src="<c:url value="/images/madhuram-sweets.png" />" width="170" height="40" class="d-inline-block align-top" alt="" loading="lazy">
          </a>
        </nav>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          
        </ul>
        <ul class="navbar-nav">
        <c:choose>
		  <c:when test="${empty username}">
		    <li class="nav-item">
	            <a class="nav-link" href="/login">Login</a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link" href="/register">Register</a>
	          </li>
		  </c:when>
		  <c:otherwise>
		  	<li class="nav-item text-center">
	            <a class="nav-link" href="/user/userdetails">Hello, ${username}</a>
	        </li>
		  	<li class="nav-item">
	            <a class="nav-link" href="/user/orderportal">Order Now!</a>
	        </li>
	        <li class="nav-item">
	            <a class="nav-link" href="/logout">Logout</a>
	          </li>
		  </c:otherwise>
		</c:choose>
          <li class="nav-item">
            <a class="nav-link" href="/about">About Us</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/faq">FAQ</a>
          </li>
        </ul>
      </div>
    </nav>
    	<jsp:doBody/>
   <!-- Footer -->
  </body>
</html>
