package View.Admin.DanhSachChuHo.DSChuHoForm;

import Component.CheckTruongDuLieu;
import Controller.ChuHoController.DSChuHoController;
import Controller.PersonalInFoController.DSPersonalInfoController;
import Model.ChuHo;
import View.Admin.DanhSachChuHo.DSChuHoView;
import View.Admin.MainAdminView;
import javax.swing.JOptionPane;

public class ThemChuHoDialog extends javax.swing.JDialog {
    private MainAdminView mainNhanVienView;
    
    public ThemChuHoDialog(MainAdminView Frame,boolean modal) {
        this.mainNhanVienView = Frame;
        initComponents();
        this.setResizable(false);
        this.setTitle("Thêm chủ hộ");
        this.setModalityType(DEFAULT_MODALITY_TYPE.APPLICATION_MODAL);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SdtTF = new javax.swing.JTextField();
        cccdNVTF = new javax.swing.JTextField();
        okBT = new javax.swing.JButton();
        huyBT = new javax.swing.JButton();
        HoTenTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cccdLbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        manvLbl = new javax.swing.JLabel();
        DiaChiTF = new javax.swing.JTextField();
        CccdTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        AccountTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        PassTF = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        PassConfirmTF = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        DobDC = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        okBT.setText("OK");
        okBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBTActionPerformed(evt);
            }
        });

        huyBT.setText("Hủy");
        huyBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huyBTActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Họ tên:");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Ngày sinh:");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        cccdLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cccdLbl.setText("CCCD:");
        cccdLbl.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Địa chỉ:");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        manvLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        manvLbl.setText("CCCD nhân viên:");
        manvLbl.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Số điên thoại:");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel5.setText("Username:");

        jLabel6.setText("Password: ");

        jLabel7.setText("Confirm password:");

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        DobDC.setDateFormatString("yyyy / MM / dd");
        DobDC.setMinSelectableDate(new java.util.Date(-62135791121000L));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cccdLbl)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(manvLbl)
                    .addComponent(jLabel4))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DiaChiTF, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(HoTenTF, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(SdtTF, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(cccdNVTF, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(CccdTF, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(DobDC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AccountTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(PassTF, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PassConfirmTF))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addComponent(okBT, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(huyBT, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cccdLbl)
                    .addComponent(CccdTF, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HoTenTF, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(AccountTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel6)
                        .addComponent(PassTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(DobDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(DiaChiTF, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(PassConfirmTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(SdtTF, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cccdNVTF, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(manvLbl)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(okBT)
                            .addComponent(huyBT))))
                .addContainerGap(23, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBTActionPerformed
        // Kiểm tra Text field có bị trống không
        if(CccdTF.getText().equals("") || SdtTF.getText().equals("") || HoTenTF.getText().equals("") 
            || DiaChiTF.getText().equals("") || cccdNVTF.getText().equals("")
            || AccountTF.getText().equals("") || PassTF.getText().equals("") || PassConfirmTF.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
        } 
        else if(!PassTF.getText().equals(PassConfirmTF.getText())){
            JOptionPane.showMessageDialog(this, "Vui lòng xác nhận đúng mật khẩu bạn đã nhập!");
        }
        else if(!(new CheckTruongDuLieu().KtraTonTaiAccountUsername(AccountTF.getText()))){
            JOptionPane.showMessageDialog(this, "Tên Account đã tồn tại!");
        }
        else if(!(CheckTruongDuLieu.KtraCCCD(CccdTF.getText()) && CheckTruongDuLieu.KtraCCCD(cccdNVTF.getText()) && CheckTruongDuLieu.KtraSDT(SdtTF.getText()) && CheckTruongDuLieu.KtraDate(DobDC))){
            JOptionPane.showMessageDialog(this, "Vui lòng xem lại và nhập thông tin hợp lệ!");
        }
        else if(new CheckTruongDuLieu().KtraCCCDTonTai(CccdTF.getText())){
            JOptionPane.showMessageDialog(this, "CCCD đã tồn tại! Có thể đã nằm trên hệ thống và chỉ được ẩn đi!");
        } 
        else {    
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Bạn có chắc muốn thêm chủ hộ với CCCD: " + CccdTF.getText() + " không?",
            "Xác nhận thêm",
            JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                ChuHo chuHo;
                chuHo = new ChuHo(CccdTF.getText(), HoTenTF.getText(), DiaChiTF.getText(), SdtTF.getText(), new java.sql.Date(DobDC.getDate().getTime()));
//                new DSChuHoController().ThemChuHo(chuHo, AccountTF.getText(), PassTF.getText(), cccdNVTF.getText());
                JOptionPane.showMessageDialog(this, "Đã thêm tài khoản của chủ hộ có CCCD: " + CccdTF.getText());
            
                mainNhanVienView.CapNhatBangTrangThai();
                mainNhanVienView.setForm(new DSChuHoView(mainNhanVienView));
                this.dispose();
            }       
            this.dispose();
        }
    }//GEN-LAST:event_okBTActionPerformed

    private void huyBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huyBTActionPerformed
        this.dispose();
    }//GEN-LAST:event_huyBTActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AccountTF;
    private javax.swing.JTextField CccdTF;
    private javax.swing.JTextField DiaChiTF;
    private com.toedter.calendar.JDateChooser DobDC;
    private javax.swing.JTextField HoTenTF;
    private javax.swing.JPasswordField PassConfirmTF;
    private javax.swing.JPasswordField PassTF;
    private javax.swing.JTextField SdtTF;
    private javax.swing.JLabel cccdLbl;
    private javax.swing.JTextField cccdNVTF;
    private javax.swing.JButton huyBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel manvLbl;
    private javax.swing.JButton okBT;
    // End of variables declaration//GEN-END:variables
}
