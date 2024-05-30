/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.DAO;

import Controller.DBS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Usage_NormDAO {
    public List<Double>getAll(){
        List<Double>tmp=new ArrayList();
        String SQL="SELECT Value FROM USAGE_NORMS";
        
      try {
            Connection cnn = DBS.getConnection();
            PreparedStatement pre = cnn.prepareStatement(SQL);
            ResultSet re=pre.executeQuery();
            while(re.next()){
                tmp.add(re.getDouble("Value"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tmp;
    }
}
