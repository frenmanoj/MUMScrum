<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>

	<%@ include file="common/header.jsp"%>

	<div class="jumbotron">
		<div class="container">

			<h1>HTTP Status 403 - Access is denied</h1>

			<c:choose>
				<c:when test="${empty username}">
					<h2>You do not have permission to access this page!</h2>
				</c:when>
				<c:otherwise>
					<h2>
						Username : ${username} <br><br>You do not have permission to access
						this page!
					</h2>
				</c:otherwise>
			</c:choose>

		</div>

	</div>
</body>
</html>