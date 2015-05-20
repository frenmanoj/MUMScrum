<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
</head>

<body>

	<%@ include file="../common/header.jsp"%>

	<form action="selectRelease" method="post"
		onsubmit="return validateInputs();">

		<div class="col-md-3">
			<select class="form-control" id="select-product" name="productBacklogId"
				onchange="listReleases(this);">

				<option value="0">Select Product Backlog</option>
				<c:forEach items="${productBacklogList}" var="productBacklog">
					<option value="${productBacklog.id}">${productBacklog.title}</option>
				</c:forEach>

			</select>

		</div>

		<div class="col-md-3">

			<select class="form-control" id="select-release" name="releaseBacklogId" disabled>

				<option value="0">Select Release Backlog</option>
			</select>
		</div>

		<div class="col-md-6">
			<input type="submit" value="View Sprints" class="btn btn-primary" />
		</div>
		
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>

	<%@ include file="../common/footer.jsp"%>

	<script type="text/javascript">
		function listReleases(selectedProduct) {

			$('#select-release').find('option:not(:first)').remove();

			var productId = $(selectedProduct).val();
			
			if ( productId == "0") {
				
				$('#select-release').prop("disabled", true);
				
				return;
			}


			$.get("getReleases/" + productId, function(releaseData) {

				$.each(releaseData, function(releaseId, releaseName) {

					$('#select-release').append(
							$("<option value='" + releaseId + "'>"
									+ releaseName + "</option>"));
				});

				$('#select-release').prop("disabled", false);
			});

		}

		function validateInputs() {

			var selectedProduct = $("#select-product").val();

			if (selectedProduct == "0") {

				showAlert("Please select a product!");
				return false;
			}

			var selectedRelease = $("#select-release").val();

			if (selectedRelease == "0") {

				showAlert("Please select a release!");
				return false;
			}

			return true;
		}
	</script>

</body>
</html>