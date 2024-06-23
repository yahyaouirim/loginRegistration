<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<meta charset="UTF-8"><meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>
	<div class="container bg-light">
	
		<div class="d-flex justify-content-between w-75 mt-5 mb-5">
			<div><h1>Welcome, <c:out value="${user.userName}"/>!</h1></div>
			<div><a class="btn btn-danger" href="/logout">logout</a></div>
		
		</div>
		<p>This is your dashboard. Nothing to see here yet.</p>
	
	</div>




</body>
</html>