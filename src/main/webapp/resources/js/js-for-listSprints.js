
function editSprint(id) {

	$.get("get/" + id, function(result) {

		BootstrapDialog.show({
			title : 'Edit Sprint',
			message : $(result),
			buttons : [ {
				label : 'Cancel',
				action : function(dialogRef) {

					resetDialog($('#sprintForm'));
					dialogRef.close();
				}
			}, {
				label : 'Save',
				cssClass : 'btn-primary',
				action : function(dialogRef) {

					$('#sprintForm').submit();
				}
			} ]
		});

	});
}
