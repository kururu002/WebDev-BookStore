$(function() {

	$("#save").click(function(e) {
		var username = $("input[name='username']").val();
		var password = $("input[name='password']").val();
		var role = $("input[name='role']").val();
		console.log(username, password, role);

		var dataset = e.currentTarget.dataset;
		var id = dataset.id;

		if (id != "") { // Edit
			jQuery.ajax({
				url : 'updateUserPro',
				processData : true,
				dataType : "text",
				data : {
					id : id,
					username : username,
					password : password,
					role : role
				},
				success : function(data) {
					console.log(id);
					bootbox.alert({
						message : '修改成功，注：若关联外键不存在，则不修改',
						callback : function() {
							location.reload();
						}
					});
				}
			});
		} else { // Add
			jQuery.ajax({
				url : 'addUserPro',
				processData : true,
				dataType : "text",
				data : {
					username : username,
					password : password,
					role : role
				},
				success : function(data) {
					bootbox.alert({
						message : '添加成功，注：若关联外键不存在，则不添加',
						callback : function() {
							location.reload();
						}
					});
				}
			})
		}

		$('#modal').modal('hide');
	});

	$(".delete").click(function(e) {
		bootbox.confirm({
			buttons : {
				confirm : {
					label : '删除'
				},
				cancel : {
					label : '取消'
				}
			},
			message : '确认删除？',
			callback : function(result) {
				if (result) {

					var dataset = e.currentTarget.dataset;
					var id = dataset.id;
					jQuery.ajax({
						url : 'deleteUserPro',
						processData : true,
						dataType : "text",
						data : {
							id : id
						},
						success : function(data) {
							console.log(id);
							bootbox.alert({
								message : '删除成功，注：若关联外键存在，则不删除',
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

	$("#add").click(function(e) {
		$('#modalTitle').html("Add");

		$("input[name='username']").val("");
		$("input[name='password']").val("");
		$("input[name='role']").val("");

		$("#save").attr("data-id", "");
		$('#modal').modal('show');
	});

	$(".edit").click(function(e) {
		$('#modalTitle').html("Edit");
		var dataset = e.currentTarget.dataset;
		var id = dataset.id;
		console.log(id);

		$("input[name='username']").val(dataset.username);
		$("input[name='password']").val(dataset.password);
		$("input[name='role']").val(dataset.role);

		$("#save").attr("data-id", dataset.id);
		$('#modal').modal('show');
	});

});