package Model;

import java.util.List;

public class Customers extends Accounts{
    private List<E_Meters> ListE_Meter;
    private int id_Staff;

    public Customers(){};

    public int getId_Staff() {
        return id_Staff;
    }

    public void setId_Staff(int id_Staff) {
        this.id_Staff = id_Staff;
    }
    
    public Customers(Personal_Infos Ps, Accounts acc) {
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
    
     public Customers(Personal_Infos Ps,int id_staff) {
        this.setCCCD(Ps.getCCCD());
        this.setDOB(Ps.getDOB());
        this.setFirstname(Ps.getFirstname());
        this.setLastname(Ps.getLastname());
        this.setMiddleName(Ps.getMiddleName());
        this.setPhone(Ps.getPhone());
        this.setSex(Ps.isSex());
        this.setAddress(Ps.getAddress());
        this.id_Staff=id_staff;
    }
     

    
    public Customers(String Account_Username, String CCCD, String Account_Password, int Privilege, boolean Status) {
        super(Account_Username, CCCD, Account_Password, Privilege, Status);
    }

    public List<E_Meters> getListE_Meter() {
        return ListE_Meter;
    }

    public void setListE_Meter(List<E_Meters> ListE_Meter) {
        this.ListE_Meter = ListE_Meter;
    }
}
