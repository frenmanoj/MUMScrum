<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>List Of Employees</title>


</head>

<body>

	<%@ include file="../common/header.jsp"%>

	<div id="employeeDialog"
		style="display: none; padding-left: 30px; padding-right: 30px">
		<%@ include file="employeeForm.jsp"%>
	</div>

	<button class="btn btn-primary" id="add-employee">Add Employee</button>
	<div id="inlineEmployeeDialog" style="display: none; width: 100%;">
		<%@ include file="inlineEmployeeForm.jsp"%>
	</div>

	<br>
	<br>
	<div style="display: block;" id="employee-list-container">

		<p style="font-size: 21px; color: #333;">List Of Employees</p>

		<table class="table table-condensed table-striped table-bordered"
			id="employee-table">
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
						<td><c:out value="${employee.firstName}" /> <c:out
								value="${employee.lastName}" /></td>
						<td><c:out value="${employee.email}" /></td>
						<td><c:out value="${employee.salary}" /></td>

						<td><nobr>
								<button class="btn btn-primary btn-sm"
									onclick="editEmployee(${employee.id});">

									<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
									Edit
								</button>

								<a id="delete-confirm" href="delete/${employee.id}"
									class="btn btn-primary btn-sm"> <span
									class="glyphicon glyphicon-remove" aria-hidden="true"></span>Delete
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
		 
		 $('#add-employee').click(function(){
			 
			 $('#inlineEmployeeDialog').slideToggle();
			 $('#employee-list-container').slideToggle();
		 });
		 
		 confirmDelete( $("#delete-confirm"), "Are you sure you want to delete this employee?");
	});
	
	</script>

	<script type="text/javascript"
		src='<c:url value="/web-resources/js/js-for-listEmployees.js"/>'></script>
</body>
</html>