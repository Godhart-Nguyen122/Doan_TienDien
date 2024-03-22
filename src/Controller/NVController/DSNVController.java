/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.NVController;

import LayMotSoUIdepTaiDay.BangDanhSach;
import Model.Staff;
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

//    public void TimKiemNV (String keyword, JTable table) {
//        //Cast table về dạng DefaultTableModel, sau đó dùng một số hàm built-in có sẵn từ DefaultTableModel
//        DefaultTableModel model = (DefaultTableModel) table.getModel();
//        boolean found = false;
//
//        //Xử lý tìm kiếm
//        try {
//            for (int i = 0; i < model.getRowCount(); i++) {
//                //Lấy từng phần thử dò theo keyword, getValueAt('lấy phần tử tại dòng i', 'lấy chọn trường dữ liệu cột 0')
//                if (model.getValueAt(i, 1) != null) {
//                    String ten = model.getValueAt(i, 1).toString(); // Chuyển đổi thành chuỗi
//                    if (ten.equalsIgnoreCase(keyword)) {
//                        // Tìm thấy từ khóa, chọn dòng đó trong bảng
//                        table.setRowSelectionInterval(i, i);
//                        found = true;
//                        break;
//                    }
//                }
//            }
//
//            if (!found) {
//                // Hiển thị thông báo nếu không tìm thấy
//                JOptionPane.showMessageDialog(null, "Không tìm thấy người dùng có tên: " + keyword);
//            }
//        } catch (Exception ex) {
//            // Bắt và xử lý ngoại lệ
//            ex.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi tìm kiếm người dùng.");
//        }
//    }
    public void TimKiemNV (String keyword, JTable table) {
        boolean found = false;
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        //Xử lý tìm kiếm
        try {
            for(Staff nv : this.dsNV){
                int i = 0;                
                if(nv.getUsername().equalsIgnoreCase(keyword)){
                    table.setRowSelectionInterval(i, i);
                    found = true;
                    break;  
                }
                i++;
            }

            if (!found) {
                // Hiển thị thông báo nếu không tìm thấy
                JOptionPane.showMessageDialog(null, "Không tìm thấy người dùng có tên: " + keyword);
            }
        } catch (Exception ex) {
            // Bắt và xử lý ngoại lệ
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi tìm kiếm người dùng.");
        }
    }
    
    public void XoaChuHo(String CCCD_NV){
        new NVDao().XoaNVDAO(CCCD_NV);
    }
    
    public int SoluongChuho(){
        return dsNV.size();
    }
      
    public void CapNhatThongTinChuHo(Staff nv){
        new NVDao().CapNhatThongTinChuHoDAO(nv);
    }
  
    public void CapNhatAccountChuHo(Staff nv, String Account, String Password){
        new NVDao().CapNhatAccountChuHoDAO(nv, Account, Password);
    }    
    
    public void CapNhatCCCDChuHo(Staff nv, String CCCD_Moi){
        new NVDao().CapNhatCCCDChuHoDAO(nv, CCCD_Moi);
    }
}
