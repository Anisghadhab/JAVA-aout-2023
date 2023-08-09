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
    <title>insert title</title>
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
                        <h2 class="card-title">Edit a Burger</h2>
                        <form:form action="/burgers/${burger.id }/update" method="post" modelAttribute="burger">
                            <div class="form-group">
                                <form:label path="name">Burger Name</form:label>
                                <form:errors path="name" cssClass="text-danger"/>
                                <form:input path="name" class="form-control"/>
                            </div>
                            <div class="form-group">
                                <form:label path="restaurant">Restaurant Name</form:label>
                                <form:errors path="restaurant" cssClass="text-danger"/>
                                <form:textarea path="restaurant" class="form-control"/>
                            </div>

                            <div class="form-group">
                                <form:label path="rating">Rating</form:label>
                                <form:errors path="rating" cssClass="text-danger"/>
                                <form:input type="number" path="rating" class="form-control"/>
                            </div>
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form:form>
                        <a href="/burgers" class="btn btn-secondary mt-3">Return</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
   
</body>
</html>

