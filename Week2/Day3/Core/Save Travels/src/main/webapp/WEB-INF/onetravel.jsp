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
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<div class="card">
					<div class="card-body">
						<h2 class="card-title mb-4">Expense Details</h2>

						<div class="row">
							<div class="col-md-6">
								<p>
									<strong>Expense Name:</strong> ${oneTravel.name}
								</p>
								<p>
									<strong>Expense Description:</strong> ${oneTravel.description}
								</p>
								<p>
									<strong>Vendor:</strong> ${oneTravel.vendor}
								</p>
								<p>
									<strong>Amount Spent:</strong> $${oneTravel.amount}
								</p>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>



</body>
</html>

