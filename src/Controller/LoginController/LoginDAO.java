
package Controller.LoginController;

import Database.DBS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDAO {
    
    public boolean Login(String userName,String passWord) throws Exception{
        Connection cnn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean isValid = false;
       
        try {
            cnn = DBS.getConnection();
            String SQL="SELECT COUNT(A.CCCD) AS Count,Privilege FROM ACCOUNT A WHERE A.Account_Username=? AND A.Account_Password=? ";
            preparedStatement = cnn.prepareStatement(SQL);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, passWord);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int count = resultSet.getInt("Count");
                isValid = count > 0; 
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        
        } 
        return isValid;
    }
    
    public int getPrivilege(String userName, String passWord) throws Exception{
        Connection cnn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int privilege=0;
        try{
            cnn = DBS.getConnection();
            String SQL="SELECT COUNT(A.CCCD) AS Count,Privilege FROM ACCOUNT A WHERE A.Account_Username=? AND A.Account_Password=? ";
            preparedStatement = cnn.prepareStatement(SQL);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, passWord);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                privilege=resultSet.getInt("Privilege");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return privilege;
    }
    
    public void UpdateLogin(String CCCD,String userName,String passWord) throws Exception{
        Connection cnn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            cnn=DBS.getConnection();
            String SQL="UPDATE ACCOUNT\n" +
                        "SET Account_Password =?\n" +
                        "WHERE CCCD = ? AND Account_Username = ?";
            preparedStatement=cnn.prepareStatement(SQL);
            preparedStatement.setString(1, passWord);
            preparedStatement.setString(2, CCCD);
            preparedStatement.setString(3, userName);
            preparedStatement.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public boolean CheckUsername(String cccd,String username) throws Exception{
        Connection cnn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String tmp="";
        try{
            cnn=DBS.getConnection();
            String SQL="SELECT Account_Username FROM ACCOUNT WHERE CCCD=?";
            preparedStatement=cnn.prepareStatement(SQL);
            preparedStatement.setString(1,cccd);
            ResultSet re=preparedStatement.executeQuery();
            while(re.next()){
                tmp=re.getString("Account_Username");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return tmp.equals(username);
    }
}
