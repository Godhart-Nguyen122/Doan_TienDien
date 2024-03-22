package View.Admin.DanhSachChuHo.DSChuHoForm;

import Component.CheckTruongDuLieu;
import Controller.ChuHoController.DSChuHoController;
import View.Admin.DanhSachChuHo.DSChuHoView;
import View.Admin.MainAdminView;
import javax.swing.JOptionPane;

public class XoaChuHoDialog extends javax.swing.JDialog {
    private MainAdminView mainAdminView;
    private DSChuHoView dSChuHoView;
    public XoaChuHoDialog(MainAdminView Frame, DSChuHoView FrameChuHoView, boolean modal) {
        initComponents();
        this.mainAdminView = Frame;
        this.dSChuHoView = FrameChuHoView;
        this.setSize(400, 175);
        this.setResizable(false);
        this.setTitle("Xóa chủ hộ");
        this.setModalityType(DEFAULT_MODALITY_TYPE.APPLICATION_MODAL);
        this.setLocationRelativeTo(null);
        
        if(dSChuHoView.getChuHo() != null){
            cccdTf.setText(dSChuHoView.getChuHo().getCCCD());
        }  
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cccdTf = new javax.swing.JTextField();
        cccdLbl = new javax.swing.JLabel();
        okBtn = new javax.swing.JButton();
        hủyBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(420, 120));

        cccdLbl.setText("Nhập CCCD cần xóa:");

        okBtn.setText("OK");
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });

        hủyBtn.setText("Hủy");
        hủyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hủyBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(cccdLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(okBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hủyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cccdTf, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cccdTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cccdLbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hủyBtn)
                    .addComponent(okBtn))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed
        //Kiểm tra Text field có bị trống không
        if(cccdTf.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng không được bỏ trống");
        }else if(!(CheckTruongDuLieu.KtraCCCD(cccdTf.getText()))){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng CCCD (phải là các chữ số có đủ 12 ký tự)");
        }else if(!(new CheckTruongDuLieu().KtraCCCDTonTai(cccdTf.getText()))){
            JOptionPane.showMessageDialog(this, "Chủ hộ có CCCD: " + cccdTf.getText() + " không tồn tại!");
        }else{
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Bạn có chắc muốn xóa chủ hộ có CCCD: " + cccdTf.getText() + " không?",
            "Xác nhận xóa",
            JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                new DSChuHoController().XoaChuHo(cccdTf.getText());
                JOptionPane.showMessageDialog(this, "Đã xóa chủ hộ có CCCD: " + cccdTf.getText() + " thành công!");

                mainAdminView.CapNhatBangTrangThai();
                mainAdminView.setForm(new DSChuHoView(mainAdminView));

                this.dispose();
            }
        }
    }//GEN-LAST:event_okBtnActionPerformed

    private void hủyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hủyBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_hủyBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cccdLbl;
    private javax.swing.JTextField cccdTf;
    private javax.swing.JButton hủyBtn;
    private javax.swing.JButton okBtn;
    // End of variables declaration//GEN-END:variables
}
