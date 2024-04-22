package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DataSensorsHandler;

@WebServlet(name = "DeleteServlet", urlPatterns = {"/deleteservlet"})
public class deleteservlet extends HttpServlet
{
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    private static final long serialVersionUID = 1L;
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
        response.setContentType ("text/html;charset=UTF-8");
        
        String id_str = request.getParameter("id");
        int id = Integer.parseInt(id_str);
        
        DataSensorsHandler dataDAO = new DataSensorsHandler();
        if (dataDAO.delete(id)==1) {
            System.out.println("Delete data sucessfully.");
            
        } else {
            System.out.println("Delete unsuccessfully. Log at DeleteStudentSerlvet.");
        }
        response.sendRedirect("/getservlet");
    }
}