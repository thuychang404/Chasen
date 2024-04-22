/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DataSensorsHandler;
import Model.DataSensors;


/**
 * Servlet implementation class addservlet
 */
@WebServlet(name = "addservlet", urlPatterns = "/addservlet")
public class addservlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType ("text/html;charset=UTF-8");
    }

 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
  *      response)
  */
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        
        request.setAttribute("title", request.getParameter("title"));
        request.setAttribute("action", request.getParameter("action"));
        request.getRequestDispatcher("add.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest (request, response);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter ();
        
//        String id_str = (String) request.getParameter("id").trim();
        String temperature_str = (String) request.getParameter("temperature").trim();
        String humid_str = (String) request.getParameter("humid").trim();
        String intensity_str = (String) request.getParameter("intensity").trim();
//        String readingTime = (String) request.getParameter("readingTime").trim();
        
//        int id = Integer.parseInt(id_str);
        float temperature = Float.parseFloat(temperature_str);
        float humid = Float.parseFloat(humid_str);
        float intensity = Float.parseFloat(intensity_str);
        
        DataSensors data = new DataSensors (temperature, humid, intensity);
        
        DataSensorsHandler dataDAO = new DataSensorsHandler();
        System.out.println("Data:" + data.toString());
        if(dataDAO.save(data)==1) {
            System.out.println("Add successfully!");
            response.sendRedirect("/getservlet");
        } else {
            System.out.println("Add unsucessfully!");
        }
    }
    
        @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
