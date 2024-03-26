package View.AdminView.ThongTinSuDungDien.ThongTinSDDienForm;

import View.AdminView.MainAdminView;
import javax.swing.JOptionPane;

public class ThemCongToDien extends javax.swing.JDialog {
//    private MainAdminView mainNhanVienView;
//    private ThongTinSDDienView thongTinSDDienView;
    
    public ThemCongToDien(MainAdminView mnv, boolean modal) {
//        this.mainNhanVienView = mnv;
//        this.thongTinSDDienView = ttsd;
        initComponents();       
//        this.setResizable(false);
//        this.setTitle("Thêm thông tin công tơ điện");
//        this.setModalityType(DEFAULT_MODALITY_TYPE.APPLICATION_MODAL);
//        this.setLocationRelativeTo(null);
//        
//        if(thongTinSDDienView.getThongTinSuDung() != null){
//            this.CCCDTF.setText(thongTinSDDienView.getThongTinSuDung().getCCCD());
//        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        CCCDTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        HinhThucOTF = new javax.swing.JTextField();
        DiaChiTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        OkBT = new javax.swing.JButton();
        HuyBT = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        IDConToTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("CCCD:");

        CCCDTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CCCDTFActionPerformed(evt);
            }
        });

        jLabel2.setText("Hình thức ở:");

        jLabel3.setText("Địa chỉ:");

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

        jLabel4.setText("ID công tơ:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(IDConToTF, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(HinhThucOTF, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(OkBT, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(HuyBT, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(DiaChiTF, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CCCDTF, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CCCDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(IDConToTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HinhThucOTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DiaChiTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OkBT)
                    .addComponent(HuyBT))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkBTActionPerformed
//        // Kiểm tra Text field có bị trống không
//       
//        if(CCCDTF.getText().equals("") || IDConToTF.getText().equals("") || HinhThucOTF.getText().equals("")
//           || DiaChiTF.getText().equals("")){
//            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
//        } 
////        else if(!(CheckTruongDuLieu.KtraCCCD(CCCDTF.getText()))){
////            JOptionPane.showMessageDialog(this, "Vui lòng xem lại thông tin CCCD hợp lệ!");
////        }
////        else if(!new CheckTruongDuLieu().KtraCCCDTonTai(CCCDTF.getText())){
////            JOptionPane.showMessageDialog(this, "CCCD:" + CCCDTF.getText() + " không tồn tại!");
////        }
//        else if(!new CheckTruongDuLieu().KtraIDCongTo(IDConToTF.getText())){
//            JOptionPane.showMessageDialog(this, "Vui lòng xem lại thông tin ID công tơ điện!");
//        }
//        else if(!new CheckTruongDuLieu().KtraTonTaiIDCongTo(IDConToTF.getText())){
//            JOptionPane.showMessageDialog(this, "Công tơ điện có ID: " + IDConToTF.getText() + " đã tồn tại!");
//        }
//      
//        else {    
//            
//            int confirm = JOptionPane.showConfirmDialog(
//                this,
//                "Bạn có chắc muốn thêm công tơ điện cho chủ hộ với CCCD: " + CCCDTF.getText() + " không?",
//            "Xác nhận thêm",
//            JOptionPane.YES_NO_OPTION
//            );
//            if (confirm == JOptionPane.YES_OPTION) {
//                new DSThongTinSDController().ThemCongToDien( IDConToTF.getText(), HinhThucOTF.getText(), DiaChiTF.getText());
//                JOptionPane.showMessageDialog(this, "Đã thêm công tơ điện cho chủ hộ có CCCD: " + CCCDTF.getText());
//            
//                mainNhanVienView.setForm(new ThongTinSDDienView(mainNhanVienView));
//                this.dispose();
//            }       
//            this.dispose();
//        }        
    }//GEN-LAST:event_OkBTActionPerformed

    private void HuyBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HuyBTActionPerformed
        this.dispose();
    }//GEN-LAST:event_HuyBTActionPerformed

    private void CCCDTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CCCDTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CCCDTFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CCCDTF;
    private javax.swing.JTextField DiaChiTF;
    private javax.swing.JTextField HinhThucOTF;
    private javax.swing.JButton HuyBT;
    private javax.swing.JTextField IDConToTF;
    private javax.swing.JButton OkBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
