package Controller.ChuHoController;

import Controller.DBS;
import Model.Customers;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChuHoDAO {
    
    private List<Customers>lstChuHo=new ArrayList<>();
    
    public void Lammoi(){
        lstChuHo.clear();
    }
    
    public List<Customers> getAll() throws Exception{
        Lammoi();

        String SQL = "SELECT \n" +
                    "a.CCCD, Firstname, Lastname, Middlename, DOB, p.Address,p.Phone, a.Account_Username, a.Account_Password, p.Sex \n" +
                    "FROM CUSTOMERS c\n" +
                    "JOIN ACCOUNTS a ON c.Account_Customer=a.Account_Username\n" +
                    "JOIN PERSON_INFOS p ON a.CCCD=p.CCCD\n" +
                    "WHERE a.Status='0' AND a.Privilege='1';";
        try(
            Connection con = new DBS().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
        ){
            while(rs.next()){
                Customers customer = new Customers();
                customer.setCCCD(rs.getString("CCCD"));
                customer.setFirstname(rs.getString("Firstname"));
                customer.setLastname(rs.getString("Lastname"));
                customer.setMiddleName(rs.getString("Middlename"));
                customer.setDOB(rs.getDate("DOB"));
                customer.setAddress(rs.getString("Address"));
                customer.setPhone(rs.getString("Phone"));
                customer.setAccount_username(rs.getString("Account_Username"));
                customer.setPassword(rs.getString("Account_Password"));
                customer.setSex(rs.getBoolean("Sex"));
                lstChuHo.add(customer);
            }
        }
        
        return lstChuHo;
    }
    
    public void ThemChuHoDAO(Customers chuHo, String Username, String Pass,int id_nv) throws Exception{
        String SQL1 = "INSERT INTO PERSON_INFOS (CCCD, Firstname, Lastname, Middlename, DOB, Address, Phone, Sex) "
                       +"VALUES (?,?,?,?,?,?,?,?)";
    
        
        String SQL2 = "INSERT INTO ACCOUNTS (Account_Username, CCCD, Account_Password, Privilege, Status)\n" +
                        "VALUES (?, ?, ?, '1', '0');";
        
        String SQL3 = "INSERT INTO CUSTOMERS (ID_Staff, Account_Customer)\n" +
                       "VALUES (?, ?);";
        
//        String SQL4 = "SELECT S.ID_Staffs " +
//                      "FROM [dbo].[PERSON_INFO] AS P " +
//                      "JOIN [dbo].[ACCOUNT] AS A " +
//                      "ON P.CCCD = A.CCCD " +
//                      "JOIN [dbo].[STAFFS] AS S " +
//                      "ON S.CCCD = A.CCCD " +
//                      "WHERE P.CCCD = ?";
//        
        Connection con = new DBS().getConnection();
//        PreparedStatement stmt4 = con.prepareStatement(SQL4);
//        stmt4.setString(1, CCCD_NV);

//        ResultSet rs4 = stmt4.executeQuery();

//        if (rs4.next()) {
//             String ID_Staffs = rs4.getString("ID_Staffs");
            try(
                PreparedStatement rs1 = con.prepareStatement(SQL1);
                PreparedStatement rs2 = con.prepareStatement(SQL2);
                PreparedStatement rs3 = con.prepareStatement(SQL3);     
                
            ){
                //PERSONAL_INFO
                rs1.setString(1, chuHo.getCCCD());
                rs1.setString(2, chuHo.getFirstname());
                rs1.setString(3, chuHo.getLastname());
                rs1.setString(4, chuHo.getMiddleName());
                rs1.setDate(5, chuHo.getDOB());
                rs1.setString(6, chuHo.getPhone());
                rs1.setString(7, chuHo.getAddress());
                rs1.setBoolean(8, chuHo.isSex());
  
                //ACCOUNT
                rs2.setString(1, chuHo.getAccount_username());
                rs2.setString(2, Username);
                rs2.setString(3, Pass);  
            
                //CHUHO
                rs3.setInt(1, id_nv);
                rs3.setString(2, chuHo.getAccount_username());
                
                int rowsAffected1 = rs1.executeUpdate();
                int rowsAffected2 = rs2.executeUpdate();
                int rowsAffected3 = rs3.executeUpdate();
                    if (rowsAffected1 > 0 && rowsAffected2 > 0 && rowsAffected3 > 0 ) {
                        System.out.println("Tài khoản đã được thêm vào hệ thống!!!");
                    } else {
                        System.out.println("Lỗi không thể thêm tài khoản vào hệ thống!!!");
                }
        }
//        } else {
//            System.out.println("Lỗi không tìm được nhân viên!!!");
//        }     
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
    
    public void CapNhatThongTinChuHoDAO(Customers chuHo){
        String SQL = "UPDATE PERSON_INFOS SET Firstname=?, Lastname=?,"
                + " Middlename=?, DOB=?, Address=?, Phone=?, Sex=? WHERE CCCD=? ";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement stmt = con.prepareStatement(SQL);
            
            stmt.setString(1, chuHo.getFirstname());
            stmt.setString(2, chuHo.getLastname());
            stmt.setString(3, chuHo.getMiddleName());
            stmt.setDate(4, chuHo.getDOB());
            stmt.setString(5, chuHo.getAddress());
            stmt.setString(6, chuHo.getPhone());
            stmt.setBoolean(7, chuHo.isSex());
            stmt.setString(8, chuHo.getCCCD());

            int affectedRows = stmt.executeUpdate();
        
            if (affectedRows > 0) {
                System.out.println("Thông báo hệ thống đã cập nhật chủ hộ có CCCD: " + chuHo.getCCCD() + " thành công!");
            } else {
                System.out.println("Cập nhật chủ hộ có CCCD: " + chuHo.getCCCD() + " trên hệ thống thất bại!!!");
            }
        } catch (Exception ex) {
            Logger.getLogger(ChuHoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void CapNhatAccountChuHoDAO(Customers chuHo, String Account, String Password){
        String SQL1 = "UPDATE ACCOUNTS SET Account_Username=?, Account_Password=? WHERE CCCD=?";

        try {
            Connection con = new DBS().getConnection();
            PreparedStatement stmt = con.prepareStatement(SQL1);
            
            stmt.setString(1, chuHo.getAccount_username());
            stmt.setString(2, chuHo.getPassword());
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
    
    public void CapNhatCCCDChuHoDAO(Customers chuHo, String CCCD_Moi){
        String SQL = "UPDATE PERSON_INFOS SET CCCD=? WHERE CCCD=? ";
        
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement stmt = con.prepareStatement(SQL);
            
            stmt.setString(1, CCCD_Moi);
            stmt.setString(2, chuHo.getCCCD());

            int affectedRows = stmt.executeUpdate();
            String tenchuho=chuHo.getLastname()+" "+chuHo.getMiddleName()+" "+chuHo.getFirstname();
            if (affectedRows > 0) {
                System.out.println("Thông báo hệ thống đã cập nhật thành công CCCD chủ hộ có tên: " + tenchuho);
            } else {
                System.out.println("Cập nhật CCCD chủ hộ có tên: " + tenchuho + " trên hệ thống thất bại!!!");
            }
        } catch (Exception ex) {
            Logger.getLogger(ChuHoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
}
