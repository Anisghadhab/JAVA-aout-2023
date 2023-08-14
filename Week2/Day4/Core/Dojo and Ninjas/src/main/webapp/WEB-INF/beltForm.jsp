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
<title>Belt Form</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<div class="card">
					<div class="card-body">
						<h2 class="card-title">New Belt</h2>
						<form:form action="/belts/new" method="post" modelAttribute="belt">
							<div class="form-group">
								<form:label path="title">Title</form:label>
								<form:errors path="title" cssClass="text-danger" />
								<form:input path="title" class="form-control" />
							</div>
							<div class="form-group">
								<form:label path="description">Description</form:label>
								<form:errors path="description" cssClass="text-danger" />
								<form:textarea path="description" class="form-control" />
							</div>
							<div class="form-group">
								<form:label path="language">Language</form:label>
								<form:errors path="language" cssClass="text-danger" />
								<form:input path="language" class="form-control" />
							</div>
							<div class="form-group">
								<form:label path="numberOfPages">Pages</form:label>
								<form:errors path="numberOfPages" cssClass="text-danger" />
								<form:input type="number" path="numberOfPages"
									class="form-control" />
							</div>
							<div class="form-group">
								<form:select path="dojo">
									<c:forEach items="${dojoList }" var="oneDojo">
										<form:option value="${oneDojo.id }">
								${oneDojo.name }
								</form:option>
									</c:forEach>
							</div>



							</form:select>
							<button type="submit" class="btn btn-primary">Submit</button>
						</form:form>
						<a href="/belts" class="btn btn-secondary mt-3">Return</a>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>

