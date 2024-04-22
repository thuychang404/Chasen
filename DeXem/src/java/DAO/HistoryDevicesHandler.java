/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.util.*;
import java.sql.*;

import Model.HistoryDevices;
import java.text.SimpleDateFormat;

/**
 *
 * @author trang
 */
public class HistoryDevicesHandler extends DBConnect {
    Connection con = DBConnect();
    public int save(HistoryDevices e)
    {
        int status = 0;
        try
        {
            PreparedStatement ps =con.prepareStatement ("insert into HistoryDevices(device, status) values (?,?)");
//            ps.setInt (1, e.getId ());
            ps.setString (1, e.getDevice());
            ps.setString (2, e.getStatus());
                        
            status = ps.executeUpdate ();
            con.close ();
        } 
        catch (Exception ex)
        {
            ex.printStackTrace ();
        }
        return status;
    }
    
    public int update (HistoryDevices e)
    {
        int status = 0;
        try
        {
            java.util.Date currentDate = new java.util.Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = formatter.format(currentDate);
            
            PreparedStatement ps = con.prepareStatement ("update HistoryDevices set temperature=?, humid=?, intensity=?, readingTime=? where id=?;");
            ps.setString (1, e.getDevice());
            ps.setString (2, e.getStatus());
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
            PreparedStatement ps =con.prepareStatement ("delete from HistoryDevices where id=?");
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
    
    public HistoryDevices getHistoryDevicesById (int id)
    {
        HistoryDevices e = new HistoryDevices();
        try
        {
            
            PreparedStatement ps =con.prepareStatement ("select * from HistoryDevices where id=?");
            ps.setInt (1, id);
            ResultSet rs = ps.executeQuery ();
            if (rs.next ())
            {
                e.setId (rs.getInt(1));
                e.setDevice (rs.getString (2));
                e.setStatus (rs.getString (3));
                e.setReadingTime (rs.getString(4));

            }
            con.close ();
        }
        catch (Exception ex)
        {
            ex.printStackTrace ();
        }
        return e;
    }
    
    public ArrayList < HistoryDevices > getAllHistoryDevices ()
    {
        ArrayList<HistoryDevices> list = new ArrayList<HistoryDevices>();
        try
        {
            PreparedStatement ps = con.prepareStatement ("select * from HistoryDevices;");
            ResultSet rs = ps.executeQuery ();
            while (rs.next ())
            {
                HistoryDevices e = new HistoryDevices ();
                e.setId (rs.getInt(1));
                e.setDevice(rs.getString(2));
                e.setStatus(rs.getString(3));
                e.setReadingTime (rs.getString(4));   

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
    
    public ArrayList<HistoryDevices> findHistoryDevicesWithDevice() {
        
        ArrayList<HistoryDevices> list = new ArrayList<HistoryDevices>();

        try {
            String query = "select * from HistoryDevices where device=?";

            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                HistoryDevices history = new HistoryDevices();
                history.setId(rs.getInt("id"));
                history.setDevice(rs.getString("device"));
                history.setStatus(rs.getString("status"));
                history.setReadingTime(rs.getString("readingTime"));
                
                list.add(history);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
