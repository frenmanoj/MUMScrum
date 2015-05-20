<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:url var="actionUrl" value="UserStories/save" />

<form:form id="userStoryForm" commandName="userStory" method="post"
	action="${actionUrl }" class="form-horizontal">

	<fieldset>
		<legend></legend>
		<div class="col-md-12">
			<div class="form-group">
				<label class="control-label" for="title">Title</label>
				<form:input id="title" path="title" placeholder="Title"
					class="form-control" />
			</div>
			<div class="form-group">
				<label class="control-label" for="description">Description</label>
				<form:input id="description" path="description"
					placeholder="Description" class="form-control" />
			</div>

			<div class="form-group">
				<label class="control-label" for="estimatedDevHours">Estimated
					Hours</label>
				<form:input id="estimatedDevHours" path="estimatedDevHours"
					class="form-control" />
			</div>

			<div class="form-group">
				<label class="control-label" for="remainingDevHours">Remaining
					Hours</label>
				<form:input id="remainingDevHours" path="remainingDevHours"
					class="form-control" />
			</div>

			<form:input path="assignedDate" type="hidden" />
			<form:input path="completedDate" type="hidden" />
			<form:input path="createdDate" type="hidden" />

			<form:input path="id" type="hidden" />
		</div>
	</fieldset>
</form:form>