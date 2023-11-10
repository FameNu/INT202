<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form action="register" method="post">
    <label for="email">Enter Email: </label> <input type="text" id="email" name="email">
    <label for="username">Enter Username: </label><input type="text" id="username" name="username">
    <input type="submit" value="Submit">
</form>
<c:if test="${user.username != null}">
    <hr>
    <h2>Welcome ${user.username} (${user.email})</h2>
</c:if>
</body>
</html>
