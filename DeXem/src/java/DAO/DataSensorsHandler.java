/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.util.*;
import java.sql.*;

import Model.DataSensors;
import java.text.SimpleDateFormat;

/**
 *
 * @author trang
 */
public class DataSensorsHandler extends DBConnect {
    Connection con = DBConnect();
    public int save(DataSensors e)
    {
        int status = 0;
        try
        {
            PreparedStatement ps =con.prepareStatement ("insert into DataSensors(temperature, humid, intensity) values (?,?,?)");
//            ps.setInt (1, e.getId ());
            ps.setFloat (1, e.getTemperature());
            ps.setFloat (2, e.getHumid());
            ps.setFloat (3, e.getIntensity());
                        
            status = ps.executeUpdate ();
            con.close ();
        } 
        catch (Exception ex)
        {
            ex.printStackTrace ();
        }
        return status;
    }
    
    public int update (DataSensors e)
    {
        int status = 0;
        try
        {
            java.util.Date currentDate = new java.util.Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = formatter.format(currentDate);
            
            PreparedStatement ps = con.prepareStatement ("update DataSensors set temperature=?, humid=?, intensity=?, readingTime=? where id=?;");
            ps.setFloat (1, e.getTemperature());
            ps.setFloat (2, e.getHumid());
            ps.setFloat (3, e.getIntensity());
            // ? cần một hàm thời gian hiện tại?
            ps.setString (4, formattedDate);
            
            status = ps.executeUpdate ();
            con.close ();
        } 
        catch (Exception ex)
        {
            ex.printStackTrace ();
        }
        return status;
    }
    
    public int delete (int id)
    {
        int status = 0;
        try
        {
            PreparedStatement ps =con.prepareStatement ("delete from DataSensors where id=?");
            ps.setInt (1, id);
            status = ps.executeUpdate ();
            con.close ();
        } 
        catch (Exception e)
        {
            e.printStackTrace ();
        }
        return status;
    }
    
    public DataSensors getDataSensorsById (int id)
    {
        DataSensors e = new DataSensors();
        try
        {
            
            PreparedStatement ps =con.prepareStatement ("select * from DataSensors where id=?");
            ps.setInt (1, id);
            ResultSet rs = ps.executeQuery ();
            if (rs.next ())
            {
                e.setId (rs.getInt(1));
                e.setTemperature (rs.getFloat (2));
                e.setHumid (rs.getFloat (3));        
                e.setIntensity (rs.getFloat (4));
                e.setReadingTime (rs.getString(5));

            }
            con.close ();
        }
        catch (Exception ex)
        {
            ex.printStackTrace ();
        }
        return e;
    }
    
    public ArrayList < DataSensors > getAllDataSensors ()
    {
        ArrayList<DataSensors> list = new ArrayList<DataSensors>();
        try
        {
            PreparedStatement ps = con.prepareStatement ("select * from DataSensors;");
            ResultSet rs = ps.executeQuery ();
            while (rs.next ())
            {
                DataSensors e = new DataSensors ();
                e.setId (rs.getInt(1));
                e.setTemperature (rs.getFloat (2));
                e.setHumid (rs.getFloat (3));        
                e.setIntensity (rs.getFloat (4));
                e.setReadingTime (rs.getString(5));   

                list.add (e);
            }
            con.close ();
        }
        catch (Exception e)
        {
            e.printStackTrace ();
        }
        return list;
    }
    
    public ArrayList<DataSensors> findDataSensorsWithTemperature() {
        
        ArrayList<DataSensors> list = new ArrayList<DataSensors>();

        try {
            String query = "select * from DataSensors where temperature=?";

            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                DataSensors data = new DataSensors();
                data.setId(rs.getInt("id"));
                data.setTemperature(rs.getFloat("temperature"));
                data.setHumid(rs.getFloat("humid"));
                data.setIntensity(rs.getFloat("intensity"));
                data.setReadingTime(rs.getString("readingTime"));
                
                list.add(data);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
