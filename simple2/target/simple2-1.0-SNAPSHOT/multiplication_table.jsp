<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 18/9/2566
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result of multication</title>
</head>
<body>
<form action="multiplication_table.jsp" method="get">
    Enter: <input type="text" name="number"> <input type="submit">
</form>
<%--    <h3>${message} <span style="color:red">(${param.number == null ? "Null" : param.number})</span></h3>--%>

<c:if test="${message != null}">
    <h3>Error::</h3>
    <h2>Multiplication table of ${param.number == null ? "Null" : param.number}</h2>
</c:if>
<c:if test="${message == null}">
<h2>Multiplication table of ${param.number == null ? "Null" : param.number}</h2>
<table style="border: 1px solid darkcyan; text-align: right">
    <tr>
        <td colspan="5">${param.number}</td>
    </tr>
    <c:forEach begin="1" end="12" var="n">
        <tr style="text-align: left">
            <td>${param.number}</td>
            <td> x </td>
            <td> ${n} </td>
            <td> = </td>
            <td> ${param.number * n}</td>
        </tr>
    </c:forEach>
</table>
</c:if>
</body>
</html>
