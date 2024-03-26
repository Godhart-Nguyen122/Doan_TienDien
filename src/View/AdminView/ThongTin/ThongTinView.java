package View.AdminView.ThongTin;

import View.AdminView.MainAdminView;

public class ThongTinView extends javax.swing.JPanel {

    private MainAdminView mainAdminView = new MainAdminView();
    
    public ThongTinView(MainAdminView mnv) {
        initComponents();
        this.mainAdminView = mnv;
        this.setSize(mainAdminView.getMainPanel().getSize());
        this.setVisible(true);
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoutButton = new LayMotSoUIdepTaiDay.ButtonThuong();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cccdfield = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        dobField = new javax.swing.JTextField();
        phoneField = new javax.swing.JTextField();
        addressField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(getPreferredSize());
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoutButton.setBackground(new java.awt.Color(204, 204, 204));
        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logout-8-16.png"))); // NOI18N
        logoutButton.setText("Đăng xuất");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 320, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Thông tin cá nhân");
        jLabel1.setToolTipText("");
        jLabel1.setIconTextGap(0);
        jLabel1.setOpaque(true);
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 6, 213, 54));

        jSeparator1.setOpaque(true);
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 66, 736, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Ngày sinh:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 104, 36));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Số điện thoại:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 104, 37));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Địa chỉ:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 104, 37));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Họ tên:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 104, 36));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("CCCD:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 104, 36));

        cccdfield.setEditable(false);
        cccdfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cccdfieldActionPerformed(evt);
            }
        });
        add(cccdfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 380, 24));

        nameField.setEditable(false);
        add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 380, 24));

        dobField.setEditable(false);
        add(dobField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 380, 24));

        phoneField.setEditable(false);
        add(phoneField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 380, 24));

        addressField.setEditable(false);
        add(addressField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 380, 24));
    }// </editor-fold>//GEN-END:initComponents

    private void cccdfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cccdfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cccdfieldActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
       
    }//GEN-LAST:event_logoutButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressField;
    private javax.swing.JTextField cccdfield;
    private javax.swing.JTextField dobField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private LayMotSoUIdepTaiDay.ButtonThuong logoutButton;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField phoneField;
    // End of variables declaration//GEN-END:variables
}
