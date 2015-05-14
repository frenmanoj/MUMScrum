<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:url var="actionUrl" value="save" />

<form:form id="productBacklogForm" commandName="productBacklog"
	method="post" action="${actionUrl }"
	class="pure-form pure-form-aligned">

	<fieldset>
		<legend></legend>

		<div class="pure-control-group">
			<label for="name">Title</label>
			<form:input path="title" placeholder="ProductBacklog Name" />
		</div>
		<div class="pure-control-group">
			<label for="code">Code</label>
			<form:input id="merocode" path="description"
				placeholder="Description" />
		</div>

		<form:input path="id" type="hidden" />
	</fieldset>
</form:form>