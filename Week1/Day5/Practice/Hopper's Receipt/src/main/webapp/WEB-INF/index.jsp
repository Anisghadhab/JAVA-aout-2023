<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
<title>zina</title>
</head>
<body>
	<h1>
		Customer Name:
		<c:out value="${firstname }" />
	</h1>
	<h3>
		Item name:
		<c:out value="${itemName }" />
	</h3>
	<h3>
		Price: $
		<c:out value="${price }" />
	</h3>
	<h3>
		Description:
		<c:out value="${description }" />
	</h3>
	<h3>
		Vendor:
		<c:out value="${vendor }" />
	</h3>
</body>
</html>