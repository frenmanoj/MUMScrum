<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>List Release Backlog</title>

</head>
<body>

	<%@ include file="../common/header.jsp"%>

	<div id="releaseBacklogDialog"
		style="display: none; padding-left: 30px; padding-right: 30px">
		<%@ include file="releaseBacklogForm.jsp"%>
	</div>

	<div id="inlineReleaseBacklogDialog">
		<%@ include file="inlineReleaseBacklogForm.jsp"%>
	</div>

	<br />

	<fieldset>
		<legend></legend>
	</fieldset>

	<br>
	<div style="margin: 0 auto;">

		<p style="font-size: 21px; color: #333;">
			List Of Release Backlogs for <b>${productBacklog.title}</b>
		</p>
		<table class="table table-condensed table-striped table-bordered"
			id="release-table">
			<thead>
				<tr>
					<th width="5%">S.N</th>
					<th width="20%">Name</th>
					<th width="20%">Description</th>
					<th width="25%">StartDate</th>
					<th width="25%">EndDate</th>
					<th width="5%">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${releaseBackloglist}" var="releaseBacklog"
					varStatus="loopCounter">
					<tr>
						<td><c:out value="${loopCounter.count}" /></td>
						<td><a href="${releaseBacklog.id}/details"><c:out
									value="${releaseBacklog.name}" /></a></td>
						<td><c:out value="${releaseBacklog.description}" /></td>
						<td><c:choose>
								<c:when test="${releaseBacklog.startDate!=null}">
									<c:out value="${fn:substring(releaseBacklog.startDate,0,10)}" />
								</c:when>
								<c:otherwise>
									<c:out value="${releaseBacklog.startDate}" />
								</c:otherwise>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${releaseBacklog.endDate!=null}">
									<c:out value="${fn:substring(releaseBacklog.endDate,0,10)}" />
								</c:when>
								<c:otherwise>
									<c:out value="${releaseBacklog.endDate}" />
								</c:otherwise>
							</c:choose></td>

						<td><nobr>
								<button class="btn btn-primary btn-sm"
									onclick="editReleaseBacklog(${releaseBacklog.id});">

									<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
									Edit
								</button>

								<a id="delete-confirm" class="btn btn-primary btn-sm"
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


	<%@ include file="../common/footer.jsp"%>

	<script type="text/javascript">
	
	$( document ).ready(function() {
    
		if ( $('#message-box') ) {
			
			$('#message-box').show(new function(){setTimeout(function(){ $('#message-box').slideUp() }, 4000);});
		}
		
		confirmDelete( $("#delete-confirm"), "Are you sure you want to delete this release?");
		
		initializeDatePicker();
	    $('#release-table').dataTable();
	});

	</script>
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/js-for-listReleaseBacklog.js"/>'></script>
</body>
</html>