package Model;

public class Invoices {
    private String ID_E_Meter;
    private String Invoice_Date;
    private boolean Invoice_PayMethod;
    private boolean Invoice_Status;
    private int Start_Num;
    private int End_Num;
    private Double Total_Price;

    public Invoices() {}

    public Invoices(String ID_E_Meter, String Invoice_Date, boolean Invoice_PayMethod, boolean Invoice_Status, int Start_Num, int End_Num, Double Total_Price) {
        this.ID_E_Meter = ID_E_Meter;
        this.Invoice_Date = Invoice_Date;
        this.Invoice_PayMethod = Invoice_PayMethod;
        this.Invoice_Status = Invoice_Status;
        this.Start_Num = Start_Num;
        this.End_Num = End_Num;
        this.Total_Price = Total_Price;
    }

    public String getID_E_Meter() {
        return ID_E_Meter;
    }

    public void setID_E_Meter(String ID_E_Meter) {
        this.ID_E_Meter = ID_E_Meter;
    }

    public String getInvoice_Date() {
        return Invoice_Date;
    }

    public void setInvoice_Date(String Invoice_Date) {
        this.Invoice_Date = Invoice_Date;
    }

    public boolean isInvoice_PayMethod() {
        return Invoice_PayMethod;
    }

    public void setInvoice_PayMethod(boolean Invoice_PayMethod) {
        this.Invoice_PayMethod = Invoice_PayMethod;
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
