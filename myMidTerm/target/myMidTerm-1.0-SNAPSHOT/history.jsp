<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History Prime Number</title>
</head>
<body>
<h2>Welcome ${user.username} (${user.email})</h2>
<hr>
<c:choose>
    <c:when test="${historyList != null && !historyList.isEmpty()}">
        <table>
            <tr>
                <th>No</th>
                <th>Number</th>
                <th>Is Prime Number?</th>
            </tr>
            <c:forEach items="${historyList}" var="hl" varStatus="vs">
                <tr>
                    <td>${vs.count}</td>
                    <td>${hl.getNumber()}</td>
                    <td>
                        <c:choose>
                            <c:when test="${hl.isPrime()}">&#10003;</c:when>
                            <c:otherwise>&#10060;</c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <h3>Not have history</h3>
    </c:otherwise>
</c:choose>
</body>
</html>
