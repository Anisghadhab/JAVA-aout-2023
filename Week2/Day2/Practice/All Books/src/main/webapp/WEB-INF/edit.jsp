<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Book</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
    <div class="container mt-5">
        <h1>Edit Book</h1>
        <form:form action="/books/${book.id}" method="post" modelAttribute="book">
            <input type="hidden" name="_method" value="put">

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
                <form:input type="number" path="numberOfPages" class="form-control" />
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form:form>
        <div class="text-center mt-3">
            <a href="/books" class="btn btn-secondary">Return</a>
        </div>
    </div>
</body>
</html>
