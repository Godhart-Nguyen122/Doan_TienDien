
package Controller.DSPhanCongController;

import Controller.DAO.CustomerDAO;
import Controller.DAO.Personal_InfosDAO;
import Controller.DAO.PhanCongDAO;
import Controller.DSChuHoController.DSChuHo;
import Controller.SupportFunction.StringProcessing;
import LayMotSoUIdepTaiDay.BangDanhSach;
import Model.Customers;
import Model.Personal_Infos;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class DSPhanCongController {
    //Lấy danh sách nhân viên ghi nc 
    private List<Personal_Infos>personal_InfosNV=new ArrayList<>();
    private List<Customers>personal_InfosCH=new ArrayList<>();
    
    
    public List<Personal_Infos> getAllStaffGhincInfo()throws Exception{
        personal_InfosNV=new Personal_InfosDAO().getAllStaffGhincInfo();
        return this.personal_InfosNV;
    }
    //Lấy danh sách chủ hộ chưa phân công 
    public List<Customers> getAllCustomers() throws Exception{
        personal_InfosCH=new CustomerDAO().getAll();
        return this.personal_InfosCH;
    }
    //Show ra danh sách các chủ hộ , lấy id của nhân viên có trong danh sách chủ hộ đó
    //Search ra và trả về đối tượng nhân viên đó 
    public Personal_Infos SearchStaffTheoId(int id) throws Exception{
        return new Personal_InfosDAO().getStaffInfosbyID(id);
    }
    public int getIdStaffByAccountUsername(String AccountUsername) throws Exception{
        return new PhanCongDAO().getIDStaffByUserName(AccountUsername);
    }
    public boolean addId_Staff_Input_toCustomer(int idStaff ,int idCustomer) throws Exception{
        return new  PhanCongDAO().addIdStafftoCustomer(idStaff, idCustomer);
    }
    public int getIdCustomerbyCCCD(String CCCD){
        return new CustomerDAO().getIdCustomerbyCCCD(CCCD);
    }
    public boolean updateId_Staff_Input_toCustomer(int idStaff, int idCustomer) throws Exception{
        return new PhanCongDAO().addIdStafftoCustomer(idStaff, idCustomer);
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
            check = new StringProcessing().StringSearchingTable(bangDanhSach, Text, 5);          
        }
        else if(type == 5){
            check = new StringProcessing().StringSearchingTable(bangDanhSach, Text, 3);          
        } else if(type == 6){
            check = new StringProcessing().StringSearchingTable(bangDanhSach, Text, 4);          
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
                new StringProcessing().StringSortingTable(bangDanhSach, 2, true);
            else
                new StringProcessing().StringSortingTable(bangDanhSach, 2, false);             
        }else if(thuocTinh == 3){
            if(loaiSapXep == 1)
                new StringProcessing().StringSortingTable(bangDanhSach, 4, true);
            else
                new StringProcessing().StringSortingTable(bangDanhSach, 4, false);             
        }else if(thuocTinh == 4){
            if(loaiSapXep == 1)
                new StringProcessing().StringSortingTable(bangDanhSach, 3, true);
            else
                new StringProcessing().StringSortingTable(bangDanhSach, 3, false);             
        }
                              
    }    
}
