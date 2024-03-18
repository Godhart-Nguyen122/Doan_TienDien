package Controller.PersonalInFoController;

import Controller.DBS;
import Model.ChuHo;
import Model.Personalinfo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonalInfoDAO {
    private List<Personalinfo> lstPerson = new ArrayList<>();
    
    public List<Personalinfo> getAll() throws Exception{
        String SQL = "SELECT *\n" +
                     "FROM [dbo].[PERSON_INFO]";
        try(
            Connection con = new DBS().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
        ){
            while(rs.next()){
                Personalinfo ps = new Personalinfo();
                ps.setCCCD(rs.getString("CCCD"));
                ps.setUsername(rs.getString("Username"));
                ps.setAddress(rs.getString("Address"));
                ps.setPhone(rs.getString("Phone"));
                ps.setDOB(rs.getDate("DOB"));
                
                lstPerson.add(ps);
            }
        }
        
        return lstPerson;
    }

    public List<Personalinfo> getLstPerson() {
        return lstPerson;
    }

    public void setLstPerson(List<Personalinfo> lstPerson) {
        this.lstPerson = lstPerson;
    }
}
