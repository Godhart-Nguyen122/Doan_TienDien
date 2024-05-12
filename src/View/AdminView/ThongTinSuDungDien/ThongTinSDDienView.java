package View.AdminView.ThongTinSuDungDien;

import Controller.DSPhanCongController.DSPhanCongController;
import Controller.ThongTinSDDienController.ThongTinSDDienController;
import LayMotSoUIdepTaiDay.BangDanhSach;
import LayMotSoUIdepTaiDay.ComboboxThuong;
import Model.Customers;
import Model.E_Meters;
import Model.Personal_Infos;
import View.AdminView.MainAdminView;
import View.AdminView.ThongTinSuDungDien.ThongTinSDDienForm.SortLoaiStringThongTinSDDienDialog;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ThongTinSDDienView extends javax.swing.JPanel {

    
    private MainAdminView mainAdminView = new MainAdminView();
    private List<Customers> listcustomer=new ArrayList<Customers>();
    private List<E_Meters> listemeter=new ArrayList<E_Meters>();
    private DefaultTableModel model;

    
    public ThongTinSDDienView(MainAdminView mainAdminView) throws Exception {
        initComponents();
         this.mainAdminView = mainAdminView;
         this.setSize(mainAdminView.getMainPanel().getSize());
        this.BangDSThongTinSD.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.model= (DefaultTableModel) BangDSThongTinSD.getModel();
        this.model.getDataVector().removeAllElements();
        this.model.fireTableDataChanged();
        
        LammoiDS();
        ShowThongTinTuDBS2(this.listcustomer,this.listemeter);
    }
    public  void LammoiDS() throws Exception{
       this.listcustomer.clear();
       this.listemeter.clear();
       this.model.setRowCount(0);
       
       this.listcustomer=new ThongTinSDDienController().getListCustomer();
       this.listemeter=new ThongTinSDDienController().getListEmeter();
    }
    
    public boolean checkcustomerIdinE(int customerId){
        for(E_Meters tmp:listemeter){
            if(tmp.getID_Customer()==customerId){
                return true;
            }
        }
        return false;
    }
    //Mục đích làm function dùng lại cho trường hợp chủ hộ đã có công tơ điện và chủ hộ chưa có công tơ điện 
    public void ShowThongTinTuDBS2(List<Customers>listcus,List<E_Meters>eList) throws Exception{
        this.model.setRowCount(0);
        if(listcus.isEmpty()){
            JOptionPane.showMessageDialog(this,"Danh sách Chủ hộ rỗng ");
        }else if(eList.isEmpty()){
            JOptionPane.showMessageDialog(this,"Danh sách công tơ điện rỗng ");
        }else{
            
            for(Customers tmpcus:listcus){
                //Get CustomerInfo
                int customerId=new ThongTinSDDienController().getIdCustomerbyCCCD(tmpcus.getCCCD());
                String tenCustmer=tmpcus.getLastname()+" "+tmpcus.getMiddleName()+" "+tmpcus.getFirstname();
                //Get StaffInfo
                int staffId=tmpcus.getId_Staff(); 
                Personal_Infos InputStaffInfos =new ThongTinSDDienController().SearchStaffTheoId(staffId);
                String tenStaff="";
                String cccdStaff="";
                String phoneStaff="";
                if(InputStaffInfos !=null){
                    tenStaff=InputStaffInfos.getLastname()+" "+InputStaffInfos.getMiddleName()+" "+InputStaffInfos.getFirstname();
                    cccdStaff= InputStaffInfos.getCCCD();
                    phoneStaff=InputStaffInfos.getPhone();
                }
                //Kiem tra da co trong Emeter chua 
                
                Object [] row=null;
                
                if(!checkcustomerIdinE(customerId)){
                    //Truong hop customer ko co cong to dien 
                    row = new Object[]{
                                    tmpcus.getCCCD(),      
                                    tenCustmer,             
                                    tmpcus.getPhone(),     
                                    "",              
                                    "",         
                                    "",       
                                    cccdStaff,  
                                    tenStaff,           
                                    phoneStaff, 
                                 }; 
                    model.addRow(row);
                }else{
                    //Truogn hop da co cong to dien 
                    for(E_Meters tmpe:eList ){   
                        int customerIdinE=tmpe.getID_Customer();
                        if(customerId==customerIdinE){
                                row = new Object[]{
                                                tmpcus.getCCCD(),      
                                                tenCustmer,             
                                                tmpcus.getPhone(),     
                                                tmpe.getID_E_Meter(),              
                                                tmpe.getAddress(),         
                                                tmpe.getType_Living(),       
                                                cccdStaff,  
                                                tenStaff,           
                                                phoneStaff, 
                                            };
                            model.addRow(row);  
                        }
                    }
                }
   
            }
        }    
    }
    
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
        BangDSThongTinSD = new LayMotSoUIdepTaiDay.BangDanhSach();
        TimKiemCb = new LayMotSoUIdepTaiDay.ComboboxThuong();
        SapXepCkb = new LayMotSoUIdepTaiDay.ComboboxThuong();
        SapXepBt = new LayMotSoUIdepTaiDay.ButtonThuong();

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

        BangDSThongTinSD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CCCDCh", "Tên", "SĐT", "Mã Công tơ", "Địa chỉ", "Hình thức ở", "CCCD nhân viên", "Tên nhân viên", "SĐT nhân viên"
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
        jScrollPane1.setViewportView(BangDSThongTinSD);

        TimKiemCb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CCCDCh", "Họ và tên Ch", "Địa chỉ", "SĐTCh", "Hình thức ở" }));
        TimKiemCb.setSelectedItem(null
        );
        TimKiemCb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TimKiemCb.setLabeText("(Tìm kiếm theo)");
        TimKiemCb.setLineColor(new java.awt.Color(0, 153, 255));

        SapXepCkb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Theo CCCD ", "Theo họ và tên ", "Theo địa chỉ", "Theo SĐT", "Theo hình thức ở", "Theo Mã Công tơ " }));
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LamMoiBT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DaNhapCTDCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ChuaNhapCTDCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                        .addComponent(SapXepCkb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SapXepBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LamMoiBT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TimKiemBT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(TimKiemTF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TimKiemCb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ChuaNhapCTDCB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DaNhapCTDCB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5))
                    .addComponent(SapXepCkb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SapXepBt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TimKiemBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemBTActionPerformed
        BangDSThongTinSD.setSelectionMode(2);
        Object selected = TimKiemCb.getSelectedItem();
        if(TimKiemTF.getText().replaceAll(" ", "").equals("") || selected == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại tìm kiếm và không bỏ trống thông tin nhập!!!");            
        }else if(selected.equals("CCCDCh")){
            if(!DSPhanCongController.Searching(TimKiemTF.getText(), BangDSThongTinSD, 1))
               JOptionPane.showMessageDialog(this, "Không tìm thấy Chủ hộ có CCCD: " + TimKiemTF.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy Chủ hộ có CCCD: " + TimKiemTF.getText());  
        }else if(selected.equals("Họ và tên Ch")){
            if(!DSPhanCongController.Searching(TimKiemTF.getText(), BangDSThongTinSD, 2))
               JOptionPane.showMessageDialog(this, "Không tìm thấy Chủ hộ có họ tên: " + TimKiemTF.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy Chủ hộ có họ tên: " + TimKiemTF.getText());              
        }else if(selected.equals("Địa chỉ")){
            if(!DSPhanCongController.Searching(TimKiemTF.getText(), BangDSThongTinSD, 3))
               JOptionPane.showMessageDialog(this, "Không tìm thấy Chủ hộ có địa chỉ: " + TimKiemTF.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy Chủ hộ có địa chỉ: " + TimKiemTF.getText());              
        }else if(selected.equals("SĐTCh")){
            if(!DSPhanCongController.Searching(TimKiemTF.getText(), BangDSThongTinSD, 4))
               JOptionPane.showMessageDialog(this, "Không tìm thấy Chủ hộ có SĐT: " + TimKiemTF.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy Chủ hộ có SĐT: " + TimKiemTF.getText());              
        }else if(selected.equals("Hình thức ở")){
            if(!DSPhanCongController.Searching(TimKiemTF.getText(), BangDSThongTinSD, 5))
               JOptionPane.showMessageDialog(this, "Không tìm thấy Chủ hộ có Account: " + TimKiemTF.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy Chủ hộ có Account: " + TimKiemTF.getText());              
        }
    }//GEN-LAST:event_TimKiemBTActionPerformed

    private void LamMoiBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoiBTActionPerformed
        try {
            mainAdminView.setForm(new ThongTinSDDienView(mainAdminView));
            DaNhapCTDCB.setSelected(false);
            ChuaNhapCTDCB.setSelected(false);
            NhapCTDCB.clearSelection();
        } catch (Exception ex) {
            Logger.getLogger(ThongTinSDDienView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_LamMoiBTActionPerformed

    private void ChuaNhapCTDCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChuaNhapCTDCBActionPerformed
        List<Customers> newListCustomer=new ArrayList<>();
        for(Customers tmpCus: listcustomer){
            int cusId=new ThongTinSDDienController().getIdCustomerbyCCCD(tmpCus.getCCCD());
            if(!checkcustomerIdinE(cusId)){
                newListCustomer.add(tmpCus);
            }
        }
        try {
            ShowThongTinTuDBS2(newListCustomer, this.listemeter);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_ChuaNhapCTDCBActionPerformed

    private void DaNhapCTDCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DaNhapCTDCBActionPerformed
        List<Customers> newListCustomer=new ArrayList<>();
        //Loc ra danh sach cac customer da co cong to dien 
        for(Customers tmpCus : listcustomer){
            int cusId=new ThongTinSDDienController().getIdCustomerbyCCCD(tmpCus.getCCCD());
            for(E_Meters tmpe  : listemeter){
                if(tmpe.getID_Customer()==cusId){
                    newListCustomer.add(tmpCus);
                    break;
                }
            }
        }
        try {
            ShowThongTinTuDBS2(newListCustomer, this.listemeter);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_DaNhapCTDCBActionPerformed

    private void SapXepBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SapXepBtActionPerformed
        Object selected = SapXepCkb.getSelectedItem();
        if(selected == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thuộc tính cần sắp xếp!!!");
        }else{
            SortLoaiStringThongTinSDDienDialog sortLoaiStringThongTinSDDienDialog = new SortLoaiStringThongTinSDDienDialog(this.mainAdminView, this, true);
            sortLoaiStringThongTinSDDienDialog.setVisible(true);
        }
    }//GEN-LAST:event_SapXepBtActionPerformed
     public ComboboxThuong getSapXepCkb() {
        return SapXepCkb;
    }

    public void setSapXepCkb(ComboboxThuong SapXepCkb) {
        this.SapXepCkb = SapXepCkb;
    }
    private void showCapNhatCongToDienDialog() {

    }  

    public BangDanhSach getBangDSThongTinSD() {
        return BangDSThongTinSD;
    }

    public void setBangDSThongTinSD(BangDanhSach BangDSThongTinSD) {
        this.BangDSThongTinSD = BangDSThongTinSD;
    }
    
    private void showThemCongToDienDialog() {

    }  
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.BangDanhSach BangDSThongTinSD;
    private LayMotSoUIdepTaiDay.CheckBox ChuaNhapCTDCB;
    private LayMotSoUIdepTaiDay.CheckBox DaNhapCTDCB;
    private LayMotSoUIdepTaiDay.ButtonThuong LamMoiBT;
    private javax.swing.ButtonGroup NhapCTDCB;
    private LayMotSoUIdepTaiDay.ButtonThuong SapXepBt;
    private LayMotSoUIdepTaiDay.ComboboxThuong SapXepCkb;
    private LayMotSoUIdepTaiDay.ButtonThuong TimKiemBT;
    private LayMotSoUIdepTaiDay.ComboboxThuong TimKiemCb;
    private javax.swing.JTextField TimKiemTF;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
