<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>List Of Sprints</title>

<link rel="stylesheet"
	href='<c:url value="/web-resources/bootstrap3-dialog/css/bootstrap-dialog.css"/>'>
</head>

<body>

	<%@ include file="../common/header.jsp"%>
     
	<div id="sprintDialog" style="display: none; padding-left: 30px; padding-right:30px">
		<%@ include file="sprintForm.jsp"%>
	</div>

	<div id="inlineSprintDialog">
		<%@ include file="inlineSprintForm.jsp"%>
	</div>

	<fieldset>
		<legend></legend>
	</fieldset>

	<br>


	<div style="margin: 0 auto; ">
		<p style="font-size: 21px; color: #333;">

			List Of Sprints
		</p>
		<table class="table table-condensed table-striped table-bordered" id="sprint-table">
			<thead>
				<tr>
					<th width="5%">S.N</th>
					<th width="30%">Title</th>
					<th width="35%">Description</th>					
					<th width="30%">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${sprintList}" var="sprint"
					varStatus="loopCounter">
					<tr>
						<td><c:out value="${loopCounter.count}" /></td>
						<td><a href="${sprint.id}/userStories/"><c:out value="${sprint.title}" /></a></td>
						<td><c:out value="${sprint.description}" /></td>
                         
						<td><nobr>
						       <a class="btn btn-primary btn-sm" href="${sprint.id}/viewBurndown/"> 
						       <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> View Burndown Chart</a>
								<button class="btn btn-primary btn-sm"
									onclick="editSprint(${sprint.id});">

									<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
									Edit
								</button>

								<a class="btn btn-primary btn-sm"
									onclick="return confirm('Are you sure you want to delete this sprint?');"
									href="delete/${sprint.id}"> <span
									class="glyphicon glyphicon-remove" aria-hidden="true"></span>
									Delete
								</a>

							</nobr></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

	<%@ include file="../common/footer.jsp"%>


	<script type="text/javascript">
	
	
	$(document).ready(function(){
		
		
		 $('#sprint-table').dataTable();
	});
	
	
	</script>

	<!--  It is advised to put the <script> tags at the end of the document body so they don't block rendering of the page -->
	<%-- <script type="text/javascript"
		src='<c:url value="/web-resources/js/lib/jquery-1.10.2.js"/>'></script> --%>
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/lib/jquery-ui-1.10.4.custom.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/lib/jquery.ui.datepicker.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/js-for-listSprints.js"/>'></script>

	<script type="text/javascript"
		src='<c:url value="/web-resources/bootstrap3-dialog/js/bootstrap-dialog.js"/>'></script>
		
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/common.js"/>'></script>
</body>
</html>