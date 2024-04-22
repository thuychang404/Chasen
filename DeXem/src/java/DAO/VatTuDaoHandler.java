package DAO;

import java.util.*;
import java.sql.*;

import Model.VatTu;

public class VatTuDaoHandler extends DBConnect
{
    Connection con = DBConnect();
    public int save(VatTu e)
    {
        int status = 0;
        try
        {
            PreparedStatement ps =con.prepareStatement ("insert into MatHang(mahang, tenhang, soluong) values (?,?,?)");
            ps.setString (1, e.getId ());
            ps.setString (2, e.getName ());
            ps.setString(3, e.getAmount());
            
            
            status = ps.executeUpdate ();
            con.close ();
        } 
        catch (Exception ex)
        {
            ex.printStackTrace ();
        }
        return status;
    }
    
    public int update (VatTu e)
    {
        int status = 0;
        try
        {
            
            PreparedStatement ps = con.prepareStatement ("update MatHang set tenhang=?, soluong=? where mahang=?;");
            ps.setString (1, e.getName ());
            ps.setString(2, e.getAmount());
            ps.setString (3, e.getId ());
            
            status = ps.executeUpdate ();
            con.close ();
        } 
        catch (Exception ex)
        {
            ex.printStackTrace ();
        }
        return status;
    }
    
    public int delete (String id)
    {
        int status = 0;
        try
        {
            PreparedStatement ps =con.prepareStatement ("delete from MatHang where mahang=?");
            ps.setString (1, id);
            status = ps.executeUpdate ();
            con.close ();
        } 
        catch (Exception e)
        {
            e.printStackTrace ();
        }
        return status;
    }
    
    public VatTu getVatTuById (String id)
    {
        VatTu e = new VatTu ();
        try
        {
            
            PreparedStatement ps =con.prepareStatement ("select * from MatHang where mahang=?");
            ps.setString (1, id);
            ResultSet rs = ps.executeQuery ();
            if (rs.next ())
            {
                e.setId (rs.getString(1));
                e.setName (rs.getString (2));
                e.setAmount (rs.getString (3));        
            }
            con.close ();
        }
        catch (Exception ex)
        {
            ex.printStackTrace ();
        }
        return e;
    }
    
    public ArrayList < VatTu > getAllVatTu ()
    {
        ArrayList<VatTu> list = new ArrayList<VatTu>();
        try
        {
            
            PreparedStatement ps = con.prepareStatement ("select * from MatHang");
            ResultSet rs = ps.executeQuery ();
            while (rs.next ())
            {
                VatTu e = new VatTu ();
                e.setId (rs.getString(1));
                e.setName (rs.getString (2));
                e.setAmount (rs.getString (3));     

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
    
    public ArrayList<VatTu> findVatTuWithPrice() {
        
        ArrayList<VatTu> list = new ArrayList<VatTu>();

        try {
            String query = "select mh.tenhang, nk.giaban"
                    + "from MatHang as mh"
                    + "join NhatKyBanHang as nk ON mh.mahang = nk.mahang"
                    + "where nk.giaban > 100000";

            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                VatTu vt = new VatTu();
                vt.setName(rs.getString("tenhang"));
                vt.setPrice(rs.getFloat("giaban"));
//                student.setMaSV(resultSet.getString("masv"));
                list.add(vt);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}