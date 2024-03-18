/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.Admin.QLPQTaiKhoan;

import View.Admin.MainAdminView;
import View.Admin.QLPQTaiKhoan.form.*;

/**
 *
 * @author vduct
 */
public class QLPQTaiKhoan extends javax.swing.JPanel {

    /**
     * Creates new form QLPQTaiKhoan
     */
    private MainAdminView mainAdminView = new MainAdminView();
    public QLPQTaiKhoan(MainAdminView mnv) {
        initComponents();
        this.mainAdminView = mnv;
        this.setSize(mainAdminView.getMainPanel().getSize());
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScrollPane = new javax.swing.JScrollPane();
        BangDSChuHo = new LayMotSoUIdepTaiDay.BangDanhSach();
        TimKiemTF = new javax.swing.JTextField();
        TimKiemButton = new LayMotSoUIdepTaiDay.ButtonThuong();
        capNhatButton = new LayMotSoUIdepTaiDay.ButtonThuong();
        phanCongButton = new LayMotSoUIdepTaiDay.ButtonThuong();
        xoaButton = new LayMotSoUIdepTaiDay.ButtonThuong();
        refreshButton = new LayMotSoUIdepTaiDay.ButtonThuong();
        filterComboBox = new LayMotSoUIdepTaiDay.ComboboxThuong();
        sortCombobox = new LayMotSoUIdepTaiDay.ComboboxThuong();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        BangDSChuHo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CCCD", "Account", "Password", "Phân quyền", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        BangDSChuHo.getTableHeader().setReorderingAllowed(false);
        ScrollPane.setViewportView(BangDSChuHo);

        TimKiemTF.setBackground(new java.awt.Color(231, 231, 231));
        TimKiemTF.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        TimKiemButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/search.png"))); // NOI18N
        TimKiemButton.setText("Tìm kiếm");
        TimKiemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimKiemButtonActionPerformed(evt);
            }
        });

        capNhatButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/6.png"))); // NOI18N
        capNhatButton.setText("Xóa");
        capNhatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capNhatButtonActionPerformed(evt);
            }
        });

        phanCongButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/6.png"))); // NOI18N
        phanCongButton.setText("Thêm");
        phanCongButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phanCongButtonActionPerformed(evt);
            }
        });

        xoaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/6.png"))); // NOI18N
        xoaButton.setText("Sửa");
        xoaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaButtonActionPerformed(evt);
            }
        });

        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/6.png"))); // NOI18N
        refreshButton.setText("Làm Mới");

        filterComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", " " }));
        filterComboBox.setLabeText("Trạng thái");

        sortCombobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1" }));
        sortCombobox.setToolTipText("");
        sortCombobox.setLabeText("Phân quyền\n");

        jLabel1.setText("Phân quyền:");

        jLabel2.setText("Trạng thái:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TimKiemTF, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TimKiemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phanCongButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(capNhatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xoaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sortCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TimKiemTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TimKiemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(phanCongButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(capNhatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(xoaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sortCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(filterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TimKiemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemButtonActionPerformed

    }//GEN-LAST:event_TimKiemButtonActionPerformed

    private void phanCongButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phanCongButtonActionPerformed
        Them them = new Them(mainAdminView, true);
        them.setVisible(true);
    }//GEN-LAST:event_phanCongButtonActionPerformed

    private void capNhatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capNhatButtonActionPerformed
        Xoa xoa = new Xoa(mainAdminView, true);
        xoa.setVisible(true);
    }//GEN-LAST:event_capNhatButtonActionPerformed

    private void xoaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaButtonActionPerformed
        Sua sua = new Sua(mainAdminView, true);
        sua.setVisible(true);
    }//GEN-LAST:event_xoaButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.BangDanhSach BangDSChuHo;
    private javax.swing.JScrollPane ScrollPane;
    private LayMotSoUIdepTaiDay.ButtonThuong TimKiemButton;
    private javax.swing.JTextField TimKiemTF;
    private LayMotSoUIdepTaiDay.ButtonThuong capNhatButton;
    private LayMotSoUIdepTaiDay.ComboboxThuong filterComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private LayMotSoUIdepTaiDay.ButtonThuong phanCongButton;
    private LayMotSoUIdepTaiDay.ButtonThuong refreshButton;
    private LayMotSoUIdepTaiDay.ComboboxThuong sortCombobox;
    private LayMotSoUIdepTaiDay.ButtonThuong xoaButton;
    // End of variables declaration//GEN-END:variables
}
