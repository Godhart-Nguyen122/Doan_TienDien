
package Controller.InvoicesController;

import Controller.DBS;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class InvoiceDAO {
    
    public BigDecimal Gettotalprice() throws Exception{
        String SQL="SELECT SUM(I.Total_Price) AS Total \n" +
                     "FROM INVOICES AS I;";
        BigDecimal total = null;
        try(
            Connection con = new DBS().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            ){
         while(rs.next()){
            total=rs.getBigDecimal("Total");
         }
        }
        return total;
    }
}
