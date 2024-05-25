package View.CustomerView.DSHoaDonDien;

import Controller.CustomerView.DSHoaDon.DSHoaDon;
import View.CustomerView.MainCustomerView;
import Controller.DSHoaDonController.DSHoaDonController;
import View.AdminView.ThongTinSuDungDien.*;
import LayMotSoUIdepTaiDay.BangDanhSach;
import LayMotSoUIdepTaiDay.ComboboxThuong;
import Model.Customers;
import Model.Invoices;
import View.CustomerView.DSHoaDonDien.SortLoaiStringDSHoaDonDialog;


import View.AdminView.MainAdminView;
import View.AdminView.ThongTinSuDungDien.ThongTinSDDienForm.SortLoaiStringThongTinSDDienDialog;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class DSHoaDonDien extends javax.swing.JPanel {

    
    private MainCustomerView ctv = new MainCustomerView();
    private DefaultTableModel model;
    private List<Invoices>invoiceses=new ArrayList<>();

    
    public DSHoaDonDien(MainCustomerView cv) throws Exception {
        initComponents();
        this.ctv = cv;
        this.setSize(ctv.getMainPanel().getSize());
        this.BangDSHoaDon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.model= (DefaultTableModel) BangDSHoaDon.getModel();
        this.model.getDataVector().removeAllElements();
        this.model.fireTableDataChanged();
        LammoiDS();
        ShowThongTinTuDBS(this.invoiceses);
    }
    public  void LammoiDS() throws Exception{
       this.invoiceses.clear();
       this.model.setRowCount(0);
       
       if(this.DaNhapCTDCB.isSelected()){
           this.invoiceses=new DSHoaDon().getAllInCase(1);
       }else if(this.ChuaNhapCTDCB.isSelected()){
           this.invoiceses=new DSHoaDon().getAllInCase(0);
       }else{
           this.invoiceses=new DSHoaDon().getAllInCase(2);
       }       
    }
    
    public void ShowThongTinTuDBS(List<Invoices>invoicelist) throws Exception{
        this.model.setRowCount(0);
        if(invoicelist.isEmpty()){
            JOptionPane.showMessageDialog(this,"Danh sách Hóa đơn rỗng ");
        }else{
            for(Invoices invoices :invoicelist){
                int id=invoices.getId();
                String nv = invoices.getStaff_name();
                int level = invoices.getLevel();
                int kwh = invoices.getCurrentNum();
                String ngaylap=invoices.getInvoice_Date();
                Double tongtien=invoices.getTotal_Price();
                
                Object[] datarow={
                    id,
                    nv,
                    level,
                    kwh,
                    ngaylap,
                    tongtien
                };      
                model.addRow(datarow);
            }
        } 
    }
    //Mục đích làm function dùng lại cho trường hợp chủ hộ đã có công tơ điện và chủ hộ chưa có công tơ điện 
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NhapCTDCB = new javax.swing.ButtonGroup();
        SapXepBt1 = new LayMotSoUIdepTaiDay.ButtonThuong();
        SapXepCkb = new LayMotSoUIdepTaiDay.ComboboxThuong();
        TimKiemTF = new javax.swing.JTextField();
        TimKiemBT = new LayMotSoUIdepTaiDay.ButtonThuong();
        ChuaNhapCTDCB = new LayMotSoUIdepTaiDay.CheckBox();
        LamMoiBT = new LayMotSoUIdepTaiDay.ButtonThuong();
        DaNhapCTDCB = new LayMotSoUIdepTaiDay.CheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        BangDSHoaDon = new LayMotSoUIdepTaiDay.BangDanhSach();
        TimKiemCb = new LayMotSoUIdepTaiDay.ComboboxThuong();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(757, 557));

        SapXepBt1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sort.png"))); // NOI18N
        SapXepBt1.setText("Sắp xếp");
        SapXepBt1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SapXepBt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SapXepBt1ActionPerformed(evt);
            }
        });

        SapXepCkb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Theo ID", "Theo nhân viên ", "Theo mức điện", "Theo số kwh", "Theo ngày lập", "Theo tổng tiền" }));
        SapXepCkb.setSelectedItem(null);
        SapXepCkb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SapXepCkb.setLabeText("(Chọn thuộc tính cần sắp xếp)");

        TimKiemTF.setBackground(new java.awt.Color(231, 231, 231));
        TimKiemTF.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        TimKiemBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/search.png"))); // NOI18N
        TimKiemBT.setText("Tìm kiếm");
        TimKiemBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimKiemBTActionPerformed(evt);
            }
        });

        ChuaNhapCTDCB.setBackground(new java.awt.Color(153, 153, 153));
        NhapCTDCB.add(ChuaNhapCTDCB);
        ChuaNhapCTDCB.setText("Chưa Thanh toán");
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
        DaNhapCTDCB.setText("Đã Thanh toán");
        DaNhapCTDCB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DaNhapCTDCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DaNhapCTDCBActionPerformed(evt);
            }
        });

        BangDSHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nhân viên lập", "Mức điện", "Số kwh", "Ngày lập", "Tổng tiền "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(BangDSHoaDon);

        TimKiemCb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mức điện", "Nhân viên lập hóa đơn", " ", " " }));
        TimKiemCb.setSelectedItem(null
        );
        TimKiemCb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TimKiemCb.setLabeText("(Tìm kiếm theo)");
        TimKiemCb.setLineColor(new java.awt.Color(0, 153, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DaNhapCTDCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ChuaNhapCTDCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TimKiemTF, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TimKiemCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TimKiemBT, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LamMoiBT, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SapXepCkb, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SapXepBt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TimKiemBT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LamMoiBT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(TimKiemCb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TimKiemTF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SapXepCkb, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChuaNhapCTDCB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DaNhapCTDCB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SapXepBt1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TimKiemBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemBTActionPerformed
        BangDSHoaDon.setSelectionMode(2);
        Object selected = TimKiemCb.getSelectedItem();
        if(TimKiemTF.getText().replaceAll(" ", "").equals("") || selected == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại tìm kiếm và không bỏ trống thông tin nhập!!!");            
        }else if(selected.equals("Mức điện")){
            if(!DSHoaDonController.Searching(TimKiemTF.getText(), BangDSHoaDon, 3))
               JOptionPane.showMessageDialog(this, "Không tìm thấy Hóa đơn có Id: " + TimKiemTF.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy Hóa đơn có Id: " + TimKiemTF.getText());  
        }else if(selected.equals("Nhân viên lập hóa đơn")){
            if(!DSHoaDonController.Searching(TimKiemTF.getText(), BangDSHoaDon, 2))
               JOptionPane.showMessageDialog(this, "Không tìm thấy Chủ hộ có CCCD: " + TimKiemTF.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy Chủ hộ có CCCD: " + TimKiemTF.getText());              
        }
    }//GEN-LAST:event_TimKiemBTActionPerformed

    private void LamMoiBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoiBTActionPerformed
        try {
            ctv.setForm(new DSHoaDonDien(ctv));
            DaNhapCTDCB.setSelected(false);
            ChuaNhapCTDCB.setSelected(true);
        } catch (Exception ex) {
            Logger.getLogger(DSHoaDonDien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_LamMoiBTActionPerformed

    private void ChuaNhapCTDCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChuaNhapCTDCBActionPerformed
        List<Invoices>tmp=new ArrayList<>();
        try {
            this.LammoiDS();
        } catch (Exception ex) {
            Logger.getLogger(DSHoaDonDien.class.getName()).log(Level.SEVERE, null, ex);
        }
          for(Invoices in: this.invoiceses){
                tmp.add(in);
          }
           try {
               ShowThongTinTuDBS(tmp);
           } catch (Exception ex) {
               Logger.getLogger(DSHoaDonDien.class.getName()).log(Level.SEVERE, null, ex);
           }
    }//GEN-LAST:event_ChuaNhapCTDCBActionPerformed

    private void DaNhapCTDCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DaNhapCTDCBActionPerformed
       //Da thanh toan
        List<Invoices>tmp=new ArrayList<>();
        try {
            this.LammoiDS();
        } catch (Exception ex) {
            Logger.getLogger(DSHoaDonDien.class.getName()).log(Level.SEVERE, null, ex);
        }
       for(Invoices in: this.invoiceses){
               tmp.add(in);
       }
        try {
            ShowThongTinTuDBS(tmp);
        } catch (Exception ex) {
            Logger.getLogger(DSHoaDonDien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DaNhapCTDCBActionPerformed

    private void SapXepBt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SapXepBt1ActionPerformed
        Object selected = SapXepCkb.getSelectedItem();
        if(selected == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thuộc tính cần sắp xếp!!!");
        }else{
            SortLoaiStringDSHoaDonDialog sortLoaiStringDSHoaDonDialog=new SortLoaiStringDSHoaDonDialog(this.ctv, this, true);
            sortLoaiStringDSHoaDonDialog.setVisible(true);
        }
    }//GEN-LAST:event_SapXepBt1ActionPerformed
    
     public ComboboxThuong getSapXepCkb() {
        return SapXepCkb;
    }

    public void setSapXepCkb(ComboboxThuong SapXepCkb) {
        this.SapXepCkb = SapXepCkb;
    }
    private void showCapNhatCongToDienDialog() {

    }  

    public BangDanhSach getBangDSHoaDon() {
        return BangDSHoaDon;
    }

    public void setBangDSHoaDon(BangDanhSach BangDSHoaDon) {
        this.BangDSHoaDon = BangDSHoaDon;
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.BangDanhSach BangDSHoaDon;
    private LayMotSoUIdepTaiDay.CheckBox ChuaNhapCTDCB;
    private LayMotSoUIdepTaiDay.CheckBox DaNhapCTDCB;
    private LayMotSoUIdepTaiDay.ButtonThuong LamMoiBT;
    private javax.swing.ButtonGroup NhapCTDCB;
    private LayMotSoUIdepTaiDay.ButtonThuong SapXepBt;
    private LayMotSoUIdepTaiDay.ButtonThuong SapXepBt1;
    private LayMotSoUIdepTaiDay.ComboboxThuong SapXepCkb;
    private LayMotSoUIdepTaiDay.ButtonThuong TimKiemBT;
    private LayMotSoUIdepTaiDay.ComboboxThuong TimKiemCb;
    private javax.swing.JTextField TimKiemTF;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
