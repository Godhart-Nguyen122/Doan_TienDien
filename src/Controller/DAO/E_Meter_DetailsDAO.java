
package Controller.DAO;

import Controller.DBS;
import Model.E_Meter_Details;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;
import Controller.DBS;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class E_Meter_DetailsDAO {
//     public  List<E_Meter_Details> getChiTietCongTo(String ngay,int idstaff) {
//        List<E_Meter_Details> listEmeterDetail =new ArrayList<>();
//        String SQL="select * from E_METER_DETAILS where Creating_Date=? and ID_Staff_Input=?";
//           try {           
//             Connection con = new DBS().getConnection();
//             PreparedStatement ps = con.prepareStatement(SQL);
//            ps.setString(1, ngay);
//            ps.setInt(2,idstaff);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                 
//                  E_Meter_Details tmp =new E_Meter_Details();
//                  tmp.setID_E_Meter(rs.getString("ID_E_METER"));
//                  tmp.setCurrent_num(rs.getInt("Current_Num"));
//                  tmp.setCreating_Date(rs.getDate("Creating_Date"));
//                  tmp.setID_Staff_Input(rs.getInt("ID_Staff_Input"));
//                  tmp.setId(rs.getInt("ID"));
//                  listEmeterDetail.add(tmp);             
//            }             
//        } catch (Exception e) {
//            e.printStackTrace();
//        }   
//        return listEmeterDetail;
//     }
     public List<E_Meter_Details>getAlldetailByDate(String date,int idstaffInput){
          List<E_Meter_Details> detailsList = new ArrayList<>();

        // Define the date format matching the date string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);

        String SQL = "SELECT * FROM E_METER_DETAILS " +
                     "WHERE YEAR(Creating_Date) = YEAR(?) " +
                     "AND MONTH(Creating_Date) = MONTH(?) " +
                     "AND ID_Staff_Input = ?";

        try{
            Connection con = new DBS().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);

            // Convert LocalDate to java.sql.Date
            java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);

            // Set the parameters
            ps.setDate(1, sqlDate);
            ps.setDate(2, sqlDate);
            ps.setInt(3, idstaffInput);

            // Execute the query
            ResultSet rs = ps.executeQuery();

            // Process the result set
            while (rs.next()) {
                E_Meter_Details detail = new E_Meter_Details();
                detail.setId(rs.getInt("ID"));
                detail.setID_E_Meter(rs.getString("ID_E_METER"));
                detail.setCurrent_num(rs.getInt("Current_Num"));
                detail.setCreating_Date(rs.getDate("Creating_Date"));
                detail.setID_Staff_Input(rs.getInt("ID_Staff_Input"));
                detailsList.add(detail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return detailsList;
     }
     
     
     public int getOnlyMonth(String date){
        String[] parts = date.split("-");
       int k= Integer.parseInt(parts[1]);
       k=k-1;
       String MM = String.valueOf(k);

       return k;
    }
     public int getOnlyYear(String date) {
        String[] parts = date.split("-");
       int k= Integer.parseInt(parts[0]);
      
       return k;
    }
     public String convertngay(String date)
    {
        String dayy="01";
       String result = date.substring(0, date.length() - 2);
       result=result+dayy;
       return result;
    }
     public static E_Meter_Details getaddressByIdmeter(String idmt,String date) {
        E_Meter_Details wmd= new E_Meter_Details();
        String SQL="select * from E_METER_DETAILS where ID_E_METER=? and Creating_Date=?";
           try {
            
             Connection con = new DBS().getConnection();
             PreparedStatement ps = con.prepareStatement(SQL);
             ps.setString(1,idmt);
              ps.setString(2,date);
          
            ResultSet rs = ps.executeQuery();
       
            while(rs.next()){
                 
               wmd.setId(rs.getInt("ID"));
                wmd.setID_E_Meter(rs.getString("ID_E_METER"));
                 wmd.setCurrent_num(rs.getInt("Current_Num"));
                  wmd.setCreating_Date(rs.getDate("Creating_Date"));
                   wmd.setID_Staff_Input(rs.getInt("ID_Staff_Input"));
      
            }
               
        } catch (Exception e) {
        }

        return wmd;
    }
     public  List<E_Meter_Details> getListChiTietCongToByName(String Name,String date,int idStaff) {
    List<E_Meter_Details> list =new ArrayList<>();
                String SQL="SELECT * FROM E_METERS wm \n" +
                            "JOIN CUSTOMERS ctm ON wm.ID_Customer = ctm.ID \n" +
                            "join ACCOUNTS acc on acc.Account_Username=ctm.Account_Customer \n" +
                            "join E_METER_DETAILS wmdt on wmdt.ID_E_METER=wm.ID_E_METER\n" +
                            "join PERSON_INFOS psif on psif.CCCD=acc.CCCD  where CONCAT(Firstname, ' ',  Middlename,' ',Lastname ) like ? and Creating_Date=? and wmdt.ID_Staff_Input=?";
           try {
            
             Connection con = new DBS().getConnection();
             PreparedStatement ps = con.prepareStatement(SQL);
           ps.setString(1, "%" + Name + "%");
            ps.setString(2, date);
              ps.setInt(3,idStaff);
//               SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//             Date parsedDate = dateFormat.parse(ngay);
//            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
//            
//            ps.setDate(1, sqlDate);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 
                  E_Meter_Details tmp =new E_Meter_Details();
                  tmp.setID_E_Meter(rs.getString("ID_E_METER"));
                  tmp.setCurrent_num(rs.getInt("Current_Num"));
                  tmp.setCreating_Date(rs.getDate("Creating_Date"));
                  tmp.setID_Staff_Input(rs.getInt("ID_Staff_Input"));
                  tmp.setId(rs.getInt("ID"));
                  list.add(tmp);
                  
              
              
            }
               
        } catch (Exception e) {
        }
          
        
          
        return list;
    }
     public  List<E_Meter_Details> getChiTietCongToByCCCD(String CCCD,String date,int idstaff) {
    List<E_Meter_Details> list =new ArrayList<>();
                String SQL="SELECT * FROM E_METERS wm \n" +
"        JOIN CUSTOMERS ctm ON wm.ID_Customer = ctm.ID\n" +
"        join ACCOUNTS acc on acc.Account_Username=ctm.Account_Customer  \n" +
"        join E_METER_DETAILS wmdt on wmdt.ID_E_METER=wm.ID_E_METER\n" +
"        where CCCD Like ? and Creating_Date=? and wmdt.ID_Staff_Input=?";
           try {
            
             Connection con = new DBS().getConnection();
             PreparedStatement ps = con.prepareStatement(SQL);
           ps.setString(1, "%" + CCCD + "%");
            ps.setString(2, date);
             ps.setInt(3, idstaff);
//               SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//             Date parsedDate = dateFormat.parse(ngay);
//            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
//            
//            ps.setDate(1, sqlDate);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 
                  E_Meter_Details tmp =new E_Meter_Details();
                  tmp.setID_E_Meter(rs.getString("ID_E_METER"));
                  tmp.setCurrent_num(rs.getInt("Current_Num"));
                  tmp.setCreating_Date(rs.getDate("Creating_Date"));
                  tmp.setID_Staff_Input(rs.getInt("ID_Staff_Input"));
                  tmp.setId(rs.getInt("ID"));
                  list.add(tmp);
             
            }
               
        } catch (Exception e) {
        }
         
        return list;
    }
     public  List<E_Meter_Details> getListChiTietCongToByIDMeter(String idct,String ngay,int idStaff) {
    List<E_Meter_Details> list =new ArrayList<>();
        String SQL="select * from E_METER_DETAILS where ID_E_METER like ? and Creating_Date=? and ID_Staff_Input=?";
           try {
            
             Connection con = new DBS().getConnection();
             PreparedStatement ps = con.prepareStatement(SQL);
             ps.setString(1, "%" +idct+ "%");
            ps.setString(2, ngay);
            ps.setInt(3, idStaff);
//               SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//             Date parsedDate = dateFormat.parse(ngay);
//            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
//            
//            ps.setDate(1, sqlDate);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 
                  E_Meter_Details tmp =new E_Meter_Details();
                  tmp.setID_E_Meter(rs.getString("ID_E_METER"));
                  tmp.setCurrent_num(rs.getInt("Current_Num"));
                  tmp.setCreating_Date(rs.getDate("Creating_Date"));
                  tmp.setID_Staff_Input(rs.getInt("ID_Staff_Input"));
                  tmp.setId(rs.getInt("ID"));
                  list.add(tmp);}
               
        } catch (Exception e) {
        }
        return list;
    }
     public boolean checkExistEMetter(String idmt){
         boolean check= false;
         String SQL="select * from E_METERS where ID_E_METER=?";
           try {
            
                 Connection con = new DBS().getConnection();
             PreparedStatement ps = con.prepareStatement(SQL);
             ps.setString(1,idmt);
          
            ResultSet rs = ps.executeQuery();
       
            while(rs.next()){
                 
               check=true;
      
            }
               
        } catch (Exception e) {
        }
           return check;
         
     }
     public void AddEmetter(String idmt,int currentnum,int idstaff,String date){
        //Thêm Account vào một Account mới 
        String SQL = "INSERT INTO E_METER_DETAILS (ID_E_METER,Current_Num,ID_Staff_Input,Creating_Date) VALUES(?, ?, ?,?);";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement rs = con.prepareStatement(SQL);
            
            rs.setString(1, idmt);
            rs.setInt(2, currentnum);
            rs.setInt(3, idstaff);
            rs.setString(4, date);
       
            int rowsAffected = rs.executeUpdate();
        
            
        } catch (Exception ex) {
            ex.printStackTrace();
//            System.out.println("Lỗi hệ thống!!! (AccountsDAO) - AddDAO");
        }
      }
     public boolean checkIdStaff(int idstaff,String idmt) {
       boolean t= false;
        String SQL="select * from CUSTOMERS ctm \n" +
                    "join E_METERS wm on ctm.ID = wm.ID_Customer where ID_Staff_Input=? and ID_E_METER=? ";
           try {
                Connection con = new DBS().getConnection();
                PreparedStatement ps = con.prepareStatement(SQL);
                ps.setInt(1,idstaff);
                ps.setString(2,idmt); 
                ResultSet rs = ps.executeQuery();      
            while(rs.next()){
                 
               t=true;
      
            }
               
        } catch (Exception e) {
        }

        return t;
    }
     public boolean checkExistEMDetail(String idmt,String date) {
       boolean t= false;
        String SQL="select * from E_METER_DETAILS where ID_E_METER=? and Creating_Date=?";
           try {
            
                 Connection con = new DBS().getConnection();
             PreparedStatement ps = con.prepareStatement(SQL);
             ps.setString(1,idmt);
             ps.setString(2,date);
            
            ResultSet rs = ps.executeQuery();
       
            while(rs.next()){
                 
               t=true;
      
            }
               
        } catch (Exception e) {
        }

        return t;
    }
     public static String getCCCDByIDMeter(String idmeter) {
        String cccd="";
        String SQL="SELECT * FROM E_METERS wm JOIN CUSTOMERS ctm ON wm.ID_Customer = ctm.ID join ACCOUNTS acc on acc.Account_Username=ctm.Account_Customer where ID_E_METER=?";
           try {
            
                 Connection con = new DBS().getConnection();
             PreparedStatement ps = con.prepareStatement(SQL);
             ps.setString(1,idmeter);
            ResultSet rs = ps.executeQuery();
       
            while(rs.next()){
                 
                cccd=rs.getString("CCCD");
      
            }
               
        } catch (Exception e) {
        }
        return cccd;
    }
     public static String getHotenByCCCD(String cccd) {
        String hoten="";
        String SQL="SELECT CONCAT(Firstname, ' ',  Middlename,' ',Lastname ) AS Fullname FROM PERSON_INFOS where CCCD=?";
           try {
            
             Connection con = new DBS().getConnection();
             PreparedStatement ps = con.prepareStatement(SQL);
             ps.setString(1,cccd);
            ResultSet rs = ps.executeQuery();
       
            while(rs.next()){
                 
                hoten=rs.getString("Fullname");

            }
               
        } catch (Exception e) {
        }

        return hoten;
    }
      public static String thangDienCu(String date)
    {
        String[] parts = date.split("-");
       int k= Integer.valueOf(parts[1]);
       k=k-1;
       String MM = String.valueOf(k);
       if(MM.length()!=2)
       {
            MM="0"+MM;
       }
      
       String rs=parts[0]+"-"+MM+"-"+parts[2];
        
       return rs;
    }
      public static int getSoDienCu(String ngay,String idmt) {
        int soDien=0;
        String SQL="select * from E_METER_DETAILS where Creating_Date=? and ID_E_METER=?";
           try {
            
                 Connection con = new DBS().getConnection();
             PreparedStatement ps = con.prepareStatement(SQL);
             ps.setString(1,ngay);
             ps.setString(2,idmt);
            ResultSet rs = ps.executeQuery();
       
            while(rs.next()){
                 
                soDien=rs.getInt("Current_Num");
      
            }
               
        } catch (Exception e) {
        }

        return soDien;
    }
      public static String getaddressByIdmeter(String idmt) {
        String addr="";
        String SQL="select * from E_METERS where ID_E_METER=?";
           try {
            
                 Connection con = new DBS().getConnection();
             PreparedStatement ps = con.prepareStatement(SQL);
             ps.setString(1,idmt);
          
            ResultSet rs = ps.executeQuery();
       
            while(rs.next()){
                 
                addr=rs.getString("Address");
      
            }
               
        } catch (Exception e) {
        }
          
        
          
        return addr;
    }
       public static boolean UpdateSoDien(String CreatingDate,String idmeter,int idstaffInput,int currentNum){
   
        String SQL = "UPDATE E_METER_DETAILS " +
             "SET Current_Num = ? " +
             "WHERE YEAR(Creating_Date) = YEAR(?) " +
             "AND MONTH(Creating_Date) = MONTH(?) " +
             "AND ID_E_METER = ? " +
             "AND ID_Staff_Input = ?";
        boolean result=false;
         try{
                 // Define the date format matching the date string
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                // Parse the string to LocalDate
                LocalDate localDate = LocalDate.parse(CreatingDate, formatter);

                // Convert LocalDate to java.sql.Date
                java.sql.Date sqlDate = Date.valueOf(localDate);

            }catch(Exception e){
                e.printStackTrace();
            }   
        
        
        
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement rs = con.prepareStatement(SQL); 
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            // Parse the string to LocalDate
            LocalDate localDate = LocalDate.parse(CreatingDate, formatter);
            // Convert LocalDate to java.sql.Date
            java.sql.Date sqlDate = Date.valueOf(localDate);

            rs.setInt(1, currentNum);
            rs.setDate(2, sqlDate);
            rs.setDate(3, sqlDate);
            rs.setString(4, idmeter);
            rs.setInt(5, idstaffInput);
            int rowsAffected = rs.executeUpdate();
            if(rowsAffected==1){
                result=true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
      }
       
    private List<E_Meter_Details>listEmeterDetail=new ArrayList<>();
   
    public List<E_Meter_Details> getAll() throws Exception{
        this.listEmeterDetail.clear();
        String SQL="SELECT * FROM E_METER_DETAILS";
           try(
            Connection con = new DBS().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
        ){
            while(rs.next()){
                  E_Meter_Details tmp =new E_Meter_Details();
                  tmp.setId(rs.getInt("ID"));
                  tmp.setID_E_Meter(rs.getString("ID_E_METER"));
                  tmp.setCurrent_num(rs.getInt("Current_Num"));
                  tmp.setCreating_Date(rs.getDate("Creating_Date"));
                  tmp.setID_Staff_Input(rs.getInt("ID_Staff_Input"));
                  this.listEmeterDetail.add(tmp);
            }
        }
        return listEmeterDetail;
    }
    
    public static E_Meter_Details getLastRecordbyEmeterID(String emeterId ) throws Exception{
        E_Meter_Details result = null;
        String SQL = "SELECT TOP 1 * FROM [dbo].[E_METER_DETAILS] WHERE [ID_E_METER] = ? ORDER BY [ID] DESC;";

        try (Connection con = new DBS().getConnection();
             PreparedStatement stmt = con.prepareStatement(SQL)) {

            stmt.setString(1, emeterId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    result = new E_Meter_Details();
                    result.setId(rs.getInt("ID"));
                    result.setID_E_Meter(rs.getString("ID_E_METER"));
                    result.setCurrent_num(rs.getInt("Current_Num"));
                    result.setCreating_Date(rs.getDate("Creating_Date"));
                    result.setID_Staff_Input(rs.getInt("ID_Staff_Input"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    } 
    public static boolean addNewE_EmeterDetail(E_Meter_Details a){
        boolean result=false;
        String SQL = "INSERT INTO [dbo].[E_METER_DETAILS] " +
                     "([ID_E_METER], [Current_Num], [Creating_Date], [ID_Staff_Input]) " +
                     "VALUES (?, ?, ?, ?)";
        try (Connection con = new DBS().getConnection();
             PreparedStatement stmt = con.prepareStatement(SQL)) {


            
            stmt.setString(1, a.getID_E_Meter());
            stmt.setInt(2, a.getCurrent_num());
            stmt.setDate(3,a.getCreating_Date());
            stmt.setInt(4, a.getID_Staff_Input());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                result=true;
                System.out.println("A new record was inserted successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
          
        return result;
    }
    public static boolean checkifExistEmeterDetail(E_Meter_Details a ){
        boolean result = false;
        String SQL = "SELECT CASE " +
                     "WHEN EXISTS (" +
                     "    SELECT 1 " +
                     "    FROM [dbo].[E_METER_DETAILS] " +
                     "    WHERE [ID_E_METER] = ? " +
                     "          AND YEAR([Creating_Date]) = YEAR(?) " +
                     "          AND MONTH([Creating_Date]) = MONTH(?)" +
                     ") " +
                     "THEN CAST(1 AS BIT) " +
                     "ELSE CAST(0 AS BIT) " +
                     "END AS RecordExists";
        try (Connection con = new DBS().getConnection();
             PreparedStatement stmt = con.prepareStatement(SQL)) {

            stmt.setString(1, a.getID_E_Meter());
            stmt.setDate(2, a.getCreating_Date());
            stmt.setDate(3, a.getCreating_Date());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    result = rs.getBoolean("RecordExists");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static boolean checkIfexistPreviousMonth(String idmeter,Date previvous){
        boolean result =false;
         String SQL = "SELECT CASE " +
                         "WHEN EXISTS (" +
                         "    SELECT 1 " +
                         "    FROM [dbo].[E_METER_DETAILS] " +
                         "    WHERE [ID_E_METER] = ? " +
                         "          AND YEAR([Creating_Date]) = YEAR(?) " +
                         "          AND MONTH([Creating_Date]) = MONTH(?)" +
                         ") " +
                         "THEN CAST(1 AS BIT) " +
                         "ELSE CAST(0 AS BIT) " +
                         "END AS RecordExists";
        return result;
    }
}

