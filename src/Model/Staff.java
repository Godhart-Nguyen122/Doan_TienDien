
package Model;

import java.sql.Date;

public class Staff {
      private String CCCD;
    private String Username;    
    private String Address;
    private String Phone;
    private Date DOB;
    private String phai;

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getUsername() {
        return Username;
    }

    public String getPhai() {
        return phai;
    }

    public void setPhai(String phai) {
        this.phai = phai;
    }

    public void setUsername(String Username) {
        this.Username = Username;
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
    
    public Staff(String CCCD, String Username, String Address, String Phone, Date DOB) {
        this.CCCD = CCCD;
        this.Username = Username;
        this.Address = Address;
        this.Phone = Phone;
        this.DOB = DOB;
    }
    
    public Staff(){};

    public String getAccount() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getPassword() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
