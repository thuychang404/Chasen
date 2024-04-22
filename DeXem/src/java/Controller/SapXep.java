/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DataSensorsHandler;
import Model.DataSensors;

import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.Collections;
 import java.util.Comparator;
/**
 *
 * @author vuong
 */
@WebServlet("/sapxep")
public class SapXep extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    private static final long serialVersionUID = 1L;
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        // My code
        DataSensorsHandler dataDAO = new DataSensorsHandler();
        ArrayList <DataSensors> dataList = dataDAO.getAllDataSensors();
        
        Collections.sort(dataList, new Comparator<DataSensors>() {
            @Override
            public int compare(DataSensors d1, DataSensors d2) {
                int id1 = d1.getId();
                int id2 = d2.getId();
                // Sử dụng phép trừ để so sánh
                return id1 - id2;
            }
        });
                        
        request.setAttribute("length", dataList.size());
        request.setAttribute("dataList", dataList);
        request.getRequestDispatcher("showSX.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
