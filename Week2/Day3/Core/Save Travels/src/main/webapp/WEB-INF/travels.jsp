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
	<h1>Travel Tracker</h1>
	<hr>

	<table class="table">
		<thead>
			<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${travelList }" var="oneTravel">
				<tr>
					<td><a href="/travels/${oneTravel.id}">${oneTravel.name }</a></td>
					<td>${oneTravel.vendor }</td>
					<td>${oneTravel.amount }</td>
					<td class="d-flex flex-row">
						<a href="/travels/${oneTravel.id }/edit" class="btn btn-outline-primary col-md-2 ">Edit</a>
					
						<form action="/travels/${oneTravel.id}/delete" method="post">
							<input type="hidden" name="_method" value="delete"> 
							<input type="submit" value="Delete" class="btn btn-outline-primary col-md-14 offset-md-4">
						</form>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

  <div class="container mt-5">
        <div class="row">
            <div class="col-md-8 offset-md-2">
                <div class="card">
                    <div class="card-body">
                        <h2 class="card-title">Add a Expense</h2>
                        <form:form action="/travels" method="post" modelAttribute="travel">
                            <div class="form-group">
                                <form:label path="name">Expense Name:</form:label>
                                <form:errors path="name" cssClass="text-danger"/>
                                <form:input path="name" class="form-control"/>
                            </div>
                            <div class="form-group">
                                <form:label path="vendor">Vendor:</form:label>
                                <form:errors path="vendor" cssClass="text-danger"/>
                                <form:input path="vendor" class="form-control"/>
                            </div>

                            <div class="form-group">
                                <form:label path="amount">Amount:</form:label>
                                <form:errors path="amount" cssClass="text-danger"/>
                                <form:input type="number" path="amount" class="form-control"/>
                            </div>
                            <div class="form-group">
                                <form:label path="description">Description:</form:label>
                                <form:errors path="description" cssClass="text-danger"/>
                                <form:textarea path="description" class="form-control"/>
                            </div>
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>


	

	  <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>

