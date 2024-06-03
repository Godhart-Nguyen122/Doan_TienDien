
package Controller.StaffView.subFormController;

import Controller.DAO.E_Meter_DetailsDAO;

public class capNhatChiSoController {
    public static boolean capNhatChiso(String CreatingDate,String idmeter,int idstaffInput,int currentNum){
        return new E_Meter_DetailsDAO().UpdateSoDien(CreatingDate, idmeter, idstaffInput, currentNum);
    }
}
