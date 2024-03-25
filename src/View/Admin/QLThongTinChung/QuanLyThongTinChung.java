
package View.Admin.QLThongTinChung;

import Controller.QLThongTinChungController.DSThongTinChungController;
import Model.Personal_Infos;
import View.Admin.MainAdminView;
import View.Admin.QLThongTinChung.Form.Sua;
import View.Admin.QLThongTinChung.Form.Them;
import View.Admin.QLThongTinChung.Form.Xoa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;





public class QuanLyThongTinChung extends javax.swing.JPanel {

    private MainAdminView mainAdminView = new MainAdminView();
    private List<Personal_Infos> ListPersonal_Infos;
    
    public void lammoi(){
        ListPersonal_Infos=new DSThongTinChungController().getListPersonal_Infos();
        DefaultTableModel model=(DefaultTableModel) bangthongtinchung.getModel();
        model.setRowCount(0);
        for(Personal_Infos tmp : ListPersonal_Infos){
            Object [] row={
                tmp.getCCCD(),tmp.getLastname(),
                tmp.getMiddleName(),tmp.getFirstname(),
                tmp.getDOB() , tmp.getAddress(),
                tmp.getPhone() , tmp.isSex()==true ? "Nam":"Nữ",
            };
            model.addRow(row);
        }
        model.fireTableDataChanged();
    }
    
    public QuanLyThongTinChung(MainAdminView mnv) {
        initComponents();
        this.mainAdminView = mnv;
        this.setSize(mainAdminView.getMainPanel().getSize());
        this.setVisible(true);
        lammoi();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        bangDanhSach2 = new LayMotSoUIdepTaiDay.BangDanhSach();
        panelBorder1 = new LayMotSoUIdepTaiDay.PanelBorder();
        TimKiemTF = new javax.swing.JTextField();
        ThemBT2 = new LayMotSoUIdepTaiDay.ButtonThuong();
        CapNhatBT = new LayMotSoUIdepTaiDay.ButtonThuong();
        XoaBT = new LayMotSoUIdepTaiDay.ButtonThuong();
        LamMoiBT = new LayMotSoUIdepTaiDay.ButtonThuong();
        TimKiemBT = new LayMotSoUIdepTaiDay.ButtonThuong();
        panelBorder2 = new LayMotSoUIdepTaiDay.PanelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        bangthongtinchung = new LayMotSoUIdepTaiDay.BangDanhSach();

        bangDanhSach2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        jScrollPane2.setViewportView(bangDanhSach2);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
        );

        TimKiemTF.setBackground(new java.awt.Color(231, 231, 231));
        TimKiemTF.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        ThemBT2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Isert_icon.png"))); // NOI18N
        ThemBT2.setText("Thêm ");
        ThemBT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemBT2ActionPerformed(evt);
            }
        });

        CapNhatBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/6.png"))); // NOI18N
        CapNhatBT.setText("Cập nhật");
        CapNhatBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CapNhatBTActionPerformed(evt);
            }
        });

        XoaBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/delete_icon.png"))); // NOI18N
        XoaBT.setText("Xóa");
        XoaBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaBTActionPerformed(evt);
            }
        });

        LamMoiBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Refresh.png"))); // NOI18N
        LamMoiBT.setText("Làm mới");
        LamMoiBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LamMoiBTActionPerformed(evt);
            }
        });

        TimKiemBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/search.png"))); // NOI18N
        TimKiemBT.setText("Tìm kiếm");
        TimKiemBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimKiemBTActionPerformed(evt);
            }
        });

        bangthongtinchung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CCCD", "Họ", "Tên lót", "Tên", "Ngày sinh", "Địa chỉ", "Số điện thoại", "Giới Tính"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bangthongtinchung.setEditingColumn(0);
        bangthongtinchung.setEditingRow(0);
        jScrollPane1.setViewportView(bangthongtinchung);

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TimKiemTF, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TimKiemBT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ThemBT2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(XoaBT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CapNhatBT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LamMoiBT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelBorder2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TimKiemTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ThemBT2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CapNhatBT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(XoaBT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LamMoiBT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TimKiemBT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ThemBT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemBT2ActionPerformed
        Them them = new Them(mainAdminView, true);
        them.setVisible(true);
    }//GEN-LAST:event_ThemBT2ActionPerformed

    private void CapNhatBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CapNhatBTActionPerformed
       Sua sua = new Sua(mainAdminView, true);
        sua.setVisible(true);
    }//GEN-LAST:event_CapNhatBTActionPerformed

    private void XoaBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaBTActionPerformed
       Xoa xoa = new Xoa(mainAdminView, true);
        xoa.setVisible(true);
    }//GEN-LAST:event_XoaBTActionPerformed

    private void LamMoiBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoiBTActionPerformed
        lammoi();
    }//GEN-LAST:event_LamMoiBTActionPerformed

    private void TimKiemBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemBTActionPerformed
       
    }//GEN-LAST:event_TimKiemBTActionPerformed
                                          

    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.ButtonThuong CapNhatBT;
    private LayMotSoUIdepTaiDay.ButtonThuong LamMoiBT;
    private LayMotSoUIdepTaiDay.ButtonThuong ThemBT2;
    private LayMotSoUIdepTaiDay.ButtonThuong TimKiemBT;
    private javax.swing.JTextField TimKiemTF;
    private LayMotSoUIdepTaiDay.ButtonThuong XoaBT;
    private LayMotSoUIdepTaiDay.BangDanhSach bangDanhSach2;
    private LayMotSoUIdepTaiDay.BangDanhSach bangthongtinchung;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private LayMotSoUIdepTaiDay.PanelBorder panelBorder1;
    private LayMotSoUIdepTaiDay.PanelBorder panelBorder2;
    // End of variables declaration//GEN-END:variables
}
