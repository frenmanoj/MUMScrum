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

		date = jQuery.datepicker.parseDate( inputFormat, dateString);

		dateString = jQuery.datepicker.formatDate( outputFormat, date);

		dateField.val(dateString);
	}
}