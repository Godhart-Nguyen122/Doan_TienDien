
package View.AdminView.DanhSachPhanCong.Form;

import Controller.DSChuHoController.DSChuHo;
import Controller.DSNhanVienController.DSNhanVien;
import Controller.DSPhanCongController.DSPhanCongController;
import Model.Customers;
import Model.Personal_Infos;
import Model.Staffs;
import View.AdminView.MainAdminView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class PhanCong extends javax.swing.JDialog {

    private MainAdminView mainNhanVienView;
    private List<Personal_Infos>personal_InfosNV=new ArrayList<>();
    private List<Customers>personal_InfosCHNChuaPC=new ArrayList<>();
    
    public  void refresh() throws Exception{
        
         cbNhanVien.removeAllItems();
         cbChuho.removeAllItems();
         //Them Nhan vien ghi nuoc 
         for(Personal_Infos tmp :personal_InfosNV){
             String fullname=tmp.getLastname()+ " " +tmp.getMiddleName()+" "+tmp.getLastname();
             cbNhanVien.addItem(fullname);
             System.out.println(fullname);
        }
         //Them chu ho chua phan cong 
         System.out.println("=========================");
         for(Customers tmp :personal_InfosCHNChuaPC){
                 String fullname=tmp.getLastname()+ " " +tmp.getMiddleName()+" "+tmp.getLastname();
                 cbChuho.addItem(fullname);
                 System.out.println(fullname);        
         }
    }
    
    
    public PhanCong(MainAdminView Frame,boolean modal) throws Exception {    
        this.mainNhanVienView = Frame;
        initComponents();
        this.personal_InfosNV=new DSPhanCongController().getAllStaffGhincInfo();
        for(Customers tmp :new DSPhanCongController().getAllCustomers()){
            if(tmp.getId_Staff()==0){
                personal_InfosCHNChuaPC.add(tmp);
            }
        }
        refresh();
        this.setResizable(false);
        this.setTitle("Thêm Phân Công");
        this.setModalityType(DEFAULT_MODALITY_TYPE.APPLICATION_MODAL);
        this.setLocationRelativeTo(null);
        
//        System.out.println(ProgramVariable.username);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CCCDChuHoField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TenChuHoField = new javax.swing.JTextField();
        SDTChuHoField = new javax.swing.JTextField();
        TenNhanVienField = new javax.swing.JTextField();
        SDTNhanVienField = new javax.swing.JTextField();
        CCCDNhanVienField = new javax.swing.JTextField();
        OkButton = new LayMotSoUIdepTaiDay.ButtonThuong();
        jLabel4 = new javax.swing.JLabel();
        cbNhanVien = new javax.swing.JComboBox<>();
        cbChuho = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("               Nhân Viên ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("                    Chủ hộ ");

        CCCDChuHoField.setEditable(false);

        jLabel3.setText("CCCD:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        jLabel6.setText("Họ và Tên:");

        jLabel7.setText("SĐT:");

        TenChuHoField.setEditable(false);

        SDTChuHoField.setEditable(false);

        TenNhanVienField.setEditable(false);

        SDTNhanVienField.setEditable(false);

        CCCDNhanVienField.setEditable(false);

        OkButton.setText("OK");
        OkButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        OkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("PHÂN CÔNG");

        cbNhanVien.setBackground(new java.awt.Color(242, 242, 242));
        cbNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", " " }));
        cbNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNhanVienActionPerformed(evt);
            }
        });

        cbChuho.setBackground(new java.awt.Color(242, 242, 242));
        cbChuho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", " " }));
        cbChuho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbChuhoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(217, 217, 217))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbChuho, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SDTChuHoField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CCCDChuHoField)
                            .addComponent(TenChuHoField, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbNhanVien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TenNhanVienField)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                            .addComponent(CCCDNhanVienField)
                            .addComponent(SDTNhanVienField, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbNhanVien)
                    .addComponent(cbChuho, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CCCDChuHoField, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(80, 80, 80))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CCCDNhanVienField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TenNhanVienField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TenChuHoField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(SDTNhanVienField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SDTChuHoField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNhanVienActionPerformed
         int index=cbNhanVien.getSelectedIndex();
        if(index<0){
            index=0;
        }
        this.CCCDNhanVienField.setText(personal_InfosNV.get(index).getCCCD());
        String fullname=personal_InfosNV.get(index).getLastname()+ " " +personal_InfosNV.get(index).getMiddleName()+" "+personal_InfosNV.get(index).getLastname();
        this.TenNhanVienField.setText(fullname);
        this.SDTNhanVienField.setText(personal_InfosNV.get(index).getPhone());
    }//GEN-LAST:event_cbNhanVienActionPerformed

    private void cbChuhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbChuhoActionPerformed
        int index=cbChuho.getSelectedIndex();
        if(index<0){
            index=0;
        }
        this.CCCDChuHoField.setText(personal_InfosCHNChuaPC.get(index).getCCCD());
        String fullname=personal_InfosCHNChuaPC.get(index).getLastname()+ " " +personal_InfosCHNChuaPC.get(index).getMiddleName()+" "+personal_InfosCHNChuaPC.get(index).getLastname();
        this.TenChuHoField.setText(fullname);
        this.SDTChuHoField.setText(personal_InfosCHNChuaPC.get(index).getPhone());
    }//GEN-LAST:event_cbChuhoActionPerformed

    private void OkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkButtonActionPerformed
    int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn tiếp tục phân công chủ hộ này?", "XÁC NHẬN", JOptionPane.YES_NO_OPTION);
    if(option==JOptionPane.YES_OPTION){
        // T
        String CCDDStaff=personal_InfosNV.get(cbNhanVien.getSelectedIndex()).getCCCD();
        Staffs tmp=new DSNhanVien().SearchObjCCCD(CCDDStaff);
        
        int index=cbChuho.getSelectedIndex();
        Customers selectedChuHo=personal_InfosCHNChuaPC.get(index);
        int IdCustomer=new DSPhanCongController().getIdCustomerbyCCCD(selectedChuHo.getCCCD());
        
//        // Viết dài đỡ cho việc query
        try {
            int staffId=new DSPhanCongController().getIdStaffByAccountUsername(tmp.getAccount_Username());
                    System.out.println("id staff: " +staffId);

            //Them staffId vao Customer
           boolean result= new DSPhanCongController().addId_Staff_Input_toCustomer(staffId, IdCustomer);
           if(result){
               JOptionPane.showMessageDialog(null, "Đã phân công chủ hộ thành công");
           }
        } catch (Exception ex) {
            Logger.getLogger(PhanCong.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }else if(option==JOptionPane.NO_OPTION){
        this.dispose();
    }
    }//GEN-LAST:event_OkButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CCCDChuHoField;
    private javax.swing.JTextField CCCDNhanVienField;
    private LayMotSoUIdepTaiDay.ButtonThuong OkButton;
    private javax.swing.JTextField SDTChuHoField;
    private javax.swing.JTextField SDTNhanVienField;
    private javax.swing.JTextField TenChuHoField;
    private javax.swing.JTextField TenNhanVienField;
    private javax.swing.JComboBox<String> cbChuho;
    private javax.swing.JComboBox<String> cbNhanVien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
