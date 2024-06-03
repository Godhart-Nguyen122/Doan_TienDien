/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View.StaffView.GhiChiSoView.GhiChiSoDialog;

import Controller.DAO.CustomerDAO;
import Controller.DAO.E_Meter_DetailsDAO;
import Controller.DAO.PhanCongDAO;
import Controller.DSChuHoController.DSChuHo;
import Controller.StaffView.GhiChiSo;
import Controller.StaffView.subFormController.GhiChiSoDialogController;
import Model.Customers;
import Model.E_Meter_Details;
import Model.E_Meters;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author DELL
 */
public class GhiChiSoDialog extends javax.swing.JDialog {
    private String _date;
    private int idstafflogin;
    private List<Customers>dsChuhoMnStaff; 
    
    
    public GhiChiSoDialog(boolean modal,int idstafflogin) throws Exception {
        initComponents();
        this.idstafflogin=idstafflogin;
        setLocationRelativeTo(null);
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
        this.dsChuhoMnStaff=new ArrayList<>();
        showchuhoCBinfo();
        
        
       
    }
    private void getcurrentDate(){
          // Get the current date as LocalDate
        LocalDate currentDate = LocalDate.now();
        // Convert LocalDate to java.sql.Date
        Date sqlDate = Date.valueOf(currentDate);
        // Create a DateTimeFormatter instance
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Format the java.sql.Date to a string
        String dateString = dateFormatter.format(currentDate);
        // Print the formatted date string
        txtDate.setText(dateString);
    }
    private void devideChuho() throws Exception{
        // Chia danh sách chủ hộ theo nhân viên ghi điện 0 
        if(!dsChuhoMnStaff.isEmpty()){
            this.dsChuhoMnStaff.clear();
        }
        List<Customers>danhsach=new DSChuHo().LayDanhSachChuho();
         for(Customers tmp:danhsach){
             boolean roleStaff=new PhanCongDAO().getRoleStaffbyId(this.idstafflogin);
             if(roleStaff==false){
                 if(tmp.getId_Staff()==this.idstafflogin){
                     this.dsChuhoMnStaff.add(tmp);
                 }
             }
        }
        if(dsChuhoMnStaff.isEmpty()){
            JOptionPane.showMessageDialog(this,"Danh sách chủ hộ rỗng","Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void showchuhoCBinfo() throws Exception{
        devideChuho();
        getcurrentDate();
        this.chuhoCB.removeAllItems();
        if(dsChuhoMnStaff.isEmpty()){
            JOptionPane.showMessageDialog(this,"Danh sách chủ hộ rỗng","Warning",JOptionPane.WARNING_MESSAGE);
        }else{
            for(Customers tmp:this.dsChuhoMnStaff){
            this.chuhoCB.addItem(tmp);
            }
            actionchuhoCB();
        }
    }
    private void actionchuhoCB(){
         this.chuhoCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Customers selectedCus=(Customers)chuhoCB.getSelectedItem();
                    if(selectedCus!=null){
                       String cusCCCD=selectedCus.getCCCD();
                       int cusId=new CustomerDAO().getIdCustomerbyCCCD(cusCCCD);
                        try {
                            showIdcongToCB(cusId);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }             
                }
            });
    }
    private void showIdcongToCB(int cusId) throws Exception{
        this.cbCongto.removeAllItems();
        List<E_Meters>tmp=new ArrayList<>();
        tmp=new GhiChiSo().getListEmeterbyIdCus(cusId);
        if(tmp.isEmpty()){
            JOptionPane.showMessageDialog(this,"Danh sách công tơ điện rỗng","Error",JOptionPane.WARNING_MESSAGE);
        }else{
            for(E_Meters a:tmp){
            this.cbCongto.addItem(a);
            }
             actionconToCB();
        }
       
    }
    private void actionconToCB(){
        this.cbCongto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    E_Meters selectedEmeter=(E_Meters) cbCongto.getSelectedItem();
                    if(selectedEmeter!=null){
                        int oldNum=0;
                        E_Meter_Details tmp=null;
                        try {
                            tmp=new GhiChiSoDialogController().getLastRecordbyEmeterID(selectedEmeter.getID_E_Meter());
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        if(tmp!=null){
                            oldNumTxt.setText(String.valueOf(tmp.getCurrent_num()));
                        }else{
                            oldNumTxt.setText("0");
                        }    
                    }
               
                }
               
            });
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnGhi = new javax.swing.JButton();
        txtDate = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        oldNumTxt = new javax.swing.JTextField();
        txtSoNuocMoi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnGhi1 = new javax.swing.JButton();
        chuhoCB = new LayMotSoUIdepTaiDay.ComboboxThuong();
        cbCongto = new LayMotSoUIdepTaiDay.ComboboxThuong();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("GHI SỐ ĐIỆN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(161, 161, 161))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(16, 16, 16))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("THÁNG :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("ID_CongTo:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("SỐ ĐIỆN CŨ:");

        btnGhi.setText("Ghi");
        btnGhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhiActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("SỐ ĐIỆN MỚI");

        oldNumTxt.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("CHỦ HỘ:");

        btnGhi1.setText("Thoát");
        btnGhi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhi1ActionPerformed(evt);
            }
        });

        chuhoCB.setBackground(new java.awt.Color(204, 204, 204));
        chuhoCB.setLabeText("gh");

        cbCongto.setLabeText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)))
                    .addComponent(jLabel5))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSoNuocMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(oldNumTxt)
                    .addComponent(chuhoCB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbCongto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGhi, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGhi1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(chuhoCB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbCongto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(oldNumTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoNuocMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGhi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGhi1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhiActionPerformed
        // TODO add your handling code here:
      int option = JOptionPane.showConfirmDialog(
                        this,
                        "Bạn có muốn chắc muốn ghi điện hay không?",
                        "Xác nhận ghi điện",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
            );
      if(option==JOptionPane.YES_OPTION){
        if(oldNumTxt.getText().equals("")||txtSoNuocMoi.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Vui lòng chọn các thông tin cần thiết để ghi điện","Error",JOptionPane.WARNING_MESSAGE);
        }else{
            
            String date =txtDate.getText();
            String dateStr = txtDate.getText();
            Date creatingDate;
            creatingDate = Date.valueOf(dateStr);
            
            String idemeter=cbCongto.getSelectedItem().toString();
            int currentNum=Integer.parseInt(txtSoNuocMoi.getText().trim());
            int previousNum=Integer.parseInt(oldNumTxt.getText().trim());
            
            if(currentNum<previousNum){
                JOptionPane.showMessageDialog(this,"Số điện mới phải nhỏ hơn số điện cũ","Error",JOptionPane.WARNING_MESSAGE);
            }else{
                E_Meter_Details tmp=new E_Meter_Details(0,idemeter, currentNum, creatingDate, this.idstafflogin);
                
                if(new GhiChiSoDialogController().checkifExistDetail(tmp)){
                    JOptionPane.showMessageDialog(this,"Đã ghi điện tháng này","Warning",JOptionPane.WARNING_MESSAGE);  
                }else{
                    boolean result=new GhiChiSoDialogController().addNewEmeterDetail(tmp);
                    if(result){
                        JOptionPane.showMessageDialog(this,"Ghi chỉ số thành công","Success",JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    }else{
                        JOptionPane.showMessageDialog(this,"Ghi chỉ số thất bại","Error",JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }
      }
//        E_Meter_DetailsDAO hdd = new E_Meter_DetailsDAO();
//    
//
//            String sonuoccu = oldNumTxt.getText().trim();
//            String sonuocmoi = txtSoNuocMoi.getText().trim();
//            int sonuocmoiINT= Integer.valueOf(sonuocmoi);
//
//            String kiemtraso = "^[0-9.+]+$";
//            if (!hdd.checkExistEMetter(txtChuHo.getText())) {
//                JOptionPane.showMessageDialog(this, "Không tìm thấy Công tơ Điện!");
//            } 
//
//             else if (sonuocmoi.isEmpty()) {
//                JOptionPane.showMessageDialog(this, "Không được để trống số điện. Vui lòng nhập lại!");
//            }
//            else if (!sonuoccu.matches(kiemtraso)) {
//                JOptionPane.showMessageDialog(this, "Định dạng số điện sai. Vui lòng nhập lại!");
//            } else if (!sonuocmoi.matches(kiemtraso)) {
//                JOptionPane.showMessageDialog(this, "Định dạng số điện sai. Vui lòng nhập lại!");
//            }  else {
//
//              
//                float sonuoccuf = Float.parseFloat(oldNumTxt.getText().trim());
//                float sonuocmoif = Float.parseFloat(txtSoNuocMoi.getText().trim());
//
//                if (sonuocmoif < sonuoccuf) {
//                    JOptionPane.showMessageDialog(this, "Số nước mới không thể thấp hơn số điện cũ. Vui lòng nhập lại!");
//                } else {
//                    int test = JOptionPane.showConfirmDialog(null, "Bạn chắc có muốn thêm số điện  hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
//                    if (test == JOptionPane.YES_OPTION) {
////                        AddDichVu();
////                        AddHoaDonPhong();
////                        CapNhatDichVuPhong();
////                        showTable();
//                    
////                        hdd.addBangSDNuoc(date_, txtChuHo.getText(), txtSoNuocCu.getText().trim(), txtSoNuocMoi.getText().trim());
////                        hdd.addHoaDonNuoc(date_, txtChuHo.getText(), txtSoNuocCu.getText().trim(), txtSoNuocMoi.getText().trim());
//                           hdd.AddEmetter(txtChuHo.getText(),sonuocmoiINT,idstaflogn,_date);
//                           this.dispose();
//                    } else if (test == JOptionPane.NO_OPTION) {
//                        JOptionPane.showMessageDialog(this, "Bạn đã hủy cập nhật thành công");
//                    }
//                }
//            }
//        
        
        
    }//GEN-LAST:event_btnGhiActionPerformed

    private void btnGhi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhi1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        
    }//GEN-LAST:event_btnGhi1ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
// /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(JDialogGhiSoNuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JDialogGhiSoNuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JDialogGhiSoNuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JDialogGhiSoNuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
////                GhiChiSoDialog dialog = new GhiChiSoDialog(true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGhi;
    private javax.swing.JButton btnGhi1;
    private LayMotSoUIdepTaiDay.ComboboxThuong cbCongto;
    private LayMotSoUIdepTaiDay.ComboboxThuong chuhoCB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField oldNumTxt;
    private javax.swing.JLabel txtDate;
    private javax.swing.JTextField txtSoNuocMoi;
    // End of variables declaration//GEN-END:variables

//    public void setData(Map data)
//    {
//        txtDate.setText((String) data.get("thangghi"));
//        date_=(String) data.get("thangghi1");
//      //  System.out.println("ngay2 set data"+(String) data.get("thangghi1"));
//    }
}
