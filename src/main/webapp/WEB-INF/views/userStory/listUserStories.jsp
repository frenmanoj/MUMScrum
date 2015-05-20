<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>List Of User Stories</title>
</head>

<body>

		<%@ include file="../common/header.jsp"%>

		<div id="userStoryDialog"  style="display: none; padding-left: 30px; padding-right:30px">
			<%@ include file="userStoryForm.jsp"%>
		</div>
	
		<br>
		<div style="margin: 0 auto;">
	
		<p style="font-size: 21px; color: #333;">
			
			List Of User Stories
		</p>
		<table class="table table-condensed table-striped table-bordered" id="user-story-table">
			<thead>
				<tr>
					<th width="5%">S.N</th>
					<th width="20%">Title</th>
					<th width="30%">Description</th>
					<th width="15%">Estimated Hours</th>
					<th width="15%">Remaining Hours</th>
					<th width="20%">Product Backlog</th>
					<th width="20%">Release Backlog</th>
					<th width="20%">Sprint</th>
					<th width="15%">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userStoryList}" var="userStory"
					varStatus="loopCounter">
					<tr>
						<td><c:out value="${loopCounter.count}" /></td>
						<td>${userStory.title}</td>
						<td>${userStory.description}</td>
						<td>${userStory.estimatedDevHours}</td>
						<td>${userStory.remainingDevHours}</td>
						<td>${userStory.productBacklog.getTitle()}</td>
						<td>${userStory.releaseBacklog.getName()}</td>
						<td>${userStory.sprint.getTitle()}</td>
						<td><nobr>
								<button class="btn btn-primary btn-sm"
									onclick="editUserStory(${userStory.id});">

									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
									 Edit
								</button>

															</nobr></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	
	<%@ include file="../common/footer.jsp"%>


	<script type="text/javascript">
	
	$(document).ready(function(){
		
		
		 $('#user-story-table').dataTable();
	});

	</script>

	<script type="text/javascript"
		src='<c:url value="/web-resources/js/js-for-listUserStories.js"/>'></script>
</body>
</html>