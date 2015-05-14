function addUserStory() {
	$('#userStoryDialog').dialog("option", "title", 'Add UserStory');
	$('#userStoryDialog').dialog('open');
}

function editUserStory(id) {

	$.get("get/" + id, function(result) {

		$("#userStoryDialog").html(result);

		$('#userStoryDialog').dialog("option", "title", 'Edit UserStory');

		$("#userStoryDialog").dialog('open');

		initializeDatePicker();
	});
}

function initializeDatePicker() {
	$(".datepicker").datepicker({
		dateFormat : "yy-mm-dd",
		changeMonth : true,
		changeYear : true,
		showButtonPanel : true
	});
}

function resetDialog(form) {

	form.find("input").val("");
}

$(document).ready(function() {

	$('#userStoryDialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 460,
		buttons : {
			"Save" : function() {
				$('#userStoryForm').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#userStoryForm'));

			$(this).dialog('close');
		}
	});

	initializeDatePicker();
});
