package Controller.QLPhanQuyenTKController;

import Controller.DAO.AccountsDAO;
import Controller.SupportFunction.StringProcessing;
import LayMotSoUIdepTaiDay.BangDanhSach;
import Model.Accounts;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class DSTaiKhoanPhanQuyen {
    private static List<Accounts> ListAccount;

    public static List<Accounts> KhoiTaoListAccount() {
        try {
            setListAccount(new AccountsDAO().getAll());
            return ListAccount;
        } catch (Exception ex) {
            Logger.getLogger(DSTaiKhoanPhanQuyen.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static List<Accounts> getListAccount() {
        return ListAccount;
    }

    public static void setListAccount(List<Accounts> ListAccount) {
        DSTaiKhoanPhanQuyen.ListAccount = ListAccount;
    }
    
    public static void Add(Accounts Acc){
        new AccountsDAO().AddDAO(Acc);
        ListAccount.add(Acc);
    }
    
    public static void Delete(String Account){
        new AccountsDAO().DeleteDAO(Account);
        int index = SearchIndexAccount(Account);
        Accounts Acc = ListAccount.get(index);
        Acc.setStatus(true);
        ListAccount.set(index, Acc);
    }

    public static void Unlock(String Account){
        new AccountsDAO().UnlockDAO(Account);
        int index = SearchIndexAccount(Account);
        Accounts Acc = ListAccount.get(index);
        Acc.setStatus(false);
        ListAccount.set(index, Acc);
    }
    
    public static void Update(Accounts Acc, Accounts AccCu){
        new AccountsDAO().UpdateTTCDAO(Acc);
        int index = SearchIndexAccount(AccCu.getAccount_Username());
        ListAccount.set(index, Acc);        
    }

    public static void UpdatePrivilege(Accounts Acc){
        new AccountsDAO().UpdatePrivilegeDAO(Acc);
        int index = SearchIndexAccount(Acc.getAccount_Username());
        ListAccount.set(index, Acc);        
    }
    
    //Số lượng chủ hộ
    public static int CustomerQuantity(){
        int num = 0;
        for(Accounts Acc : ListAccount){
            if(Acc.getPrivilege() == 0)
                num++;
        }
        return num;
    }
    
    //Số lượng nhân viên
    public static int StaffQuantity(){
        int num = 0;
        for(Accounts Acc : ListAccount){
            if(Acc.getPrivilege() == 1)
                num++;
        }
        return num;        
    }
    
    public static Accounts SearchObjAccount(String Account){
        for(Accounts Acc : ListAccount)
            if(Acc.getAccount_Username().equals(Account))
                return Acc;
        return null;
    }
    
    public static int SearchIndexAccount(String Account){
        int index = 0;
        for(Accounts Acc : ListAccount){
            if(Acc.getAccount_Username().equals(Account))
                return index;
            index++;
        }
        return -1;
    }    
    
    public static boolean Searching(String Text, BangDanhSach bangDanhSach, int type){
        boolean check = false;   
        if(type == 1){
            check = new StringProcessing().StringSearchingTable(bangDanhSach, Text, 0);
        }else if(type == 2){
            check = new StringProcessing().StringSearchingTable(bangDanhSach, Text, 1);       
        }
        return check;
    }
    
    public static void Filter(int loaiLoc, int thuocTinh, BangDanhSach bangDanhSach){
        DefaultTableModel model = (DefaultTableModel) bangDanhSach.getModel();
        if(thuocTinh == 1){
            if(loaiLoc == 1){
                new StringProcessing().StringFiltering(bangDanhSach, "Nhân viên", 3);
            }else if(loaiLoc == 2){
                new StringProcessing().StringFiltering(bangDanhSach, "Chủ hộ", 3);                
            }else if(loaiLoc == 3){
                for(int row = 0; row < bangDanhSach.getRowCount(); row++){
                    String value = (String) bangDanhSach.getValueAt(row, 3);
                    if(value.equals("(Chưa phân quyền)")){
                        model.removeRow(row);
                        row--;
                    }
                }                
            }else if(loaiLoc == 4){
                new StringProcessing().StringFiltering(bangDanhSach, "(Chưa phân quyền)", 3);               
            }
        }else if(thuocTinh == 2){
            if(loaiLoc == 1){
                new StringProcessing().StringFiltering(bangDanhSach, "Mở", 4);
            }else if(loaiLoc == 2){
                new StringProcessing().StringFiltering(bangDanhSach, "Đã bị khóa", 4);                
            }            
        }else if(thuocTinh == 3){
            if(loaiLoc == 1){
                Map<String, Integer> SolanLapCCCD = new HashMap<>();
                List<String> CCCD = new ArrayList<>();
                
                for(int i = 0; i < bangDanhSach.getRowCount(); i++){
                    String value = (String) bangDanhSach.getValueAt(i, 0);
                    SolanLapCCCD.put(value, SolanLapCCCD.getOrDefault(value, 0) + 1);
                }               
                
                for(String Key : SolanLapCCCD.keySet()){
                    Integer Values = SolanLapCCCD.get(Key);
                    if(Values == 2)
                        CCCD.add(Key);
                }
                
                
                for(int i = 0; i < bangDanhSach.getRowCount(); i++){           
                    String value = (String) bangDanhSach.getValueAt(i, 0);
                    if(CCCD.contains(value)){
                        model.removeRow(i);
                        i--;
                    }
                }
            }else if(loaiLoc == 2){
                Map<String, Integer> SolanLapCCCD = new HashMap<>();
                List<String> CCCD = new ArrayList<>();
                
                for(int i = 0; i < bangDanhSach.getRowCount(); i++){
                    String value = (String) bangDanhSach.getValueAt(i, 0);
                    SolanLapCCCD.put(value, SolanLapCCCD.getOrDefault(value, 0) + 1);
                }               
                               
                for(String Key : SolanLapCCCD.keySet()){
                    Integer Values = SolanLapCCCD.get(Key);
                    if(Values == 1)
                        CCCD.add(Key);
                }               
                
                for(int i = 0; i < bangDanhSach.getRowCount(); i++){                
                    String value = (String) bangDanhSach.getValueAt(i, 0);
                    if(CCCD.contains(value)){
                        model.removeRow(i);
                        i--;
                    }
                }
            }            
        }
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
        }     
    }
}
