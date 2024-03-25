package Controller.QLThongTinChungController;

import Controller.DAO.Personal_InfosDAO;
import Model.Personal_Infos;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DSThongTinChungController {
    private List<Personal_Infos> ListPersonal_Infos;

    public DSThongTinChungController(){
        try {
            this.ListPersonal_Infos = new Personal_InfosDAO().getAll();
        } catch (Exception ex) {
            Logger.getLogger(DSThongTinChungController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Personal_Infos> getListPersonal_Infos() {
        return ListPersonal_Infos;
    }

    public void setListPersonal_Infos(List<Personal_Infos> ListPersonal_Infos) {
        this.ListPersonal_Infos = ListPersonal_Infos;
    }
    
    public void Add(Personal_Infos Ps){
        new Personal_InfosDAO().AddDAO(Ps);
        ListPersonal_Infos.add(Ps);
    }
    
    public void Update_NoCCCD(Personal_Infos Ps){
        new Personal_InfosDAO().Update_NoCCCDDAO(Ps);
        ListPersonal_Infos.set(ListPersonal_Infos.indexOf(Ps), Ps);
    }
    
    public void UpdateCCCD(String CCCD_Cu, String CCCD_Moi){
        new Personal_InfosDAO().UpdateCCCDDAO(CCCD_Cu, CCCD_Moi);
        Personal_Infos Ps = SearchObjCCCD(CCCD_Cu);
        ListPersonal_Infos.set(ListPersonal_Infos.indexOf(Ps), Ps);        
    }
    
    public Personal_Infos SearchObjCCCD(String CCCD){
        for(Personal_Infos Ps : ListPersonal_Infos){
            if(Ps.getCCCD().equals(CCCD))
                return Ps;
        }
        return null;
    }
    
}
