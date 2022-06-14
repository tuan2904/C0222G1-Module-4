<%--
  Created by IntelliJ IDEA.
  User: SON NGUYEN
  Date: 10/30/2018
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>currency converter</title>
</head>
<body>
<form method="post" action="/usd">
  <label>Rate: </label>
  <input type="text" name="vnd" placeholder="VNĐ" value="22000"><br>
  <label>USD: </label>
  <input type="text" name="usd" placeholder="USD" value="0"><br>
  <input type="submit" id="submit" value="convert">
</form>
</body>
</html>