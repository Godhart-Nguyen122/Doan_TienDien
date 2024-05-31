package Model;

import java.util.List;

public class E_Meters {
    private String ID_E_Meter;
    private int ID_Customer;
    private String Address;
    private String Type_Living;
    private boolean Status ;
    
    private List <Invoices> ListInvoice;
    
   
    
    public List<Invoices> getListInvoice() {
        return ListInvoice;
    }

    @Override
    public String toString() {
        return this.ID_E_Meter;
    }

    public void setListInvoice(List<Invoices> ListInvoice) {
        this.ListInvoice = ListInvoice;
    }
    
    public E_Meters() {}

    public E_Meters(int ID_Customer, String Address, String Type_Living, boolean Status, List<Invoices> ListInvoice) {
        this.ID_Customer = ID_Customer;
        this.Address = Address;
        this.Type_Living = Type_Living;
        this.Status = Status;
        this.ListInvoice = ListInvoice;
    }

    public E_Meters(String ID_E_Meter, int ID_Customer, String Address, String Type_Living, boolean Status, List<Invoices> ListInvoice) {
        this.ID_E_Meter = ID_E_Meter;
        this.ID_Customer = ID_Customer;
        this.Address = Address;
        this.Type_Living = Type_Living;
        this.Status = Status;
        this.ListInvoice = ListInvoice;
    }

    public String getID_E_Meter() {
        return ID_E_Meter;
    }

    public int getID_Customer() {
        return ID_Customer;
    }

    public String getAddress() {
        return Address;
    }

    public String getType_Living() {
        return Type_Living;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setID_E_Meter(String ID_E_Meter) {
        this.ID_E_Meter = ID_E_Meter;
    }

    public void setID_Customer(int ID_Customer) {
        this.ID_Customer = ID_Customer;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setType_Living(String Type_Living) {
        this.Type_Living = Type_Living;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    

   
    
}
