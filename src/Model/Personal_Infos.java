package Model;

import java.sql.Date;
import java.util.List;

public class Personal_Infos {
    private String CCCD;
    private String Firstname;    
    private String Lastname;    
    private String MiddleName;    
    private String Address;
    private String Phone;
    private Date DOB;
    private boolean Sex;
    
    public Personal_Infos() {}

    public Personal_Infos(String CCCD, String Firstname, String Lastname, String MiddleName, String Address, String Phone, Date DOB, boolean Sex) {
        this.CCCD = CCCD;
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.MiddleName = MiddleName;
        this.Address = Address;
        this.Phone = Phone;
        this.DOB = DOB;
        this.Sex = Sex;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String MiddleName) {
        this.MiddleName = MiddleName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public boolean isSex() {
        return Sex;
    }

    public void setSex(boolean Sex) {
        this.Sex = Sex;
    }
   
   
}
