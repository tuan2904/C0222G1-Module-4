<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" cellpadding="5">
    <tr>
        <td>Họ và tên:</td>
        <td>Năm sinh:</td>
        <td>Giới tính:</td>
        <td>Quốc tịch:</td>
        <td>Số CMND hoặc hộ chiếu hoặc giấy thông hành hợp pháp khác:</td>
        <td>Thông tin đi lại:</td>
        <td>Số hiệu phương tiện:</td>
        <td>Số ghế:</td>
        <td>Ngày khởi hành:</td>
        <td>Ngày kết thúc:</td>
        <td>Trong vòng 14 ngày có đi đâu không:</td>
    </tr>
    <tr>
        <td>${medicalList.name}</td>
        <td>${medicalList.birthDay}</td>
        <td>${medicalList.gender}</td>
        <td>${medicalList.nationality}</td>
        <td>${medicalList.idCar}</td>
        <td>${medicalList.travelInformation}</td>
        <td>${medicalList.vehicleNumber}</td>
        <td>${medicalList.seats}</td>
        <td>${medicalList.dateStart}</td>
        <td>${medicalList.dateEnd}</td>
        <td>${medicalList.destinationCity}</td>
    </tr>
</table>
</body>
</html>
