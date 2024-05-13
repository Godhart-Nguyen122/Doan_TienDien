
package Controller.DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;
import Controller.DBS;
import Model.Invoices;
import java.sql.Connection;

public class InvoicesDAO {
    private List<Invoices>invoiceslist=new ArrayList<>();
    
    public List<Invoices> getAll() throws Exception{
        this.invoiceslist.clear();
        String SQL="SELECT * FROM INVOICES";
           try(
            Connection con = new DBS().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
        ){
            while(rs.next()){
                  Invoices tmp =new Invoices();
                  tmp.setId(rs.getInt("ID"));
                  tmp.setInvoice_Date(rs.getString("Invoice_Date"));
                  tmp.setInvoice_Status(rs.getBoolean("Invoice_Status"));
                  tmp.setStart_Num(rs.getInt("Start_Num"));
                  tmp.setEnd_Num(rs.getInt("End_Num"));
                  tmp.setTotal_Price(rs.getDouble("Total_Price"));
                  tmp.setID_E_Meter_Details(rs.getInt("ID_Details"));
                  tmp.setID_Staff_Write(rs.getInt("ID_Staff_Write"));
                  this.invoiceslist.add(tmp);
            }
        }
        return invoiceslist;
    } 
}
