package Controller.DAO;
import Controller.DBS;
import Model.Accounts;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountsDAO {
    private List<Accounts> ListAccountDAO = new ArrayList<>();

    public List<Accounts> getListAccountDAO() {
        return ListAccountDAO;
    }

    public void setListAccountDAO(List<Accounts> ListAccountDAO) {
        this.ListAccountDAO = ListAccountDAO;
    }
    
    public List<Accounts> getAll() throws Exception{
        ListAccountDAO.clear();
        String SQL = "SELECT * FROM [dbo].[ACCOUNTS]";
        try(
            Connection con = new DBS().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
        ){
            while(rs.next()){
                  Accounts Acc = new Accounts();
                  Acc.setAccount_Username(rs.getString("Account_Username"));
                  Acc.setCCCD(rs.getString("CCCD"));
                  Acc.setAccount_Password(rs.getString("Account_Password"));
                  Acc.setPrivilege(rs.getInt("Privilege"));          
                  Acc.setStatus(rs.getBoolean("Status"));  
                  
                  ListAccountDAO.add(Acc);
            }
        }
        return ListAccountDAO;
    }    
}
