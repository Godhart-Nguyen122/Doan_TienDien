/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View.CustomerView.DSHoaDonDien;

import Controller.DSHoaDonController.DSHoaDonController;
import View.AdminView.DSHoaDonView.DSHoaDonMainView;
import View.CustomerView.MainCustomerView;
import static java.awt.Dialog.DEFAULT_MODALITY_TYPE;
import javax.swing.JOptionPane;

/**
 *
 * @author vduct
 */
public class SortLoaiStringDSHoaDonDialog extends javax.swing.JDialog {

    private MainCustomerView mctv;
    private DSHoaDonDien dSHoaDonDien;
    
    public SortLoaiStringDSHoaDonDialog(MainCustomerView cv, DSHoaDonDien dshdd, boolean modal) {
        initComponents();
        this.mctv = cv;
        this.dSHoaDonDien = dshdd;
        this.setModalityType(DEFAULT_MODALITY_TYPE.APPLICATION_MODAL);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        OkBt = new javax.swing.JButton();
        CancelBt = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        AZCkb = new LayMotSoUIdepTaiDay.CheckBox();
        ZACkb = new LayMotSoUIdepTaiDay.CheckBox();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        OkBt.setText("Ok");
        OkBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkBtActionPerformed(evt);
            }
        });

        CancelBt.setText("Cancel");
        CancelBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("SẮP XẾP THEO CHUỖI:");

        AZCkb.setBackground(new java.awt.Color(0, 0, 0));
        AZCkb.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        AZCkb.setText("Từ A đến Z (bé đến lớn)");

        ZACkb.setBackground(new java.awt.Color(0, 0, 0));
        ZACkb.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ZACkb.setText("Từ Z đến A (lớn đến bé)");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Theo thứ tự:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(AZCkb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(OkBt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(ZACkb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CancelBt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AZCkb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ZACkb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelBt)
                    .addComponent(OkBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkBtActionPerformed
        if(!AZCkb.isSelected() && !ZACkb.isSelected()){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại sắp xếp!!!");
        }else if(AZCkb.isSelected()){
            SortDialog(1);
            JOptionPane.showMessageDialog(this, "Đã sắp xếp chuỗi theo thứ tự A-Z");
            this.dispose();
        }else{
            SortDialog(2);
            JOptionPane.showMessageDialog(this, "Đã sắp xếp chuỗi theo thứ tự Z-A");
            this.dispose();
        }
    }//GEN-LAST:event_OkBtActionPerformed

    private void CancelBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelBtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.CheckBox AZCkb;
    private javax.swing.JButton CancelBt;
    private javax.swing.JButton OkBt;
    private LayMotSoUIdepTaiDay.CheckBox ZACkb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    private void SortDialog(int loaiSapXep) {
        Object selected = this.dSHoaDonDien.getSapXepCkb().getSelectedItem();
        if(selected.equals("Theo ID")){
            DSHoaDonController.Sorting(loaiSapXep, 1, dSHoaDonDien.getBangDSHoaDon());
        }else if(selected.equals("Theo nhân viên")){
            DSHoaDonController.Sorting(loaiSapXep, 2, dSHoaDonDien.getBangDSHoaDon());                
        }else if(selected.equals("Theo mức điện")){
            DSHoaDonController.Sorting(loaiSapXep, 3, dSHoaDonDien.getBangDSHoaDon());                
        }else if(selected.equals("Theo số kwh")){
            DSHoaDonController.Sorting(loaiSapXep, 4, dSHoaDonDien.getBangDSHoaDon());                
        }else if(selected.equals("Theo Ngày ")){
            DSHoaDonController.Sorting(loaiSapXep, 5, dSHoaDonDien.getBangDSHoaDon());                
        }else if(selected.equals("Theo Tổng tiền")){
            DSHoaDonController.Sorting(loaiSapXep, 6, dSHoaDonDien.getBangDSHoaDon());                
        }
    }
}
