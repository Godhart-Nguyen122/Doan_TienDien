package Controller.SupportFunction;

import Controller.QLThongTinChungController.DSThongTinChung;
import Model.Personal_Infos;

public class CheckingDataExist {
    public static boolean CheckExistCCCD(String CCCD){
        for(Personal_Infos Ps : new DSThongTinChung().getListPersonal_Infos())
            if(Ps.getCCCD().equals(CCCD))
                return true;
        return false;
    }

    public static boolean CheckExistPhone(String Sdt){
        for(Personal_Infos Ps : new DSThongTinChung().getListPersonal_Infos())
            if(Ps.getPhone().equals(Sdt))
                return true;
        return false;
    }    
    
}
