
package Controller.DSHoaDonController;

import Controller.DAO.CustomerDAO;
import Controller.DAO.E_MeterDAO;
import Controller.DAO.E_Meter_DetailsDAO;
import Controller.DAO.InvoicesDAO;
import Controller.DAO.Personal_InfosDAO;
import Controller.SupportFunction.StringProcessing;
import LayMotSoUIdepTaiDay.BangDanhSach;
import Model.Customers;
import Model.E_Meter_Details;
import Model.E_Meters;
import Model.Invoices;
import Model.Personal_Infos;
import java.util.List;

public class DSHoaDonController {
    
    public List<E_Meter_Details> getAllEmeterDetails() throws Exception{
        return new E_Meter_DetailsDAO().getAll();
    }
    public List<Invoices>getAllInvoices() throws Exception{
        return new InvoicesDAO().getAll();
    }
    public Personal_Infos getStaffbyId(int idStaff) throws Exception{
        return new Personal_InfosDAO().getStaffInfosbyID(idStaff);
    }
    public Customers getInfoCustomerbyIdEmeterDetail(int id) throws Exception{
        List<E_Meters>e_Meterses=new E_MeterDAO().getAll();
        List<Customers>customerses=new CustomerDAO().getAll();
        List<E_Meter_Details>listEmeterDetail=new E_Meter_DetailsDAO().getAll();
        String emeterId="";
        Customers result=null;
        int customerId=0;
        
        for(E_Meter_Details tmp: listEmeterDetail){
            if(tmp.getId()==id){
                emeterId=tmp.getID_E_Meter();
                break;
            }
        }
        for(E_Meters tmp :e_Meterses){
            if(tmp.getID_E_Meter().equals(emeterId)){
                customerId=tmp.getID_Customer();
                break;
            }
        }
        for(Customers tmp:customerses){
            if(new CustomerDAO().getIdCustomerbyCCCD(tmp.getCCCD())==customerId){
                result=tmp;
                break;
            }
        }
        return result;
    }
    
      public static boolean Searching(String Text, BangDanhSach bangDanhSach, int type){
        boolean check = false;   
        if(type == 1){
            check = new StringProcessing().StringSearchingTable(bangDanhSach, Text, 0);
        }else if(type == 2){
            check = new StringProcessing().StringSearchingTable(bangDanhSach, Text, 1);       
        }else if(type == 3){
            check = new StringProcessing().StringSearchingTable(bangDanhSach, Text, 2);         
        }else if(type == 4){
            check = new StringProcessing().StringSearchingTable(bangDanhSach, Text, 3);          
        }
        else if(type == 5){
            check = new StringProcessing().StringSearchingTable(bangDanhSach, Text, 4);          
        } else if(type == 6){
            check = new StringProcessing().StringSearchingTable(bangDanhSach, Text, 5);          
        }
        return check;
    }
     public static void Sorting(int loaiSapXep, int thuocTinh, BangDanhSach bangDanhSach){
        if(thuocTinh == 1){
            if(loaiSapXep == 1)
                new StringProcessing().StringSortingTable(bangDanhSach, 0, true);
            else
                new StringProcessing().StringSortingTable(bangDanhSach, 0, false);                
        }else if(thuocTinh == 2){
            if(loaiSapXep == 1)
                new StringProcessing().StringSortingTable(bangDanhSach, 1, true);
            else
                new StringProcessing().StringSortingTable(bangDanhSach, 1, false);             
        }else if(thuocTinh == 3){
            if(loaiSapXep == 1)
                new StringProcessing().StringSortingTable(bangDanhSach, 2, true);
            else
                new StringProcessing().StringSortingTable(bangDanhSach, 2, false);             
        }else if(thuocTinh == 4){
            if(loaiSapXep == 1)
                new StringProcessing().StringSortingTable(bangDanhSach, 3, true);
            else
                new StringProcessing().StringSortingTable(bangDanhSach, 3, false);             
        }else if(thuocTinh == 5){
            if(loaiSapXep == 1)
                new StringProcessing().StringSortingTable(bangDanhSach, 4, true);
            else
                new StringProcessing().StringSortingTable(bangDanhSach, 4, false);             
        }else if(thuocTinh == 6){
            if(loaiSapXep == 1)
                new StringProcessing().StringSortingTable(bangDanhSach, 5, true);
            else
                new StringProcessing().StringSortingTable(bangDanhSach, 5, false);             
        }
                              
    } 
     
    public static void Filter(String dateString, int loaiLoc, int thuocTinh, BangDanhSach bangDanhSach){
        if(thuocTinh == 1){
            if(loaiLoc == 1){
                new StringProcessing().StringDateFilteringTable(bangDanhSach, dateString, 4, "Ngày");
            }
            if(loaiLoc == 2){
                new StringProcessing().StringDateFilteringTable(bangDanhSach, dateString, 4, "Tháng");                
            }
            if(loaiLoc == 3){
                new StringProcessing().StringDateFilteringTable(bangDanhSach, dateString, 4, "Năm");                
            }
        }
    }
}
