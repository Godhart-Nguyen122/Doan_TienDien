package View.Admin.DanhSachChuHo.DSChuHoForm;

import Component.CheckTruongDuLieu;
import Controller.ChuHoController.DSChuHoController;
import View.Admin.DanhSachChuHo.DSChuHoView;
import View.Admin.MainAdminView;
import javax.swing.JOptionPane;

public class CapNhatAccountCH extends javax.swing.JDialog {
    private MainAdminView mainNhanVienView;
    private DSChuHoView dSChuHoView;
    public CapNhatAccountCH(MainAdminView Frame, DSChuHoView FrameChuHoView, boolean modal) {
        initComponents();
        this.mainNhanVienView = Frame;
        this.dSChuHoView = FrameChuHoView;
        this.setResizable(false);
        this.setTitle("Cập nhật Account chủ hộ");
        this.setModalityType(DEFAULT_MODALITY_TYPE.APPLICATION_MODAL);
        this.setLocationRelativeTo(null);
        
        AccountTF.setText(dSChuHoView.getChuHo().getAccount_username());
        PassTF.setText(dSChuHoView.getChuHo().getPassword());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        AccountTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        PassTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ConfirmPassTF = new javax.swing.JTextField();
        OkBT = new javax.swing.JButton();
        HuyBT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Account:");

        jLabel2.setText("Password:");

        jLabel3.setText("Confirm password:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(47, 47, 47)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PassTF, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AccountTF, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConfirmPassTF, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(OkBT, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(HuyBT, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(AccountTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(PassTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ConfirmPassTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OkBT)
                    .addComponent(HuyBT))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkBTActionPerformed
        // Kiểm tra Text field có bị trống không
        if(AccountTF.getText().isEmpty() || PassTF.getText().isEmpty() || ConfirmPassTF.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
        }else if(!(PassTF.getText().equals(ConfirmPassTF.getText()))){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin hợp lệ!");
        }
        else if(!(new CheckTruongDuLieu().KtraTonTaiAccountUsername(AccountTF.getText()))){
            JOptionPane.showMessageDialog(this, "Tên Account đã tồn tại!");
        }
        else {  
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Bạn có chắc muốn cập nhật Account chủ hộ có CCCD: " + dSChuHoView.getChuHo().getCCCD() + " không?",
            "Xác nhận cập nhật",
            JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {

                JOptionPane.showMessageDialog(this, "Đã cập nhật thông tin Account của chủ hộ có CCCD: " + dSChuHoView.getChuHo().getCCCD());
                
                new DSChuHoController().CapNhatAccountChuHo(dSChuHoView.getChuHo(), AccountTF.getText(), PassTF.getText());
                
                mainNhanVienView.setForm(new DSChuHoView(mainNhanVienView));
                
                this.dispose();          
            }
            this.dispose();   
        }   
    }//GEN-LAST:event_OkBTActionPerformed

    private void HuyBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HuyBTActionPerformed
        this.dispose();
    }//GEN-LAST:event_HuyBTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AccountTF;
    private javax.swing.JTextField ConfirmPassTF;
    private javax.swing.JButton HuyBT;
    private javax.swing.JButton OkBT;
    private javax.swing.JTextField PassTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
