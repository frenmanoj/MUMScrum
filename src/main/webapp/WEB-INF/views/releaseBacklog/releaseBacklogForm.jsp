<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:url var="actionUrl" value="save" />

<form:form id="releaseBacklogForm" commandName="releaseBacklog"
	method="post" action="${actionUrl }" class="form-horizontal">

	<fieldset>
		<legend></legend>

		<div class="form-group">
			<label class="control-label" for="title">Name</label>
			
			<form:input name="name" path="name" placeholder="Input Release Backlog  Name" class="form-control"
				required="true" />
		</div>
		
		<div class="form-group">
			<label class="control-label" for="description">Description</label>
			<form:input name="description" path="description"
				placeholder="Input Description" class="form-control" required="true" />
		</div>
		
		<!-- Start Date -->
			<div class="form-group">
				<label for="dtp_input1" class="control-label">Start Date </label> <br>
				<div class="input-group date form_date1" data-date=""
					data-date-format="dd mm yyyy" data-link-field="dtp_input1"
					data-link-format="yyyy-mm-dd">
					<form:input id="startDate" class="form-control" path="startDate" type="text" />
					<span class="input-group-addon "><span
						class="glyphicon glyphicon-calendar"></span> </span>
				</div>
			</div>

			<!-- End Date -->
			<div class="form-group">
				<label for="dtp_input2" class=" control-label">End Date </label> <br>
				<div class="input-group date form_date2" data-date=""
					data-date-format="dd mm yyyy" data-link-field="dtp_input2"
					data-link-format="dd-mm-yyyy">
					<form:input id="endDate" class="form-control" type="text" path="endDate"/>
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-calendar"></span> </span>
				</div>
				
			</div>
		
		<form:input path="id" type="hidden" />
	</fieldset>
</form:form>

<script type="text/javascript"
		src='<c:url value="/web-resources/js/common.js"/>'></script>