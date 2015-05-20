function editProductBacklog(id) {

	$.get("get/" + id, function(result) {

		BootstrapDialog.show({
			title : 'Edit Product Backlog',
			message : $(result),
			buttons : [ {
				label : 'Cancel',
				action : function(dialogRef) {

					resetDialog($('#productBacklogForm'));
					dialogRef.close();
				}
			}, {
				label : 'Save',
				cssClass : 'btn-primary',
				action : function(dialogRef) {

					$('#productBacklogForm').submit();
				}
			} ]
		});
	});
}
