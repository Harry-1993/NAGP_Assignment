<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Create an account</title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<body>

	<div class="container">

		<form:form method="POST" modelAttribute="issueForm"
			action="${contextPath}/addIssues" class="form-issue">
			<h2 class="form-signin-heading">Create your issue</h2>
			<spring:bind path="issueName">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="issueName" class="form-control"
						placeholder="Issue Name" autofocus="true"></form:input>
					<form:errors path="issueName"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="subject">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="subject" class="form-control"
						placeholder="Subject"></form:input>
					<form:errors path="subject"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="description">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="description" class="form-control"
						placeholder="Desrciption"></form:input>
					<form:errors path="description"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="issueType">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:select path="issueType">
						<form:option value="" label="Select Option" />
						<form:options path="issueType" items="${issueTypes}"
							class="form-control" placeholder="Issue Type" />
					</form:select>
				</div>
			</spring:bind>


			<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
		</form:form>

	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
