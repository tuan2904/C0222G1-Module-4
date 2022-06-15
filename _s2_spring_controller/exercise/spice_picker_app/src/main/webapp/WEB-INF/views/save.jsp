<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/14/2022
  Time: 7:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="" method="get">
    <h1>Sandwich Condiments</h1>
    <div><input type="checkbox" name="condiment" value="lettuce">Lettuce</div>
    <div><input type="checkbox" name="condiment" value="tomato">Tomato</div>
    <div><input type="checkbox" name="condiment" value="mustard">Mustard</div>
    <div><input type="checkbox" name="condiment" value="sprouts">Sprouts</div>
    <input type="submit" value="save">
</form>
<h6>Result:</h6>
<c:forEach items="${condiment}" var="cnm">
    <p>${cnm}</p>
</c:forEach>
</body>
</html>
