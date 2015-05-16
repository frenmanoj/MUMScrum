<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>List Release Backlog</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>

	<%@ include file="../common/header.jsp"%>

<c:url var="actionUrl" value="save"/>
	<form:form id="listReleaseForm" commandName="releaseBacklog" method="post" action="${actionUrl }" class="form-horizontal">
		<fieldset>

			<!-- Form Name -->
			<legend>Add Release Backlog</legend>

			<c:if test="${not empty message}">
		
		    <div id="message-box" class="alert alert-success" role="alert" style="display:none">${message}</div>
		
		   </c:if>
			<!-- Text input-->
			<div class="col-md-3">
				<label class="control-label" for="name">Name</label> <br> 
				<form:input id="name"  path="name"  placeholder="Input release name" class="form-control"
				 required="true" type="text"/>
			</div>
			
			<!-- Text input-->
			<div class="col-md-3">
				<label class="control-label" for="name">Description</label> <br> 
				<form:input id="description"  path="description"  placeholder="Input release name" class="form-control"
				 required="true" type="text"/>
			</div>
			<!-- Start Date -->
			<div class="col-md-2">
				<label for="dtp_input1" class="control-label">Start Date </label> <br>
				<div class="input-group date form_date1" data-date=""
					data-date-format="dd MM yyyy" data-link-field="dtp_input1"
					data-link-format="yyyy-mm-dd">
					<form:input class="form-control" path="startDate" type="text"  readonly="true" />
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
					<form:input class="form-control" type="text" path="endDate" readonly="true" />
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-calendar"></span> </span>
				</div>
				
			</div>


			<!-- Button -->
			<div class="col-sm-2" style="margin-top:27px;">
			
				<button id="saveBtn" style="width: 8em" name="save"
					class="btn btn-primary">Save</button>
			</div>
		</fieldset>
	</form:form>
	
	<br/>
	
	<fieldset>
		<legend></legend>
	</fieldset>

	<br>
	<div style="margin: 0 auto;">

		<p style="font-size: 21px; color: #333;">List Of Release Backlogs</p>
		<table data-toggle="table" data-cache="false" data-height="100" class="table table-condensed table-striped table-bordered">
			<thead>
				<tr>
					<th width="5%">S.N</th>
					<th width="20%">Name</th>
					<th width="20%">Description</th>
					<th width="25%">StartDate</th>
					<th width="25%">EndtDate</th>
					<th width="5%" f>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${releaseBackloglist}" var="releaseBacklog"
					varStatus="loopCounter">
					<tr>
						<td><c:out value="${loopCounter.count}" /></td>
						<td><a href="${releaseBacklog.id}/UserStories"><c:out
						 value="${releaseBacklog.name}" /></a></td>
						 <td><c:out value="${releaseBacklog.description}"/></td>
						 <td><c:out value="${releaseBacklog.startDate}"/></td>
						<td><c:out value="${releaseBacklog.endDate}" /></td>

						<td><nobr>
								<button class="btn btn-primary btn-sm"
									onclick="editReleaseBacklog(${releaseBacklog.id});">

									<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
									Edit
								</button>

								<a class="btn btn-primary btn-sm"
									onclick="return confirm('Are you sure you want to delete this productBacklog?');"
									href="delete/${releaseBacklog.id}"> <span
									class="glyphicon glyphicon-remove" aria-hidden="true"></span>
									Delete
								</a>

							</nobr></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</div>	



	<script type="text/javascript">
		$('.form_date1').datetimepicker({

			weekStart : 1,
			todayBtn : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 2,
			minView : 2,
			forceParse : 0,
			format : 'mm/dd/yyyy'
		});
	
	
	$('.form_date2').datetimepicker({

			weekStart : 1,
			todayBtn : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 2,
			minView : 2,
			forceParse : 0,
			format : 'mm/dd/yyyy'
		});
	
	$( document ).ready(function() {
    
	if ( $('#message-box') ) {
		
		$('#message-box').show(new function(){setTimeout(function(){ $('#message-box').slideUp() }, 4000);});

	}
});

</script>
<%@ include file="../common/footer.jsp"%>
</body>
</html>