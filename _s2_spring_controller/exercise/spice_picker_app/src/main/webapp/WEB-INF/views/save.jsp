<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/save" method="post">
    <h1>Sandwich Condiments</h1>
    <div><input type="checkbox" name="condiment" value="lettuce">Lettuce</div>
    <div><input type="checkbox" name="condiment" value="tomato">Tomato</div>
    <div><input type="checkbox" name="condiment" value="mustard">Mustard</div>
    <div><input type="checkbox" name="condiment" value="sprouts">Sprouts</div>
    <input type="submit" value="save">
</form>
<h6>Result:</h6>
<c:forEach items="${condiment}" var="condiment">
    <p>${condiment}</p>
</c:forEach>
</body>
</html>
