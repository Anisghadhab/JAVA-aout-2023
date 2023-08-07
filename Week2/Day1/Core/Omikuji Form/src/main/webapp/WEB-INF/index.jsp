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

<title>Insert title here</title>
</head>
<body>
  <div class="container mt-5">
    <form action="/processForm" method="post">
      <div class="mb-3">
        <label for="number" class="form-label">Pick any number from 5 to 25</label>
        <input type="number" class="form-control" id="number" name="number" required>
      </div>
      <div class="mb-3">
        <label for="cityName" class="form-label">Enter the name of any city</label>
        <input type="text" class="form-control" id="cityName" name="cityName" required>
      </div>
      <div class="mb-3">
        <label for="personName" class="form-label">Enter the name of any real person</label>
        <input type="text" class="form-control" id="personName" name="personName" required>
      </div>
      <div class="mb-3">
        <label for="hobby" class="form-label">Enter professional endeavor or hobby</label>
        <input type="text" class="form-control" id="hobby" name="hobby" required>
      </div>
      <div class="mb-3">
        <label for="livingThing" class="form-label">Enter any type of living thing</label>
        <input type="text" class="form-control" id="livingThing" name="livingThing" required>
      </div>
      <div class="mb-3">
        <label for="somethingNice" class="form-label">Say something nice to someone</label>
        <textarea class="form-control" id="somethingNice" name="somethingNice" rows="4" required></textarea>
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
