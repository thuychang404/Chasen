<%-- 
    Document   : showVT
    Created on : Nov 3, 2023, 10:17:11 AM
    Author     : vuong
--%>

<%@page import="java.util.*" %>
<%@page import="Model.DataSensors" %>

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
            <h2>Danh sách mặt hàng</h2>
            <p>Có ${length} mặt hàng trong kho</p>
            <table>
                <tr>
                    <th>ID </th>
                    <th>temperature</th>
                    <th>humid</th>
                    <th>intensity</th>
                    <th>readingTime</th>
<!--                    <th>Action</th>-->
                </tr>
                <%
                List<DataSensors> dataList = new ArrayList<>();
                Object dataAttribute = request.getAttribute("dataList");

                if (dataAttribute != null) {
                    if (dataAttribute instanceof ArrayList) {
                        dataList = (ArrayList<DataSensors>) dataAttribute;
                    } else if (dataAttribute instanceof DataSensors) {
                        // If it's a single VatTu object, add it to the list
                        dataList.add((DataSensors) dataAttribute);
                    }
                }

                for (DataSensors data : dataList) {
                %>
                    <!-- Table rows to display item details -->
                    <tr>
                        <td><%= data.getId() %></td>
                        <td><%= data.getTemperature() %></td>
                        <td><%= data.getHumid() %></td>
                        <td><%= data.getIntensity() %></td>
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
