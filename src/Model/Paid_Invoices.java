
package Model;

import java.util.Date;

public class Paid_Invoices {
    private int Id_Invoices;
    private Date date;

    public Paid_Invoices(int Id_Invoices, Date date) {
        this.Id_Invoices = Id_Invoices;
        this.date = date;
    }
    
    public int getId_Invoices() {
        return Id_Invoices;
    }

    public void setId_Invoices(int Id_Invoices) {
        this.Id_Invoices = Id_Invoices;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
