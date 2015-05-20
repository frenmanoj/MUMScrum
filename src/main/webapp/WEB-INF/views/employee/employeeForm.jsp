<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:url var="actionUrl" value="save" />

<form:form id="employeeForm" commandName="employee"
	method="post" action="${actionUrl }" class="form-horizontal">

	<fieldset>
		<legend></legend>

		<div class="form-group">
			<label class="control-label" for="firstName">First Name</label>
			
			<form:input name="firstName" path="firstName" placeholder="First Name" class="form-control"
				required="true" />
		</div>
		
		<div class="form-group">
				<label class="control-label" for="lastName">Last Name</label> <br>
				<form:input name="lastName" path="lastName"
					placeholder="Last Name" class="form-control"
					required="true"/>
			</div>
			
			<div class="form-group">
				<label class="control-label" for="email">Email</label> <br>
				<form:input name="email" path="email"
					placeholder="Email" class="form-control"
					required="true"/>
			</div>
			
			<div class="form-group">
				<label for="salary" class="control-label">Salary</label> <br>
				<form:input class="form-control" required="true"
					path="salary" placeholder="Salary" />
			</div>
			
			<div class="form-group">
				<label class="control-label" for="phone">Phone</label> <br>
				<form:input name="phone" path="phone"
					placeholder="Phone" class="form-control"/>
			</div>
			
			<div class="form-group">
				<label for="ssn" class="control-label">SSN</label> <br>
				<form:input class="form-control"
					path="ssn" placeholder="SSN" />
			</div>
			
			<div class="form-group">
				<label class="control-label" for="street">Street</label> <br>
				<form:input name="street" path="street"
					placeholder="Street" class="form-control"/>
			</div>
			
			<div class="form-group">
				<label class="control-label" for="city">City</label> <br>
				<form:input name="city" path="city"
					placeholder="City" class="form-control"/>
			</div>
			
			<div class="form-group">
				<label class="control-label" for="state">State</label> <br>
				<form:input name="state" path="state"
					placeholder="State" class="form-control"/>
			</div>
			
			<div class="form-group">
				<label class="control-label" for="zipcode">Zipcode</label> <br>
				<form:input name="zipcode" path="zipcode"
					placeholder="Zipcode" class="form-control"/>
			</div>
			ID:
			<form:input path="id" />
			<br>User Id: 
			<form:input path="user.id" type="text" />
			
			<br>Password:
			<form:input path="user.password" type="text" />
			<br>Username:
			<form:input path="user.username" type="text" />
			<form:input path="user.enabled" type="text" />
	</fieldset>
</form:form>