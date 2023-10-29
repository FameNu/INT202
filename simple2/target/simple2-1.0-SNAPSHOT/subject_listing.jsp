<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 4/9/2566
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Subject List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div class="flex-content" style="margin: 100px; background-color: beige">
        <h1>Subject List::</h1>
        <hr>
        <table>
            <tr class="row bg-light">
                <th class="col-1">Subject ID</th>
                <th class="col-3">Title</th>
                <th class="col-1">Credit</th>
            </tr>
            <c:forEach items="${subjects}" var="subject" varStatus="vs">
                <tr class="row">
                    <td class="col-1">${subject.id}</td>
                    <td class="col-3">${subject.title}</td>
                    <td class="col-1">${subject.credit}</td>
                    <td><input type="checkbox" value="${subject.id}"></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
