function addProductBacklog() {
	$('#productBacklogDialog').dialog("option", "title", 'Add ProductBacklog');
	$('#productBacklogDialog').dialog('open');
}

function editProductBacklog(id) {

	$.get("get/" + id, function(result) {

		$("#productBacklogDialog").html(result);

		$('#productBacklogDialog').dialog("option", "title",
				'Edit ProductBacklog');

		$("#productBacklogDialog").dialog('open');

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

	$('#productBacklogDialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 460,
		buttons : {
			"Save" : function() {
				$('#productBacklogForm').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#productBacklogForm'));

			$(this).dialog('close');
		}
	});

	initializeDatePicker();
});
