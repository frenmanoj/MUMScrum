<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>List Of ProductBacklogs</title>

</head>

<body>

	<%@ include file="../common/header.jsp"%>

	<div id="productBacklogDialog" style="display: none;">
		<%@ include file="productBacklogForm.jsp"%>
	</div>

	<div id="inlineProductBacklogDialog">
		<%@ include file="inlineProductBacklogForm.jsp"%>
	</div>

	<fieldset>
		<legend></legend>
	</fieldset>

	<br>


	<div style="margin: 0 auto;">
		<p style="font-size: 21px; color: #333;">List Of Product Backlogs
		</p>
		<table class="table table-condensed table-striped table-bordered"
			id="product-table">
			<thead>
				<tr>
					<th width="5%">S.N</th>
					<th width="30%">Title</th>
					<th width="45%">Description</th>
					<th width="15%">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productBacklogList}" var="productBacklog"
					varStatus="loopCounter">
					<tr>
						<td><c:out value="${loopCounter.count}" /></td>
						<td><a href="${productBacklog.id}/details"><c:out
									value="${productBacklog.title}" /></a></td>
						<td><c:out value="${productBacklog.description}" /></td>

						<td><nobr>
								<button class="btn btn-primary btn-sm"
									onclick="editProductBacklog(${productBacklog.id});">

									<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
									Edit
								</button>

								<a id="delete-confirm" class="btn btn-primary btn-sm"
									href="delete/${productBacklog.id}"> <span
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
		
		 $('#product-table').dataTable();
		
		 confirmDelete( $("#delete-confirm"), "Are you sure you want to delete this productBacklog?");
	});
	
	
	</script>

	<!--  It is advised to put the <script> tags at the end of the document body so they don't block rendering of the page -->

	<script type="text/javascript"
		src='<c:url value="/web-resources/js/js-for-listProductBacklogs.js"/>'></script>
</body>
</html>