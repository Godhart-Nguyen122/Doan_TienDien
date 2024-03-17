package Model;

import java.sql.Date;
import java.util.List;

public class Customers extends Personal_Infos{
    private List<E_Meters> ListE_Meter;

    public Customers() {}

    public List<E_Meters> getListE_Meter() {
        return ListE_Meter;
    }

    public void setListE_Meter(List<E_Meters> ListE_Meter) {
        this.ListE_Meter = ListE_Meter;
    }

    public Customers(String CCCD, String Firstname, String Lastname, String MiddleName, String Address, String Phone, Date DOB, boolean Sex) {
        super(CCCD, Firstname, Lastname, MiddleName, Address, Phone, DOB, Sex);
    }
    
}
