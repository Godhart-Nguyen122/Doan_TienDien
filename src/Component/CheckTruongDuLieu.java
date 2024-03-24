package Component;

import Controller.ChuHoController.DSChuHoController;
import Controller.PersonalInFoController.DSPersonalInfoController;
import Controller.ThongTinSDController.DSThongTinSDController;
import Model.Customers;
import Model.Customers;
import Model.Personal_Infos;
import Model.ThongTinSuDung;
import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckTruongDuLieu {
    // Kiểm tra CCCD
    public static boolean KtraCCCD(String CCCD) {
        // Kiểm tra độ dài
        if (CCCD.length() != 12) {
            return false;
        }
        
        // Kiểm tra các ký tự có phải là chữ số
        for (int i = 0; i < CCCD.length(); i++) {
            if (!Character.isDigit(CCCD.charAt(i))) {
                return false;
            }
        }
        
        return true;
    }

    // Kiểm tra SĐT
    public static boolean KtraSDT(String SDT) {
        // Kiểm tra độ dài
        if (SDT.length() != 10) {
            return false;
        }
        
        // Kiểm tra các ký tự có phải là chữ số
        for (int i = 0; i < SDT.length(); i++) {
            if (!Character.isDigit(SDT.charAt(i))) {
                return false;
            }
        }
        
        return true;
    }    
     
    // Kiểm tra Date
    public static boolean KtraDate(JDateChooser dateChooser) {
        // Kiểm tra nếu dateChooser trả về null (đồng nghĩa với lỗi)
        if (dateChooser.getDate() == null) {
            return false;
        }

        // Format ngày tháng kiểu yyyy/MM/dd
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        sdf.setLenient(false); // Không cho phép chuyển đổi mềm dẻo

        try {
            // Chuyển đổi ngày tháng từ JDateChooser thành kiểu Date
            Date date = dateChooser.getDate();
            String dateString = sdf.format(date); // Chuyển thành chuỗi theo định dạng yyyy/MM/dd
            Date parsedDate = sdf.parse(dateString); // Chuyển chuỗi thành Date

            // Kiểm tra xem chuỗi ngày tháng đã được chuyển đổi đúng định dạng chưa
            if (!dateString.equals(sdf.format(parsedDate))) {
                return false; // Định dạng không đúng
            }
        } catch (ParseException e) {
            return false; // Định dạng không đúng
        }

        return true; // Định dạng đúng
        }
    
    public boolean KtraCCCDTonTai(String CCCD){
        for(Personal_Infos personalinfo : new DSPersonalInfoController().getDsPerson()){
            if(personalinfo.getCCCD().equals(CCCD)){
                return true;
            }
        }
        return false;
    }
    
    public boolean KtraIDCongTo(String ID){
        if (ID.length() != 8 || !ID.matches("[0-9]+"))
            return false;        
        return true;       
    }
    
    public boolean KtraTonTaiIDCongTo(String ID){
        for(ThongTinSuDung thongTinSuDung : new DSThongTinSDController().getLstThongTinSuDungs()){
            String idE_Meter = thongTinSuDung.getID_E_Meter();
            if(idE_Meter != null && idE_Meter.equals(ID))
                return false;            
        }
        return true;
    }
    
    public boolean KtraTonTaiAccountUsername(String Account_ChuHo){
        for(Customers chuHo : new DSChuHoController().getDsChuHo()){
            if(chuHo.getAccount_username().equals(Account_ChuHo))
                return false;
        }
        return true;
    }
}
