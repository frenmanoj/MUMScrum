<c:url var="actionUrl" value="save" />
<form:form id="listReleaseForm" commandName="releaseBacklog"
	method="post" action="${actionUrl }" class="form-horizontal">
	
	<fieldset>
		<!-- Form Name -->
		<legend>
			Add Release Backlog for <b>${productBacklog.title}</b>
		</legend>

		<c:if test="${not empty message}">

			<div id="message-box" class="alert alert-success" role="alert"
				style="display: none">${message}</div>

		</c:if>
		<!-- Text input-->
		<div class="col-md-3">
			<label class="control-label" for="name">Name</label> <br>
			<form:input id="name" path="name" placeholder="Input release name"
				class="form-control" required="true" type="text" />
		</div>

		<!-- Text input-->
		<div class="col-md-3">
			<label class="control-label" for="name">Description</label> <br>
			<form:input id="description" path="description"
				placeholder="Input release name" class="form-control"
				required="true" type="text" />
		</div>
		<!-- Start Date -->
		<div class="col-md-2">
			<label for="dtp_input1" class="control-label">Start Date </label> <br>
			<div class="input-group date form_date1" data-date=""
				data-date-format="dd MM yyyy" data-link-field="dtp_input1"
				data-link-format="yyyy-mm-dd">
				<form:input class="form-control" path="startDate" type="text"
					readonly="true" />
				<span class="input-group-addon "><span
					class="glyphicon glyphicon-calendar"></span> </span>
			</div>
		</div>

		<!-- End Date -->
		<div class="col-sm-2">
			<label for="dtp_input2" class=" control-label">End Date </label> <br>
			<div class="input-group date form_date2" data-date=""
				data-date-format="MM dd yyyy" data-link-field="dtp_input2"
				data-link-format="MM-dd-yyyy">
				<form:input class="form-control" type="text" path="endDate"
					readonly="true" />
				<span class="input-group-addon"><span
					class="glyphicon glyphicon-calendar"></span> </span>
			</div>

		</div>


		<!-- Button -->
		<div class="col-sm-2" style="margin-top: 27px;">

			<button id="saveBtn" style="width: 8em" name="save"
				class="btn btn-primary">Save</button>
		</div>
	</fieldset>
</form:form>