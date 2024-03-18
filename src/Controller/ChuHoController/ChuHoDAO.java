package Controller.ChuHoController;

import Controller.DBS;
import Model.ChuHo;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChuHoDAO {
    
    private List<ChuHo>lstChuHo=new ArrayList<>();
    
    public void Lammoi(){
        lstChuHo.clear();
    }
    
    public List<ChuHo> getAll() throws Exception{
        Lammoi();
        String SQL = "SELECT P.CCCD, P.Username, P.DOB, P.Address, P.Phone, A.Account_Username, A.Account_Password\n" +
                     "FROM [dbo].[PERSON_INFO] AS P\n" +
                     "JOIN [dbo].[ACCOUNT] AS A\n" +
                     "ON P.CCCD = A.CCCD\n" +
                     "WHERE A.Privilege = 0 AND A.Da_Xoa = 0";
        try(
            Connection con = new DBS().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
        ){
            while(rs.next()){
                ChuHo chuHo = new ChuHo();
                chuHo.setCCCD(rs.getString("CCCD"));
                chuHo.setUsername(rs.getString("Username"));
                chuHo.setAddress(rs.getString("Address"));
                chuHo.setPhone(rs.getString("Phone"));
                chuHo.setDOB(rs.getDate("DOB"));
                chuHo.setAccount(rs.getString("Account_Username"));
                chuHo.setPassword(rs.getString("Account_Password"));
                
                lstChuHo.add(chuHo);
            }
        }
        
        return lstChuHo;
    }
    
    public void ThemChuHoDAO(ChuHo chuHo, String Username, String Pass, String CCCD_NV) throws Exception{
        String SQL1 = "INSERT INTO [dbo].[PERSON_INFO]\n" + 
                      "VALUES(?, ?, ?, ?, ?)";
        
        String SQL2 = "INSERT INTO [dbo].[ACCOUNT]\n" +
                      "VALUES(?, ?, ?, 0, 0)";
        
        String SQL3 = "INSERT INTO [dbo].[CHUHO]\n" +
                      "VALUES(?, ?)";
        
        String SQL4 = "SELECT S.ID_Staffs " +
                      "FROM [dbo].[PERSON_INFO] AS P " +
                      "JOIN [dbo].[ACCOUNT] AS A " +
                      "ON P.CCCD = A.CCCD " +
                      "JOIN [dbo].[STAFFS] AS S " +
                      "ON S.CCCD = A.CCCD " +
                      "WHERE P.CCCD = ?";
        
        Connection con = new DBS().getConnection();
        PreparedStatement stmt4 = con.prepareStatement(SQL4);
        stmt4.setString(1, CCCD_NV);

        ResultSet rs4 = stmt4.executeQuery();

        if (rs4.next()) {
             String ID_Staffs = rs4.getString("ID_Staffs");
            try(
                PreparedStatement rs1 = con.prepareStatement(SQL1);
                PreparedStatement rs2 = con.prepareStatement(SQL2);
                PreparedStatement rs3 = con.prepareStatement(SQL3);     
                
            ){
                //PERSONAL_INFO
                rs1.setString(1, chuHo.getCCCD());
                rs1.setString(2, chuHo.getUsername());
                rs1.setDate(3, chuHo.getDOB());
                rs1.setString(4, chuHo.getAddress());
                rs1.setString(5, chuHo.getPhone());
  
                //ACCOUNT
                rs2.setString(1, chuHo.getCCCD());
                rs2.setString(2, Username);
                rs2.setString(3, Pass);  
            
                //CHUHO
                rs3.setString(1, chuHo.getCCCD());
                rs3.setString(2, ID_Staffs);
                
                int rowsAffected1 = rs1.executeUpdate();
                int rowsAffected2 = rs2.executeUpdate();
                int rowsAffected3 = rs3.executeUpdate();
                    if (rowsAffected1 > 0 && rowsAffected2 > 0 && rowsAffected3 > 0 ) {
                        System.out.println("Tài khoản đã được thêm vào hệ thống!!!");
                    } else {
                        System.out.println("Lỗi không thể thêm tài khoản vào hệ thống!!!");
                }
        }
        } else {
            System.out.println("Lỗi không tìm được nhân viên!!!");
        }     
    }
    
    public void XoaChuHoDAO(String CCCD_ChuHo){
        String SQL = "UPDATE [dbo].[ACCOUNT]\n" +
                    "SET [Da_Xoa] = 1\n" +
                    "WHERE [CCCD] = ?";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement stmt = con.prepareStatement(SQL);
            stmt.setString(1, CCCD_ChuHo);

            int affectedRows = stmt.executeUpdate();
        
            if (affectedRows > 0) {
                System.out.println("Thông báo hệ thống đã xóa chủ hộ có CCCD: " + CCCD_ChuHo + " thành công!");
            } else {
                System.out.println("Xóa chủ hộ có CCCD: " + CCCD_ChuHo + " trên hệ thống thất bại!!!");
            }
        } catch (Exception ex) {
            Logger.getLogger(ChuHoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void CapNhatThongTinChuHoDAO(ChuHo chuHo){
        String SQL = "UPDATE [dbo].[PERSON_INFO]\n" +
                     "SET Username = ?,\n" +
                     "DOB = ?,\n" +
                     "Address = ?,\n" +
                     "Phone = ?\n" +
                     "WHERE [CCCD] = ?";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement stmt = con.prepareStatement(SQL);
            
            stmt.setString(1, chuHo.getUsername());
            stmt.setDate(2, chuHo.getDOB());
            stmt.setString(3, chuHo.getAddress());
            stmt.setString(4, chuHo.getPhone());
            stmt.setString(5, chuHo.getCCCD());

            int affectedRows = stmt.executeUpdate();
        
            if (affectedRows > 0) {
                System.out.println("Thông báo hệ thống đã cập nhật chủ hộ có CCCD: " + chuHo.getCCCD() + " thành công!");
            } else {
                System.out.println("cập nhật chủ hộ có CCCD: " + chuHo.getCCCD() + " trên hệ thống thất bại!!!");
            }
        } catch (Exception ex) {
            Logger.getLogger(ChuHoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void CapNhatAccountChuHoDAO(ChuHo chuHo, String Account, String Password){
        String SQL1 = "UPDATE [dbo].[ACCOUNT]\n" +
                     "SET [Account_Username] = ?,\n" +
                     "[Account_Password] = ?\n" +
                     "WHERE [CCCD] = ?";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement stmt = con.prepareStatement(SQL1);
            
            stmt.setString(1, Account);
            stmt.setString(2, Password);
            stmt.setString(3, chuHo.getCCCD());

            int affectedRows = stmt.executeUpdate();
        
            if (affectedRows > 0) {
                System.out.println("Thông báo hệ thống đã cập nhật Account chủ hộ có CCCD: " + chuHo.getCCCD() + " thành công!");
            } else {
                System.out.println("Cập nhật Account chủ hộ có CCCD: " + chuHo.getCCCD() + " trên hệ thống thất bại!!!");
            }
        } catch (Exception ex) {
            Logger.getLogger(ChuHoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void CapNhatCCCDChuHoDAO(ChuHo chuHo, String CCCD_Moi){
        String SQL = "UPDATE [dbo].[PERSON_INFO]\n" +
                     "SET [CCCD] = ?\n" +
                     "WHERE [CCCD] = ?\n" +
                     "\n" +
                     "UPDATE [dbo].[CHUHO]\n" +
                     "SET [CCCD] = ?\n" +
                     "WHERE [CCCD] = ?";
        
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement stmt = con.prepareStatement(SQL);
            
            stmt.setString(1, CCCD_Moi);
            stmt.setString(2, chuHo.getCCCD());
            
            stmt.setString(3, CCCD_Moi);
            stmt.setString(4, chuHo.getCCCD());

            int affectedRows = stmt.executeUpdate();
        
            if (affectedRows > 0) {
                System.out.println("Thông báo hệ thống đã cập nhật thành công CCCD chủ hộ có tên: " + chuHo.getUsername());
            } else {
                System.out.println("Cập nhật CCCD chủ hộ có tên: " + chuHo.getUsername() + " trên hệ thống thất bại!!!");
            }
        } catch (Exception ex) {
            Logger.getLogger(ChuHoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
}
