<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Grade</title>
</head>
<body>
    <h3>Calculate your grade</h3>
    <form action="eval-grade" method="post">
      <label for="number">Enter: </label>
      <input type="text" name="number" id="number">
      <input type="submit" value="Submit">
    </form>
    <hr>
<c:if test="${msg != null}">
    <h1>${msg}</h1>
</c:if>
<c:if test="${msg == null}">
    <h1>Your Grade is ${grade}</h1>
</c:if>
</body>
</html>
