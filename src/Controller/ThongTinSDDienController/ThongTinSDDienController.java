
package Controller.ThongTinSDDienController;

import Controller.DAO.CustomerDAO;
import Controller.DAO.E_MeterDAO;
import Controller.DAO.Personal_InfosDAO;
import Controller.DSNhanVienController.DSNhanVien;
import Controller.SupportFunction.StringProcessing;
import LayMotSoUIdepTaiDay.BangDanhSach;
import Model.Customers;
import Model.E_Meters;
import Model.Personal_Infos;
import Model.Staffs;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class ThongTinSDDienController {
    
    public List<E_Meters> getListEmeter() throws Exception{
        return new E_MeterDAO().getAll();
    }
    public List<Customers>getListCustomer() throws Exception{
        return new CustomerDAO().getAll();
    }
    public List<Staffs>getListStaff(){
        return DSNhanVien.KhoiTaoListStaffs();
    }
    public Personal_Infos SearchStaffTheoId(int id) throws Exception{
        return new Personal_InfosDAO().getStaffInfosbyID(id);
    } 
    public int getIdCustomerbyCCCD(String CCCD){
        return new CustomerDAO().getIdCustomerbyCCCD(CCCD);
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
                new StringProcessing().StringSortingTable(bangDanhSach, 4, true);
            else
                new StringProcessing().StringSortingTable(bangDanhSach, 4, false);             
        }else if(thuocTinh == 4){
            if(loaiSapXep == 1)
                new StringProcessing().StringSortingTable(bangDanhSach, 2, true);
            else
                new StringProcessing().StringSortingTable(bangDanhSach, 2, false);             
        }else if(thuocTinh == 5){
            if(loaiSapXep == 1)
                new StringProcessing().StringSortingTable(bangDanhSach, 5, true);
            else
                new StringProcessing().StringSortingTable(bangDanhSach, 5, false);             
        }
        else if(thuocTinh == 6){
            if(loaiSapXep == 1)
                new StringProcessing().StringSortingTable(bangDanhSach, 3, true);
            else
                new StringProcessing().StringSortingTable(bangDanhSach, 3, false);       
        
        }     
    }  
}
