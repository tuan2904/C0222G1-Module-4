<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/edit" method="post" modelAttribute="emailModel">
<table>
    <h5>Language: <form:select path="language" id="language">
        <option value="English">English</option>
        <option value="Vietnamese">Vietnamese</option>
        <option value="Japanese">Japanese</option>
        <option value="Chinese">Chinese</option>
    </form:select>
    </h5>
    <h5>Page:
        <form:select path="pageSize">
            <option value="5">5</option>
            <option value="10">10</option>
            <option value="15">15</option>
            <option value="25">25</option>
            <option value="50">50</option>
            <option value="100">100</option>
        </form:select>
    </h5>
    <h5>Spams Filter: <form:radiobutton path="spamsFilter"/> Enable spams filter</h5>
    <h5>Signature: <form:input type="text" path="signature"/></h5>
    <button type="submit"> enter</button>
    </form:form>
</body>
</html>
