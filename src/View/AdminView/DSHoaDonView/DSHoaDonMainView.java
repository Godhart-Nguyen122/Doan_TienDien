package View.AdminView.DSHoaDonView;

import Controller.DSHoaDonController.DSHoaDonController;
import View.AdminView.ThongTinSuDungDien.*;
import LayMotSoUIdepTaiDay.BangDanhSach;
import LayMotSoUIdepTaiDay.ComboboxThuong;
import Model.Customers;
import Model.E_Meter_Details;
import Model.Invoices;
import Model.Personal_Infos;
import View.AdminView.DSHoaDonView.DSHoaDonDialog.FilterLoaiDateDSHoaDonDialog;
import View.AdminView.DSHoaDonView.DSHoaDonDialog.SortLoaiStringDSHoaDonDialog;
import View.AdminView.DSNhanVienView.DSNhanVienDialog.FilterLoaiDateDSNVDialog;

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

public class DSHoaDonMainView extends javax.swing.JPanel {

    
    private MainAdminView mainAdminView = new MainAdminView();
    private DefaultTableModel model;
    private List<Invoices>invoiceses=new ArrayList<>();

    
    public DSHoaDonMainView(MainAdminView mainAdminView) throws Exception {
        initComponents();
        this.mainAdminView = mainAdminView;
        this.setSize(mainAdminView.getMainPanel().getSize());
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
       
       this.invoiceses=new DSHoaDonController().getAllInvoices();
    }
    
    public void ShowThongTinTuDBS(List<Invoices>invoicelist) throws Exception{
        this.model.setRowCount(0);
        if(invoicelist.isEmpty()){
            JOptionPane.showMessageDialog(this,"Danh sách Hóa đơn rỗng ");
        }else{
            for(Invoices invoices :invoicelist){
                
                Personal_Infos staff=new DSHoaDonController().getStaffbyId(invoices.getID_Staff_Write());
                Customers cus=new DSHoaDonController().getInfoCustomerbyIdEmeterDetail(invoices.getID_E_Meter_Details());
                int invoiceid=invoices.getId();
                String cccdch=cus.getCCCD();
                String hovatench=cus.getLastname()+" "+cus.getMiddleName()+" "+cus.getFirstname();
                String hovatennv=staff.getLastname()+" "+staff.getMiddleName()+" "+staff.getFirstname();
                String ngay=invoices.getInvoice_Date();
                Double tongtien=invoices.getTotal_Price();
                boolean thanhtoan=invoices.isInvoice_Status();
                
                Object[] datarow={
                    invoiceid,
                    hovatench,
                    hovatennv,
                    ngay,
                    tongtien,
                    thanhtoan==true?"Đã thanh toán":"Chưa thanh toán"
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
        TimKiemTF = new javax.swing.JTextField();
        TimKiemBT = new LayMotSoUIdepTaiDay.ButtonThuong();
        ChuaNhapCTDCB = new LayMotSoUIdepTaiDay.CheckBox();
        LamMoiBT = new LayMotSoUIdepTaiDay.ButtonThuong();
        DaNhapCTDCB = new LayMotSoUIdepTaiDay.CheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        BangDSHoaDon = new LayMotSoUIdepTaiDay.BangDanhSach();
        TimKiemCb = new LayMotSoUIdepTaiDay.ComboboxThuong();
        SapXepCkb = new LayMotSoUIdepTaiDay.ComboboxThuong();
        SapXepBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        LocCkb = new LayMotSoUIdepTaiDay.ComboboxThuong();
        LocBt = new LayMotSoUIdepTaiDay.ButtonThuong();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(757, 557));

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
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CCCD(CH)", "Họ và Tên (CH)", "Họ và Tên (NV)", "Ngày ", "Tổng tiền ", "Thanh toán"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Float.class, java.lang.String.class
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
        jScrollPane1.setViewportView(BangDSHoaDon);

        TimKiemCb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "CCCD(CH)", "Họ và tên(CH)", "Họ và tên(NV)", "Ngày", " " }));
        TimKiemCb.setSelectedItem(null
        );
        TimKiemCb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TimKiemCb.setLabeText("(Tìm kiếm theo)");
        TimKiemCb.setLineColor(new java.awt.Color(0, 153, 255));

        SapXepCkb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Theo ID", "Theo CCCD ", "Theo họ và tên(CH)", "Theo họ và tên(NV)", "Theo Ngày", "Theo Tổng tiền" }));
        SapXepCkb.setSelectedItem(null);
        SapXepCkb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SapXepCkb.setLabeText("(Chọn thuộc tính cần sắp xếp)");

        SapXepBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sort.png"))); // NOI18N
        SapXepBt.setText("Sắp xếp");
        SapXepBt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SapXepBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SapXepBtActionPerformed(evt);
            }
        });

        LocCkb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Theo ngày sinh" }));
        LocCkb.setSelectedItem(null);
        LocCkb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LocCkb.setLabeText("(Chọn thuộc tính cần lọc)");

        LocBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/filter.png"))); // NOI18N
        LocBt.setText("Lọc");
        LocBt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LocBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TimKiemTF, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TimKiemCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TimKiemBT, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LocCkb, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DaNhapCTDCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ChuaNhapCTDCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LamMoiBT, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SapXepCkb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SapXepBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LocBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TimKiemBT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(TimKiemTF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TimKiemCb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LocCkb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LocBt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ChuaNhapCTDCB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DaNhapCTDCB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LamMoiBT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4))
                    .addComponent(SapXepCkb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SapXepBt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TimKiemBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemBTActionPerformed
        BangDSHoaDon.setSelectionMode(2);
        Object selected = TimKiemCb.getSelectedItem();
        if(TimKiemTF.getText().replaceAll(" ", "").equals("") || selected == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại tìm kiếm và không bỏ trống thông tin nhập!!!");            
        }else if(selected.equals("ID")){
            if(!DSHoaDonController.Searching(TimKiemTF.getText(), BangDSHoaDon, 1))
               JOptionPane.showMessageDialog(this, "Không tìm thấy Hóa đơn có Id: " + TimKiemTF.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy Hóa đơn có Id: " + TimKiemTF.getText());  
        }else if(selected.equals("CCCD(CH)")){
            if(!DSHoaDonController.Searching(TimKiemTF.getText(), BangDSHoaDon, 2))
               JOptionPane.showMessageDialog(this, "Không tìm thấy Chủ hộ có CCCD: " + TimKiemTF.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy Chủ hộ có CCCD: " + TimKiemTF.getText());              
        }else if(selected.equals("Họ và tên(CH)")){
            if(!DSHoaDonController.Searching(TimKiemTF.getText(), BangDSHoaDon, 3))
               JOptionPane.showMessageDialog(this, "Không tìm thấy Chủ hộ có Họ và tên: " + TimKiemTF.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy Chủ hộ có Họ và tên: " + TimKiemTF.getText());              
        }else if(selected.equals("Họ và tên(NV)")){
            if(!DSHoaDonController.Searching(TimKiemTF.getText(), BangDSHoaDon, 4))
               JOptionPane.showMessageDialog(this, "Không tìm thấy Nhân viên có Họ và tên: " + TimKiemTF.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy Nhân viên có Họ và tên: " + TimKiemTF.getText());              
        }else if(selected.equals("Ngày")){
            if(!DSHoaDonController.Searching(TimKiemTF.getText(), BangDSHoaDon, 5))
               JOptionPane.showMessageDialog(this, "Không tìm thấy Hóa đơn có Ngày: " + TimKiemTF.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy Hóa đơn có Ngày: " + TimKiemTF.getText());              
        }
    }//GEN-LAST:event_TimKiemBTActionPerformed

    private void LamMoiBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoiBTActionPerformed
        try {
            mainAdminView.setForm(new DSHoaDonMainView(mainAdminView));
            DaNhapCTDCB.setSelected(false);
            ChuaNhapCTDCB.setSelected(false);
            NhapCTDCB.clearSelection();
        } catch (Exception ex) {
            Logger.getLogger(DSHoaDonMainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_LamMoiBTActionPerformed

    private void ChuaNhapCTDCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChuaNhapCTDCBActionPerformed
 List<Invoices>tmp=new ArrayList<>();
       for(Invoices in: this.invoiceses){
           if(!in.isInvoice_Status()){
               tmp.add(in);
           }
       }
        try {
            ShowThongTinTuDBS(tmp);
        } catch (Exception ex) {
            Logger.getLogger(DSHoaDonMainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ChuaNhapCTDCBActionPerformed

    private void DaNhapCTDCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DaNhapCTDCBActionPerformed
       //Da thanh toan
        List<Invoices>tmp=new ArrayList<>();
       for(Invoices in: this.invoiceses){
           if(in.isInvoice_Status()){
               tmp.add(in);
           }
       }
        try {
            ShowThongTinTuDBS(tmp);
        } catch (Exception ex) {
            Logger.getLogger(DSHoaDonMainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DaNhapCTDCBActionPerformed

    private void SapXepBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SapXepBtActionPerformed
        Object selected = SapXepCkb.getSelectedItem();
        if(selected == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thuộc tính cần sắp xếp!!!");
        }else{
            SortLoaiStringDSHoaDonDialog sortLoaiStringDSHoaDonDialog=new SortLoaiStringDSHoaDonDialog(this.mainAdminView, this, true);
            sortLoaiStringDSHoaDonDialog.setVisible(true);
        }
    }//GEN-LAST:event_SapXepBtActionPerformed

    private void LocBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocBtActionPerformed
        Object selected = LocCkb.getSelectedItem();
        if(selected == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thuộc tính cần lọc!!!");
        }else if(selected.equals("Theo ngày sinh")){
            FilterLoaiDateDSHoaDonDialog filter = new FilterLoaiDateDSHoaDonDialog (this.mainAdminView, this, true);
            filter.setVisible(true);
        }
    }//GEN-LAST:event_LocBtActionPerformed
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

   
    
    private void showThemCongToDienDialog() {

    }  
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.BangDanhSach BangDSHoaDon;
    private LayMotSoUIdepTaiDay.CheckBox ChuaNhapCTDCB;
    private LayMotSoUIdepTaiDay.CheckBox DaNhapCTDCB;
    private LayMotSoUIdepTaiDay.ButtonThuong LamMoiBT;
    private LayMotSoUIdepTaiDay.ButtonThuong LocBt;
    private LayMotSoUIdepTaiDay.ComboboxThuong LocCkb;
    private javax.swing.ButtonGroup NhapCTDCB;
    private LayMotSoUIdepTaiDay.ButtonThuong SapXepBt;
    private LayMotSoUIdepTaiDay.ComboboxThuong SapXepCkb;
    private LayMotSoUIdepTaiDay.ButtonThuong TimKiemBT;
    private LayMotSoUIdepTaiDay.ComboboxThuong TimKiemCb;
    private javax.swing.JTextField TimKiemTF;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
