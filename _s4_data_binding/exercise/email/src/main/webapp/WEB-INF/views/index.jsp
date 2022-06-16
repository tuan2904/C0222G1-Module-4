<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" cellpadding="5">
    <tr>
        <td>Language:</td>
        <td>Page Size:</td>
        <td>Spams Filter:</td>
        <td>Signature:</td>
    </tr>
    <tr>
        <td>${email.language}</td>
        <td>${email.pageSize}</td>
        <td>${email.spamsFilter}</td>
        <td>${email.signature}</td>
    </tr>
</table>
<form method="get" action="/edit">
    <button type="submit">Update</button>
</form>
<form method="get" action="/email">
    <button type="submit">cancel</button>
</form>
</body>
</html>
