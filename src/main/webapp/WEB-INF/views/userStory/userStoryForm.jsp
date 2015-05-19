<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<form:form id="userStoryForm" commandName="userStory" method="post"
	action="save" class="form-horizontal">

	<fieldset>
		<legend></legend>

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

		<form:input path="id" type="hidden" />
	</fieldset>
</form:form>