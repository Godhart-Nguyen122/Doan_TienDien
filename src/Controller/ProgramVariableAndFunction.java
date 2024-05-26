
package Controller;

import Controller.DAO.CustomerDAO;
import Controller.DAO.PhanCongDAO;
import Controller.DSNhanVienController.DSNhanVien;
import Model.Accounts;
import Model.Customers;
import Model.Staffs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgramVariableAndFunction {
    private static Accounts LoginAccount = new Accounts();
    private List<Staffs>stafflist=new ArrayList<>();
    private List<Customers>cuslist=new ArrayList<>();
    private Map<Integer,List<Integer>> combinedMap = new HashMap<>();
 
    public Map<Integer, List<Integer>> combineLists() throws Exception {
        this.combinedMap.clear();
        this.stafflist=new DSNhanVien().KhoiTaoListStaffs();
        this.cuslist=new CustomerDAO().getAll();
        List<Integer>tmp=new ArrayList<>();
        // Combine lists when lengths are equal
        if (stafflist.size() == cuslist.size()) {
            for (int i = 0; i < stafflist.size(); i++) {
                int idStaff=new PhanCongDAO().getIDStaffByUserName(this.stafflist.get(i).getCCCD());
                int idCus=new CustomerDAO().getIdCustomerbyCCCD(this.cuslist.get(i).getCCCD());
                tmp.add(idCus);
                combinedMap.put(idStaff,tmp);
                tmp.clear();
            }
        } else if (stafflist.size() < cuslist.size()) { // Combine lists when length of A is less than B
            int i;
            for (i = 0; i < stafflist.size(); i++) {
                int idStaff=new PhanCongDAO().getIDStaffByUserName(this.stafflist.get(i).getCCCD());
                int idCus=new CustomerDAO().getIdCustomerbyCCCD(this.cuslist.get(i).getCCCD());
                tmp.add(idCus);
                combinedMap.put(idStaff, tmp);
                tmp.clear();
            }
            
            // Map remaining elements of B with empty string
            for (int j = i; j < cuslist.size(); j++) {
                int idStaff=new PhanCongDAO().getIDStaffByUserName(this.stafflist.get(j-stafflist.size()).getCCCD());
                int idCus=new CustomerDAO().getIdCustomerbyCCCD(this.cuslist.get(j).getCCCD()); 
                combinedMap.get(idStaff).add(idCus);     
            }
        } else { // Combine lists when length of A is greater than B
            int i;
            for (i = 0; i < cuslist.size(); i++) {
                int idStaff=new PhanCongDAO().getIDStaffByUserName(this.stafflist.get(i).getCCCD());
                int idCus=new CustomerDAO().getIdCustomerbyCCCD(this.cuslist.get(i).getCCCD());
                tmp.add(idCus);
                combinedMap.put(idStaff, tmp);
                tmp.clear();            
            }
            // Map remaining elements of A with empty string
            for (int j = i; j < stafflist.size(); j++) {
                int idStaff=new PhanCongDAO().getIDStaffByUserName(this.stafflist.get(i).getCCCD());
                combinedMap.put(idStaff,tmp);
            }
        }
        return combinedMap;
    }

    public static String getLoginAccount() {
        return LoginAccount.getAccount_Username();
    }

    public static void setLoginAccount(String Account_Username) {
        ProgramVariableAndFunction.LoginAccount.setAccount_Username(Account_Username);
    }
    
    
    
}
