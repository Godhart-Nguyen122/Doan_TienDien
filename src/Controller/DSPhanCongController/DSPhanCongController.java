
package Controller.DSPhanCongController;

import Controller.DAO.CustomerDAO;
import Controller.DAO.Personal_InfosDAO;
import Controller.DAO.PhanCongDAO;
import Controller.DSChuHoController.DSChuHo;
import Model.Customers;
import Model.Personal_Infos;
import java.util.ArrayList;
import java.util.List;

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
}
