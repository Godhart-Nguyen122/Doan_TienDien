package View.AdminView.ThongTinSuDungDien.ThongTinSDDienForm;

import Controller.SupportFunction.CheckingDataExist;
import Controller.SupportFunction.StringProcessing;
import View.AdminView.MainAdminView;
import javax.swing.JOptionPane;

public class CapNhatCongToDien extends javax.swing.JDialog {
//    private MainAdminView mainNhanVienView;
//    private ThongTinSDDienView thongTinSDDienView;
    public CapNhatCongToDien(MainAdminView mnv, boolean modal) {
//        this.mainNhanVienView = mnv;
//        this.thongTinSDDienView = ttsd;
//        this.setResizable(false);
//        this.setLocationRelativeTo(null);
//        this.setTitle("Cập nhật thông tin công tơ điện");
//        initComponents();
//        
//        CccdTF.setEnabled(false);
//        IDcuTF.setEnabled(false);
//        CccdTF.setText(thongTinSDDienView.getThongTinSuDung().getCCCD());
//        IDcuTF.setText(thongTinSDDienView.getThongTinSuDung().getID_E_Meter());
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HuyBT = new javax.swing.JButton();
        OkBT = new javax.swing.JButton();
        IDcuTF = new javax.swing.JTextField();
        CccdTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        IDMoiTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        DiaChiTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        HinhThucOTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        HuyBT.setText("Hủy");
        HuyBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HuyBTActionPerformed(evt);
            }
        });

        OkBT.setText("OK");
        OkBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkBTActionPerformed(evt);
            }
        });

        IDcuTF.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        IDcuTF.setForeground(new java.awt.Color(0, 0, 0));

        CccdTF.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CccdTF.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setText("CCCD:");

        jLabel3.setText("Mã số công tơ điện (cũ):");

        jLabel4.setText("Mã số công tơ điện (mới):");

        jLabel5.setText("Địa chỉ:");

        jLabel1.setText("Hình thức ở:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(OkBT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(HuyBT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DiaChiTF)
                            .addComponent(IDMoiTF)
                            .addComponent(IDcuTF)
                            .addComponent(CccdTF, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(HinhThucOTF))))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CccdTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDcuTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDMoiTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DiaChiTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(HinhThucOTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OkBT)
                    .addComponent(HuyBT))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HuyBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HuyBTActionPerformed
        this.dispose();
    }//GEN-LAST:event_HuyBTActionPerformed

    private void OkBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkBTActionPerformed
//        // Kiểm tra Text field có bị trống không
//        if(IDMoiTF.getText().equals("") || DiaChiTF.getText().equals("") || HinhThucOTF.getText().equals("")){
//            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
//        }
//        else if(!new StringProcessing().CheckID_E_Meter(IDMoiTF.getText())){
//            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã số công tơ điện hợp lệ!");
//        }
//        else if(!new CheckingDataExist().CheckExistID_E_Meter(IDMoiTF.getText())){
//            JOptionPane.showMessageDialog(this, "Mã số công tơ điện: " + IDMoiTF.getText() + " đã tồn tại!");
//        }
//        else {  
//            int confirm = JOptionPane.showConfirmDialog(
//                this,
//                "Bạn có chắc muốn cập nhật công tơ điện chủ hộ có CCCD: " + CccdTF.getText() + " không?",
//            "Xác nhận cập nhật",
//            JOptionPane.YES_NO_OPTION
//            );
//
//            if (confirm == JOptionPane.YES_OPTION) {
//                
//                mainNhanVienView.setForm(new ThongTinSDDienView(mainNhanVienView));
//                
//                this.dispose();          
//            } 
//        }
        
    }//GEN-LAST:event_OkBTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CccdTF;
    private javax.swing.JTextField DiaChiTF;
    private javax.swing.JTextField HinhThucOTF;
    private javax.swing.JButton HuyBT;
    private javax.swing.JTextField IDMoiTF;
    private javax.swing.JTextField IDcuTF;
    private javax.swing.JButton OkBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
