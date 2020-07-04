<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Of Issues Created</title>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 60%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}
</style>
</head>
<body style="background-color: #FFFFE0;">

	<div style="margin-top: 50px; margin-left: 200px; height: 50px;">
		<h2>Issue List</h2>
	</div>
	<table style="margin-top: 0px; margin-left: 100px;">
		<tr>
			<th>S.No</th>
			<th>Issue Name</th>
			<th>Subject</th>
			<th>Description</th>
			<th>Issue Type</th>
			<th>Edit</th>
			<th>Delete</th>

		</tr>
		<c:forEach items="${issueList}" var="issue">
			<tr>
				<td>${issue.id}</td>
				<td>${issue.issueName}</td>
				<td>${issue.subject}</td>
				<td>${issue.description}</td>
				<td>${issue.issueType}</td>

				<td>
					<form action="/edit?id=${issue.id}" method="post">
						<input type="submit" value="Edit"
							style="background: none; border: 0px; cursor: pointer;" /> <input
							type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
				</td>

				<td>
					<form action="/delete?id=${issue.id}" method="post">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" /> <input type="submit" value="Delete"
							style="background: none; border: 0px; cursor: pointer;" />
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>