
package Controller.DAO;

import Model.Customers;
import java.util.ArrayList;
import java.util.List;
import Controller.DBS;
import Model.Accounts;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CustomerDAO {
    private List<Customers>listcustomer =new ArrayList<Customers>();
      // Lấy thông tin của tất cả chủ hộ  
      public List<Customers> getAll() throws Exception{
        listcustomer.clear();
        String SQL = "SELECT P.CCCD, P.Firstname, P.Lastname, P.Middlename, P.DOB, P.Address, P.Phone, P.Sex ,C.ID_Staff_Input ,C.ID_Staff_Write\n" +
                    "FROM CUSTOMERS C\n" +
                    "JOIN ACCOUNTS A ON C.Account_Customer = A.Account_Username\n" +
                    "JOIN PERSON_INFOS P ON A.CCCD = P.CCCD\n" +
                    "WHERE A.Status=0;";
        try(
            Connection con = new DBS().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
        ){
            while(rs.next()){
                  Customers tmp=new Customers();
                  tmp.setCCCD(rs.getString("CCCD"));
                  tmp.setFirstname(rs.getString("Firstname"));
                  tmp.setLastname(rs.getString("Lastname"));
                  tmp.setMiddleName(rs.getString("Middlename")); 
                  tmp.setDOB(rs.getDate("DOB"));
                  tmp.setAddress(rs.getString("Address"));
                  tmp.setPhone(rs.getString("Phone"));
                  tmp.setSex(rs.getBoolean("Sex"));
                  tmp.setId_Staff(rs.getInt("ID_Staff_Input"));
                  tmp.setId_Staff_Write(rs.getInt("ID_Staff_Write"));
                  listcustomer.add(tmp);
            }
        }
        return listcustomer;
    }
    public Customers getIdStaffWriteandInputbyCCCD(String cccd) throws Exception{
        //Vietlai nhu nay copy do luoi -..- 
        Customers tmp=new Customers();
         String SQL = "SELECT P.CCCD, P.Firstname, P.Lastname, P.Middlename, P.DOB, P.Address, P.Phone, P.Sex ,C.ID_Staff_Input\n" +
                    "FROM CUSTOMERS C\n" +
                    "JOIN ACCOUNTS A ON C.Account_Customer = A.Account_Username\n" +
                    "JOIN PERSON_INFOS P ON A.CCCD = P.CCCD\n" +
                    "WHERE A.Status=0 AND P.CCCD=?;";
           try (
        Connection con = new DBS().getConnection();
        PreparedStatement pre = con.prepareStatement(SQL);
        ) {
            pre.setString(1, cccd); // Set the parameter ID value
        try (ResultSet rs = pre.executeQuery()) {
            while (rs.next()) {
                tmp.setCCCD(rs.getString("CCCD"));
                  tmp.setFirstname(rs.getString("Firstname"));
                  tmp.setLastname(rs.getString("Lastname"));
                  tmp.setMiddleName(rs.getString("Middlename")); 
                  tmp.setDOB(rs.getDate("DOB"));
                  tmp.setAddress(rs.getString("Address"));
                  tmp.setPhone(rs.getString("Phone"));
                  tmp.setSex(rs.getBoolean("Sex"));
                  tmp.setId_Staff(rs.getInt("ID_Staff_Input"));
                  tmp.setId_Staff_Write(rs.getInt("ID_Staff_Write"));
            }
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tmp;
    } 
      
    public Customers getCustomerbyId(int idcus) throws Exception{
        Customers tmp=new Customers();
        String SQL = "SELECT P.CCCD, P.Firstname, P.Lastname, P.Middlename, P.DOB, P.Address, P.Phone, P.Sex ,C.ID_Staff_Input\n" +
                    "FROM CUSTOMERS C\n" +
                    "JOIN ACCOUNTS A ON C.Account_Customer = A.Account_Username\n" +
                    "JOIN PERSON_INFOS P ON A.CCCD = P.CCCD\n" +
                    "WHERE A.Status=0 AND C.ID=?;";
        try (
        Connection con = new DBS().getConnection();
        PreparedStatement pre = con.prepareStatement(SQL);
        ) {
            pre.setInt(1, idcus); // Set the parameter ID value
        try (ResultSet rs = pre.executeQuery()) {
            while (rs.next()) {
                tmp.setCCCD(rs.getString("CCCD"));
                  tmp.setFirstname(rs.getString("Firstname"));
                  tmp.setLastname(rs.getString("Lastname"));
                  tmp.setMiddleName(rs.getString("Middlename")); 
                  tmp.setDOB(rs.getDate("DOB"));
                  tmp.setAddress(rs.getString("Address"));
                  tmp.setPhone(rs.getString("Phone"));
                  tmp.setSex(rs.getBoolean("Sex"));
                  tmp.setId_Staff(rs.getInt("ID_Staff_Input"));
            }
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tmp;
    }
    public int getIdCustomerbyCCCD(String CCCD){
        int customerID=0;
        String SQL="SELECT ID \n" +
                    "FROM ACCOUNTS A \n" +
                    "JOIN CUSTOMERS C ON A.Account_Username = C.Account_Customer \n" +
                    "WHERE A.CCCD = ?";
        
        try {
            Connection cnn = DBS.getConnection();
            PreparedStatement pre = cnn.prepareStatement(SQL);
            pre.setString(1, CCCD);
            ResultSet re=pre.executeQuery();
            while(re.next()){
                customerID=re.getInt("ID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
      return  customerID;
    }
}
