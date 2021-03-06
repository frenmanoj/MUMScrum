<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:url var="actionUrl" value="save" />

<form:form id="employeeForm" commandName="employee" method="post"
	action="${actionUrl }" class="form-horizontal">

	<fieldset>
		<legend></legend>

		<div class="col-md-12">
			<div class="col-md-6">
				<label class="control-label" for="firstName">First Name</label> <br>
				<form:input name="firstName" path="firstName"
					placeholder="First Name" class="form-control" required="true"
					type="text" />
			</div>

			<div class="col-md-6">
				<label class="control-label" for="lastName">Last Name</label> <br>
				<form:input name="lastName" path="lastName" placeholder="Last Name"
					class="form-control" required="true" type="text" />
			</div>

			<div class="col-md-6">
				<label class="control-label" for="email">Email</label> <br>
				<form:input name="email" path="email" placeholder="Email"
					class="form-control" required="true" type="text" />
			</div>

			<div class="col-md-6">
				<label for="salary" class="control-label">Salary</label> <br>
				<form:input class="form-control" type="text" required="true"
					path="salary" placeholder="Salary" />
			</div>

			<div class="col-md-6">
				<label class="control-label" for="phone">Phone</label> <br>
				<form:input name="phone" path="phone" placeholder="Phone"
					class="form-control" type="text" />
			</div>

			<div class="col-md-6">
				<label for="ssn" class="control-label">SSN</label> <br>
				<form:input class="form-control" type="text" path="ssn"
					placeholder="SSN" />
			</div>

			<div class="col-md-6">
				<label class="control-label" for="street">Street</label> <br>
				<form:input name="street" path="street" placeholder="Street"
					class="form-control" type="text" />
			</div>

			<div class="col-md-6">
				<label class="control-label" for="city">City</label> <br>
				<form:input name="city" path="city" placeholder="City"
					class="form-control" type="text" />
			</div>

			<div class="col-md-6">
				<label class="control-label" for="state">State</label> <br>
				<form:input name="state" path="state" placeholder="State"
					class="form-control" type="text" />
			</div>

			<div class="col-md-6">
				<label class="control-label" for="zipcode">Zipcode</label> <br>
				<form:input name="zipcode" path="zipcode" placeholder="Zipcode"
					class="form-control" type="text" />
			</div>

		</div>

		<form:input path="id" type="hidden"/>
	</fieldset>
</form:form>