<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:url var="actionUrl" value="save" />

<form:form id="productBacklogForm" commandName="productBacklog"
	method="post" action="${actionUrl }" class="form-horizontal">

	<fieldset>
		<legend></legend>

		<div class="form-group">
			<label class="control-label" for="title">Title</label>

			<form:input name="title" path="title"
				placeholder="ProductBacklog Name" class="form-control"
				required="true" />
		</div>

		<div class="form-group">
			<label class="control-label" for="description">Code</label>
			<form:input name="description" path="description"
				placeholder="Description" class="form-control" required="true" />
		</div>
		<form:input path="id" type="hidden" />
	</fieldset>
</form:form>