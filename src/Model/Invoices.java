package Model;

public class Invoices {
    private int id;
    private String Invoice_Date;
    private boolean Invoice_Status;
    private int Start_Num;
    private int End_Num;
    private Double Total_Price;
    private int ID_E_Meter_Details;
    private int ID_Staff_Write;
    
    public Invoices() {
    }

    public Invoices(int id, String Invoice_Date, boolean Invoice_Status, int Start_Num, int End_Num, Double Total_Price, int ID_E_Meter_Details, int ID_Staff_Write) {
        this.id = id;
        this.Invoice_Date = Invoice_Date;
        this.Invoice_Status = Invoice_Status;
        this.Start_Num = Start_Num;
        this.End_Num = End_Num;
        this.Total_Price = Total_Price;
        this.ID_E_Meter_Details = ID_E_Meter_Details;
        this.ID_Staff_Write = ID_Staff_Write;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getID_E_Meter_Details() {
        return ID_E_Meter_Details;
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

    public int getStart_Num() {
        return Start_Num;
    }

    public void setStart_Num(int Start_Num) {
        this.Start_Num = Start_Num;
    }

    public int getEnd_Num() {
        return End_Num;
    }

    public void setEnd_Num(int End_Num) {
        this.End_Num = End_Num;
    }

    public Double getTotal_Price() {
        return Total_Price;
    }

    public void setTotal_Price(Double Total_Price) {
        this.Total_Price = Total_Price;
    }
    
}
