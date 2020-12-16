<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link rel="stylesheet" href="/css/simple-sidebar.css">
    <!-- Bootstrap core CSS -->

    <title>Admin Pannel</title>
</head>
<body>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
  <div class="d-flex" id="wrapper">

    <!-- Sidebar -->
    <div class="bg-light border-right" id="sidebar-wrapper">
      <div class="sidebar-heading"> <h3>Admin Panel</h3> </div>
      <div class="list-group list-group-flush">
        <a href="/admin/users" class="list-group-item list-group-item-action bg-light">Users</a>
        <a href="/admin/admins" class="list-group-item list-group-item-action bg-light">Admins</a>
        <a href="/admin/orders" class="list-group-item list-group-item-action bg-light">Orders</a>
        <a href="/admin/items" class="list-group-item list-group-item-action bg-light">Items</a>
        <a href="/admin/categories" class="list-group-item list-group-item-action bg-light">Categories</a>
        <a href="/admin/transactions" class="list-group-item list-group-item-action bg-light">Transactions</a>
        <a href="/admin/parameters" class="list-group-item list-group-item-action bg-light">Payment Parameters</a>
        <a href="/admin/feedbacks" class="list-group-item list-group-item-action bg-light">Feedbacks</a>
        <a href="/admin/complaints" class="list-group-item list-group-item-action bg-light">Complaints</a>
        <a href="/admin/faq" class="list-group-item list-group-item-action bg-light">FAQ</a>
        <a href="/admin/gallery" class="list-group-item list-group-item-action bg-light">Gallery</a>
      </div>
    </div>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">

      <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
        <button class="btn btn-primary" id="menu-toggle">Toggle Menu</button>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
            <li class="nav-item">
              <a class="nav-link" href="/">Go to Website<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/logout">Logout</a>
            </li>
        
          </ul>
        </div>
      </nav>
      
      <jsp:doBody/>

    </div>
    <!-- /#page-content-wrapper -->

  </div>
  <!-- /#wrapper -->

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Menu Toggle Script -->
  <script>
    $("#menu-toggle").click(function(e) {
      e.preventDefault();
      $("#wrapper").toggleClass("toggled");
    });
  </script>

</body>
</html>