package Model;

import java.util.List;

public class E_Meters {
    private String ID_E_Meter;
    private String CCCD;
    private String Address;
    private String Type_Living;
    
    private List <Invoices> ListInvoice;

    public List<Invoices> getListInvoice() {
        return ListInvoice;
    }

    public void setListInvoice(List<Invoices> ListInvoice) {
        this.ListInvoice = ListInvoice;
    }
    
    public E_Meters() {}

    public E_Meters(String ID_E_Meter, String CCCD, String Address, String Type_Living) {
        this.ID_E_Meter = ID_E_Meter;
        this.CCCD = CCCD;
        this.Address = Address;
        this.Type_Living = Type_Living;
    }

    public String getID_E_Meter() {
        return ID_E_Meter;
    }

    public void setID_E_Meter(String ID_E_Meter) {
        this.ID_E_Meter = ID_E_Meter;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getType_Living() {
        return Type_Living;
    }

    public void setType_Living(String Type_Living) {
        this.Type_Living = Type_Living;
    }
    
}
