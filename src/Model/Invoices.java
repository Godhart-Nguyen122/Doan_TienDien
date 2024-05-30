package Model;

public class Invoices {
    private int id;
    private String Invoice_Date;
    private boolean Invoice_Status;
    private int ID_E_Meter_Details;
    private int ID_Staff_Write;
    private String staff_name;
    private int currentNum;
    private int level;

    public int getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(int currentNum) {
        this.currentNum = currentNum;
    }
    
    public Invoices() {
    }

    public Invoices(int id, String Invoice_Date, boolean Invoice_Status, int ID_E_Meter_Details,int level ,int ID_Staff_Write) {
           this.id = id;
           this.Invoice_Date = Invoice_Date;
           this.Invoice_Status = Invoice_Status;
           this.ID_E_Meter_Details = ID_E_Meter_Details;
           this.level=level;
           this.ID_Staff_Write = ID_Staff_Write;
       }
    public int getId() {
        return id;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getID_E_Meter_Details() {
        return ID_E_Meter_Details;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setID_E_Meter_Details(int ID_E_Meter_Details) {
        this.ID_E_Meter_Details = ID_E_Meter_Details;
    }

    public int getID_Staff_Write() {
        return ID_Staff_Write;
    }

    public void setID_Staff_Write(int ID_Staff_Write) {
        this.ID_Staff_Write = ID_Staff_Write;
    }
    

    public String getInvoice_Date() {
        return Invoice_Date;
    }

    public void setInvoice_Date(String Invoice_Date) {
        this.Invoice_Date = Invoice_Date;
    }


    public boolean isInvoice_Status() {
        return Invoice_Status;
    }

    public void setInvoice_Status(boolean Invoice_Status) {
        this.Invoice_Status = Invoice_Status;
    }

    
}
