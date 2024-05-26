
package Controller.DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;
import Controller.DBS;
import Controller.ProgramVariableAndFunction;
import Helper.DateDBToString;
import Model.Invoices;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public List<Invoices> getAllInCase(int i) throws Exception{
        this.invoiceslist.clear();
        Connection con = new DBS().getConnection();
        String sql = "{CALL SP_DSHOADON(?, ?)}";
        
        CallableStatement cs;
        try {
            cs = con.prepareCall(sql);
            cs.setInt(1, i);
            cs.setString(2,ProgramVariableAndFunction.getLoginAccount());
             
            ResultSet rs = cs.executeQuery();
            
            while(rs.next()){
                Invoices tmp =new Invoices();
                tmp.setId(rs.getInt(1));
                tmp.setInvoice_Date(DateDBToString.DateToString(rs.getDate(2)));
                tmp.setCurrentNum(rs.getInt(3));
                tmp.setLevel(rs.getInt(4));
                tmp.setStaff_name(rs.getString(5));
                
                this.invoiceslist.add(tmp);
            }

            //System.out.println("Success!");
        } catch (SQLException ex) {
            Logger.getLogger(InvoicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return invoiceslist;
    } 
    
}
