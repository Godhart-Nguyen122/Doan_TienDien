package Controller.SupportFunction;

import Controller.QLPhanQuyenTKController.DSTaiKhoanPhanQuyen;
import Controller.QLThongTinChungController.DSThongTinChung;
import Model.Accounts;
import Model.Personal_Infos;
import java.util.ArrayList;
import java.util.List;

public class CheckingDataExist {
    public static boolean CheckExistCCCD(String CCCD, Personal_Infos ps){
        List<Personal_Infos> list = new ArrayList<>(new DSThongTinChung().getListPersonal_Infos());
        if(ps != null){
            int index = DSThongTinChung.SearchIndexCCCD(ps.getCCCD());
            list.remove(index);
        }
        for(Personal_Infos Ps : list)
            if(Ps.getCCCD().equals(CCCD))
                return true;
        return false;
    }
    
    public static boolean CheckExistAccount(String Account, Accounts Acc){
        List<Accounts> list = new ArrayList<>(new DSTaiKhoanPhanQuyen().getListAccount());
        if(Acc != null){
            int index = DSTaiKhoanPhanQuyen.SearchIndexAccount(Acc.getAccount_Username());
            list.remove(index);
        }
        for(Accounts acc : list)
            if(acc.getAccount_Username().equals(Account))
                return true;
        return false;
    }
    
    public static boolean CheckExistPhone(String Sdt, Personal_Infos ps){
        List<Personal_Infos> list = new ArrayList<>(new DSThongTinChung().getListPersonal_Infos());
        if(ps != null){
            int index = DSThongTinChung.SearchIndexCCCD(ps.getCCCD());
            list.remove(index);
        }
        for(Personal_Infos Ps : list)
            if(Ps.getPhone().equals(Sdt))
                return true;            
        return false;
    }    
    
    public static boolean CheckDuplicateAcc(String CCCD){
        int i = 0;
        for(Accounts Acc : new DSTaiKhoanPhanQuyen().getListAccount()){
            if(Acc.getCCCD().equals(CCCD))
                i++;
            if(i == 2)
                return true;
        }
        return false;
    }

    public static boolean CheckDuplicatePrivilege(String CCCD, int Privilege){
        for(Accounts Acc : new DSTaiKhoanPhanQuyen().getListAccount()){
            if(Acc.getCCCD().equals(CCCD)){
                if(Privilege == Acc.getPrivilege())
                    return true;
            }
        }
        
        return false;
    }    
    
    public boolean KtraIDCongTo(String ID){
        if (ID.length() != 8 || !ID.matches("[0-9]+"))
            return false;        
        return true;       
    }
    
    public boolean CheckExistID_E_Meter(String ID){
//        for(ThongTinSuDung thongTinSuDung : new DSThongTinSDController().getLstThongTinSuDungs()){
//            String idE_Meter = thongTinSuDung.getID_E_Meter();
//            if(idE_Meter != null && idE_Meter.equals(ID))
//                return false;            
//        }
        return true;
    }
}
