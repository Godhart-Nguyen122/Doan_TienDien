package View.AdminView.DanhSachPhanCong;

import Controller.DSPhanCongController.DSPhanCongController;
import Model.Customers;
import Model.Personal_Infos;
import View.AdminView.DanhSachPhanCong.Form.CapNhat;
import View.AdminView.DanhSachPhanCong.Form.PhanCong;
import View.AdminView.MainAdminView;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class DSPhanCong extends javax.swing.JPanel {

    private MainAdminView mainAdminView = new MainAdminView();
     private List<Personal_Infos>personal_InfosNV=new ArrayList<>();
    private List<Customers>personal_InfosCH=new ArrayList<>();
    
    public void showThongtin() throws Exception{
        this.personal_InfosCH=new DSPhanCongController().getAllCustomers();
        DefaultTableModel model = (DefaultTableModel) BangDSPhanCong.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged(); 
        
        for(Customers tmp : personal_InfosCH){
            Personal_Infos newStaff=new DSPhanCongController().SearchStaffTheoId(tmp.getId_Staff());
            String nameCH=tmp.getLastname()+" "+tmp.getMiddleName()+" "+tmp.getFirstname();
            if(newStaff!=null){
                String nameStaff=newStaff.getLastname()+" "+newStaff.getMiddleName()+" "+newStaff.getFirstname();
                model.addRow(new Object[]{tmp.getCCCD(),newStaff.getCCCD(),nameCH,tmp.getPhone(),tmp.getAddress(),nameStaff,newStaff.getPhone(),newStaff.getAddress()});
            }else{
                model.addRow(new Object[]{tmp.getCCCD()," ",nameCH,tmp.getPhone(),tmp.getAddress()," "," "," "});
            }
        }
    }
   
    
    public DSPhanCong(MainAdminView mnv) throws Exception {
        initComponents();
        this.mainAdminView = mnv;
        this.setSize(mainAdminView.getMainPanel().getSize());
        this.setVisible(true);
        showThongtin();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScrollPane = new javax.swing.JScrollPane();
        BangDSPhanCong = new LayMotSoUIdepTaiDay.BangDanhSach();
        TimKiemTF = new javax.swing.JTextField();
        TimKiemButton = new LayMotSoUIdepTaiDay.ButtonThuong();
        phanCongButton = new LayMotSoUIdepTaiDay.ButtonThuong();
        capNhatButton = new LayMotSoUIdepTaiDay.ButtonThuong();
        xoaButton = new LayMotSoUIdepTaiDay.ButtonThuong();
        refreshButton = new LayMotSoUIdepTaiDay.ButtonThuong();

        setPreferredSize(new java.awt.Dimension(757, 557));

        BangDSPhanCong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CCCD CH", "CCCD NV", "Họ và Tên CH", "SĐT(CH)", "Địa chỉ (CH)", "Họ và Tên (NV)", "SĐT(NV)", "Địa chỉ (NV)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        BangDSPhanCong.getTableHeader().setReorderingAllowed(false);
        ScrollPane.setViewportView(BangDSPhanCong);

        TimKiemTF.setBackground(new java.awt.Color(231, 231, 231));
        TimKiemTF.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        TimKiemButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/search.png"))); // NOI18N
        TimKiemButton.setText("Tìm kiếm");
        TimKiemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimKiemButtonActionPerformed(evt);
            }
        });

        phanCongButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/6.png"))); // NOI18N
        phanCongButton.setText("Phân Công");
        phanCongButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phanCongButtonActionPerformed(evt);
            }
        });

        capNhatButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/6.png"))); // NOI18N
        capNhatButton.setText("Cập Nhật");
        capNhatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capNhatButtonActionPerformed(evt);
            }
        });

        xoaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/6.png"))); // NOI18N
        xoaButton.setText("Xóa");

        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/6.png"))); // NOI18N
        refreshButton.setText("Làm Mới");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
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
                .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(ScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
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
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TimKiemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemButtonActionPerformed

    }//GEN-LAST:event_TimKiemButtonActionPerformed

    private void filterComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterComboBoxActionPerformed

    private void phanCongButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phanCongButtonActionPerformed
        try {
            PhanCong phanCong =new PhanCong(mainAdminView, true);
            phanCong.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(DSPhanCong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_phanCongButtonActionPerformed

    private void capNhatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capNhatButtonActionPerformed
       CapNhat capNhat = new CapNhat(mainAdminView, true);
       capNhat.setVisible(true);
    }//GEN-LAST:event_capNhatButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.BangDanhSach BangDSPhanCong;
    private javax.swing.JScrollPane ScrollPane;
    private LayMotSoUIdepTaiDay.ButtonThuong TimKiemButton;
    private javax.swing.JTextField TimKiemTF;
    private LayMotSoUIdepTaiDay.ButtonThuong capNhatButton;
    private LayMotSoUIdepTaiDay.ButtonThuong phanCongButton;
    private LayMotSoUIdepTaiDay.ButtonThuong refreshButton;
    private LayMotSoUIdepTaiDay.ButtonThuong xoaButton;
    // End of variables declaration//GEN-END:variables
}
