<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>one Dojo ninjas</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   <table class="table">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${oneDojo.ninjas }" var="oneNinja">
				<tr>
					<td><a href="/ninjas/${oneNinja.id}">${oneNinja.firstName }</a></td>
					<td>${oneNinja.lastName }</td>
					<td>${oneNinja.age }</td>
					<td class="d-flex flex-row">
						<a href="/ninjas/${oneNinja.id }/edit" class="btn btn-outline-primary col-md-2 ">Edit</a>
					
						<form action="/ninjas/${oneNinja.id}/delete" method="post">
							<input type="hidden" name="_method" value="delete"> 
							<input type="submit" value="Delete" class="btn btn-outline-primary col-md-14 offset-md-4">
						</form>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</body>
</html>

