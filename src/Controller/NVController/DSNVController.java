
package Controller.NVController;

import LayMotSoUIdepTaiDay.BangDanhSach;
import Model.Staff;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vduct
 */
public class DSNVController {
     private List<Staff> dsNV;

    public void refresh(){
        this.dsNV.clear();
    }
    
    public DSNVController() {
//        refresh();
        try {
            this.dsNV = new NVDao().getAll();
        } catch (Exception ex) {
            Logger.getLogger(DSNVController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Staff> getDsNV() {
        return dsNV;
    }

    public Staff LayThongTinNVQuaCCCD(String CCCD) {
        for(Staff nv : dsNV){
            if(nv.getCCCD().equals(CCCD)){
                return nv;
            }
        }
        return null;
    }


    public List<Staff> TimKiemNV (String keyword, String type) {
        boolean found = false;
        List<Staff> staffs = new ArrayList<>();

        //Xử lý tìm kiếm
        try {
            if(type.equalsIgnoreCase("CCCD")){
                for(Staff nv : this.dsNV){                             
                    if(nv.getCCCD().equalsIgnoreCase(keyword)){
                        staffs.add(nv);
                        found = true;
                        break;  
                    }
                }

                if (!found) {
                    // Hiển thị thông báo nếu không tìm thấy
                    JOptionPane.showMessageDialog(null, "Không tìm thấy người dùng có CCCD: " + keyword);
                }
            }else if(type.equalsIgnoreCase("Họ tên")){
                for(Staff nv : this.dsNV){
                    if(nv.getUsername().replaceAll("  ", " ").equalsIgnoreCase(keyword.replaceAll("  ", " "))){
                        staffs.add(nv);
                        found = true;
                        break;  
                    }
                }

                if (!found) {
                    // Hiển thị thông báo nếu không tìm thấy
                    JOptionPane.showMessageDialog(null, "Không tìm thấy người dùng có tên: " + keyword);
                }
            }else if(type.equalsIgnoreCase("Account")){
                for(Staff nv : this.dsNV){
                    if(nv.getAccount().equalsIgnoreCase(keyword)){
                        staffs.add(nv);
                        found = true;
                        break;  
                    }
                }

                if (!found) {
                    // Hiển thị thông báo nếu không tìm thấy
                    JOptionPane.showMessageDialog(null, "Không tìm thấy người dùng có Account: " + keyword);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Lỗi lựa chọn tìm kiếm!" + keyword);
            }
            
        } catch (Exception ex) {
            // Bắt và xử lý ngoại lệ
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi tìm kiếm người dùng.");
        }
        
        return staffs;
    }
}
