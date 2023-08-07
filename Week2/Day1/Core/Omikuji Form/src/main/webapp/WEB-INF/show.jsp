<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- YOUR own local CSS -->
    <link rel="stylesheet" href="/css/main.css"/>
    <!-- For any Bootstrap that uses JS -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

    <meta charset="UTF-8">
    <title>Omikuji Results</title>
    <style>
        /* Additional styles specific to this page */

    </style>
</head>
<body>
    <div class="container">
        <h3 class="mt-4">Here's Your Omikuji!</h3>
        <div class="block">
            <p>
                In ${number} years, you will live in ${cityName} with ${personName} as your roommate,
                ${hobby} for a living.
                The next time you see a ${livingThing}, you will have good luck.
                Also, ${somethingNice}.
            </p>
        </div>
    </div>
</body>
</html>
