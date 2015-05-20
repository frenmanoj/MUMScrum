$(document).ready(function() {

	searchBoxFilter();
});

function searchBoxFilter() {

	$('.search-box').keyup(function() {

		$rows = $(this).closest("div").find('table:first tbody tr');

		val = $.trim($(this).val()).replace(/ +/g, ' ').toLowerCase();

		$rows.show().filter(function() {
			var text = $(this).text().replace(/\s+/g, ' ').toLowerCase();
			return !~text.indexOf(val);
		}).hide();
	});

}

function formatMyDate(dateField, length, inputFormat, outputFormat) {

	var dateString = dateField.val();

	if (dateString) {

		if (dateString.length > length) {

			dateString = dateString.substring(0, length);
		}

		date = jQuery.datepicker.parseDate(inputFormat, dateString);

		dateString = jQuery.datepicker.formatDate(outputFormat, date);

		dateField.val(dateString);
	}
}

function confirmDelete(anchorElem, message) {

	$(anchorElem).click(function(e) {

		e.preventDefault();

		BootstrapDialog.confirm({
			title : 'Confirmation!',
			message : '' + message,
			closable : true,
			btnOKClass : 'btn-primary',
			callback : function(result) {

				
				if (result) {
					
					window.location.href = $(anchorElem).attr('href');
				}
				
			}
		});
	});
}

function showAlert(message, title) {

	if (!title) {

		title = "Message";
	}

	BootstrapDialog.show({
		title : title,
		message : message,
		buttons : [ {
			label : 'Ok',
			action : function(dialog) {
				dialog.close();
			}
		} ]
	});

}

function resetDialog(form) {

	form.find("input").val("");
}