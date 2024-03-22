/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.NVController;

import Controller.DBS;
import Model.Staff;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NVDao {
    private List<Staff>lstNV=new ArrayList<>();
    
    public void Lammoi(){
        lstNV.clear();
    }
    
    public List<Staff> getAll() throws Exception{
        Lammoi();
        String SQL = """
                     SELECT P.CCCD, P.Firstname+' '+P.Middlename+' '+P.Lastname AS Username, P.DOB, P.Address, P.Phone
                     FROM [dbo].[PERSON_INFOS] AS P
                     JOIN [dbo].[ACCOUNTS] AS A
                     ON P.CCCD = A.CCCD
                     WHERE A.Privilege = 2 AND A.Status = 0""";
        try(
            Connection con = DBS.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
        ){
                
            while(rs.next()){Staff staff = new Staff();
                staff.setCCCD(rs.getString("CCCD"));
                staff.setUsername(rs.getString("Username"));
                staff.setDOB(rs.getDate("DOB"));
                staff.setAddress(rs.getString("Address"));
                staff.setPhone(rs.getString("Phone"));
                
//                staff.setAccount(rs.getString("Account_Username"));
//                staff.setPassword(rs.getString("Account_Password"));
                
                lstNV.add(staff);
            }
        }
        
        return lstNV;
    }
    
    public void ThemNVDAO(Staff nv) throws Exception{
        String[] nameSplit = nv.getUsername().split(" ");
        
        String SQL1 = "INSERT INTO [dbo].[PERSON_INFOS]\n" + 
                      "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        
        String SQL2 = "INSERT INTO [dbo].[STAFFS]\n" +
                      "VALUES(?, ?)";
        
        Connection con = new DBS().getConnection();
        PreparedStatement rs1 = con.prepareStatement(SQL1);
        PreparedStatement rs2 = con.prepareStatement(SQL2);
        
        //PERSONAL_INFOS
        rs1.setString(1, nv.getCCCD());
        for(String s : nameSplit){
            int i=2;
            rs1.setString(i, s);
            i++;
        }
        rs1.setDate(5, nv.getDOB());
        rs1.setString(6, nv.getAddress());
        rs1.setString(7, nv.getPhone());    
        rs1.setString(8, nv.getPhai()); 
    }
    
    public void XoaNVDAO(String CCCD_NV){
        
        String SQL = "UPDATE [dbo].[ACCOUNTS]\n" +
                    "SET [Status] = 1\n" +
                    "WHERE [CCCD] = ?";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement stmt = con.prepareStatement(SQL);
            stmt.setString(1, CCCD_NV);

            int affectedRows = stmt.executeUpdate();
        
            if (affectedRows > 0) {
                System.out.println("Thông báo hệ thống đã xóa nhân viên có CCCD: " + CCCD_NV + " thành công!");
            } else {
                System.out.println("Xóa nhân viên có CCCD: " + CCCD_NV + " trên hệ thống thất bại!!!");
            }
        } catch (Exception ex) {
            Logger.getLogger(NVDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void CapNhatThongTinChuHoDAO(Staff nv){
        String[] nameSplit = nv.getUsername().split(" ");
        
        String SQL = "UPDATE [dbo].[PERSON_INFOS]\n" +
                     "SET Firstname = ?,\n" +
                     "Lastname = ?\n"+
                     "Middlename = ?\n"+
                     "DOB = ?,\n" +
                     "Address = ?,\n" +
                     "Phone = ?\n" +
                     "Phai = ?\n" +
                     "WHERE [CCCD] = ?";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement stmt = con.prepareStatement(SQL);
            
            for(String s : nameSplit){
                int i=1;
                stmt.setString(i, s);
                i++;
            }
            stmt.setDate(4, nv.getDOB());
            stmt.setString(5, nv.getAddress());
            stmt.setString(6, nv.getPhone());
            stmt.setString(7, nv.getPhai());
            stmt.setString(8, nv.getCCCD());

            int affectedRows = stmt.executeUpdate();
        
            if (affectedRows > 0) {
                System.out.println("Thông báo hệ thống đã cập nhật nhân viên có CCCD: " + nv.getCCCD() + " thành công!");
            } else {
                System.out.println("cập nhật nhân viên có CCCD: " + nv.getCCCD() + " trên hệ thống thất bại!!!");
            }
        } catch (Exception ex) {
            Logger.getLogger(NVDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void CapNhatAccountChuHoDAO(Staff nv, String Account, String Password){
        String SQL1 = "UPDATE [dbo].[ACCOUNTS]\n" +
                     "SET [Account_Username] = ?,\n" +
                     "[Account_Password] = ?\n" +
                     "WHERE [CCCD] = ?";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement stmt = con.prepareStatement(SQL1);
            
            stmt.setString(1, Account);
            stmt.setString(2, Password);
            stmt.setString(3, nv.getCCCD());

            int affectedRows = stmt.executeUpdate();
        
            if (affectedRows > 0) {
                System.out.println("Thông báo hệ thống đã cập nhật Account nhân viên có CCCD: " + nv.getCCCD() + " thành công!");
            } else {
                System.out.println("Cập nhật Account nhân viên có CCCD: " + nv.getCCCD() + " trên hệ thống thất bại!!!");
            }
        } catch (Exception ex) {
            Logger.getLogger(NVDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void CapNhatCCCDChuHoDAO(Staff nv, String CCCD_Moi){
        String SQL = "UPDATE [dbo].[PERSON_INFOS]\n" +
                     "SET [CCCD] = ?\n" +
                     "WHERE [CCCD] = ?\n" +
                     "\n" +
                     "UPDATE [dbo].[STAFFS]\n" +
                     "SET [CCCD] = ?\n" +
                     "WHERE [CCCD] = ?";
        
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement stmt = con.prepareStatement(SQL);
            
            stmt.setString(1, CCCD_Moi);
            stmt.setString(2, nv.getCCCD());
            
            stmt.setString(3, CCCD_Moi);
            stmt.setString(4, nv.getCCCD());

            int affectedRows = stmt.executeUpdate();
        
            if (affectedRows > 0) {
                System.out.println("Thông báo hệ thống đã cập nhật thành công CCCD nhân viên có tên: " + nv.getUsername());
            } else {
                System.out.println("Cập nhật CCCD nhân viên có tên: " + nv.getUsername() + " trên hệ thống thất bại!!!");
            }
        } catch (Exception ex) {
            Logger.getLogger(NVDao.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
}
