package Controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DataSensors;
import DAO.DataSensorsHandler;
@WebServlet("/viewservlet")  
public class viewservlet extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    private static final long serialVersionUID = 1L;
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        
        DataSensorsHandler itemDAO = new DataSensorsHandler();
        
        DataSensors item = null;
        
        String id_str = request.getParameter("id");
        int id = Integer.parseInt(id_str);
        
        item = itemDAO.getDataSensorsById(id);
        
        request.setAttribute("length", 1);
        request.setAttribute("itemList", item);
        request.getRequestDispatcher("getItems.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
        @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}