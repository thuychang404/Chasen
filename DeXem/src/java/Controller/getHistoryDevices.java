/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.HistoryDevicesHandler;
import Model.HistoryDevices;
import java.util.ArrayList;

/**
 *
 * @author vuong
 */
@WebServlet("/getHistoryDevices")
public class getHistoryDevices extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    private static final long serialVersionUID = 1L;
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        // My code
        HistoryDevicesHandler deviceDAO = new HistoryDevicesHandler();
        ArrayList <HistoryDevices> deviceList = deviceDAO.getAllHistoryDevices();
        request.setAttribute("length", deviceList.size());
        request.setAttribute("deviceList", deviceList);
        request.getRequestDispatcher("showDevice.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
