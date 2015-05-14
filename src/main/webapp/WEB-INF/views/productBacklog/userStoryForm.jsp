<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:url var="actionUrl" value="UserStories/save" />

<form:form id="userStoryForm" commandName="userStory" method="post"
	action="${actionUrl }">

	<fieldset>
		<legend></legend>

		<div class="">
			<label for="title">Title</label>
			<form:input id="title" path="title" placeholder="Title" />
		</div>
		<div class="">
			<label for="description">Code</label>
			<form:input id="description" path="description"
				placeholder="Description" />
		</div>

		<div class="">
			<label for="estimatedHours">Estimated Hours</label>
			<form:input id="estimatedHours" path="estimatedHours" />
		</div>

		<div class="">
			<label for="remainingHours">Remaining Hours</label>
			<form:input id="remainingHours" path="remainingHours" />
		</div>
		
		<form:input path="assignedDate" type="hidden"/>
		<form:input path="completedDate" type="hidden"/>
		<form:input path="createdDate" type="hidden"/>

		<form:input path="id" type="hidden" />
	</fieldset>
</form:form>