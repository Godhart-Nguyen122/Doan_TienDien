/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.CustomersController.ThongTinController;

import Controller.DAO.Customer_InfoDAO;
import Model.Customer_Info;

/**
 *
 * @author vduct
 */
public class ThongTinController {
    private Customer_InfoDAO customerDao = null;

    public ThongTinController() {
        this.customerDao = new Customer_InfoDAO();
    }
    
    public Customer_Info getInfo() throws Exception{
        return this.customerDao.getInfo();
    }
    
    public void updateInfo(Customer_Info ci){
        this.customerDao.updateInfo(ci);
    }
    
    public int updateMK(Customer_Info ci, String mkc){
        return this.customerDao.updateMK(ci, mkc);
    }
}
