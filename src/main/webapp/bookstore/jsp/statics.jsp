<%@ page import="java.util.ArrayList"%>
<%@ page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>BookStore</title>

<%
	String path = request.getContextPath();

%>
<link href="<%=path%>/bookstore/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=path%>/bookstore/css/dataTables.bootstrap.css"
	rel="stylesheet">
<link href="<%=path%>/bookstore/css/dataTables.responsive.css"
	rel="stylesheet">
<link href="<%=path%>/bookstore/css/bookstore.css" rel="stylesheet">
<link href="<%=path%>/bookstore/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
</head>

<body>
	<%
		int amount = 0;
	    if (request.getAttribute("amount") != null){
	    	amount = Integer.parseInt(String.valueOf(request.getAttribute("amount")));
	    }
	%>
	
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">

		<div class="navbar-header">
			<a class="navbar-brand" href="#">BookStore</a>
		</div>

		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<li><a href="allUsersPro"><i
							class="fa fa-user fa-fw"></i> Users</a></li>
					<li><a href="allBooksPro"><i class="fa fa-book fa-fw"></i>
							Books</a></li>
					<li><a href="allOrdersPro"><i class="fa fa-reorder fa-fw"></i>
							Orders</a></li>
					<li><a href="allOrderitemsPro"><i
							class="fa fa-table fa-fw"></i> Orderitems</a></li>
					<li><a href="SalesStaticsPro" class="active"><i
							class="fa fa-table fa-fw"></i> Sales Statics</a></li>
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">SaleStatics</h1>
				</div>
			</div>
			
			
	<form method="post" action="SalesStaticsPro">
           <br>user id:<input name="userid" type="text" /></br>                        
           <br>book id:<input name="bookid" type="text" /></br>
           <input name="Submits" type="submit" value="sales" />
    </form>
    <div class="row">
		<div class="col-md-2 col-md-offset-5">
			<strong><mark>
				<h4>
					total:<%=amount%></h4>
					</mark></strong>
		</div>
	</div>
	<script src="<%=path%>/bookstore/js/jquery.min.js"></script>
	<script src="<%=path%>/bookstore/js/bootstrap.min.js"></script>
	<script src="<%=path%>/bookstore/js/jquery.dataTables.min.js"></script>
	<script src="<%=path%>/bookstore/js/dataTables.bootstrap.min.js"></script>
	<script src="<%=path%>/bookstore/js/bookstore.js"></script>
	<script src="<%=path%>/bookstore/js/bootbox.min.js"></script>

	<script src="<%=path%>/bookstore/js/user.js"></script>

	<script>
		$(document).ready(function() {
			$('#dataTables').DataTable({
				responsive : true
			});
		});
	</script>

</body>

</html>
