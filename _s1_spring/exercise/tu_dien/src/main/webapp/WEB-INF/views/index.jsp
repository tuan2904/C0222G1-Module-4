<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/13/2022
  Time: 10:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/dictionary" method="post">
    <input type="text" name="english" placeholder="input Vietnamese" value="${language}"><br>
    <input type="text"  placeholder="input Vietnamese" value="${english}"><br>
    <button type="submit"> Submit</button>
</form>
</body>
</html>
