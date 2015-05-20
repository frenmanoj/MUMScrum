<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form>
	<fieldset>
		<legend>Employee Detail</legend>
		<div>
			<div class="col-md-12">
				<div class="col-md-1">
					<label>Name:</label>
				</div>
				<div class="col-md-11">
					<i>${employee.firstName} ${employee.lastName}</i>
				</div>
			</div>

			<div class="col-md-12">
				<div class="col-md-1">
					<label>Email:</label>
				</div>
				<div class="col-md-11">
					<i>${employee.email} </i>
				</div>
			</div>

			<div class="col-md-12">
				<div class="col-md-1">
					<label>Phone:</label>
				</div>
				<div class="col-md-11">
					<i>${employee.phone} </i>
				</div>
			</div>

			<div class="col-md-12">
				<div class="col-md-1">
					<label>SSN:</label>
				</div>
				<div class="col-md-11">
					<i>${employee.ssn} </i>
				</div>
			</div>

			<div class="col-md-12">
				<div class="col-md-1">
					<label>Street:</label>
				</div>
				<div class="col-md-11">
					<i>${employee.street} </i>
				</div>
			</div>

			<div class="col-md-12">
				<div class="col-md-1">
					<label>State:</label>
				</div>
				<div class="col-md-11">
					<i>${employee.state} </i>
				</div>
			</div>

			<div class="col-md-12">
				<div class="col-md-1">
					<label>City:</label>
				</div>
				<div class="col-md-11">
					<i>${employee.city} </i>
				</div>
			</div>

			<div class="col-md-12">
				<div class="col-md-1">
					<label>Zipcode:</label>
				</div>
				<div class="col-md-11">
					<i>${employee.zipcode} </i>
				</div>
			</div>

			<a class="btn btn-primary " href="update">Update</a>

		</div>

	</fieldset>
</form>