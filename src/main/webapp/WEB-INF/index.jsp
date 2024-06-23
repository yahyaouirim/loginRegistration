<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <meta charset="UTF-8">
    <title>Login and Registration</title>
</head>
<body>
<div class="container mt-3 mb-3 mx-auto w-75">
    <div class="row mx-auto">
        <h1>Welcome!</h1>
        <p>Join our growing community</p>
    </div>
    <div class="row mx-auto">   
        <div class="col-md-6 gap-3 mt-3 mb-3">
            <h2>Register</h2>
            <div class="p-3 border bg-dark text-white">
                <form:form action="/register" method="post" modelAttribute="newUser">
                    <div class="form-group">
                        <form:label class="form-label" path="userName">UserName: </form:label>
                        <form:errors path="userName" class="text-danger"/>
                        <form:input class="form-control" path="userName"/>
                    </div>
                    <div class="form-group">
                        <form:label path="email">Email: </form:label>
                        <form:errors path="email" class="text-danger"/>
                        <form:input class="form-control" path="email"/>
                    </div>
                    <div class="form-group">
                        <form:label path="password">Password: </form:label>
                        <form:errors path="password" class="text-danger"/>
                        <form:input class="form-control" path="password" type="password"/>
                    </div>
                    <div class="form-group">
                        <form:label path="confirm">Confirm Password: </form:label>
                        <form:errors path="confirm" class="text-danger"/>
                        <form:input class="form-control" path="confirm" type="password"/>
                    </div>
                    <div>
                        <input class="btn btn-block btn-primary" type="submit" value="Submit"/>
                    </div>
                </form:form>
            </div>
        </div>  
        <div class="col-md-6 mt-3 mb-3 bg-dark p-3 text-white">
            <h2>Log In</h2>
            <form:form action="/login" method="post" modelAttribute="newLogin">
                <div class="form-group">
                    <form:label path="email">Email: </form:label>
                    <form:errors path="email" class="text-danger"/>
                    <form:input class="form-control" path="email"/>
                </div>
                <div class="form-group">
                    <form:label path="password">Password: </form:label>
                    <form:errors path="password" class="text-danger"/>
                    <form:input class="form-control" path="password" type="password"/>
                </div> 
                <input class="btn btn-block btn-primary" type="submit" value="Submit"/>
            </form:form>
        </div>   
    </div>    
</div>
</body>
</html>
