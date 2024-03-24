package Controller.PersonalInFoController;

import Controller.DBS;
import Model.Customers;
import Model.Personal_Infos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonalInfoDAO {
    private List<Personal_Infos> lstPerson = new ArrayList<>();
    
    public List<Personal_Infos> getAll() throws Exception{
        String SQL = "SELECT *\n" +
                     "FROM [dbo].[PERSON_INFOS]";
        try(
            Connection con = new DBS().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
        ){
            while(rs.next()){
                Personal_Infos ps = new Personal_Infos();
                ps.setCCCD(rs.getString("CCCD"));
                ps.setCCCD(rs.getString("Firstname"));
                ps.setCCCD(rs.getString("Lastname"));
                ps.setCCCD(rs.getString("Middlename"));
                ps.setDOB(rs.getDate("DOB"));
                ps.setCCCD(rs.getString("Address"));
                ps.setCCCD(rs.getString("Phone"));
                ps.setCCCD(rs.getString("Sex"));
                lstPerson.add(ps);
            }
        }
        
        return lstPerson;
    }

    public List<Personal_Infos> getLstPerson() {
        return lstPerson;
    }

    public void setLstPerson(List<Personal_Infos> lstPerson) {
        this.lstPerson = lstPerson;
    }
}
