/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.CustomerView.DSHoaDon;

import Controller.DAO.InvoicesDAO;
import Model.Invoices;
import java.util.List;

/**
 *
 * @author vduct
 */
public class DSHoaDon {
    private InvoicesDAO inDao = null;

    public DSHoaDon() {
        this.inDao = new InvoicesDAO();
    }
    
    public List<Invoices> getAllInCase(int i) throws Exception{
        return this.inDao.getAllInCase(i);
    } 
}
