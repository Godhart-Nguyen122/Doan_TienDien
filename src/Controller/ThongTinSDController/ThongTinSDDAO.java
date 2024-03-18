package Controller.ThongTinSDController;

import Controller.DBS;
import Model.ThongTinSuDung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThongTinSDDAO {
    private List<ThongTinSuDung>lstThongTinSD = new ArrayList<>();
       
    public List<ThongTinSuDung> getAll() throws Exception{
            String SQL = "SELECT \n" +
                         "P.CCCD, \n" +
                         "P.Username, \n" +
                         "P.Phone, \n" +
                         "E.ID_E_METER,\n" +
                         "E.Type_Living,\n" +
                         "E.DiaChi,\n" +
                         "S.CCCD AS CCCD_NhanVien,\n" +
                         "P2.Username AS Username_NhanVien, \n" +
                         "P2.Phone AS Phone_NhanVien\n" +
                         "FROM [dbo].[CHUHO] AS C\n" +
                         "JOIN [dbo].[STAFFS] AS S ON C.ID_Staff = S.ID_Staffs\n" +
                         "JOIN [dbo].[ACCOUNT] AS A ON A.CCCD = C.CCCD \n" +
                         "LEFT JOIN [dbo].[E_METER] AS E ON E.ID_Chuho = C.ID_Chuho\n" +
                         "JOIN [dbo].[PERSON_INFO] AS P ON P.CCCD = A.CCCD \n" +
                         "JOIN [dbo].[ACCOUNT] AS A2 ON S.CCCD = A2.CCCD\n" +
                         "JOIN [dbo].[PERSON_INFO] AS P2 ON P2.CCCD = A2.CCCD\n" + 
                         "WHERE A.Da_Xoa = 0";
            try(
                Connection con = new DBS().getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL);
            ){
            while(rs.next()){
                ThongTinSuDung thongTinSuDung = new ThongTinSuDung();
                
                thongTinSuDung.setCCCD(rs.getString("CCCD"));
                thongTinSuDung.setUsername(rs.getString("Username"));
                thongTinSuDung.setPhone(rs.getString("Phone"));
                thongTinSuDung.setID_E_Meter(rs.getString("ID_E_METER"));
                thongTinSuDung.setType_living(rs.getString("Type_Living"));
                thongTinSuDung.setDiaChi(rs.getString("DiaChi"));
                thongTinSuDung.setCCCD_NhanVien(rs.getString("CCCD_NhanVien"));
                thongTinSuDung.setUsername_NhanVien(rs.getString("Username_NhanVien"));
                thongTinSuDung.setPhone_NhanVien(rs.getString("Phone_NhanVien"));
                
                lstThongTinSD.add(thongTinSuDung);
            }
            }
            return lstThongTinSD;
       }

    public List<ThongTinSuDung> getLstThongTinSD() {
        return lstThongTinSD;
    }

    public void setLstThongTinSD(List<ThongTinSuDung> lstThongTinSD) {
        this.lstThongTinSD = lstThongTinSD;
    }
    
    public void ThemThongTinSDDienDAO (String CCCD, String ID, String TypeLiving, String DiaChi){

            String SQL = "INSERT INTO [dbo].[E_METER] ([ID_E_METER], [ID_Chuho], [Type_Living], [DiaChi])\n" +
                    "SELECT ?, C.ID_Chuho, ?, ?\n" +
                    "FROM [dbo].[CHUHO] AS C\n" +
                    "WHERE C.CCCD = ?";
            
            try {   
                Connection con = new DBS().getConnection();
                PreparedStatement stmt = con.prepareStatement(SQL);
    
                stmt.setString(1, ID);
                stmt.setString(2, TypeLiving);
                stmt.setString(3, DiaChi);
                stmt.setString(4, CCCD);
    
                int rowsAffected = stmt.executeUpdate(); 
    
                if(rowsAffected > 0){
                    System.out.println("Đã thêm công tơ điện cho chủ hộ có CCCD: " + CCCD + " !");
                } else {
                    System.out.println("Thêm công tơ điện cho chủ hộ có CCCD: " + CCCD + " thất bại!");
            }
    
            } catch (Exception ex) {
                Logger.getLogger(ThongTinSDDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
}
