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
    
    public void AddDAO(Accounts Acc){
        String SQL = "INSERT INTO [dbo].[ACCOUNTS] \n" +
                     "VALUES(?, ?, ?, ?, 0);";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement rs = con.prepareStatement(SQL);
            
            rs.setString(1, Acc.getAccount_Username());
            rs.setString(2, Acc.getCCCD());
            rs.setString(3, Acc.getAccount_Password());
            rs.setInt(4, Acc.getPrivilege());    
            
            int rowsAffected = rs.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Đã thêm người dùng vào hệ thống!!!");
            } else {
                System.out.println("Lỗi không thể thêm người dùng vào hệ thống!!!");
            }            
            
        } catch (Exception ex) {
            System.out.println("Lỗi hệ thống!!! (AccountsDAO) - AddDAO");
        }
    }
    
    public void DeleteDAO(String CCCD){
        String SQL = "UPDATE [dbo].[ACCOUNTS]\n" +
                     "SET [Status] = 1\n" +
                     "WHERE [CCCD] = ?";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement rs = con.prepareStatement(SQL);
            
            rs.setString(1, CCCD);
            
           int rowsAffected = rs.executeUpdate();
           
           if (rowsAffected > 0) {
                System.out.println("Đã khóa account người dùng có CCCD: " + CCCD + "trên hệ thống!!!");
                
            } else {
                System.out.println("Lỗi không thể khóa account người dùng có CCCD: " + CCCD + " trên hệ thống!!!");
            }  
        } catch (Exception ex) {
            System.out.println("Lỗi hệ thống!!! (AccountsDAO) - DeleteDAO");
        }
    }
    
    public void UpdateDAO(Accounts Acc){
        String SQL = "UPDATE [dbo].[ACCOUNTS]\n" +
                     "SET [Account_Username] = ?, \n" +
                     "    [Account_Password] = ?, \n" +
                     "    [Privilege] = ? \n" +
                     "WHERE [CCCD] = ?";
      try {
            Connection con = new DBS().getConnection();
            PreparedStatement stmt = con.prepareStatement(SQL);
            
            stmt.setString(1, Acc.getAccount_Username());
            stmt.setString(2, Acc.getAccount_Password());
            stmt.setInt(3, Acc.getPrivilege());
            stmt.setString(4, Acc.getCCCD());

            int affectedRows = stmt.executeUpdate();
        
            if (affectedRows > 0) {
                System.out.println("Thông báo hệ thống đã cập nhật Account người dùng có CCCD: " + Acc.getCCCD() + " thành công!");
            } else {
                System.out.println("Cập nhật Account người dùng có CCCD: " + Acc.getCCCD() + " trên hệ thống thất bại!!!");
            }
        } catch (Exception ex) {
                System.out.println("Lỗi hệ thống!!! (AccountsDAO) - UpdateDAO");
        }           
    }
}
