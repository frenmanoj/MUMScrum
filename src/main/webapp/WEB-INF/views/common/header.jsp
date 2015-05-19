<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
<title>MUMScrum</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<link rel="stylesheet"
	href='<c:url value="/web-resources/css/lib/dataTables.bootstrap.css"/>'>

<link rel="stylesheet"
	href='<c:url value="/web-resources/css/customize.css"/>'>

<link rel="stylesheet"
	href='<c:url value="/web-resources/css/bootstrap-datetimepicker.min.css"/>'>

<link rel="stylesheet"
	href='<c:url value="/web-resources/css/jquery-ui-1.10.4.custom.css"/>'>


<style>
body {
	margin-top: 25px;
	margin-bottom: 25px;
	margin-left: auto;
	margin-right: auto;
	padding-left: 25px;
	padding-right: 25px;
	padding-top: 25px;
	padding-bottom: 25px;
	background-color: white;
	width: 70%;
	height: 900px;
	overflow-x: hidden;
}

html {
	background: linear-gradient(27deg, #151515 5px, transparent 5px) 0 5px,
		linear-gradient(207deg, #151515 5px, transparent 5px) 10px 0px,
		linear-gradient(27deg, #222 5px, transparent 5px) 0px 10px,
		linear-gradient(207deg, #222 5px, transparent 5px) 10px 5px,
		linear-gradient(90deg, #1b1b1b 10px, transparent 10px),
		linear-gradient(#1d1d1d 25%, #1a1a1a 25%, #1a1a1a 50%, transparent 50%,
		transparent 75%, #242424 75%, #242424);
	background-color: #131313;
	background-size: 20px 20px;
}
</style>

</head>
<body>

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/mscrum/">MUMScrum</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">

					<li class="active"><a href="/mscrum/productBacklog/">Products</a></li>
					<li><a href="/mscrum/selectProduct">Releases</a></li>
					<li><a href="/mscrum/selectRelease">Sprints</a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">HR <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/mscrum/employee/">Employees</a></li>
							<li><a href="#">Organization Chart</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">

					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"><span
							class="glyphicon glyphicon-user"></span> <b>${pageContext.request.userPrincipal.name}</b>
					</a>
						<ul class="dropdown-menu">
							<li><a href="#"><span
									class="glyphicon glyphicon-eye-open"></span> &nbsp;View Profile</a></li>
							<li><a href="javascript:formSubmit()"><span
									class="glyphicon glyphicon-log-out"></span> &nbsp;Logout</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

	<script
		src='<c:url value="/web-resources/js/lib/jquery.dataTables.1.10.7.min.js"/>'></script>
	<script
		src='<c:url value="/web-resources/js/lib/dataTables.bootstrap.js"/>'></script>

	<script type="text/javascript"
		src='<c:url value="/web-resources/js/lib/bootstrap-datetimepicker.min.js"/>'></script>

	<script type="text/javascript"
		src='<c:url value="/web-resources/js/lib/jquery-ui-1.10.4.custom.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/lib/jquery.ui.datepicker.js"/>'></script>

	<script type="text/javascript"
		src='<c:url value="/web-resources/js/common.js"/>'></script>

	<c:url value="/j_spring_security_logout" var="logoutUrl" />

	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

	<%-- 	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} | <a
				href="javascript:formSubmit()"> Logout</a>
		</h2>
	</c:if>
 --%>

</body>
</html>
