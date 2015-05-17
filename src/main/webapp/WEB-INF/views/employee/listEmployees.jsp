<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>List Of Employees</title>

<link rel="stylesheet"
	href='<c:url value="/web-resources/bootstrap3-dialog/css/bootstrap-dialog.css"/>'>
</head>

<body>

	<%@ include file="../common/header.jsp"%>

	<div id="employeeDialog" style="display: none; padding-left: 30px; padding-right:30px">
		<%@ include file="employeeForm.jsp"%>
	</div>

	<div id="inlineEmployeeDialog">
		<%@ include file="inlineEmployeeForm.jsp"%>
	</div>

	<fieldset>
		<legend></legend>
	</fieldset>

	<br>
	<div style="margin: 0 auto;">

		<p style="font-size: 21px; color: #333;">
		
			List Of Employees
		</p>
		
		<table class="table table-condensed table-striped table-bordered" id="employee-table">
			<thead>
				<tr>
					<th width="5%">S.N</th>
					<th width="30%">Name</th>
					<th width="40%">Email</th>
					<th width="10%">Salary</th>
					<th width="15%">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employeeList}" var="employee"
					varStatus="loopCounter">
					<tr>
						<td><c:out value="${loopCounter.count}" /></td>
						<td><c:out value="${employee.firstName}" /> <c:out value="${employee.lastName}" /></td>
						<td><c:out value="${employee.email}" /></td>
						<td><c:out value="${employee.salary}" /></td>

						<td><nobr>
								<button class="btn btn-primary btn-sm"
									onclick="editEmployee(${employee.id});">

									<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
									Edit
								</button>

								<a class="btn btn-primary btn-sm"
									onclick="return confirm('Are you sure you want to delete this employee?');"
									href="delete/${employee.id}"> <span
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
		
		
		 $('#employee-table').dataTable();
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
		src='<c:url value="/web-resources/js/js-for-listEmployees.js"/>'></script>

	<script type="text/javascript"
		src='<c:url value="/web-resources/bootstrap3-dialog/js/bootstrap-dialog.js"/>'></script>
		
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/common.js"/>'></script>
</body>
</html>