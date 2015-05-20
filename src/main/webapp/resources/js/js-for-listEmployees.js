
function editEmployee(id) {

	$.get("get/" + id, function(result) {

		BootstrapDialog.show({
			title : 'Edit Employee',
			message : $(result),
			buttons : [ {
				label : 'Save',
				action : function(dialogRef) {

					$('#employeeForm').submit();
				}
			}, {
				label : 'Cancel',
				action : function(dialogRef) {

					resetDialog($('#employeeForm'));
					dialogRef.close();
				}
			} ]
		});

	});
}

function resetDialog(form) {

	form.find("input").val("");
}