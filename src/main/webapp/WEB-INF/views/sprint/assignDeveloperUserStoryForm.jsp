<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:url var="actionUrl" value="UserStories/save" />

<form:form id="assignDeveloperUserStoryForm" commandName="userStory"
	method="post" action="${actionUrl }" class="form-horizontal">

	<fieldset>
		<legend></legend>
		<div>
			<div class="col-md-12">
				<div class="col-md-1">
					<label>Title:</label>
				</div>
				<div class="col-md-11">
					<b>${userStory.title} </b>
				</div>
			</div>

			<div class="col-md-12">
				<div class="col-md-2">
					<label>Description:</label>
				</div>
				<div class="col-md-10">
					<i>${userStory.description} </i>
				</div>
			</div>

			<div class="col-md-12">
				<div class="form-group">
					<label class="control-label">Developer</label> <input
						id="developer" placeholder="Developer" class="form-control" />
				</div>
			</div>

			<form:input path="assignedDate" type="hidden" />
			<form:input path="completedDate" type="hidden" />
			<form:input path="createdDate" type="hidden" />

			<form:input path="id" type="hidden" />
		</div>
	</fieldset>
</form:form>