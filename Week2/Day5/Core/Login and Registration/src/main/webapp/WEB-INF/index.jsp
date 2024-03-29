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
    <title>Login Register</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   <div class="container mt-5">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<div class="card">
					<div class="card-body">
						<h2 class="card-title">Register</h2>
						<form:form action="/register" method="post" modelAttribute="user">
							<div class="form-group">
								<form:label path="userName">User Name:</form:label>
								<form:errors path="userName" cssClass="text-danger" />
								<form:input path="userName" class="form-control" />
							</div>
							<div class="form-group">
								<form:label path="email">Email:</form:label>
								<form:errors path="email" cssClass="text-danger" />
								<form:input path="email" class="form-control" />
							</div>
							<div class="form-group">
								<form:label path="password">Password:</form:label>
								<form:errors path="password" cssClass="text-danger" />
								<form:input path="password" type="password" class="form-control" />
							</div>
							<div class="form-group">
								<form:label path="confirm">Confirm Password:</form:label>
								<form:errors path="confirm" cssClass="text-danger" />
								<form:input path="confirm" type="password" class="form-control" />
							</div>
							<button type="submit" class="btn btn-primary">Submit</button>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container mt-5">
    <div class="row">
        <div class="col-md-8 offset-md-2">
            <div class="card">
                <div class="card-body">
                    <h2 class="card-title">Login</h2>
                    <form:form action="/login" method="post" modelAttribute="loginUser">
                        <div class="form-group">
                            <form:label path="email">Email:</form:label>
                            <form:errors path="email" cssClass="text-danger" />
                            <form:input path="email" class="form-control" />
                        </div>
                        <div class="form-group">
                            <form:label path="password">Password:</form:label>
                            <form:errors path="password" cssClass="text-danger" />
                            <form:input path="password" type="password" class="form-control" />
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

