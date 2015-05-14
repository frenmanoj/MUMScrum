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
	<div style="width: 95%; margin: 0 auto;">

		<%@ include file="../common/header.jsp"%>

		<h1>
			List Of User Stories for <b>${productBacklog.title}</b>
		</h1>

		<div id="userStoryDialog" style="display: none;">
			<%@ include file="userStoryForm.jsp"%>
		</div>

		<button class="btn btn-primary" onclick="addUserStory()">
			<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Add
			User Story
		</button>

		<br>
		<br>
		<table class="table table-condensed table-striped table-bordered">
			<thead>
				<tr>
					<th width="10%">S.N</th>
					<th width="20%">Title</th>
					<th width="30%">Description</th>
					<th width="15%">Estimated Hours</th>
					<th width="15%">Remaining Hours</th>
					<th width="10%"></th>
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
						<td><nobr>
								<button class="btn btn-primary"
									onclick="editUserStory(${userStory.id});">

									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
									Edit
								</button>

								<a class="btn btn-primary"
									onclick="return confirm('Are you sure you want to delete this user story?');"
									href="delete/${userStory.id}"> <span
									class="glyphicon glyphicon-remove" aria-hidden="true"></span>
									Delete
								</a>

							</nobr></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

	<!--  It is advised to put the <script> tags at the end of the document body so they don't block rendering of the page -->
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/lib/jquery-1.10.2.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/lib/jquery-ui-1.10.4.custom.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/lib/jquery.ui.datepicker.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/js-for-listUserStories.js"/>'></script>
</body>
</html>