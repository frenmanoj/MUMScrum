<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl" value="save" />

<form:form class="form-horizontal" action="${actionUrl }" method="post"
	commandName="userStory">

	<fieldset>
		<legend>Add User Story for <b>${productBacklog.title}</b></legend>

		<c:if test="${not empty message}">
		
		    <div id="message-box" class="alert alert-success" role="alert" style="display:none">${message}</div>
		
		</c:if>
		
		<div class="col-md-3">
			<label class="control-label" for="title">Title</label> <br>
			<form:input name="title" path="title"
				placeholder="User Story Title" class="form-control"
				required="true" type="text" />
		</div>

		<div class="col-md-3">
			<label for="description" class="control-label">Description</label> <br>
			<form:input class="form-control" type="text" required="true"
				path="description" placeholder="Description" />
		</div>
		
		<div class="col-md-2">
			<label for="estimatedHours" class="control-label">Estimated Hours</label> <br>
			<form:input class="form-control" type="text" required="true"
				path="estimatedHours" placeholder="" />
		</div>
		
		<div class="col-md-2">
			<label for=remainingHours class="control-label">Remaining Hours</label> <br>
			<form:input class="form-control" type="text" required="true"
				path="remainingHours" placeholder="" />
		</div>

		<form:input path="id" type="hidden" />

		<div class="col-sm-2" style="margin-top: 27px; ">
			<input type="submit" name="save" value="Save" class="btn btn-primary" style="width:7em;"/>
		</div>
	</fieldset>
</form:form>

<script>

$( document ).ready(function() {
    
	if ( $('#message-box') ) {
		
		$('#message-box').show(new function(){setTimeout(function(){ $('#message-box').slideUp() }, 4000);});

	}
});

</script>