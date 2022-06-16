
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<form action="/calculator" method="post" class="color-rect-border" style="border: black">
    <p>Number 1: <input type="text" name="number1" value="${number1}"></p>
    <p>Number 2: <input type="text" name="number2" value="${number2}"></p>
    <button name="total" value="+">Addition(+)</button>
    <button name="total" value="-">Subtraction(-)</button>
    <button name="total" value="*">Multiplication(*)</button>
    <button name="total" value="/">Division(/)</button>
    <br>
    <p>Result: <input type="text" value="${result}"></p>

</form>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
