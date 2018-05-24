<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
    String path = request.getContextPath();
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%
    if ((Integer) session.getAttribute("uid") == null) {
        response.sendRedirect("index.jsp");
    }
	
%>
<title>User Center</title>
<link href="<%=path%>/bookstore/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=path%>/bookstore/css/dataTables.bootstrap.css"
	rel="stylesheet">
<link href="<%=path%>/bookstore/css/dataTables.responsive.css"
	rel="stylesheet">
<link href="<%=path%>/bookstore/css/bookstore.css" rel="stylesheet">
<link href="<%=path%>/bookstore/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="<%=path%>/bookstore/css/jquery.fileupload.css">
<link rel="stylesheet" href="<%=path%>/bookstore/css/style.css">
</head>
<body>
<%String myphoto=new String();
String des=new String();
if(request.getAttribute("myphoto")!=null){
   myphoto=(String)request.getAttribute("myphoto");
 
}
if(request.getAttribute("mydes")!=null){
    des=(String)request.getAttribute("mydes");
  
 }
%>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">

		<div class="navbar-header">
			<a class="navbar-brand" href="#">BookStore</a>
		</div>
		<td height="50">
			<div style="text-align: right;" font-size:9px>
				<button onclick="javascript:location.href='logout.jsp'">

					<i class="fa fa-sign-out"></i>
				</button>
			</div>
		</td>
		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<li><a href="UserCart"><i class="fa fa-book fa-fw"></i>
							Shopping</a></li>
					<li><a href="MyCartPro" ><i
							class="fa fa-shopping-cart fa-fw"></i> Mycart</a></li>
					<li><a href="MyHistoryPro"><i class="fa fa-history fa-fw"></i>
							MyHistory</a></li>
					<li><a href="UserCenterPro" class="active"><i
							class="fa fa-user fa-fw"></i> UserCenter</a></li>
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">My Profile</h1>
				</div>
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default"></div>
					<form method="post" action="ChangePassword">
						Password:<input name="password" type="password" /> <br> <br>New
						password:<input name="newpassword" type="password" /> <br> <br>
						<input name="Submits" type="submit" value="Change password" />
					</form>
					My Photo
					<img alt="img" src="data:image/jpeg;base64,<%=myphoto%>"/>
					<br>
					My autograph
					<div><%=des %></div>
					<br>
					<br>
					<br>
					Update Profiles:
					<form action="UploadPro" method="post" enctype="multipart/form-data">
						<input type="text" name="description" /> 
						<input type="file" name="file" /> 
						<input type="submit" />
					</form>
					<!-- The global progress bar -->

				</div>
			</div>
		</div>
	</div>
</body>

<script src="<%=path%>/bookstore/js/jquery.min.js"></script>
<script src="<%=path%>/bookstore/js/bootstrap.min.js"></script>
<script src="<%=path%>/bookstore/js/jquery.dataTables.min.js"></script>
<script src="<%=path%>/bookstore/js/dataTables.bootstrap.min.js"></script>
<script src="<%=path%>/bookstore/js/bookstore.js"></script>
<script src="<%=path%>/bookstore/js/bootbox.min.js"></script>


</html>