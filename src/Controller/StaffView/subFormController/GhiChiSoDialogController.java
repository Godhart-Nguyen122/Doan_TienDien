
package Controller.StaffView.subFormController;

import Controller.DAO.E_Meter_DetailsDAO;
import Model.E_Meter_Details;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class GhiChiSoDialogController {
  
    public static  E_Meter_Details getLastRecordbyEmeterID(String emeterId) throws Exception{
       return new E_Meter_DetailsDAO().getLastRecordbyEmeterID(emeterId);
    }
    public static boolean addNewEmeterDetail(E_Meter_Details cs){
       return new E_Meter_DetailsDAO().addNewE_EmeterDetail(cs);
    }
    public static boolean checkifExistDetail(E_Meter_Details cs){
       return new E_Meter_DetailsDAO().checkifExistEmeterDetail(cs);
    }
}
