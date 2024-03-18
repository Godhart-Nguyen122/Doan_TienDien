package Controller.QLPhanQuyenTKController;

import Controller.DAO.AccountsDAO;
import Model.Accounts;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DSTaiKhoanPhanQuyen {
    private List<Accounts> ListAccount;

    public DSTaiKhoanPhanQuyen(){
        try {
            this.ListAccount = new AccountsDAO().getAll();
        } catch (Exception ex) {
            Logger.getLogger(DSTaiKhoanPhanQuyen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Accounts> getListAccount() {
        return ListAccount;
    }

    public void setListAccount(List<Accounts> ListAccount) {
        this.ListAccount = ListAccount;
    }
    
    //Số lượng chủ hộ
    public int CustomerQuantity(){
        int num = 0;
        for(Accounts Acc : ListAccount){
            if(Acc.getPrivilege() == 0)
                num++;
        }
        return num;
    }
    
    //Số lượng nhân viên
    public int StaffQuantity(){
        int num = 0;
        for(Accounts Acc : ListAccount){
            if(Acc.getPrivilege() == 1)
                num++;
        }
        return num;        
    }
}
