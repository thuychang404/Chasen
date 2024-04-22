<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="Model.DataSensors" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Chasen</title>
    <link rel="stylesheet" href="../css/style.css" />
</head>
<body>
    <div class="app">
        <h2>Danh sách sắp xếp mặt hàng theo điều kiện</h2>
        <p>Có ${length} mặt hàng trong danh sách.</p>
        
        <table>
            <tr>
                <th>ID </th>
                <th>temperature</th>
                <th>humid</th>
                <th>intensity</th>
                <th>readingTime</th>
            </tr>

            <%
            List<DataSensors> dataList = (List<DataSensors>) request.getAttribute("dataList");

            if (dataList != null) {
                for (DataSensors data : dataList) {
            %>
                <!-- Table rows -->
                <tr>
                    <td><%= data.getId() %></td>
                    <td><%= data.getTemperature() %></td>
                    <td><%= data.getHumid() %></td>
                    <td><%= data.getIntensity() %></td>
                    <td><%= data.getReadingTime() %></td>
                </tr>
            <%
                }
            }
            %>

        </table>

        <button class="add-btn">
            <a href="addservlet?title=Thêm+Data&action=addservlet">Thêm Data</a>
        </button>
        
        <button class="add-btn">
            <a href="/getservlet">Quay lại trang chính</a>
        </button>

        <script src="./main.js"></script>
    </div>
</body>
</html>
