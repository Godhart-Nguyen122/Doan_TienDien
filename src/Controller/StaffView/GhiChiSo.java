/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.StaffView;

import Controller.DAO.AccountsDAO;
import Controller.DAO.CustomerDAO;
import Controller.DAO.E_MeterDAO;
import Controller.DAO.E_Meter_DetailsDAO;
import Controller.QLPhanQuyenTKController.DSTaiKhoanPhanQuyen;
import static Controller.QLPhanQuyenTKController.DSTaiKhoanPhanQuyen.setListAccount;
import Model.Accounts;
import Model.Customers;
import Model.E_Meter_Details;
import Model.E_Meters;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GhiChiSo {
    private List <E_Meter_Details> listWM=new ArrayList<>();
    private List <E_Meters>e_Meters=new ArrayList<>();
    
//    public static List <E_Meter_Details> KhoiTaoListCongTo(String ngay,int idstafflogin) {
//        try {
//            List <E_Meter_Details> listWM = new E_Meter_DetailsDAO().getChiTietCongTo(ngay,idstafflogin);
//            return listWM;
//        } catch (Exception ex) {
//            Logger.getLogger(DSTaiKhoanPhanQuyen.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
//    }
    public static List <E_Meter_Details> getAlldetailByDate(String ngay,int idstafflogin) {
        List <E_Meter_Details> listWM=new ArrayList<>();
        try {
            listWM = new E_Meter_DetailsDAO().getAlldetailByDate(ngay,idstafflogin);
            return listWM;
        } catch (Exception ex) {
            Logger.getLogger(DSTaiKhoanPhanQuyen.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    } 
    //Hàm này support cho hàm getCustomerbyIdEmeter
    public int getIDCustomerbyIdMeter(String id_e_meter) throws Exception{
          int idcustomer=0;
          this.e_Meters=new E_MeterDAO().getAll();
          for(E_Meters tmp:this.e_Meters){
              if(tmp.getID_E_Meter().equals(id_e_meter)){
                  idcustomer=tmp.getID_Customer();               
                  break;
              }
          }
          return idcustomer;
    }
    public String getAddressbyIdMeter(String id_e_meter) throws Exception{
        String result="";
         this.e_Meters=new E_MeterDAO().getAll();
          for(E_Meters tmp:this.e_Meters){
              if(tmp.getID_E_Meter().equals(id_e_meter)){
                  result=tmp.getAddress();
                  break;
              }
          }
        return result;  
    }
    
    public Customers getCustomerbyIdEmeter(String id_e_meter) throws Exception{
        Customers result=null;
        int cusId=getIDCustomerbyIdMeter(id_e_meter);
        result=new CustomerDAO().getCustomerbyId(cusId);
        return result;
    }
    public int getPreviousUsageNum(int emeterdetialId,int type) throws Exception{
        int usage=new DSHoaDonStaffviewController().getUsageCusNum(emeterdetialId,type);
        return usage;
    }
    public List<E_Meters>getListEmeterbyIdCus(int idcus) throws Exception{
        this.e_Meters=new E_MeterDAO().getAll();
        List<E_Meters>result=new ArrayList<>();
        for(E_Meters tmp:this.e_Meters){
            if(tmp.getID_Customer()==idcus){
                result.add(tmp);
            }
        }
        return result;
    }
}
