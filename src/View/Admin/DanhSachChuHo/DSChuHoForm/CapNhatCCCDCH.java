package View.Admin.DanhSachChuHo.DSChuHoForm;

import Component.CheckTruongDuLieu;
import Controller.ChuHoController.DSChuHoController;
import Controller.NVController.DSNVController;
import View.Admin.DSNhanVien.DSNhanVienView;
import View.Admin.MainAdminView;
import javax.swing.JOptionPane;

public class CapNhatCCCDCH extends javax.swing.JDialog {
    private MainAdminView mainAdminView;
    private DSNhanVienView dSNVView;
    public CapNhatCCCDCH(MainAdminView Frame, DSNhanVienView FrameNVView, boolean modal) {
        initComponents();
        this.mainAdminView = Frame;
        this.dSNVView = FrameNVView;
        this.setResizable(false);
        this.setTitle("Cập nhật CCCD chủ hộ");
        this.setModalityType(DEFAULT_MODALITY_TYPE.APPLICATION_MODAL);
        this.setLocationRelativeTo(null);
        
        CCCDcuTF.setText(dSNVView.getNV().getCCCD());
        CCCDcuTF.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        CCCDcuTF = new javax.swing.JTextField();
        OkBT = new javax.swing.JButton();
        HuyBT = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        CCCDMoiTF = new javax.swing.JTextField();
        Logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("CCCD cũ:");

        CCCDcuTF.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CCCDcuTF.setForeground(new java.awt.Color(0, 0, 0));

        OkBT.setText("OK");
        OkBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkBTActionPerformed(evt);
            }
        });

        HuyBT.setText("Hủy");
        HuyBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HuyBTActionPerformed(evt);
            }
        });

        jLabel3.setText("CCCD mới:");

        Logo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Warning.png"))); // NOI18N
        Logo.setText("Cảnh báo:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Việc đổi CCCD sang mã số mới đồng nghĩa");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("với việc sau này mọi thông tin tài khoản sẽ ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("phụ thuộc vào CCCD mới. Bạn nên cân nhắc");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("kỹ về lựa chọn này!!!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addGap(0, 38, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(OkBT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(HuyBT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CCCDcuTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(CCCDMoiTF, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Logo)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CCCDcuTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CCCDMoiTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addContainerGap(70, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(HuyBT)
                            .addComponent(OkBT))
                        .addGap(23, 23, 23))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkBTActionPerformed
        // Kiểm tra Text field có bị trống không
        if(CCCDMoiTF.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
        }else if(!(new CheckTruongDuLieu().KtraCCCD(CCCDMoiTF.getText()))){
            JOptionPane.showMessageDialog(this, "Vui lòng xem lại và nhập thông tin hợp lệ!");
        }else if(new CheckTruongDuLieu().KtraCCCDTonTai(CCCDMoiTF.getText())){
            JOptionPane.showMessageDialog(this, "CCCD đã tồn tại!!!");
        }
        else {  
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Xác nhận lại một lần nữa bạn có CHẮC CHẮN muốn cập nhật CCCD chủ hộ có tên: " + dSNVView.getNV().getUsername()+ " không?",
            "Xác nhận cập nhật",
            JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {

                JOptionPane.showMessageDialog(this, "Đã cập nhật CCCD của chủ hộ có tên: " + dSNVView.getNV().getUsername());
                
                new DSNVController().CapNhatCCCDChuHo(dSNVView.getNV(), CCCDMoiTF.getText());
                
                mainAdminView.setForm(new DSNhanVienView(mainAdminView));
                
                this.dispose();          
            }
            this.dispose();   
        }   
    }//GEN-LAST:event_OkBTActionPerformed

    private void HuyBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HuyBTActionPerformed
        this.dispose();
    }//GEN-LAST:event_HuyBTActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CCCDMoiTF;
    private javax.swing.JTextField CCCDcuTF;
    private javax.swing.JButton HuyBT;
    private javax.swing.JLabel Logo;
    private javax.swing.JButton OkBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
