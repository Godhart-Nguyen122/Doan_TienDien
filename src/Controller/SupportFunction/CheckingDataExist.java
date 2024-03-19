package Controller.SupportFunction;

import Controller.QLThongTinChungController.DSThongTinChung;
import Model.Personal_Infos;

public class CheckingDataExist {
    public boolean CheckExistCCCD(String CCCD){
        for(Personal_Infos Ps : new DSThongTinChung().getListPersonal_Infos())
            if(Ps.getCCCD().equals(CCCD))
                return true;
        return false;
    }
    
}
