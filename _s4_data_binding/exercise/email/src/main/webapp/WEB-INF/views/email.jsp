<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/email" method="post" modelAttribute="emailModel">
<table>
    <h5>Language: <form:select path="language" id="language">
        <form:option value="null">Choose Language</form:option>
        <form:options items="${language}"></form:options>
    </form:select>
    </h5>
    <h5>Page: Show
        <form:select path="pageSize">
            <form:option value="null">Choose Size</form:option>
            <form:options items="${pageSize}"></form:options>
        </form:select>
    </h5>
    <h5>Spams Filter:
        <form:checkbox path="spamsFilter"></form:checkbox>Enable spams filter</h5>
    <h5>Signature: <form:input type="text" path="signature"/></h5>
    <button type="submit">Enter</button>
    </form:form>
</body>
</html>
