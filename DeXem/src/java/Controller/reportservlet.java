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

@WebServlet ("/reportservlet")
public class reportservlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter ();
        
        String id_str = (String) request.getParameter("id").trim();
        String temperature_str = (String) request.getParameter("temperature").trim();
        String humid_str = (String) request.getParameter("humid").trim();
        String intensity_str = (String) request.getParameter("intensity").trim();
        String readingTime = (String) request.getParameter("readingTime").trim();
        
        int id = Integer.parseInt(id_str);
        float temperature = Float.parseFloat(temperature_str);
        float humid = Float.parseFloat(humid_str);
        float intensity = Float.parseFloat(intensity_str);
        
        DataSensors data = new DataSensors (id, temperature, humid, intensity, readingTime);
        
        out.println("<!DOCTYPE html>");
        out.println("<html lang ='vi'>");
        out.println("<head>");
        out.println("<meta charset=\'UTF-8\'>");
        out.println("<title>Chang Storage</title>");            
        out.println("</head>");
        out.println("<body>");
        
        DataSensorsHandler dataDAO = new DataSensorsHandler ();
        if (dataDAO.save(data)==1)
        {
            out.print ("<p>Record saved successfully!</p>");
            request.getRequestDispatcher ("showData.jsp").include (request, response);
        }
        else
        {
            out.println ("Damn! You are such a loser! Can't even do a simple CRUD web!");
        }
        
        out.print ("</table>");
        out.println("</body>");
        out.println("</html>");
        
        out.close ();
    }
}