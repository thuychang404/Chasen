package Controller;
import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

import Model.DataSensors;
import DAO.DataSensorsHandler;

@WebServlet("/updateservlet")  
public class updateservlet extends HttpServlet { 
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //
    }
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {  
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        
        request.setAttribute("title", request.getParameter("title"));
        request.setAttribute("action", request.getParameter("action"));
        
        String id_str = (String) request.getParameter("id");
        int id = Integer.parseInt(id_str);
        
        DataSensorsHandler itemDAO = new DataSensorsHandler();
        
        DataSensors item = itemDAO.getDataSensorsById(id);
        
        if(item == null) {
            System.out.println("Error find Student. Log in UpdateStudentServlet.");
        } else {
            request.setAttribute("item", item);
            request.getRequestDispatcher("add.jsp").forward(request, response);
        }
    }
        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        
        String id = (String) request.getParameter("id").trim();
        String temperature_str = (String) request.getParameter("temperature").trim();
        String humid_str = (String) request.getParameter("humid").trim();
        String intensity_str = (String) request.getParameter("intensity").trim();
        String readingTime = (String) request.getParameter("readingTime").trim();
        
        // Chuyen String sang Float
        float temperature = Float.parseFloat(temperature_str);
        float humid = Float.parseFloat(humid_str);
        float intensity = Float.parseFloat(intensity_str);
        
             
        DataSensors item = new DataSensors (Integer.parseInt(id), temperature, humid, intensity, readingTime);
        DataSensorsHandler itemDAO = new DataSensorsHandler();
        
        System.out.println("Data: " + item.toString());
        
        if(itemDAO.update(item)==1) {
            response.sendRedirect("/getservlet");
        } else {
            System.out.println("Update unsucessfully!");
        }
    }
}  