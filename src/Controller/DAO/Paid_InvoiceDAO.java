
package Controller.DAO;

import Controller.DBS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Paid_InvoiceDAO {
    
    public static boolean CheckIfExistIdInvoice(int invoiceid){
        String SQL = "SELECT 1 FROM [dbo].[PAID_INVOICES] WHERE [PAID_INVOICES].[ID_INVOICES] = ?";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement rs = con.prepareStatement(SQL);
            
            rs.setInt(1, invoiceid);    
            
            try (ResultSet re = rs.executeQuery()) {
                 return re.next(); // If there is a result, the invoice ID exists
             } 
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi check existinvoiceIdin Paid_InvoiceDAO");
        }
        return false;
    }
}
