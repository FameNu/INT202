<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Multi Mom</title>
</head>
<body>
<h1>Multiple Table</h1>
<form action="multi-table" method="post">
    <label for="num">Enter Number: </label>
    <input type="text" id="num" name="num">
    <input type="submit" value="Enter">
</form>
<hr>
<c:if test="${erMsg == null && !hide}">
    <table>
        <tr>
            <th colspan="2">On mom ${number}</th>
        </tr>
        <tr>
            <th colspan="4">Index</th>
            <th>Result</th>
        </tr>
        <c:forEach begin="1" end="12" var="n">
            <tr>
                <td>${number}</td>
                <td>x</td>
                <td>${n}</td>
                <td>=</td>
                <td>${number * n}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${erMsg != null || hide}">
    <h1>Please Insert Integer Number</h1>
</c:if>
</body>
</html>
