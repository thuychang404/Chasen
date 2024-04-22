<%-- 
    Document   : showVT
    Created on : Nov 3, 2023, 10:17:11 AM
    Author     : vuong
--%>

<%@page import="java.util.*" %>
<%@page import="Model.HistoryDevices" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Chasen</title>
        <link rel="stylesheet" href="../css/style.css">
    </head>
    <body>
        <div class="app">
            <h2>Danh sách lịch sử thiết bị</h2>
            <p>Có ${length} lịch sử trong CSDL</p>
            <table>
                <tr>
                    <th>ID </th>
                    <th>device</th>
                    <th>status</th>
                    <th>readingTime</th>
                    <!--<th>Action</th>-->
                </tr>
                <%
                List<HistoryDevices> deviceList = new ArrayList<>();
                Object deviceAttribute = request.getAttribute("deviceList");

                if (deviceAttribute != null) {
                    if (deviceAttribute instanceof ArrayList) {
                        deviceList = (ArrayList<HistoryDevices>) deviceAttribute;
                    } else if (deviceAttribute instanceof HistoryDevices) {
                        // If it's a single VatTu object, add it to the list
                        deviceList.add((HistoryDevices) deviceAttribute);
                    }
                }

                for (HistoryDevices data : deviceList) {
                %>
                    <!-- Table rows to display item details -->
                    <tr>
                        <td><%= data.getId() %></td>
                        <td><%= data.getDevice() %></td>
                        <td><%= data.getStatus() %></td>
                        <td><%= data.getReadingTime() %></td>
<!--                        <td>
                            <button class="edit-btn">
                                <% 
                                    out.print("<a href='updateservlet?title=Sửa+data&action=updateservlet&id="+data.getId()+"'>Sửa</a>");
                                %>
                            </button>
                            <button>
                                <% 
                                    out.print("<a href='deleteservlet?id="+data.getId()+"'>Xoá</a>");
                                %>
                            </button>
                        </td>-->
                    </tr>
    
                <%
                }
                %>

                <%
                %>
                
            </table>
                
            <button class="add-btn">
                <a href="addservlet?title=Thêm+data&action=addservlet">Thêm mặt hàng</a>
            </button>
                
            <button class="add-btn">
                <a href="/sapxep">Sắp xếp</a>
            </button>
            <script src="./main.js"></script>
        </div>
    </body>
</html>
