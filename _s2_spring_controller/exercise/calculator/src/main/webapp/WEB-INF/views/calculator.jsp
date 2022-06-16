<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/calculator" method="post" class="color-rect-border" style="border: black">
    <p>Number 1: <input type="text" name="number1" value="${number1}"></p>
    <p>Number 2: <input type="text" name="number2" value="${number2}"></p>
    <button name="total" value="+">Addition(+)</button>
    <button name="total" value="-">Subtraction(-)</button>
    <button name="total" value="*">Multiplication(*)</button>
    <button name="total" value="/">Division(/)</button><br>
    <p>Result: <input type="text" value="${result}"></p>
</form>
</body>
</html>
