/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.Admin.DSNhanVien;

import Controller.NVController.DSNVController;
import Model.Staff;
import View.Admin.MainAdminView;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vduct
 */
public class DSNhanVienView extends javax.swing.JPanel {

    /**
     * Creates new form DSNhanVienView
     */
    
    private MainAdminView mainAdminView = new MainAdminView();
    private Staff nv;
    private List<Staff> nvs;
    
    public Staff getNV() {
        return nv;
    }

    public void setNV(Staff nv) {
        this.nv = nv;
    }
    
    public DSNhanVienView(MainAdminView mnv) {
        initComponents();
        this.mainAdminView = mnv;
        this.setSize(mainAdminView.getMainPanel().getSize());
        this.setVisible(true);
        ShowThongTinTuDBS();
        //Tạo Action khi nhấp chọn hàng trong Jtable BangDSChuHo
        ListSelectionListener rowListener;
        rowListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = BangDSNhanVien.getSelectedRow();
                    Staff nv = new DSNVController().LayThongTinNVQuaCCCD((String) BangDSNhanVien.getValueAt(selectedRow, 0));
                    if (selectedRow != -1 && nv != null) { 
                        // Lấy dữ liệu từ hàng đó và xử lý dữ liệu
                        setNV(nv);              
                        TimKiemTF.setText(nv.getCCCD());
                    }
                }
            };
        };
        BangDSNhanVien.getSelectionModel().addListSelectionListener(rowListener);
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
        BangDSNhanVien = new LayMotSoUIdepTaiDay.BangDanhSach();
        TimKiemBT = new LayMotSoUIdepTaiDay.ButtonThuong();
        TimKiemTF = new javax.swing.JTextField();
        TKCombobox = new LayMotSoUIdepTaiDay.ComboboxThuong();
        LocCombobox = new LayMotSoUIdepTaiDay.ComboboxThuong();
        LamMoiBT2 = new LayMotSoUIdepTaiDay.ButtonThuong();

        BangDSNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CCCD", "Họ và tên", "Ngày sinh", "Địa chỉ", "SĐT", "Giới tính", "Account", "Password"
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
        BangDSNhanVien.getTableHeader().setReorderingAllowed(false);
        ScrollPane.setViewportView(BangDSNhanVien);

        TimKiemBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/search.png"))); // NOI18N
        TimKiemBT.setText("Tìm kiếm");
        TimKiemBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimKiemBTActionPerformed(evt);
            }
        });

        TimKiemTF.setBackground(new java.awt.Color(231, 231, 231));
        TimKiemTF.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        TKCombobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CCCD", "Họ tên", "Account" }));
        TKCombobox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TKCombobox.setLineColor(new java.awt.Color(0, 153, 255));
        TKCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TKComboboxActionPerformed(evt);
            }
        });

        LocCombobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nam và nữ", "Nam", "Nữ" }));
        LocCombobox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LocCombobox.setLineColor(new java.awt.Color(0, 153, 255));
        LocCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocComboboxActionPerformed(evt);
            }
        });

        LamMoiBT2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Refresh.png"))); // NOI18N
        LamMoiBT2.setText("Làm mới");
        LamMoiBT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LamMoiBT2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(TKCombobox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TimKiemTF, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(TimKiemBT, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(LocCombobox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(37, 37, 37)
                .addComponent(LamMoiBT2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TimKiemTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TimKiemBT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LamMoiBT2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TKCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LocCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TimKiemBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemBTActionPerformed
        TKTable();
    }//GEN-LAST:event_TimKiemBTActionPerformed

    private void LamMoiBT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoiBT2ActionPerformed
        ShowThongTinTuDBS();
        this.TimKiemTF.setText("");
    }//GEN-LAST:event_LamMoiBT2ActionPerformed

    private void LocComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocComboboxActionPerformed
        LocTable();
    }//GEN-LAST:event_LocComboboxActionPerformed

    private void TKComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TKComboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TKComboboxActionPerformed
    
    public void ShowThongTinTuDBS(){
        this.nvs = new DSNVController().getDsNV();   
        setTable();
    }
    
    public void TKTable(){
        String key = TimKiemTF.getText().trim();
        if(key.isEmpty()){
            JOptionPane.showMessageDialog(this, "Vui lòng không được bỏ trống!");            
        }else{
            System.out.println(""+key);
            nvs = new Controller.NVController.DSNVController().TimKiemNV(key, (String) this.TKCombobox.getSelectedItem()); 
        }
        setTable();
    }
    
    public void setTable(){
        DefaultTableModel model = (DefaultTableModel) BangDSNhanVien.getModel();  
        model.setRowCount(0);    
        for(Staff nv : nvs){
            Object[] rowData = {
                nv.getCCCD(), nv.getUsername(),  nv.getDOB(),
                nv.getAddress(), nv.getPhone(),nv.getPhai(), nv.getAccount(), nv.getPassword()
            };

            model.addRow(rowData);
        }   
        model.fireTableDataChanged();
    }
    
    public void LocTable(){
        String key = (String) this.LocCombobox.getSelectedItem();
        DefaultTableModel model = (DefaultTableModel) BangDSNhanVien.getModel();  
        model.setRowCount(0); 
        if(key.equals("Nam và nữ")) setTable();
        for(Staff nv : nvs){
            if(nv.getPhai().equalsIgnoreCase(key)){
                Object[] rowData = {
                    nv.getCCCD(), nv.getUsername(), nv.getPhai(), nv.getDOB(),
                    nv.getAddress(), nv.getPhone(), nv.getAccount(), nv.getPassword()
                };
                model.addRow(rowData);
            }
        }
        
        model.fireTableDataChanged();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.BangDanhSach BangDSNhanVien;
    private LayMotSoUIdepTaiDay.ButtonThuong LamMoiBT2;
    private LayMotSoUIdepTaiDay.ComboboxThuong LocCombobox;
    private javax.swing.JScrollPane ScrollPane;
    private LayMotSoUIdepTaiDay.ComboboxThuong TKCombobox;
    private LayMotSoUIdepTaiDay.ButtonThuong TimKiemBT;
    private javax.swing.JTextField TimKiemTF;
    // End of variables declaration//GEN-END:variables
}
