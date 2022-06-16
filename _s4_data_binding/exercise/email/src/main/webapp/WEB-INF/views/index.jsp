<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/15/2022
  Time: 8:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>Language:</td>
        <td>${email.language}</td>
    </tr>
    <tr>
        <td>Page Size:</td>
        <td>${email.pageSize}</td>
    </tr>
    <tr>
        <td>Spams Filter:</td>
        <td>${email.spamsFilter}</td>
    </tr>
    <tr>
        <td>Signature:</td>
        <td>${email.signature}</td>
    </tr>

</table>
<form method="get" action="/edit">
    <button type="submit">Enter</button>
</form>
</body>
</html>
