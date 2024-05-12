package View.AdminView.DanhSachPhanCong;

import Controller.DSPhanCongController.DSPhanCongController;
import LayMotSoUIdepTaiDay.BangDanhSach;
import LayMotSoUIdepTaiDay.ComboboxThuong;
import Model.Customers;
import Model.Personal_Infos;
import View.AdminView.DanhSachPhanCong.Form.SortLoaiStringDSPhanCongDialog;
import View.AdminView.DanhSachPhanCong.Form.CapNhat;
import View.AdminView.DanhSachPhanCong.Form.PhanCong;
import View.AdminView.MainAdminView;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class DSPhanCong extends javax.swing.JPanel {

    private MainAdminView mainAdminView = new MainAdminView();
    private List<Personal_Infos>personal_InfosNV=new ArrayList<>();
    private List<Customers>personal_InfosCH=new ArrayList<>();
    private int seletedRow=-1;
    
    public void showThongtin() throws Exception{
        this.personal_InfosCH=new DSPhanCongController().getAllCustomers();
        DefaultTableModel model = (DefaultTableModel) BangDSPhanCong.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged(); 
        
        for(Customers tmp : personal_InfosCH){
            Personal_Infos newStaff=new DSPhanCongController().SearchStaffTheoId(tmp.getId_Staff());
            String nameCH=tmp.getLastname()+" "+tmp.getMiddleName()+" "+tmp.getFirstname();
            String nameStaff="";
            if(newStaff!=null){
                nameStaff=newStaff.getLastname()+" "+newStaff.getMiddleName()+" "+newStaff.getFirstname();
                model.addRow(new Object[]{tmp.getCCCD(),newStaff.getCCCD(),nameCH,tmp.getPhone(),tmp.getAddress(),nameStaff,newStaff.getPhone(),newStaff.getAddress()});
            }else{
                model.addRow(new Object[]{tmp.getCCCD()," ",nameCH,tmp.getPhone(),tmp.getAddress(),nameStaff," "," "});
            }
        }
    }
   
    
    public DSPhanCong(MainAdminView mnv) throws Exception {
        initComponents();
        this.mainAdminView = mnv;
        this.setSize(mainAdminView.getMainPanel().getSize());
        this.setVisible(true);
        showThongtin();
        BangDSPhanCong.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       
        
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
        refreshButton = new LayMotSoUIdepTaiDay.ButtonThuong();
        TimKiemCb = new LayMotSoUIdepTaiDay.ComboboxThuong();
        SapXepCkb = new LayMotSoUIdepTaiDay.ComboboxThuong();
        SapXepBt = new LayMotSoUIdepTaiDay.ButtonThuong();

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

        phanCongButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/8.png"))); // NOI18N
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

        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/4.png"))); // NOI18N
        refreshButton.setText("Làm Mới");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        TimKiemCb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CCCD(CH)", "CCCD(NV)", "Họ và tên(CH)", "Họ và tên(NV)", "SĐT(CH)", "Địa chỉ(CH)", " " }));
        TimKiemCb.setSelectedItem(null
        );
        TimKiemCb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TimKiemCb.setLabeText("(Tìm kiếm theo)");
        TimKiemCb.setLineColor(new java.awt.Color(0, 153, 255));

        SapXepCkb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Theo CCCD ", "Theo họ và tên ", "Theo địa chỉ", "Theo SĐT" }));
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
            .addComponent(ScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TimKiemTF, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TimKiemCb, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TimKiemButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phanCongButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(capNhatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(504, 504, 504)
                        .addComponent(SapXepCkb, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SapXepBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(TimKiemTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phanCongButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(capNhatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(TimKiemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(TimKiemCb, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SapXepBt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SapXepCkb, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TimKiemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemButtonActionPerformed
          BangDSPhanCong.setSelectionMode(2);
        Object selected = TimKiemCb.getSelectedItem();
        if(TimKiemTF.getText().replaceAll(" ", "").equals("") || selected == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại tìm kiếm và không bỏ trống thông tin nhập!!!");            
        }else if(selected.equals("CCCD(CH)")){
            if(!DSPhanCongController.Searching(TimKiemTF.getText(), BangDSPhanCong, 1))
               JOptionPane.showMessageDialog(this, "Không tìm thấy Chủ hộ có CCCD: " + TimKiemTF.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy Chủ hộ có CCCD: " + TimKiemTF.getText());  
        }else if(selected.equals("CCCD(NV)")){
            if(!DSPhanCongController.Searching(TimKiemTF.getText(), BangDSPhanCong, 2))
               JOptionPane.showMessageDialog(this, "Không tìm thấy Nhân viên có CCCD : " + TimKiemTF.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy Nhân viên có CCCD: " + TimKiemTF.getText());              
        }else if(selected.equals("Họ và tên(CH)")){
            if(!DSPhanCongController.Searching(TimKiemTF.getText(), BangDSPhanCong, 3))
               JOptionPane.showMessageDialog(this, "Không tìm thấy Chủ hộ có Họ và tên: " + TimKiemTF.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy Chủ hộ có Họ và tên: " + TimKiemTF.getText());              
        }else if(selected.equals("Họ và tên(NV)")){
            if(!DSPhanCongController.Searching(TimKiemTF.getText(), BangDSPhanCong, 4))
               JOptionPane.showMessageDialog(this, "Không tìm thấy Nhân viên có Họ và tên: " + TimKiemTF.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy Nhân viên có Họ và tên: " + TimKiemTF.getText());              
        }else if(selected.equals("SĐT(CH)")){
            if(!DSPhanCongController.Searching(TimKiemTF.getText(), BangDSPhanCong, 5))
               JOptionPane.showMessageDialog(this, "Không tìm thấy Chủ hộ có SĐT: " + TimKiemTF.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy Chủ hộ có SĐT: " + TimKiemTF.getText());              
        }else if(selected.equals("Địa chỉ(CH)")){
            if(!DSPhanCongController.Searching(TimKiemTF.getText(), BangDSPhanCong, 6))
               JOptionPane.showMessageDialog(this, "Không tìm thấy Chủ hộ có Địa chỉ: " + TimKiemTF.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy Chủ hộ có Địa chỉ: " + TimKiemTF.getText());              
        }
        
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
        System.out.println(BangDSPhanCong.getSelectedRow());
       
        if(BangDSPhanCong.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn chủ hộ cần cập nhật !! ");
          
        }else{
             String CccdCH= (String) BangDSPhanCong.getValueAt(BangDSPhanCong.getSelectedRow(),0);
             Customers tmp=null;
             for(Customers a :personal_InfosCH){
                 if(a.getCCCD().equals(CccdCH)){
                     tmp=a;
                     break;
                 }
             }  
             CapNhat capNhat;
            try {
                capNhat = new CapNhat(mainAdminView, true,tmp);
                capNhat.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(DSPhanCong.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }
      
    }//GEN-LAST:event_capNhatButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        try {
            showThongtin();
        } catch (Exception ex) {
            Logger.getLogger(DSPhanCong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void SapXepBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SapXepBtActionPerformed
         Object selected = SapXepCkb.getSelectedItem();
        if(selected == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thuộc tính cần sắp xếp!!!");
        }else{
            SortLoaiStringDSPhanCongDialog sortLoaiStringDSPhanCongDialog = new SortLoaiStringDSPhanCongDialog(this.mainAdminView, this, true);
            sortLoaiStringDSPhanCongDialog.setVisible(true);
        }
    }//GEN-LAST:event_SapXepBtActionPerformed

    public ComboboxThuong getSapXepCkb() {
        return SapXepCkb;
    }

    public void setSapXepCkb(ComboboxThuong SapXepCkb) {
        this.SapXepCkb = SapXepCkb;
    }

    public BangDanhSach getBangDSPhanCong() {
        return BangDSPhanCong;
    }

    public void setBangDSPhanCong(BangDanhSach BangDSPhanCong) {
        this.BangDSPhanCong = BangDSPhanCong;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.BangDanhSach BangDSPhanCong;
    private LayMotSoUIdepTaiDay.ButtonThuong SapXepBt;
    private LayMotSoUIdepTaiDay.ComboboxThuong SapXepCkb;
    private javax.swing.JScrollPane ScrollPane;
    private LayMotSoUIdepTaiDay.ButtonThuong TimKiemButton;
    private LayMotSoUIdepTaiDay.ComboboxThuong TimKiemCb;
    private javax.swing.JTextField TimKiemTF;
    private LayMotSoUIdepTaiDay.ButtonThuong capNhatButton;
    private LayMotSoUIdepTaiDay.ButtonThuong phanCongButton;
    private LayMotSoUIdepTaiDay.ButtonThuong refreshButton;
    // End of variables declaration//GEN-END:variables
}
