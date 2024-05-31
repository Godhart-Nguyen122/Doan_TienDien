
package Model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class E_Meter_Details {
     private int id;
     private String ID_E_Meter;
     private int Current_num;
     private Date Creating_Date;
     private int ID_Staff_Input;
     private List<Invoices>invoicelist=new ArrayList<>();

    public E_Meter_Details() {
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        // Format the Date object to a String
        String strDate = formatter.format(this.Creating_Date);
        return strDate; 
    }

    
    
    public E_Meter_Details(int id, String ID_E_Meter, int Current_num, Date Creating_Date, int ID_Staff_Input) {
        this.id = id;
        this.ID_E_Meter = ID_E_Meter;
        this.Current_num = Current_num;
        this.Creating_Date = Creating_Date;
        this.ID_Staff_Input = ID_Staff_Input;
    }
    
    
    public List<Invoices> getInvoicelist() {
        return invoicelist;
    }

    public void setInvoicelist(List<Invoices> invoicelist) {
        this.invoicelist = invoicelist;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public int getID_Staff_Input() {
        return ID_Staff_Input;
    }

    public void setID_Staff_Input(int ID_Staff_Input) {
        this.ID_Staff_Input = ID_Staff_Input;
    }

    
     
    public String getID_E_Meter() {
        return ID_E_Meter;
    }

    public void setID_E_Meter(String ID_E_Meter) {
        this.ID_E_Meter = ID_E_Meter;
    }

    public int getCurrent_num() {
        return Current_num;
    }

    public void setCurrent_num(int Current_num) {
        this.Current_num = Current_num;
    }

    public Date getCreating_Date() {
        return Creating_Date;
    }

    public void setCreating_Date(Date Creating_Date) {
        this.Creating_Date = Creating_Date;
    }
     
     
}
