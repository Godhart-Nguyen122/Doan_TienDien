
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
import java.sql.PreparedStatement;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.sql.Date;

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
                  tmp.setID_E_Meter_Details(rs.getInt("ID_Details"));
                  tmp.setID_Staff_Write(rs.getInt("ID_Staff_Write"));
                  tmp.setLevel(rs.getInt("Level"));
                  
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
                tmp.setCurrentNum(rs.getInt(4));
                tmp.setLevel(rs.getInt(3));
                tmp.setID_Staff_Write(rs.getInt(5));
                tmp.setID_Staff_Input(rs.getInt(6));
                tmp.setInvoicePaied_Date(DateDBToString.DateToString(rs.getDate(7)));
                
                this.invoiceslist.add(tmp);
            }

            //System.out.println("Success!");
        } catch (SQLException ex) {
            Logger.getLogger(InvoicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return invoiceslist;
    } 
    public boolean addNewInvoice(Invoices in) throws Exception{
        String SQL = "INSERT INTO INVOICES (Invoice_Date, Invoice_Status, ID_Details, Level, ID_Staff_Write) VALUES (?, ?, ?, ?, ?)";
        try{
           Connection con = new DBS().getConnection();
           PreparedStatement  pstmt =con.prepareStatement(SQL);
           
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
           LocalDate invoiceLocalDate = null;
           try {
                invoiceLocalDate = LocalDate.parse(in.getInvoice_Date(), formatter);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // Convert LocalDate to java.sql.Date
            Date invoiceDate = Date.valueOf(invoiceLocalDate);
            pstmt.setDate(1, invoiceDate);
            pstmt.setBoolean(2,false);
            pstmt.setInt(3,in.getID_E_Meter_Details());
            pstmt.setInt(4, in.getLevel());
            pstmt.setInt(5, in.getID_Staff_Write());
            // Execute the insert
            int rowsInserted = pstmt.executeUpdate();
            if(rowsInserted>0){
             
                return true;
            }

        }catch(Exception e){
     
            e.printStackTrace();        }
        return false;
    } 
    
    public boolean deleteInvoice(int invoiceId){
        String SQL = "DELETE FROM INVOICES WHERE ID = ?";
        try{
           Connection con = new DBS().getConnection();
           PreparedStatement  pstmt =con.prepareStatement(SQL);

            pstmt.setInt(1, invoiceId);
            // Execute the insert
            int rowsInserted = pstmt.executeUpdate();
            if(rowsInserted>0){
                return true;
            }
        }
        catch(Exception e){
            e.printStackTrace();        
        }
        return false;
    }
    public boolean payInvoice(int invoiceId,String invoicePayment){
        String SQL = "UPDATE INVOICES SET Invoice_Status = ? WHERE ID = ?";
        String SQL2="INSERT INTO [dbo].[PAID_INVOICES] ([ID_INVOICES], [Date], [Invoice_PayMethod]) VALUES (?, ?, ?)";
        try{
            Connection con = new DBS().getConnection();
            PreparedStatement  pstmt =con.prepareStatement(SQL);
            pstmt.setBoolean(1, true);
            pstmt.setInt(2, invoiceId);
            // Execute the insert
            int rowsInserted = pstmt.executeUpdate();
            if(rowsInserted>0){
                try{
                    PreparedStatement pstmt2=con.prepareStatement(SQL2);
                    Date utilDate = new Date(System.currentTimeMillis());
                    // Convert java.util.Date to java.sql.Date
                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                    //set data
                    pstmt2.setInt(1, invoiceId);
                    pstmt2.setDate(2, sqlDate);
                    pstmt2.setString(3, invoicePayment);
                    int rowsInserted2 = pstmt2.executeUpdate();
                    if(rowsInserted2>0){
                        return true;
                    }else{
                        return false;
                    } 
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else{
                return false;
            }
        }
        catch(Exception e){
            e.printStackTrace();        
        }
        return false;
    }
}
