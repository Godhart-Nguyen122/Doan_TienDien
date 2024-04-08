
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
        String SQL = "SELECT P.CCCD, P.Firstname, P.Lastname, P.Middlename, P.DOB, P.Address, P.Phone, P.Sex ,C.ID_Staff\n" +
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
                  tmp.setId_Staff(rs.getInt("ID_Staff"));
                  listcustomer.add(tmp);
            }
        }
        return listcustomer;
    }    
    // Lấy thông tin của tất cả chủ hộ chứa cả Id Staff
//    public List<Customers>getAllCustomerHavingIdStaff() throws Exception{
//        listcustomer.clear();
//        String SQL="select A.CCCD,P.Firstname,p.Lastname,p.Middlename,p.DOB,p.Address,p.Phone,p.Sex,c.ID_Staff from CUSTOMERS C\n" +
//                    "join ACCOUNTS A on C.Account_Customer=A.Account_Username\n" +
//                    "join PERSON_INFOS P on A.CCCD =A.CCCD\n" ;
//         try(
//            Connection con = new DBS().getConnection();
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(SQL);
//        ){
//            while(rs.next()){
//                  Customers tmp=new Customers();
//                  tmp.setCCCD(rs.getString("CCCD"));
//                  tmp.setFirstname(rs.getString("Firstname"));
//                  tmp.setLastname(rs.getString("Lastname"));
//                  tmp.setMiddleName(rs.getString("Middlename")); 
//                  tmp.setDOB(rs.getDate("DOB"));
//                  tmp.setAddress(rs.getString("Address"));
//                  tmp.setPhone(rs.getString("Phone"));
//                  tmp.setSex(rs.getBoolean("Sex"));
//                  tmp.setId_Staff(rs.getInt("ID_Staff"));
//                  listcustomer.add(tmp);
//            }
//        }
//    }
//    
}
