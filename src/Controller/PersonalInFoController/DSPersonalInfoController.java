package Controller.PersonalInFoController;

import Model.Personal_Infos;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DSPersonalInfoController {
    private List<Personal_Infos> dsPerson;

    public DSPersonalInfoController() {
        try {
            this.dsPerson = new PersonalInfoDAO().getAll();
        } catch (Exception ex) {
            Logger.getLogger(DSPersonalInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Personal_Infos> getDsPerson() {
        return dsPerson;
    }

    public void setDsPerson(List<Personal_Infos> dsPerson) {
        this.dsPerson = dsPerson;
    }   
}
