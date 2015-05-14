<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>

	<%@ include file="../common/header.jsp"%>

	<form class="form-horizontal">
		<fieldset>

			<!-- Form Name -->
			<legend>Add Release Backlog</legend>

			<!-- Text input-->
			<div class="col-md-3">
				<label class="control-label" for="name">Name</label> <br> <input
					id="name"  name="name"
					placeholder="Input release name" class="form-control" required
					type="text">
			</div>
			<!-- Start Date -->
			<div class="col-md-3">
				<label for="dtp_input2" class="control-label">Start Date </label> <br>
				<div class="input-group date form_date " data-date=""
					data-date-format="dd MM yyyy" data-link-field="dtp_input2"
					data-link-format="yyyy-mm-dd">
					<input class="form-control" type="text" value="" readonly>
					<span class="input-group-addon "><span
						class="glyphicon glyphicon-calendar"></span> </span>
				</div>
				<input type="hidden" id="dtp_input2" value="" /><br />
			</div>

			<!-- End Date -->
			<div class="col-sm-3">
				<label for="dtp_input2" class=" control-label">End Date </label> <br>
				<div class="input-group date form_date" data-date=""
					data-date-format="MM dd yyyy" data-link-field="dtp_input2"
					data-link-format="MM-dd-yyyy">
					<input class="form-control" type="text" value="" readonly>
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-calendar"></span> </span>
				</div>
				<input type="hidden" id="dtp_input2" value="" /><br />
			</div>


			<!-- Button -->
			<div class="col-sm-3" style="margin-top:27px;">
			
				<button id="saveBtn" style="width: 8em" name="save"
					class="btn btn-primary">Save</button>
			</div>
		</fieldset>
	</form>
	<!-- footer  -->
	<div id="footer" style="text-align: center;">
		<a href="#"><span style="align: center;"
			class="glyphicon glyphicon-copyright-mark"></span> 2015 Page Not
			found</a>
	</div>



	<script type="text/javascript">
		$('.form_date').datetimepicker({

			weekStart : 1,
			todayBtn : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 2,
			minView : 2,
			forceParse : 0,
			format : 'mm/dd/yyyy'
		});
	</script>

</body>
</html>