<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>List Of User Stories</title>

<link rel="stylesheet"
	href='<c:url value="/web-resources/bootstrap3-dialog/css/bootstrap-dialog.css"/>'>

<style type="text/css">
th {
	text-align: left
}
</style>


</head>

<body>

	<%@ include file="../common/header.jsp"%>

	<div style="margin: 0 auto;">

		<p style="font-size: 21px; color: #333;">

			List Of Available User Stories for the sprint: <b>${sprint.title}</b>
		</p>

		<form action="addUserStories" method="post" onsubmit="return isRowSelected();">

			<table class="table table-condensed table-striped table-bordered"
				id="user-stories-table">
				<thead>
					<tr>
						<th width="5%">S.N</th>
						<th width="20%">Title</th>
						<th width="30%">Description</th>
						<th width="15%">Estimated Hours</th>
						<th width="15%">Remaining Hours</th>
						<th width="15%">Select All <br>
							<input type="checkbox" id="select-all"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userStories}" var="userStory"
						varStatus="loopCounter">
						<tr>
							<td><c:out value="${loopCounter.count}" /></td>
							<td>${userStory.title}</td>
							<td>${userStory.description}</td>
							<td>${userStory.estimatedDevHours}</td>
							<td>${userStory.remainingDevHours}</td>
							<td><input type="checkbox" name="userStory-ids"
								value="${userStory.id}" id="row-${userStory.id}"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /> <input type="submit"
				value="Add to Sprint" class="btn btn-primary" />
		</form>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {

			$('#user-stories-table').dataTable({
				"aoColumnDefs" : [ {
					'bSortable' : false,
					'aTargets' : [ 5 ]
				} ]
			});

			$('#select-all').click(function() {
				var $this = $(this);

				if ($this.is(':checked')) {
					$("[name='userStory-ids']").prop("checked", true);
				} else {
					$("[name='userStory-ids']").prop("checked", false);
				}
			});
		});

		function isRowSelected() {

			var atLeastOneIsChecked = $('#user-stories-table tbody :checkbox:checked').length > 0;

			if (!atLeastOneIsChecked) {
				alert("No user stories selected to assign!");
			}

			return atLeastOneIsChecked;
		}
	</script>

	<!--  It is advised to put the <script> tags at the end of the document body so they don't block rendering of the page -->
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/lib/jquery-ui-1.10.4.custom.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/lib/jquery.ui.datepicker.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/web-resources/bootstrap3-dialog/js/bootstrap-dialog.js"/>'></script>

	<script type="text/javascript"
		src='<c:url value="/web-resources/js/common.js"/>'></script>
</body>
</html>