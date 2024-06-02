
package Controller.StaffView;

import Controller.DAO.CustomerDAO;
import Controller.DAO.E_MeterDAO;
import Controller.DAO.E_Meter_DetailsDAO;
import Controller.DAO.InvoicesDAO;
import Controller.DAO.Paid_InvoiceDAO;
import Controller.DAO.Usage_NormDAO;
import Controller.SupportFunction.StringProcessing;
import LayMotSoUIdepTaiDay.BangDanhSach;
import Model.Customers;
import Model.E_Meter_Details;
import Model.E_Meters;
import Model.Invoices;
import java.util.ArrayList;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class DSHoaDonStaffviewController {
    private List<Customers>lsCustomerses;
    private List<E_Meters>e_Meterses;
    private List<E_Meter_Details>detailses;
    private List<Invoices>invoiceses;

    public DSHoaDonStaffviewController() throws Exception {
        this.lsCustomerses=new CustomerDAO().getAll();
        this.e_Meterses=new E_MeterDAO().getAll();
        this.detailses=new E_Meter_DetailsDAO().getAll();
        this.invoiceses=new InvoicesDAO().getAll();
    }
    
    public List<Customers>getListCusMagbyIdStaffWrite(int idstaffwrite){
        System.out.println("Danh sach Chu ho trong Controller "+this.lsCustomerses.size());
        List<Customers>result=new ArrayList<>();
        for(Customers tmp:this.lsCustomerses){
            if(tmp.getId_Staff_Write()==idstaffwrite){
                result.add(tmp);
            }
        }
        System.out.println("Chieu dai danh sach chu ho trong controller sau khi da duyet :" +result.size());
        return result;
    }
    public E_Meter_Details getEdetailbyInvoiceDetialId(int detailId){
        for(E_Meter_Details tmp :this.detailses){
            if(tmp.getId()==detailId){
                return tmp;
            }
        }
        return null;
    }
    public int getIdCustomerbyEdetail(E_Meter_Details emd){
        String emeterId=emd.getID_E_Meter();
        for(E_Meters tmp:this.e_Meterses){
            if(tmp.getID_E_Meter().equals(emeterId)&& tmp.isStatus()!=true){
                 return tmp.getID_Customer();
            }
        }
        return -1;
    }
    public List<Double>getUsageNormList(){
        return new Usage_NormDAO().getAll();
    }
    public int getUsageCusNum(int emeterDetailId,int type){
         int previousNum=0;
         int usage = 0;
         int currentNum = 0;
         String idEmeter = "";
         // Find the matching E_Meter_Details by emeterDetailId
         for (E_Meter_Details tmp : detailses) {
             if (tmp.getId() == emeterDetailId) {
                 idEmeter = tmp.getID_E_Meter();
                 currentNum = tmp.getCurrent_num();
                 break;
             }
         }
         // Create a list of E_Meter_Details with the same ID_E_Meter
         System.out.println("idEmeter " +idEmeter);
         List<E_Meter_Details> tmplist = new ArrayList<>();
         for (E_Meter_Details tmp : detailses) {
             if (tmp.getID_E_Meter().equals(idEmeter)) {
                 tmplist.add(tmp);
             }
         }
         //To Make sure sort this tmpList which has the same ID_E_Meter 
         Collections.sort(tmplist,  (p1, p2) -> Integer.compare(p1.getId(), p2.getId()));
         // Calculate usage
         if (tmplist.size() == 1) {
             usage = currentNum;
         } else {
             int dem = tmplist.size();
             System.out.println("Bien Emeterdetal truyen vao la: "+emeterDetailId);
             for(int i=dem-1;i>=0;i--){
                 System.out.println("Bien dem I : "+i);
                 if(tmplist.get(i).getId()==emeterDetailId){
                     dem=i;
                     break;
                 }
             }
             //Fix truong hop gui vao iddetial =1   
             if(dem-1<0){
                dem=0;
                usage=currentNum;
                
             }else{
                dem=dem-1;
                E_Meter_Details previousMonth = tmplist.get(dem);
                int getUsageNumPreviousMonth = previousMonth.getCurrent_num();
                previousNum=getUsageNumPreviousMonth;
                usage = currentNum - getUsageNumPreviousMonth;
             }
          
         }
         //Type==0 lấy số điện sử dụng 
         //Type ==1 lấy số điện tháng trước đó
         if(type==1){
            usage=previousNum;
         }
         return usage;
    }
    public boolean deleteInvoice(int invoiceId){
        boolean result=new InvoicesDAO().deleteInvoice(invoiceId);
        return result;
    }
    public boolean payInvoice(int invoiceid,String payment){
        boolean result=new InvoicesDAO().payInvoice(invoiceid, payment);
        return result;
    }
     public static boolean Searching(String Text, BangDanhSach bangDanhSach, int type){
        boolean check = false;   
        if(type == 1){
            check = new StringProcessing().StringSearchingTable(bangDanhSach, Text, 1);
        }else if(type == 2){
            check = new StringProcessing().StringSearchingTable(bangDanhSach, Text, 2);       
        }
        return check;
    }
        public static void Sorting(int loaiSapXep, int thuocTinh, BangDanhSach bangDanhSach){
        if(thuocTinh == 1){
            if(loaiSapXep == 1)
                new StringProcessing().StringSortingTable(bangDanhSach, 1, true);
            else
                new StringProcessing().StringSortingTable(bangDanhSach, 1, false);                
        }else if(thuocTinh == 2){
            if(loaiSapXep == 1)
                new StringProcessing().StringSortingTable(bangDanhSach, 2, true);
            else
                new StringProcessing().StringSortingTable(bangDanhSach, 2, false);             
        }else if(thuocTinh == 3){
            if(loaiSapXep == 1)
                new StringProcessing().StringSortingTable(bangDanhSach, 3, true);
            else
                new StringProcessing().StringSortingTable(bangDanhSach, 3, false);             
        }else if(thuocTinh == 4){
            if(loaiSapXep == 1)
                new StringProcessing().StringSortingTable(bangDanhSach, 4, true);
            else
                new StringProcessing().StringSortingTable(bangDanhSach, 4, false);             
        }
    }
    
    public static boolean CheckIfExistInvoiceIDinPaidInvoice(int invoiceId){
        return new Paid_InvoiceDAO().CheckIfExistIdInvoice(invoiceId);
    }
        
}
