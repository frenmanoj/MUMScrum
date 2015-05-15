$(document).ready(function() {

	searchBoxFilter();
});

function searchBoxFilter() {

	
	$('.search-box').keyup(function() {
		
		$rows = $(this).closest( "div" ).find('table:first tbody tr');

		val = $.trim($(this).val()).replace(/ +/g, ' ').toLowerCase();

		$rows.show().filter(function() {
			var text = $(this).text().replace(/\s+/g, ' ').toLowerCase();
			return !~text.indexOf(val);
		}).hide();
	});

}