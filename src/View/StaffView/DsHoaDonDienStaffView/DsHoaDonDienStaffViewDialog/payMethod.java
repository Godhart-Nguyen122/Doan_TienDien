/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View.StaffView.DsHoaDonDienStaffView.DsHoaDonDienStaffViewDialog;

import Controller.StaffView.DSHoaDonStaffviewController;
import View.StaffView.DsHoaDonDienStaffView.DSHoaDonStaffView;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bao
 */
public class payMethod extends javax.swing.JDialog {

    private DSHoaDonStaffView dSHoaDonStaffView;
    private int invoiceId;
            
    public payMethod(DSHoaDonStaffView dSHoaDonStaffView, boolean modal) {
        initComponents();
        this.setLocationRelativeTo(this.dSHoaDonStaffView);
        this.dSHoaDonStaffView=dSHoaDonStaffView;
        this.invoiceId=dSHoaDonStaffView.getSelectedInvoiceId();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        payMethodCb = new LayMotSoUIdepTaiDay.ComboboxThuong();
        buttonThuong1 = new LayMotSoUIdepTaiDay.ButtonThuong();
        buttonThuong2 = new LayMotSoUIdepTaiDay.ButtonThuong();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("HÌNH THỨC THANH TOÁN");

        payMethodCb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tiền mặt ", "Chuyển khoản", " " }));
        payMethodCb.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        payMethodCb.setLabeText("");

        buttonThuong1.setText("OK");
        buttonThuong1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonThuong1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonThuong1ActionPerformed(evt);
            }
        });

        buttonThuong2.setText("BỎ");
        buttonThuong2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonThuong2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonThuong2ActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(payMethodCb, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonThuong1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonThuong2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(payMethodCb, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonThuong1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonThuong2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(91, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonThuong1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonThuong1ActionPerformed
        String pay=(String)payMethodCb.getSelectedItem();
        if(pay.equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn hình thức thanh toán", "Warning", JOptionPane.WARNING_MESSAGE);
        }else{
            boolean check=false;
            try {
                check=new DSHoaDonStaffviewController().CheckIfExistInvoiceIDinPaidInvoice(this.invoiceId);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if(check==true){
                JOptionPane.showMessageDialog(null, "Hóa đơn đã thanh toán, không được thanh toán lần nữa!", "Warning", JOptionPane.INFORMATION_MESSAGE);
            }else{
                try {
                    boolean result=new DSHoaDonStaffviewController().payInvoice(invoiceId, pay);
                    if(result){
                        JOptionPane.showMessageDialog(null, "Thanh toán thành công hóa đơn", "Warning", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "Thanh toán hóa đơn thất bại", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }    
        }
    }//GEN-LAST:event_buttonThuong1ActionPerformed

    private void buttonThuong2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonThuong2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonThuong2ActionPerformed

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.ButtonThuong buttonThuong1;
    private LayMotSoUIdepTaiDay.ButtonThuong buttonThuong2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private LayMotSoUIdepTaiDay.ComboboxThuong payMethodCb;
    // End of variables declaration//GEN-END:variables
}
