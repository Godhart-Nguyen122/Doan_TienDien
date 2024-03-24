package View.Admin.ThongTinSuDungDien;

import Controller.ChuHoController.DSChuHoController;
import Controller.ThongTinSDController.DSThongTinSDController;
import Model.Customers;
import Model.ThongTinSuDung;
import View.Admin.MainAdminView;
import View.Admin.ThongTinSuDungDien.ThongTinSDDienForm.CapNhatCongToDien;
import View.Admin.ThongTinSuDungDien.ThongTinSDDienForm.ThemCongToDien;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ThongTinSDDienView extends javax.swing.JPanel {
    private ThongTinSuDung thongTinSuDung;

    public ThongTinSuDung getThongTinSuDung() {
        return thongTinSuDung;
    }

    public void setThongTinSuDung(ThongTinSuDung thongTinSuDung) {
        this.thongTinSuDung = thongTinSuDung;
    }
    
    private MainAdminView mainNhanVienView;
    
    public ThongTinSDDienView(MainAdminView mnv) {
        initComponents();
        BangDSThongTinSD.clearSelection();
        this.mainNhanVienView = mnv;
        this.setSize(new MainAdminView().getMainPanel().getSize());
        this.setSize(mainNhanVienView.getMainPanel().getSize());
        this.setVisible(true);
        ChuaNhapCTDCB.resetKeyboardActions();
        DaNhapCTDCB.resetKeyboardActions();
        ChuaNhapCTDCB.setEnabled(true);
        DaNhapCTDCB.setEnabled(true);
        ShowThongTinTuDBS(new DSThongTinSDController().getLstThongTinSuDungs());
        //Tạo Action khi nhấp chọn hàng trong Jtable BangDSChuHo
        ListSelectionListener rowListener;
        rowListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = BangDSThongTinSD.getSelectedRow();
                    if (selectedRow != -1) {
                            ThongTinSuDung thongTinSD = new DSThongTinSDController().LayThongTinSDQuaCCCD((String) BangDSThongTinSD.getValueAt(selectedRow, 0));
                        if (thongTinSD != null) { 
                            // Lấy dữ liệu từ hàng đó và xử lý dữ liệu   
                            setThongTinSuDung(thongTinSD);                                      
                            TimKiemTF.setText(thongTinSuDung.getUsername());
                    }
                    }
    }
            };
        };
        BangDSThongTinSD.getSelectionModel().addListSelectionListener(rowListener);
    }

    public void ShowThongTinTuDBS(List<ThongTinSuDung> lst){
        DefaultTableModel model = (DefaultTableModel) BangDSThongTinSD.getModel();
        model.setRowCount(0); 
        BangDSThongTinSD.clearSelection();
        for(ThongTinSuDung ttsd : lst){
            Object[] rowData = {
                ttsd.getCCCD(), ttsd.getUsername(), ttsd.getPhone(), ttsd.getID_E_Meter(), 
                ttsd.getDiaChi(), ttsd.getType_living(), ttsd.getCCCD_NhanVien(), 
                ttsd.getUsername_NhanVien(), ttsd.getPhone_NhanVien()
            };
        model.addRow(rowData); 
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NhapCTDCB = new javax.swing.ButtonGroup();
        ScrollPane = new javax.swing.JScrollPane();
        BangDSThongTinSD = new LayMotSoUIdepTaiDay.BangDanhSach();
        TimKiemTF = new javax.swing.JTextField();
        ThemCTDienBT = new LayMotSoUIdepTaiDay.ButtonThuong();
        TimKiemBT = new LayMotSoUIdepTaiDay.ButtonThuong();
        XoaBT = new LayMotSoUIdepTaiDay.ButtonThuong();
        ChuaNhapCTDCB = new LayMotSoUIdepTaiDay.CheckBox();
        LamMoiBT = new LayMotSoUIdepTaiDay.ButtonThuong();
        DaNhapCTDCB = new LayMotSoUIdepTaiDay.CheckBox();
        CapNhatBT = new LayMotSoUIdepTaiDay.ButtonThuong();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(757, 557));

        BangDSThongTinSD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CCCD ", "Tên", "SĐT", "Mã số công tơ điện", "Địa chỉ", "Hình thức ở", "CCCD nhân viên", "Tên nhân viên", "SĐT nhân viên"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        BangDSThongTinSD.setPreferredSize(new java.awt.Dimension(525, 160));
        BangDSThongTinSD.getTableHeader().setReorderingAllowed(false);
        ScrollPane.setViewportView(BangDSThongTinSD);

        TimKiemTF.setBackground(new java.awt.Color(231, 231, 231));
        TimKiemTF.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        ThemCTDienBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Isert_icon.png"))); // NOI18N
        ThemCTDienBT.setText("Thêm công tơ điện");
        ThemCTDienBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemCTDienBTActionPerformed(evt);
            }
        });

        TimKiemBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/search.png"))); // NOI18N
        TimKiemBT.setText("Tìm kiếm");
        TimKiemBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimKiemBTActionPerformed(evt);
            }
        });

        XoaBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/delete_icon.png"))); // NOI18N
        XoaBT.setText("Xóa");
        XoaBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaBTActionPerformed(evt);
            }
        });

        ChuaNhapCTDCB.setBackground(new java.awt.Color(153, 153, 153));
        NhapCTDCB.add(ChuaNhapCTDCB);
        ChuaNhapCTDCB.setText("Chưa nhập công tơ điện");
        ChuaNhapCTDCB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ChuaNhapCTDCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChuaNhapCTDCBActionPerformed(evt);
            }
        });

        LamMoiBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Refresh.png"))); // NOI18N
        LamMoiBT.setText("Làm mới");
        LamMoiBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LamMoiBTActionPerformed(evt);
            }
        });

        DaNhapCTDCB.setBackground(new java.awt.Color(153, 153, 153));
        NhapCTDCB.add(DaNhapCTDCB);
        DaNhapCTDCB.setText("Đã nhập công tơ điện");
        DaNhapCTDCB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DaNhapCTDCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DaNhapCTDCBActionPerformed(evt);
            }
        });

        CapNhatBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/6.png"))); // NOI18N
        CapNhatBT.setText("Cập nhật");
        CapNhatBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CapNhatBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DaNhapCTDCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ChuaNhapCTDCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TimKiemTF, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TimKiemBT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(ThemCTDienBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CapNhatBT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(XoaBT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LamMoiBT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TimKiemTF, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ThemCTDienBT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(XoaBT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CapNhatBT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TimKiemBT, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 19, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DaNhapCTDCB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ChuaNhapCTDCB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LamMoiBT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ThemCTDienBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemCTDienBTActionPerformed
        showThemCongToDienDialog();
    }//GEN-LAST:event_ThemCTDienBTActionPerformed

    private void TimKiemBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemBTActionPerformed
        String key = TimKiemTF.getText();
        if(key.isEmpty()){
            JOptionPane.showMessageDialog(this, "Vui lòng không được bỏ trống!");
        }else{
            new Controller.ChuHoController.DSChuHoController().TimKiemChuHo(key, BangDSThongTinSD);
        }
    }//GEN-LAST:event_TimKiemBTActionPerformed

    private void XoaBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaBTActionPerformed
        
    }//GEN-LAST:event_XoaBTActionPerformed

    private void LamMoiBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoiBTActionPerformed
        mainNhanVienView.setForm(new ThongTinSDDienView(mainNhanVienView));
    }//GEN-LAST:event_LamMoiBTActionPerformed

    private void ChuaNhapCTDCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChuaNhapCTDCBActionPerformed
        TimKiemTF.setText(null);
        BangDSThongTinSD.clearSelection();
        ShowThongTinTuDBS(new DSThongTinSDController().HienThiChuaNhap(BangDSThongTinSD));
        ChuaNhapCTDCB.setEnabled(false);
        DaNhapCTDCB.setEnabled(true);
    }//GEN-LAST:event_ChuaNhapCTDCBActionPerformed

    private void DaNhapCTDCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DaNhapCTDCBActionPerformed
        TimKiemTF.setText(null);
        BangDSThongTinSD.clearSelection();
        ShowThongTinTuDBS(new DSThongTinSDController().HienThiDaNhap(BangDSThongTinSD));
        ChuaNhapCTDCB.setEnabled(true);
        DaNhapCTDCB.setEnabled(false);
    }//GEN-LAST:event_DaNhapCTDCBActionPerformed

    private void CapNhatBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CapNhatBTActionPerformed
        if(!(BangDSThongTinSD.getSelectionModel().isSelectionEmpty())){
            showCapNhatCongToDienDialog();
        }else{
            JOptionPane.showMessageDialog(this, "Vui lòng chọn chủ hộ cần cập nhật công tơ điện!!!");
        }
    }//GEN-LAST:event_CapNhatBTActionPerformed
    
    private void showCapNhatCongToDienDialog() {
        CapNhatCongToDien congToDien = new CapNhatCongToDien(mainNhanVienView, this, true);
        congToDien.setVisible(true);
    }  
    
    private void showThemCongToDienDialog() {
        ThemCongToDien themCongToDien = new ThemCongToDien(mainNhanVienView, this, true);
        themCongToDien.setVisible(true);
    }  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.BangDanhSach BangDSThongTinSD;
    private LayMotSoUIdepTaiDay.ButtonThuong CapNhatBT;
    private LayMotSoUIdepTaiDay.CheckBox ChuaNhapCTDCB;
    private LayMotSoUIdepTaiDay.CheckBox DaNhapCTDCB;
    private LayMotSoUIdepTaiDay.ButtonThuong LamMoiBT;
    private javax.swing.ButtonGroup NhapCTDCB;
    private javax.swing.JScrollPane ScrollPane;
    private LayMotSoUIdepTaiDay.ButtonThuong ThemCTDienBT;
    private LayMotSoUIdepTaiDay.ButtonThuong TimKiemBT;
    private javax.swing.JTextField TimKiemTF;
    private LayMotSoUIdepTaiDay.ButtonThuong XoaBT;
    // End of variables declaration//GEN-END:variables
}
