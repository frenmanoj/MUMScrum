function addSprint() {
	$('#sprintDialog').dialog("option", "title", 'Add Sprint');
	$('#sprintDialog').dialog('open');
}

function editSprint(id) {

	$.get("get/" + id, function(result) {

		$("#sprintDialog").html(result);

		$('#sprintDialog').dialog("option", "title",
				'Edit Sprint');

		$("#sprintDialog").dialog('open');

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

	$('#sprintDialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 460,
		buttons : {
			"Save" : function() {
				$('#sprintForm').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#sprintForm'));

			$(this).dialog('close');
		}
	});

	initializeDatePicker();
});
