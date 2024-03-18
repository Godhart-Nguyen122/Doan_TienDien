
package Controller.StaffsController;

import Controller.DBS;
import Model.Staff;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class StaffsDAO {
    private  List<Staff> lstStaffs=new ArrayList<Staff>();
    
    public void Lammoi(){
        lstStaffs.clear();
    }

    public List<Staff>getAll() throws Exception{
        Lammoi();
        String SQL="SELECT P.CCCD, P.Username, P.DOB, P.Address, P.Phone \n" +
                    "FROM STAFFS AS s \n" +
                    "JOIN PERSON_INFO AS P ON s.CCCD = P.CCCD \n" +
                    "JOIN ACCOUNT AS a ON s.CCCD = a.CCCD \n" +
                    "WHERE a.Da_Xoa = 0 AND a.Privilege = 1";
        
        
          try(
            Connection con = new DBS().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            ){
            while(rs.next()){
                Staff staff = new Staff();
                staff.setCCCD(rs.getString("CCCD"));
                staff.setUsername(rs.getString("Username"));
                staff.setAddress(rs.getString("Address"));
                staff.setPhone(rs.getString("Phone"));
                staff.setDOB(rs.getDate("DOB"));
                
                lstStaffs.add(staff);
            }
        }
          return lstStaffs;
    }
    public int soLuongnhanVien(){
        return lstStaffs.size();
    }
}
