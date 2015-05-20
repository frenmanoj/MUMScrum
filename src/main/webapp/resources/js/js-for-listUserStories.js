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

function assignDeveloper(id) {

	$.get( id + "/assignDeveloper", function(result) {

		BootstrapDialog.show({
			title : 'Assign Developer to User Story',
			message : $(result),
			buttons : [ {
				label : 'Cancel',
				action : function(dialogRef) {

					resetDialog($('#assignDeveloperUserStoryForm'));
					dialogRef.close();
				}
			}, {
				label : 'Save',
				cssClass : 'btn-primary',
				action : function(dialogRef) {

					$('#assignDeveloperUserStoryForm').submit();
				}
			} ]
		});
	});
}
