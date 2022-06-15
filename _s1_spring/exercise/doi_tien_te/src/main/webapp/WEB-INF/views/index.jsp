
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>currency converter</title>
</head>
<body>
<form method="post" action="/index">
  <label>Rate: </label>
  <input type="text" name="VND" placeholder="VNĐ" value="22000" disabled><br>
  <label>USD: </label>
  <input type="text" name="inputs" placeholder="USD" value="0"><br>
  <input type="text" value="${result1}"><br>
  <input type="submit" value="submit">
</form>
</body>
</html>