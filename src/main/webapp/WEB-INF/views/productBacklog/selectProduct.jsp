<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
</head>

<body>

	<%@ include file="../common/header.jsp"%>

	<form action="selectProduct" method="post"
		onsubmit="return validateProduct();">


		<div class="col-md-2">
			<select class="form-control" id="select-product"
				name="productBacklogId">

				<option value="0">Select Product
					Backlog :</option>
				<c:forEach items="${productBacklogList}" var="productBacklog">
					<option value="${productBacklog.id}">${productBacklog.title}</option>
				</c:forEach>

			</select>
		</div>

		<div class="col-md-10">
			<input type="submit" value="View Releases" class="btn btn-primary" />
		</div>

		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>

	<%@ include file="../common/footer.jsp"%>

	<script type="text/javascript">
		function validateProduct() {

			var productId = $("#select-product").val();

			if (productId == "0") {

				showAlert("Please select a product!");
				return false;
			}

			return true;
		}
	</script>

</body>
</html>