$(function() {

	$("#save")
			.click(
					function(e) {
						var dataset = e.currentTarget.dataset;
						var userid = dataset.userid;
						var bookid = dataset.bookid;
						var amount = $("input[name='amount']").val();
						console.log(userid, bookid, amount);

						// var id = dataset.id;

						/*
						 * if (id != "") { // Edit jQuery.ajax({ url :
						 * 'updateOrderitemPro', processData : true, dataType :
						 * "text", data : { id : id, orderid : orderid, bookid :
						 * bookid, amount : amount }, success : function(data) {
						 * console.log(id); bootbox.alert({ message : 'Modify
						 * Successfully! ' + 'PS: No change if foreign key does
						 * not exist!', callback : function() {
						 * location.reload(); } }); } }); } else {
						 */// Add
						jQuery
								.ajax({
									url : 'AddCartPro',
									processData : true,
									dataType : "text",
									data : {
										userid : userid,
										bookid : bookid,
										amount : amount
									},
									success : function(data) {
										bootbox
												.alert({
													message : 'Add Successfully! '
															+ 'PS: No change if foreign key does not exist!',
													callback : function() {
														location.reload();
													}
												});
									}
								})
						// }

						$('#modal').modal('hide');
					});

	$(".delete")
			.click(
					function(e) {
						bootbox
								.confirm({
									buttons : {
										confirm : {
											label : 'Delete'
										},
										cancel : {
											label : 'Cancel'
										}
									},
									message : 'Sure to delete?',
									callback : function(result) {
										if (result) {

											var dataset = e.currentTarget.dataset;
											var id = dataset.id;
											jQuery
													.ajax({
														url : 'deleteOrderitemPro',
														processData : true,
														dataType : "text",
														data : {
															id : id
														},
														success : function(data) {
															console.log(id);
															bootbox
																	.alert({
																		message : 'Delete Successfully! '
																				+ 'PS: No change if foreign key does not exist!',
																		callback : function() {
																			location
																					.reload();
																		}
																	});
														}
													});

										}
									}
								});
					});

	$("#add").click(function(e) {
		$('#modalTitle').html("Add");

		$("input[name='title']").val("");
		$("input[name='author']").val("");
		$("input[name='price']").val("");
		$("input[name='publisher']").val("");
		$("input[name='date']").val("");
		$("input[name='stock']").val("");

		$("#save").attr("data-id", "");
		$('#modal').modal('show');
	});

	$(".edit").click(function(e) {
		$('#modalTitle').html("Edit");
		var dataset = e.currentTarget.dataset;
		var id = dataset.id;
		console.log(id);

		$("input[name='title']").val(dataset.title);
		$("input[name='author']").val(dataset.author);
		$("input[name='price']").val(dataset.price);
		$("input[name='publisher']").val(dataset.publisher);
		$("input[name='date']").val(dataset.date);
		$("input[name='stock']").val(dataset.stock);

		$("#save").attr("data-id", dataset.id);
		$('#modal').modal('show');
	});
	$(".addcart").click(function(e) {
		$('#modalTitle').html("AddCart");
		var dataset = e.currentTarget.dataset;
		console.log(dataset.userid, dataset.bookid);
		$("input[name='amount']").val("");
		$("#save").attr({
			"data-userid" : dataset.userid,
			"data-bookid" : dataset.bookid
		});
		$('#modal').modal('show');

	});
	
});


//		
//
// var dataset = e.currentTarget.dataset;
// var bookid = dataset.bookid;
//
// jQuery.ajax({
// type : 'post',
// url : 'GetBookPro',
// dataType : "json",
// data : {
// bookid : bookid
// },
// success : console.log(result)
// });
//
// });
// function show(Request) {
// var d = Request.responseText.evalJSON();
// //测试result是否从服务器端返回给客户端
// console.log(d);
// //解析json对象

// }

