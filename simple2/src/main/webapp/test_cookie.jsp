<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25/9/2566
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test Cookie</title>
</head>
<body style="background-color: ${bgColor}">
    <h1><%= "Test Cookies" %></h1>
    <form action="TestCookieServlet" method="post">
        Please Select your theme: <br>
        &nbsp;&nbsp;&nbsp; - <input type="radio" id="radioButtonDB" name="bg" value="darkblue" ${bgColor == "darkblue" ? "checked" : ''}><label for="radioButtonDB">Dark Blue</label><br>
        &nbsp;&nbsp;&nbsp; - <input type="radio" id="radioButtonY" name="bg" value="yellow" ${bgColor == "yellow" ? "checked" : ''}><label for="radioButtonY">Yellow</label><br>
        &nbsp;&nbsp;&nbsp; - <input type="radio" id="radioButtonG" name="bg" value="gray" ${bgColor == "gray" ? "checked" : ''}><label for="radioButtonG">Gray</label><br>
        &nbsp;&nbsp;&nbsp; - <input type="submit"><br>
    </form>
</body>
</html>
