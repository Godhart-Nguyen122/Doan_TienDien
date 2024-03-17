
package Controller.LoginController;

import Controller.DAO.LoginDAO;

public class LoginController {
    
    public boolean login(String userName, String passWord) throws Exception{
        return new LoginDAO().Login(userName, passWord);
    }
    public void UpdateLogin(String CCCD,String userName ,String passWord) throws Exception{
        new LoginDAO().UpdateLogin(CCCD, userName, passWord);
    }
    public int getPrivilege(String userName, String passWord) throws Exception{
        return new LoginDAO().getPrivilege(userName, passWord);
    }
    public boolean checkUsername(String cccd,String userName) throws Exception{
        return new LoginDAO().CheckUsername(cccd, userName);
    }
    
}
