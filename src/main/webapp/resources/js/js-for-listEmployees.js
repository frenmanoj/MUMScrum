function editEmployee(id) {

	$.get("get/" + id, function(result) {

		BootstrapDialog.show({
			title : 'Edit Employee',
			message : $(result),
			buttons : [ {
				label : 'Cancel',
				action : function(dialogRef) {

					resetDialog($('#employeeForm'));
					dialogRef.close();
				}
			}, {
				label : 'Save',
				cssClass : 'btn-primary',
				action : function(dialogRef) {

					$('#employeeForm').submit();
				}
			} ]
		});

	});
}

