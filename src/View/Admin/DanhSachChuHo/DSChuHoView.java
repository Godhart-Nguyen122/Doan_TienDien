package View.Admin.DanhSachChuHo;

import Controller.ChuHoController.DSChuHoController;
import LayMotSoUIdepTaiDay.BangDanhSach;
import Model.ChuHo;
import View.Admin.MainAdminView;
import View.Admin.DanhSachChuHo.DSChuHoForm.CapNhatAccountCH;
import View.Admin.DanhSachChuHo.DSChuHoForm.CapNhatCCCDCH;
import View.Admin.DanhSachChuHo.DSChuHoForm.CapNhatThongTinCH;
import View.Admin.DanhSachChuHo.DSChuHoForm.ThemChuHoDialog;
import View.Admin.DanhSachChuHo.DSChuHoForm.XoaChuHoDialog;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
public class DSChuHoView extends javax.swing.JPanel {
    private ChuHo chuHo;

    public ChuHo getChuHo() {
        return chuHo;
    }

    public void setChuHo(ChuHo chuHo) {
        this.chuHo = chuHo;
    }
       
    private MainAdminView mainNhanVienView = new MainAdminView();
    
    public DSChuHoView(MainAdminView mnv) {
        initComponents();
        this.mainNhanVienView = mnv;
        this.setSize(mainNhanVienView.getMainPanel().getSize());
        this.setVisible(true);
        ShowThongTinTuDBS();
        CapNhatCombobox.setEnabled(false);
        //Tạo Action khi nhấp chọn hàng trong Jtable BangDSChuHo
        ListSelectionListener rowListener;
        rowListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = BangDSChuHo.getSelectedRow();
                    ChuHo chuHo = new DSChuHoController().LayThongTinChuHoQuaCCCD((String) BangDSChuHo.getValueAt(selectedRow, 0));
                    if (selectedRow != -1 && chuHo != null) { 
                        // Lấy dữ liệu từ hàng đó và xử lý dữ liệu   
                        CapNhatCombobox.setEnabled(true);
                        setChuHo(chuHo);              
                        TimKiemTF.setText(chuHo.getUsername());
                    }
                }
            };
        };
        BangDSChuHo.getSelectionModel().addListSelectionListener(rowListener);
    }

    public void ShowThongTinTuDBS(){
        List<ChuHo> dsChuHo = new DSChuHoController().getDsChuHo();   
        DefaultTableModel model = (DefaultTableModel) BangDSChuHo.getModel();  
        model.setRowCount(0);    
        for(ChuHo chuHo : dsChuHo){
            Object[] rowData = {
                chuHo.getCCCD(), chuHo.getUsername(), chuHo.getDOB(), 
                chuHo.getAddress(), chuHo.getPhone(), chuHo.getAccount(), 
                chuHo.getPassword()
            };

            model.addRow(rowData);
        }   
        model.fireTableDataChanged();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TimKiemTF = new javax.swing.JTextField();
        TimKiemBT = new LayMotSoUIdepTaiDay.ButtonThuong();
        ScrollPane = new javax.swing.JScrollPane();
        BangDSChuHo = new LayMotSoUIdepTaiDay.BangDanhSach();
        ThemBT = new LayMotSoUIdepTaiDay.ButtonThuong();
        XoaBT = new LayMotSoUIdepTaiDay.ButtonThuong();
        CapNhatBT = new LayMotSoUIdepTaiDay.ButtonThuong();
        LamMoiBT = new LayMotSoUIdepTaiDay.ButtonThuong();
        CapNhatCombobox = new LayMotSoUIdepTaiDay.ComboboxThuong();

        setBackground(new java.awt.Color(255, 255, 255));

        TimKiemTF.setBackground(new java.awt.Color(231, 231, 231));
        TimKiemTF.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        TimKiemBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/search.png"))); // NOI18N
        TimKiemBT.setText("Tìm kiếm");
        TimKiemBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimKiemBTActionPerformed(evt);
            }
        });

        BangDSChuHo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CCCD", "Họ và tên", "Ngày sinh", "Địa chỉ", "SĐT", "Account", "Password"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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

        ThemBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Isert_icon.png"))); // NOI18N
        ThemBT.setText("Thêm ");
        ThemBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemBTActionPerformed(evt);
            }
        });

        XoaBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/delete_icon.png"))); // NOI18N
        XoaBT.setText("Xóa");
        XoaBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaBTActionPerformed(evt);
            }
        });

        CapNhatBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/6.png"))); // NOI18N
        CapNhatBT.setText("Cập nhật");
        CapNhatBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CapNhatBTActionPerformed(evt);
            }
        });

        LamMoiBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Refresh.png"))); // NOI18N
        LamMoiBT.setText("Làm mới");
        LamMoiBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LamMoiBTActionPerformed(evt);
            }
        });

        CapNhatCombobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cập nhật thông tin", "Cập nhật Account", "Cập nhật CCCD" }));
        CapNhatCombobox.setSelectedItem(null
        );
        CapNhatCombobox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CapNhatCombobox.setLabeText("(Chọn loại cập nhật)");
        CapNhatCombobox.setLineColor(new java.awt.Color(0, 153, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollPane)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TimKiemTF, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TimKiemBT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(ThemBT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(XoaBT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CapNhatCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LamMoiBT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CapNhatBT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TimKiemTF, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ThemBT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(XoaBT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TimKiemBT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LamMoiBT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CapNhatCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CapNhatBT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(ScrollPane))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TimKiemBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemBTActionPerformed
        String key = TimKiemTF.getText();
        if(key.isEmpty()){
            JOptionPane.showMessageDialog(this, "Vui lòng không được bỏ trống!");            
        }else{
            new Controller.ChuHoController.DSChuHoController().TimKiemChuHo(key, BangDSChuHo); 
        }

    }//GEN-LAST:event_TimKiemBTActionPerformed

    private void XoaBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaBTActionPerformed
        showXoaChuHoDialog();
    }//GEN-LAST:event_XoaBTActionPerformed

    private void CapNhatBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CapNhatBTActionPerformed
        Object selected = CapNhatCombobox.getSelectedItem();
        if(!(BangDSChuHo.getSelectionModel().isSelectionEmpty()) && (selected != null)){          
            if(selected.equals("Cập nhật thông tin")){
                showCapNhatThongTinCHDialog();
            }else if(selected.equals("Cập nhật Account")){
                showCapNhatAccountCHDialog();
            }else if(selected.equals("Cập nhật CCCD")){
                showCapNhatCCCDCHDialog();
            }                       
        }else{
            JOptionPane.showMessageDialog(this, "Vui lòng chọn chủ hộ cần cập nhật và loại cập nhật trên bảng!!!");
        }
    }//GEN-LAST:event_CapNhatBTActionPerformed

    private void ThemBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemBTActionPerformed
        showThemChuHoDialog();
    }//GEN-LAST:event_ThemBTActionPerformed

    private void LamMoiBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoiBTActionPerformed
        mainNhanVienView.setForm(new DSChuHoView(mainNhanVienView));
    }//GEN-LAST:event_LamMoiBTActionPerformed
    
    private void showThemChuHoDialog() {
        ThemChuHoDialog themChuHoDialog = new ThemChuHoDialog(mainNhanVienView, true);
        themChuHoDialog.setVisible(true);
    }

    private void showXoaChuHoDialog() {
        XoaChuHoDialog xoaChuHoDialog = new XoaChuHoDialog(mainNhanVienView, this, true);
        xoaChuHoDialog.setVisible(true);
    }    
    
    private void showCapNhatThongTinCHDialog() {
        CapNhatThongTinCH capNhatChuHo = new CapNhatThongTinCH(mainNhanVienView, this, true);
        capNhatChuHo.setVisible(true);
    }    
    
    private void showCapNhatAccountCHDialog() {
        CapNhatAccountCH capNhatChuHo = new CapNhatAccountCH(mainNhanVienView, this, true);
        capNhatChuHo.setVisible(true);
    }    
    
    private void showCapNhatCCCDCHDialog() {
        CapNhatCCCDCH capNhatChuHo = new CapNhatCCCDCH(mainNhanVienView, this, true);
        capNhatChuHo.setVisible(true);
    }  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.BangDanhSach BangDSChuHo;
    private LayMotSoUIdepTaiDay.ButtonThuong CapNhatBT;
    private LayMotSoUIdepTaiDay.ComboboxThuong CapNhatCombobox;
    private LayMotSoUIdepTaiDay.ButtonThuong LamMoiBT;
    private javax.swing.JScrollPane ScrollPane;
    private LayMotSoUIdepTaiDay.ButtonThuong ThemBT;
    private LayMotSoUIdepTaiDay.ButtonThuong TimKiemBT;
    private javax.swing.JTextField TimKiemTF;
    private LayMotSoUIdepTaiDay.ButtonThuong XoaBT;
    // End of variables declaration//GEN-END:variables
}
