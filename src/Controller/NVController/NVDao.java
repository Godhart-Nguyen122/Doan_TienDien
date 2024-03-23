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
                     SELECT P.CCCD, P.Firstname+' '+P.Middlename+' '+P.Lastname AS Username, P.DOB, P.Address, P.Phone, A.Account_Username, A.Account_Password, P.Sex
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
                
                staff.setAccount(rs.getString("Account_Username"));
                staff.setPassword(rs.getString("Account_Password"));
                if(rs.getInt("Sex") == 0){
                    staff.setPhai("Nam");
                }else{
                    staff.setPhai("Nữ");
                }
                
                lstNV.add(staff);
            }
        }
        
        return lstNV;
    }
}
