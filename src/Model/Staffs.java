package Model;

import java.sql.Date;
import java.util.List;

public class Staffs extends Personal_Infos{
    private List<Customers> ListCustomers;

    public Staffs() {}
    
    public Staffs(String CCCD, String Firstname, String Lastname, String MiddleName, String Address, String Phone, Date DOB, boolean Sex) {
        super(CCCD, Firstname, Lastname, MiddleName, Address, Phone, DOB, Sex);
    }
    public List<Customers> getListCustomers() {
        return ListCustomers;
    }

    public void setListCustomers(List<Customers> ListCustomers) {
        this.ListCustomers = ListCustomers;
    }
        
}
