package Model;

import java.sql.Date;
import java.util.List;

public class Customers extends Personal_Infos{
    private List<E_Meters> ListE_Meter;
    private int id_staff;
    private String account_username;
    private String password;
    
    public Customers() {}

    public List<E_Meters> getListE_Meter() {
        return ListE_Meter;
    }

    public void setListE_Meter(List<E_Meters> ListE_Meter) {
        this.ListE_Meter = ListE_Meter;
    }

    public int getId_staff() {
        return id_staff;
    }

    public void setId_staff(int id_staff) {
        this.id_staff = id_staff;
    }

    public String getAccount_username() {
        return account_username;
    }

    public void setAccount_username(String account_username) {
        this.account_username = account_username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Customers(String account_username, String password, String CCCD, String Firstname, String Lastname, String MiddleName, String Address, String Phone, Date DOB, boolean Sex) {
        super(CCCD, Firstname, Lastname, MiddleName, Address, Phone, DOB, Sex);
        this.account_username = account_username;
        this.password = password;
    }
    
    public Customers(String CCCD, String Firstname, String Lastname, String MiddleName, String Address, String Phone, Date DOB, boolean Sex) {
        super(CCCD, Firstname, Lastname, MiddleName, Address, Phone, DOB, Sex);
    }
    
}
