$(function() {

	$("#save")
			.click(
					function(e) {

						var amount = $("input[name='amount']").val();
						var dataset = e.currentTarget.dataset;
						var orderid = dataset.orderid;
						var bookid = dataset.bookid;
						console.log(orderid, bookid, amount);
						var id = dataset.id;
						if (id != "") { // Edit
							jQuery
									.ajax({
										url : 'updateOrderitemPro',
										processData : true,
										dataType : "text",
										data : {
											id : id,
											orderid : orderid,
											bookid : bookid,
											amount : amount
										},
										success : function(data) {
											console.log(id);
											bootbox
													.alert({
														message : 'Modify Successfully! '
																+ 'PS: No change if foreign key does not exist!',
														callback : function() {
															location.reload();
														}
													});
										}
									});
						} else { // Add
							jQuery
									.ajax({
										url : 'addOrderitemPro',
										processData : true,
										dataType : "text",
										data : {
											orderid : orderid,
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
						}

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
									message : 'Sure to remove item from your cart?',
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

		console.log(id, dataset.orderid, dataset.bookid);
		$("input[name='amount']").val(dataset.amount);

		$("#save").attr({
			"data-orderid" : dataset.orderid,
			"data-bookid" : dataset.bookid,
			"data-id" : dataset.id
		});
		$('#modal').modal('show');
	});
	
	$(".buy")
	.click(
			function(e) {
				bootbox
						.confirm({
							buttons : {
								confirm : {
									label : 'BUY'
								},
								cancel : {
									label : 'Cancel'
								}
							},
							message : 'Sure to buy items from your cart?',
							callback : function(result) {
								if (result) {

									var dataset = e.currentTarget.dataset;
									var id = dataset.id;
									jQuery.ajax({
										url : 'buyOrderPro',
										processData : true,
										dataType : "text",
										data : {
											id : id											
										},
										success : function(data) {
											console.log(id);
											bootbox.alert({
												message : 'Buy Successfully! '
													+ 'PS: Assumed you have payed the bill!',
											    callback : function() {
													location.reload();
												}
											});
										}
									});

								}
							}
						});
			});
});
