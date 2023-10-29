<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2/10/2566
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Course Register History (Session)</h2><hr>
    <c:if test="${message != null}">
        <h2 style="color: red; background-color: yellow">
            ${message}<br><hr>
            <a href="course-list"><button>OK</button></a>
        </h2>
    </c:if>
    <c:if test="${message == null}">
        <c:forEach items="${courseRegistered.history}" var="entry">
            <h3>Semester: ${entry.key}</h3>
            <c:forEach items="${entry.value}" var="subject" varStatus="vs">
                ${vs.count}) ${subject.subjectId} ${subject.title} ${subject.credit}<br>
            </c:forEach>
            <br>
        </c:forEach>
        <hr>
        <a href="index.jsp"><button>OK</button></a>
    </c:if>
</body>
</html>
