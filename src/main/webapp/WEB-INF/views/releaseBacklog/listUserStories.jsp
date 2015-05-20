<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>List Of User Stories</title>

</head>

<body>

	<%@ include file="../common/header.jsp"%>

	<div style="margin: 0 auto;">

		<a class="btn btn-primary " href="addUserStories">Add User Stories</a>

		<p style="font-size: 21px; color: #333; margin-bottom: -5px; margin-top: 15px;">

			List Of User Stories for the release: <b>${release.name}</b>

		</p>

		<table class="table table-condensed table-striped table-bordered" id="user-stories-table">
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
						<td>${userStory.estimatedDevHours}</td>
						<td>${userStory.remainingDevHours}</td>
						<td><a id="delete-confirm" class="btn btn-primary btn-sm"
							href="delete/${userStory.id}"> <span
								class="glyphicon glyphicon-remove" aria-hidden="true"></span>
								Remove
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

	<script type="text/javascript">
		$(document).ready(function() {

			$('#user-stories-table').dataTable();
			
			confirmDelete( $("#delete-confirm"), "Are you sure you want to unassign this user story from the release?");
		});
	</script>

	<!--  It is advised to put the <script> tags at the end of the document body so they don't block rendering of the page -->
</body>
</html>