/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.DAO;

import Controller.DBS;
import Controller.ProgramVariableAndFunction;
import Model.Customer_Info;
import Model.Customers;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author vduct
 */
public class Customer_InfoDAO {
    private List<Customer_Info>listcustomer =new ArrayList<>();
    
      // Lấy thông tin khách hàng 
      public Customer_Info getInfo() throws Exception{
        Customer_Info personInfo=new Customer_Info();  
        
        String SQL = "SELECT pis.CCCD, (pis.Firstname+' '+pis.Middlename+' '+pis.Lastname) as FULLNAME, pis.Address, pis.Phone, pis.DOB, pis.Sex, acc.Account_Username, acc.Account_Password\n" +
                    "FROM CUSTOMERS cs inner join ACCOUNTS acc on cs.Account_Customer = acc.Account_Username\n" +
                    "inner join PERSON_INFOS pis on acc.CCCD = pis.CCCD\n" +
                    "where cs.Account_Customer = '"+ProgramVariableAndFunction.getLoginAccount()+"'";
        try(
            Connection con = new DBS().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
        ){
            while(rs.next()){
                personInfo.setCCCD(rs.getString(1));
                personInfo.setName(rs.getString(2));
                personInfo.setAddress(rs.getString(3));
                personInfo.setPhone(rs.getString(4));
                personInfo.setDOB(rs.getDate(5));                
                personInfo.setSex(rs.getBoolean(6));
                personInfo.setAccount(rs.getString(7));
                personInfo.setPassword(rs.getString(8));
            }
        }
        return personInfo;
    }   
      
    //Dùng cho form Khách hàng
    public List<Customer_Info> getAllCustomer(String cccd) throws Exception{
        listcustomer.clear();
        String SQL = "SELECT P.CCCD, (P.Firstname+' '+P.Middlename+' '+P.Lastname) as FULLNAME, P.DOB, P.Address, P.Phone, P.Sex \n" +
                    "FROM PERSON_INFOS P\n"+
                    "WHERE P.CCCD<>'"+ cccd.trim() +"'\n";
        try(
            Connection con = new DBS().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
        ){
            while(rs.next()){
                    String cccd1 = "";
                    Customer_Info customerInfo=new Customer_Info();
                    customerInfo.setCCCD(rs.getString(1));
                    customerInfo.setName(rs.getString(2));
                    customerInfo.setDOB(rs.getDate(3));
                    customerInfo.setAddress(rs.getString(4));
                    customerInfo.setPhone(rs.getString(5));                
                    customerInfo.setSex(rs.getBoolean(6));
                    cccd1 = customerInfo.getCCCD();
                    listcustomer.add(customerInfo);
            }
        }
        return listcustomer;
    }
    
    public void updateInfo(Customer_Info ci){
        String SQL = "UPDATE [dbo].[PERSON_INFOS]\n" +
                     "SET [DOB] = ?,\n" +
                     "	  [Address] = ?,\n" +
                     "	  [Phone] = ?\n" +
                     "WHERE [CCCD] = ?";
      try {
            Connection con = new DBS().getConnection();
            PreparedStatement stmt = con.prepareStatement(SQL);
                        
            stmt.setDate(1, ci.getDOB());
            stmt.setString(2, ci.getAddress());
            stmt.setString(3, ci.getPhone());
            stmt.setString(4, ci.getCCCD());

            int affectedRows = stmt.executeUpdate();
        
            if (affectedRows > 0) {
                System.out.println("Thông báo hệ thống đã cập nhật thành công!");
            } else {
                System.out.println("Cập nhật người dùng trên hệ thống thất bại!!!");
            }
        } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Lỗi hệ thống!!! (Personal_InfosDAO) - Update");
        }
    }
    
    public int updateMK(Customer_Info ci, String mkc){
        String SQL = "UPDATE ACCOUNTS\n" +
                     "SET Account_Password = ?\n" +
                     "WHERE Account_Username = ? AND Account_Password = ?";
        
        int affectedRows = 0;
      try {
            Connection con = new DBS().getConnection();
            PreparedStatement stmt = con.prepareStatement(SQL);
                        
            stmt.setString(1, ci.getPassword());
            stmt.setString(2, ProgramVariableAndFunction.getLoginAccount());
            stmt.setString(3, mkc);

            affectedRows = stmt.executeUpdate();
        } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Lỗi hệ thống!!! (Personal_InfosDAO) - Update");
        }
        return affectedRows;
    }
}
