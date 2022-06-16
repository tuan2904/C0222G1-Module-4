<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<title>Title</title>
<link rel="stylesheet" href="webapp\WEB-INF\resources\boostrap\css\bootstrap-grid.css">
<style>
    h4 {
        text-align: center;
    }
</style>
</head>
<body>
<h4>Tờ Khai y Tế</h4>
<h4>Đây là tài liệu quan trọng, thông tin của anh/chị sẽ giúp cơ
    quan y tế liên lạc khi cần thiết để phòng chống dịch bệnh truyền nhiễm</h4>
<form:form action="/formmedical" method="post" modelAttribute="medicalModel">
    <table>
        <tr>
            <td>Họ và tên:</td>
        </tr>
        <tr>
            <td><form:input type="text" path="name"/></td>
        </tr>
        <tr>
            <td>Năm sinh</td>
            <td>Giới tính</td>
            <td>Quốc tích</td>
        </tr>
        <tr>
            <td><form:select path="birthDay">
                <form:option value="null">Choose Year Birth Day</form:option>
                <form:options items="${birthDay}"></form:options>
            </form:select></td>

            <td><form:select name="" id="" path="gender">
                <option value="Gender">Gender</option>
                <option value="Nam">Nam</option>
                <option value="Nu">Nu</option>
            </form:select></td>
            <td><form:input type="text" path="nationality"/></td>
        </tr>

        <tr>
            <td>Số hộ chiếu hoặc số cmnd hoặc giấy thông hành hợp pháp khác:</td>
        </tr>

        <tr>
            <td><form:input type="text" path="idCar"/></td>
        </tr>

        <tr>
            <td>Thông tin đi lại:</td>
        </tr>

        <tr>
            <td>
                <form:checkboxes items="${travelInformation}" path="travelInformation"/>
            </td>
        </tr>
        <tr>
            <td>Số phương tiện:</td>
            <td>Số ghế:</td>
        </tr>
        <tr>
            <td><form:input type="text" path="seats"/></td>
            <td><form:input type="text" path="vehicleNumber"/></td>
        </tr>
        <tr>
            <td>ngày khỏi hành:</td>
            <td>ngày kết thúc:</td>
        </tr>
        <tr>
            <td><form:input type="text" path="dateStart"/></td>
            <td><form:input type="text" path="dateEnd"/></td>
        </tr>
        <tr>
            <td>Trong vòng 14 ngày qua , Anh/Chị có đến tỉnh/thành phố nào?</td>
        </tr>
        <tr>
            <td><form:input type="text" path="destinationCity"/></td>
        </tr>
    </table>
    <button type="submit">enter</button>
</form:form>
</body>
</html>
