<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>List Of ProductBacklogs</title>

<link rel="stylesheet"
	href='<c:url value="/web-resources/css/pure-0.4.2.css"/>'>

<link rel="stylesheet"
	href='<c:url value="/web-resources/css/font-awesome-4.0.3/css/font-awesome.css"/>'>

<link rel="stylesheet"
	href='<c:url value="/web-resources/css/jquery-ui-1.10.4.custom.css"/>'>

<style type="text/css">
th {
	text-align: left
}
</style>


</head>

<body>
	<div style="width: 95%; margin: 0 auto;">

		<div id="productBacklogDialog" style="display: none;">
			<%@ include file="productBacklogForm.jsp"%>
		</div>

		<h1>List Of ProductBacklogs</h1>

		<button class="pure-button pure-button-primary" onclick="addProductBacklog()">
			<i class="fa fa-plus"></i> Add ProductBacklog
		</button>
		<br>
		<table class="pure-table pure-table-bordered pure-table-striped">
			<thead>
				<tr>
					<th width="10%">S.N</th>
					<th width="30%">Title</th>
					<th width="50%">Description</th>
					<th width="10%"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productBacklogList}" var="productBacklog" varStatus="loopCounter">
					<tr>
						<td><c:out value="${loopCounter.count}" /></td>
						<td><a href="${productBacklog.id}/UserStories"><c:out value="${productBacklog.title}" /></a></td>
						<td><c:out value="${productBacklog.description}" /></td>

						<td><nobr>
								<button class="pure-button pure-button-primary"
									onclick="editProductBacklog(${productBacklog.id});">

									<i class="fa fa-pencil"></i> Edit
								</button>

								<a class="pure-button pure-button-primary"
									onclick="return confirm('Are you sure you want to delete this productBacklog?');"
									href="delete/${productBacklog.id}"> <i class="fa fa-times"></i>Delete
								</a>

							</nobr></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

	<!--  It is advised to put the <script> tags at the end of the document body so they don't block rendering of the page -->
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/lib/jquery-1.10.2.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/lib/jquery-ui-1.10.4.custom.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/lib/jquery.ui.datepicker.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/js-for-listProductBacklogs.js"/>'></script>
</body>
</html>