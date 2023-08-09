<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert title</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<h1>List Of Books</h1>
	<hr>

	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Language</th>
				<th>#Pages</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${bookList }" var="oneBook">
				<tr>
					<td>${oneBook.id }</td>
					<td><a href="/books/${oneBook.id}">${oneBook.title }</a></td>
					<td>${oneBook.language }</td>
					<td>${oneBook.numberOfPages }</td>
					<td class="d-flex flex-row">
						<a href="/books/${oneBook.id }/edit" class="btn btn-outline-primary col-md-2 ">Edit</a>
					
						<form action="/books/${oneBook.id}/delete" method="post">
							<input type="hidden" name="_method" value="delete"> 
							<input type="submit" value="Delete" class="btn btn-outline-primary col-md-14 offset-md-4">
						</form>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
		<button type="button" class="btn btn-outline-primary col-md-2 offset-md-9">
		<a href="/books/create" >Create a Book</a>
	</button>
	  <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>

