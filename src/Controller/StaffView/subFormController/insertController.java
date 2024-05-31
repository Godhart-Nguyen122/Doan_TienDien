
package Controller.StaffView.subFormController;

import Controller.DAO.E_MeterDAO;
import Controller.DAO.E_Meter_DetailsDAO;
import Controller.DAO.InvoicesDAO;
import Model.E_Meter_Details;
import Model.E_Meters;
import Model.Invoices;
import java.util.ArrayList;
import java.util.List;


public class insertController {
    private List<E_Meters>lst=new ArrayList<>();
    private List<E_Meter_Details>detialLst=new ArrayList<>();
    List<Invoices>invoiceses=new ArrayList<>();

    public insertController() throws Exception {
        this.lst=new E_MeterDAO().getAll();
        this.detialLst=new E_Meter_DetailsDAO().getAll();
        this.invoiceses=new InvoicesDAO().getAll();
    }
    
    public List<E_Meters>getlistEbyIdCus(int idCus){
        List<E_Meters>result=new ArrayList<>();
        for(E_Meters tmp:this.lst){
            if(tmp.getID_Customer()==idCus){
                result.add(tmp);
            }
        }
        return result;
    }
    public List<E_Meter_Details>getListEmeterDetaibtIdEmeter(String idemeter){
        List<E_Meter_Details>result=new ArrayList<>();
        for(E_Meter_Details tmp:this.detialLst){
            if(tmp.getID_E_Meter().equals(idemeter)){
                result.add(tmp);
            }
        }
        return result;
    }
    public boolean addNewInvoice(Invoices in) throws Exception{
        return new InvoicesDAO().addNewInvoice(in);
    }
    public boolean checkExistInvoice(int iddetail){
        for(Invoices tmp:this.invoiceses){
            if(tmp.getID_E_Meter_Details()==iddetail){
                return true;
            }
        }
        return false;
    }
}
