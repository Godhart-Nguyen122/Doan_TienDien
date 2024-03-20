package Controller.QLThongTinChungController;

import Controller.DAO.Personal_InfosDAO;
import Model.Personal_Infos;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DSThongTinChung {
    private static List<Personal_Infos> ListPersonal_Infos;

    public DSThongTinChung(){
        try {
            this.ListPersonal_Infos = new Personal_InfosDAO().getAll();
        } catch (Exception ex) {
            Logger.getLogger(DSThongTinChung.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<Personal_Infos> getListPersonal_Infos() {
        return ListPersonal_Infos;
    }

    public static void setListPersonal_Infos(List<Personal_Infos> ListPersonal_Infos) {
        DSThongTinChung.ListPersonal_Infos = ListPersonal_Infos;
    }
    
    public static void Add(Personal_Infos Ps){
        new Personal_InfosDAO().AddDAO(Ps);
        ListPersonal_Infos.add(Ps);
    }
    
    public static void Update_NoCCCD(Personal_Infos Ps){
        new Personal_InfosDAO().Update_NoCCCDDAO(Ps);
        Personal_Infos Ps_Cu = SearchObjCCCD(Ps.getCCCD());
        int index = ListPersonal_Infos.indexOf(Ps_Cu);
        ListPersonal_Infos.set(index, Ps);
    }
    
    public static void UpdateCCCD(String CCCD_Cu, String CCCD_Moi){
        new Personal_InfosDAO().UpdateCCCDDAO(CCCD_Cu, CCCD_Moi);
        Personal_Infos Ps = SearchObjCCCD(CCCD_Cu);
        int index = ListPersonal_Infos.indexOf(Ps);
        Ps.setCCCD(CCCD_Moi);
        ListPersonal_Infos.set(index, Ps);        
    }
    
    public static Personal_Infos SearchObjCCCD(String CCCD){
        for(Personal_Infos Ps : ListPersonal_Infos){
            if(Ps.getCCCD().equals(CCCD))
                return Ps;
        }
        return null;
    }
    
}
