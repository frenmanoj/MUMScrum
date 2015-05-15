<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:url var="actionUrl" value="UserStories/save" />

<form:form id="userStoryForm" commandName="userStory" method="post"
	action="${actionUrl }" class="form-horizontal">

	<fieldset>
		<legend></legend>

		<div class="form-group">
			<label class="control-label" for="title">Title</label>
			<form:input id="title" path="title" placeholder="Title" class="form-control" />
		</div>
		<div class="form-group">
			<label class="control-label" for="description">Code</label>
			<form:input id="description" path="description"
				placeholder="Description" class="form-control" />
		</div>

		<div class="form-group">
			<label class="control-label" for="estimatedHours">Estimated Hours</label>
			<form:input id="estimatedHours" path="estimatedHours" class="form-control" />
		</div>

		<div class="form-group">
			<label class="control-label" for="remainingHours">Remaining Hours</label>
			<form:input id="remainingHours" path="remainingHours" class="form-control"/>
		</div>
		
		<form:input path="assignedDate" type="hidden"/>
		<form:input path="completedDate" type="hidden"/>
		<form:input path="createdDate" type="hidden"/>

		<form:input path="id" type="hidden" />
	</fieldset>
</form:form>