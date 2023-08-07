<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fruity Loops</title>
    
    <!-- Link to Bootstrap CSS file -->
    <link href="/path/to/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="mt-4">Fruity Loops</h1>
        <table class="table table-striped mt-3">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="oneFruit" items="${fruits}">
                    <tr>
                        <td><c:out value="${oneFruit.name}" /></td>
                        <td><c:out value="${oneFruit.price}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Link to Bootstrap JS and Popper.js (optional) -->
    <script src="/path/to/bootstrap.min.js"></script>
    <script src="/path/to/popper.min.js"></script>
</body>
</html>
