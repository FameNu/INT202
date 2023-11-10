<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IsPrime</title>
</head>
<body>
<h2>Welcome ${user.username} (${user.email})</h2>
<hr>
<form action="is_prime" method="post">
    <label for="number">Enter number to check: </label>
    <input type="text" name="number" id="number"> <br>
    <c:if test="${erMSG != null}">
        <p>${erMSG}</p>
    </c:if>
    <input type="submit" value="Submit">
</form>
<c:if test="${passMSG != null}">
    <hr>
    <p>${passMSG}</p>
</c:if>
</body>
</html>
