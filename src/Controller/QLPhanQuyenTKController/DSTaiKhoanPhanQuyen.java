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
    
    public void Add(Accounts Acc){
        new AccountsDAO().AddDAO(Acc);
        ListAccount.add(Acc);
    }
    
    public void Delete(String CCCD){
        new AccountsDAO().DeleteDAO(CCCD);
        Accounts Acc = SearchObjAccount(CCCD);
        int index = ListAccount.indexOf(Acc);
        Acc.setStatus(true);
        ListAccount.set(index, Acc);
    }
    
    public void Update(Accounts Acc){
        new AccountsDAO().UpdateDAO(Acc);
        Accounts Acc_Cu = SearchObjAccount(Acc.getCCCD());
        int index = ListAccount.indexOf(Acc_Cu);
        ListAccount.set(index, Acc);        
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
    
    public Accounts SearchObjAccount(String CCCD){
        for(Accounts Acc : ListAccount)
            if(Acc.getCCCD().equals(CCCD))
                return Acc;
        return null;
    }
}
