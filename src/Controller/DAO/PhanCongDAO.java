
package Controller.DAO;

import Controller.DBS;
import Model.Customers;
import Model.Staffs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class PhanCongDAO {
    
    public int getIDStaffByUserName(String Account_Username) throws SQLException, Exception{
        String SQL="SELECT ID FROM STAFFS S WHERE S.Account_Staffs=?";
        
        Connection cnn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int id=0;
        try{
            cnn = DBS.getConnection();
            preparedStatement = cnn.prepareStatement(SQL);
            preparedStatement.setString(1, Account_Username);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                id=resultSet.getInt("ID");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return id;
    }
    public boolean  addIdStafftoCustomer(int idStaff, int idCustomer) throws Exception{
        String SQL="UPDATE CUSTOMERS\n" +
                    "SET ID_Staff_Input =  ? \n" +
                    "WHERE CUSTOMERS.ID=? ";
        boolean tmp=false;
        Connection cnn = null;
        PreparedStatement preparedStatement = null;
        try{
            cnn=DBS.getConnection();
             preparedStatement = cnn.prepareStatement(SQL);
             preparedStatement.setInt(1,idStaff);
             preparedStatement.setInt(2,idCustomer);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Đã phân công !!!");
                tmp=true;
            } else {
                System.out.println("Lỗi không thể phân công!!!");
               
            }            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return tmp;
    }
}
