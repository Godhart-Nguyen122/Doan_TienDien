
package Controller.ChuHoController;

import Model.Customers;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DSChuHoController {
    private List<Customers> dsChuHo;

    public void refresh(){
         try {
            this.dsChuHo = new ChuHoDAO().getAll();
        } catch (Exception ex) {
            Logger.getLogger(DSChuHoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public DSChuHoController() {
        refresh();
    }
    
    public List<Customers> getDsChuHo() {
        refresh();
        return dsChuHo;
    }

    public void setDsChuHo(List<Customers> dsChuHo) {
        this.dsChuHo = dsChuHo;
    }
    
    public void TimKiemChuHo (String keyword, JTable table) {
        //Cast table về dạng DefaultTableModel, sau đó dùng một số hàm built-in có sẵn từ DefaultTableModel
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        boolean found = false;

        //Xử lý tìm kiếm
        try {
            for (int i = 0; i < model.getRowCount(); i++) {
                //Lấy từng phần thử dò theo keyword, getValueAt('lấy phần tử tại dòng i', 'lấy chọn trường dữ liệu cột 0')
                if (model.getValueAt(i, 1) != null) {
                    String ten = model.getValueAt(i, 0).toString(); // Chuyển đổi thành chuỗi
                    if (ten.equalsIgnoreCase(keyword)) {
                        // Tìm thấy từ khóa, chọn dòng đó trong bảng
                        table.setRowSelectionInterval(i, i);
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                // Hiển thị thông báo nếu không tìm thấy
                JOptionPane.showMessageDialog(null, "Không tìm thấy người dùng có CCCD: " + keyword);
            }
        } catch (Exception ex) {
            // Bắt và xử lý ngoại lệ
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi tìm kiếm người dùng.");
        }
    }
    
    public Customers LayThongTinChuHoQuaCCCD(String CCCD){
        for(Customers chuHo : dsChuHo){
            if(chuHo.getCCCD().equals(CCCD)){
                return chuHo;
            }
        }
        return null;
    }
    
    public void ThemChuHo (Customers chuHo, String Username, String Pass, String CCCD_NV){
//        dsChuHo.add(chuHo);
//
//        try {
//            new ChuHoDAO().ThemChuHoDAO(chuHo, Username, Pass, CCCD_NV);
//        } catch (Exception ex) {
//            Logger.getLogger(DSChuHoController.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("Lỗi ở method ThemChuHo!");
//        }
    }
    
    public void XoaChuHo(String CCCD_ChuHo){
        new ChuHoDAO().XoaChuHoDAO(CCCD_ChuHo);
    }
    
    public int SoluongChuho(){
        return dsChuHo.size();
    }
      
    public void CapNhatThongTinChuHo(Customers chuHo){
        new ChuHoDAO().CapNhatThongTinChuHoDAO(chuHo);
    }
  
    public void CapNhatAccountChuHo(Customers chuHo, String Account, String Password){
        new ChuHoDAO().CapNhatAccountChuHoDAO(chuHo, Account, Password);
    }    
    
    public void CapNhatCCCDChuHo(Customers chuHo, String CCCD_Moi){
        new ChuHoDAO().CapNhatCCCDChuHoDAO(chuHo, CCCD_Moi);
    }
}
