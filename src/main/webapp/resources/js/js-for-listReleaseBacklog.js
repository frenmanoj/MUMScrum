function addProductBacklog() {
	$('#releaseBacklogDialog').dialog("option", "title", 'Add ReleaseBacklog');
	$('#releaseBacklogDialog').dialog('open');
}

function editReleaseBacklog(id) {

	$.get("get/" + id, function(result) {

		$("#releaseBacklogDialog").html(result);

		$('#releaseBacklogDialog').dialog("option", "title",
				'Edit ReleaseBacklog');

		$("#releaseBacklogDialog").dialog('open');

		initializeDatePicker();
	});
}


function initializeDatePicker() {
	$('.form_date1').datetimepicker({

		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		minView : 2,
		forceParse : 0,
		format : 'mm/dd/yyyy'
	});


$('.form_date2').datetimepicker({

		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		minView : 2,
		forceParse : 0,
		format : 'mm/dd/yyyy'
	});
}



function resetDialog(form) {

	form.find("input").val("");
}

$(document).ready(function() {

	$('#releaseBacklogDialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 460,
		buttons : {
			"Save" : function() {
				$('#releaseBacklogForm').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#releaseBacklogForm'));

			$(this).dialog('close');
		}
	});

	initializeDatePicker();
});
