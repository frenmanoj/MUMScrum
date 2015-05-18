<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>List Of User Stories</title>

<link rel="stylesheet"
	href='<c:url value="/web-resources/css/pure-0.4.2.css"/>'>

<link rel="stylesheet"
	href='<c:url value="/web-resources/css/font-awesome-4.0.3/css/font-awesome.css"/>'>

<link rel="stylesheet"
	href='<c:url value="/web-resources/css/jquery-ui-1.10.4.custom.css"/>'>

<style type="text/css">
th {
	text-align: left
}
</style>

</head>

<body>

	<%@ include file="../common/header.jsp"%>


	<a class="btn btn-primary" href="userStories/">User Stories</a>
	<a class="btn btn-primary" href="sprint/">Sprints</a>


	<%@ include file="../common/footer.jsp"%>
</body>
</html>