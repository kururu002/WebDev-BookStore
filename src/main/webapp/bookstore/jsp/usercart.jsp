<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Book"%>
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
	    if ((Integer)session.getAttribute("uid") ==null) {
					response.sendRedirect("index.jsp");}
	%>
	<%
	    ArrayList<Book> bookList = new ArrayList<Book>();
				if (request.getAttribute("books") != null) {
			bookList = (ArrayList<Book>) request.getAttribute("books");
				}
				ArrayList<String> IMGList = new ArrayList<String>();
				if(request.getAttribute("IMGs") != null) {
					IMGList = (ArrayList<String>) request.getAttribute("IMGs");
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
					<li><a href="UserCart" class="active"><i
							class="fa fa-book fa-fw"></i> Shopping</a></li>
					<li><a href="MyCartPro"><i
							class="fa fa-shopping-cart fa-fw"></i> Mycart</a></li>
					<li><a href="MyHistoryPro"><i class="fa fa-history fa-fw"></i>
							MyHistory</a></li>
					<li><a href="UserCenterPro"><i class="fa fa-user fa-fw"></i>
							UserCenter</a></li>
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Books</h1>
				</div>
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">

						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="dataTable_wrapper">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables">
									<thead>
										<tr>
											<th>ID</th>
											<th>IMG</th>
											<th>Title</th>
											<th>Author</th>
											<th>Price</th>
											<th>Publisher</th>
											<th>Date</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<%
										    for (int i = 0; i < bookList.size(); i++) {String img=IMGList.get(i);
																														Book book = bookList.get(i);
										%>
										<tr>
											<td><%=book.getId()%></td>
											<td><img alt="img"
												src="data:image/jpeg;base64,<%=(String)img%>" /></td>
											<td><%=book.getTitle()%></td>
											<td><%=book.getAuthor()%></td>
											<td><%=book.getPrice()%></td>
											<td><%=book.getPublisher()%></td>
											<td><%=book.getDate()%></td>
											<td>
												<button class="btn btn-default lookup" type="button"
													data-bookid="<%=book.getId()%>">
													<i class="fa fa-search"></i>
												</button>
												<button class="btn btn-default addcart" type="button"
													data-bookid="<%=book.getId()%>"
													data-userid="<%=(Integer)session.getAttribute("uid")%>">
													<i class="fa fa-plus"></i>
												</button>
											</td>
										</tr>
										<%
										    }
										%>
									</tbody>
								</table>
							</div>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->

	<div class="modal fade" id="modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="modalTitle"></h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-lg-12">
							<form role="form">
								<div class="form-group">
									<label>Amount</label> <input class="form-control" type="number"
										name="amount">
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" id="save">Save</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="modal2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="modalTitle"></h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-lg-12">
							<form role="form">
								<div class="form-group">
									<label>Infos</label> <input class="form-control" type="number"
										name="amount">
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" id="save">Save</button>
				</div>
			</div>
		</div>
	</div>
	<script src="<%=path%>/bookstore/js/jquery.min.js"></script>
	<script src="<%=path%>/bookstore/js/bootstrap.min.js"></script>
	<script src="<%=path%>/bookstore/js/jquery.dataTables.min.js"></script>
	<script src="<%=path%>/bookstore/js/dataTables.bootstrap.min.js"></script>
	<script src="<%=path%>/bookstore/js/bookstore.js"></script>
	<script src="<%=path%>/bookstore/js/bootbox.min.js"></script>

	<script src="<%=path%>/bookstore/js/usercart.js"></script>

	<script>
		$(document).ready(function() {
			$('#dataTables').DataTable({
				responsive : true
			});
		});
		$(".lookup").click(function(e) {

			var dataset = e.currentTarget.dataset;
			var thisId = dataset.bookid;
			console.log(thisId);
			var result =$.getJSON( "/BookStore/bookInfo?bookid="+thisId, function() {
				  console.log( "success" );
			})
			  .done(function() {
			    console.log( "second success" );
			  })
			  .fail(function() {
			    console.log( "error" );
			  })
			  .always(function() {
			    console.log( "complete" );
			  });
		console.log(result);
		});
	</script>

</body>

</html>


