<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>List Of User Stories</title>

<link rel="stylesheet"
	href='<c:url value="/web-resources/css/pure-0.4.2.css"/>'>

<link rel="stylesheet"
	href='<c:url value="/web-resources/css/font-awesome-4.0.3/css/font-awesome.css"/>'>

<link rel="stylesheet"
	href='<c:url value="/web-resources/css/jquery-ui-1.10.4.custom.css"/>'>

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

			List Of User Stories for <b>${release.name}</b> <a
				class="btn btn-primary pull-right" href="addUserStories">Add User Stories</a>
		</p>

		<table class="table table-condensed table-striped table-bordered">
			<thead>
				<tr>
					<th width="5%">S.N</th>
					<th width="20%">Title</th>
					<th width="30%">Description</th>
					<th width="15%">Estimated Hours</th>
					<th width="15%">Remaining Hours</th>
					<th width="15%">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userStories}" var="userStory"
					varStatus="loopCounter">
					<tr>
						<td><c:out value="${loopCounter.count}" /></td>
						<td>${userStory.title}</td>
						<td>${userStory.description}</td>
						<td>${userStory.estimatedHours}</td>
						<td>${userStory.remainingHours}</td>
						<td><a class="btn btn-primary btn-sm"
							onclick="return confirm('Are you sure you want to remove this user story from the release?');"
							href="delete/${userStory.id}"> <span
								class="glyphicon glyphicon-remove" aria-hidden="true"></span>
								Delete
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

	<script type="text/javascript">
		$(document).ready(function() {

			$('.table').dataTable();
		});
	</script>

	<!--  It is advised to put the <script> tags at the end of the document body so they don't block rendering of the page -->
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/lib/jquery-1.10.2.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/lib/jquery-ui-1.10.4.custom.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/lib/jquery.ui.datepicker.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/js-for-listUserStories.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/common.js"/>'></script>
</body>
</html>