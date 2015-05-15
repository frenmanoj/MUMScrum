<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<form:form class="form-horizontal" action="save" method="post"
	commandName="productBacklog">

	<fieldset>
		<legend>Add Product Backlog</legend>

		<div class="col-md-3">
			<label class="control-label" for="title">Title</label> <br>
			<form:input name="title" path="title"
				placeholder="Product Backlog Title" class="form-control"
				required="true" type="text" />
		</div>

		<div class="col-md-3">
			<label for="description" class="control-label">Description</label> <br>
			<form:input class="form-control" type="text" required="true"
				path="description" placeholder="Description" />
		</div>

		<form:input path="id" type="hidden" />

		<div class="col-sm-6" style="margin-top: 27px;">
			<input type="submit" name="save" value="Save" class="btn btn-primary" />
		</div>
	</fieldset>
</form:form>
