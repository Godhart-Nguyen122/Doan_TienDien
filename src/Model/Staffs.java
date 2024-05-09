package Model;

import java.util.List;

public class Staffs extends Accounts{
    private List<Customers> ListCustomers;
    private boolean role;

    public Staffs() {}
    
    public Staffs(String Account_Username, String CCCD, String Account_Password, int Privilege, boolean Status) {
        super(Account_Username, CCCD, Account_Password, Privilege, Status);
    }
    
    public Staffs(String Account_Username, String CCCD, String Account_Password, int Privilege, boolean Status, boolean Role) {
        super(Account_Username, CCCD, Account_Password, Privilege, Status);
        this.role=role;
    }
    
    public Staffs(Personal_Infos Ps, Accounts acc) {
        this.setAccount_Username(acc.getAccount_Username());
        this.setAccount_Password(acc.getAccount_Password());
        this.setCCCD(Ps.getCCCD());
        this.setDOB(Ps.getDOB());
        this.setFirstname(Ps.getFirstname());
        this.setLastname(Ps.getLastname());
        this.setMiddleName(Ps.getMiddleName());
        this.setPhone(Ps.getPhone());
        this.setPrivilege(acc.getPrivilege());
        this.setSex(Ps.isSex());
        this.setStatus(acc.isStatus());
        this.setAddress(Ps.getAddress());
        
        
    }
    
    
    public List<Customers> getListCustomers() {
        return ListCustomers;
    }

    public void setListCustomers(List<Customers> ListCustomers) {
        this.ListCustomers = ListCustomers;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }
    
    
}
