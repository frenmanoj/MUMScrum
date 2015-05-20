function editUserStory(id) {

	$.get("get/" + id, function(result) {

		BootstrapDialog.show({
			title : 'Edit User Story',
			message : $(result),
			buttons : [ {
				label : 'Cancel',
				action : function(dialogRef) {

					resetDialog($('#userStoryForm'));
					dialogRef.close();
				}
			}, {
				label : 'Save',
				cssClass : 'btn-primary',
				action : function(dialogRef) {

					$('#userStoryForm').submit();
				}
			} ]
		});
	});
}
