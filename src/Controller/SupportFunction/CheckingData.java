package Controller.SupportFunction;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckingData {
    public static boolean CheckCCCD(String CCCD) {
        // Kiểm tra độ dài
        if (CCCD.length() != 12)
            return true;     
        // Kiểm tra các ký tự có phải là chữ số
        for (int i = 0; i < CCCD.length(); i++)
            if (!Character.isDigit(CCCD.charAt(i)))
                return true;     
        return false;
    }    
    
    public static boolean CheckPhone(String SDT) {
        // Kiểm tra độ dài
        if (SDT.length() != 10) 
            return true;
        // Kiểm tra các ký tự có phải là chữ số
        for (int i = 0; i < SDT.length(); i++) 
            if (!Character.isDigit(SDT.charAt(i))) 
                return true;    
        return false;
    }    
    
    public static boolean CheckingDateFormat(Date date) {
        // Định dạng kiểm tra
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        // Kiểm tra xem ngày có đúng định dạng hay không
        String formattedDate = dateFormat.format(date);
        return !formattedDate.equals(dateFormat.format(date));
    }

}
