
package Controller.DAO;

import Controller.DBS;
import Model.Accounts;
import Model.E_Meters;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class E_MeterDAO {
    private List<E_Meters> listEmeters=new ArrayList<>();
    
    public List<E_Meters> getAll() throws Exception{
        this.listEmeters.clear();
        String SQL="SELECT * FROM E_METERS";
           try(
            Connection con = new DBS().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
        ){
            while(rs.next()){
                  E_Meters tmp =new E_Meters();
                  tmp.setID_E_Meter(rs.getString("ID_E_METER"));
                  tmp.setID_Customer(rs.getInt("ID_Customer"));
                  tmp.setAddress(rs.getString("Address"));
                  tmp.setType_Living(rs.getString("Type_Living"));
                  tmp.setStatus(rs.getBoolean("Status"));

                  this.listEmeters.add(tmp);
            }
        }
           System.out.println("Chieu dai cua e meter ben DAO: "+this.listEmeters.size());
        return listEmeters;
    }
}
