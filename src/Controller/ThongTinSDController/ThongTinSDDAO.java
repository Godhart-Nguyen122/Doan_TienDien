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
       public void Lammoi(){
        lstThongTinSD.clear();
    }
    public List<ThongTinSuDung> getAll() throws Exception{
        Lammoi();
            String SQL = """
                         SELECT A.CCCD, A.Account_Username, P.Phone, E.ID_E_METER,E.Type_Living,E.Address,P2.CCCD AS CCCD_NhanVien,A2.Account_Username AS Username_NhanVien ,P2.Phone AS Phone_NhanVien
                         FROM  [dbo].[CUSTOMERS]AS C
                         JOIN  [dbo].[ACCOUNTS] AS A ON C.Account_Customer= A.Account_Username
                         JOIN [dbo].[PERSON_INFOS] AS P ON P.CCCD = A.CCCD 
                         LEFT JOIN [dbo].[E_METERS] AS E ON E.ID_Customer = C.ID    
                         JOIN [dbo].[STAFFS] AS S ON C.ID_Staff = S.ID
                         JOIN [dbo].[ACCOUNTS] AS A2 ON A2.Account_Username=S.Account_Staffs
                         JOIN [dbo].[PERSON_INFOS] AS P2 ON P2.CCCD = A2.CCCD 
                         WHERE A.Status='0';""";
            try(
                Connection con = DBS.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL);
            ){
            while(rs.next()){
                ThongTinSuDung thongTinSuDung = new ThongTinSuDung();    
                thongTinSuDung.setCCCD(rs.getString("CCCD"));
                thongTinSuDung.setUsername(rs.getString("Account_Username"));
                thongTinSuDung.setPhone(rs.getString("Phone"));
                thongTinSuDung.setID_E_Meter(rs.getString("ID_E_METER"));
                thongTinSuDung.setType_living(rs.getString("Type_Living"));
                thongTinSuDung.setDiaChi(rs.getString("Address"));
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
    
    public void ThemThongTinSDDienDAO ( String ID, String TypeLiving, String DiaChi){

            String SQL = """
                         INSERT INTO [dbo].[E_METERS] ([ID_Customer],[Address], [Type_Living])
                         SELECT C.ID, ?, ?
                         FROM [dbo].[CUSTOMERS] AS C
                         INNER JOIN [dbo].[ACCOUNTS] AS A ON C.Account_Customer = A.Account_Username
                         WHERE A.CCCD = ?;""";
            
            try {   
                Connection con = new DBS().getConnection();
                PreparedStatement stmt = con.prepareStatement(SQL);
    
                stmt.setString(1, ID);
                stmt.setString(2, TypeLiving);
                stmt.setString(3, DiaChi);
//                stmt.setString(4, CCCD);
                stmt.execute();
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
