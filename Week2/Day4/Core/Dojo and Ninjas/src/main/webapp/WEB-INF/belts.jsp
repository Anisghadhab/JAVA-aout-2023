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
<title>All Belts</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<h1>List of Belts</h1>
	<h3>Welcome ${user.userName }</h3>
	<table class="table">
		<thead>
			<tr>
				<th>Ninja</th>
				<th>Title</th>
				<th>Language</th>
				<th>#Pages</th>
				<th>Dojo</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allBelts }" var="oneBelt">
				<tr>
					<td>${oneBelt.ninja.userName }</td>
					<td><a href="/belts/${oneBelt.id}">${oneBelt.title }</a></td>
					<td>${oneBelt.language }</td>
					<td>${oneBelt.numberOfPages }</td>
					<td> <a href="/dojos/${oneBelt.dojo.id }" >${oneBelt.dojo.name } </a> </td>
					<c:if test="${user_id == oneBelt.ninja.id}">
					<td class="d-flex flex-row"><a
						href="/belts/${oneBelt.id }/edit"
						class="btn btn-outline-primary col-md-2 ">Edit</a>
						
						<form action="/belts/${oneBelt.id}/delete" method="post">
							<input type="hidden" name="_method" value="delete"> <input
								type="submit" value="Delete"
								class="btn btn-outline-primary col-md-14 offset-md-4">
						</form>
						</td>
						</c:if>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<button type="button"
		class="btn btn-outline-primary col-md-2 offset-md-9">
		<a href="/belts/new">Create a Belt</a> 

	</button>
		<button type="button"
		class="btn btn-outline-primary col-md-2 offset-md-9">
			<a href="/dojos/new">Create a Dojo</a>

	</button>
		</button>
		<button type="button"
		class="btn btn-outline-primary col-md-2 offset-md-9">
			<a href="/logout">Logout</a>

	</button>
	
</body>
</html>

