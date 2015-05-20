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

	<div id="inlineEmployeeDialog">
		<%@ include file="inlineUpdateEmployeeForm.jsp"%>
	</div>

	
	<%@ include file="../common/footer.jsp"%>

	
	
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