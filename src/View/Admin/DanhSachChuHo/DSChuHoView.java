package View.Admin.DanhSachChuHo;

import Controller.ChuHoController.DSChuHoController;
import LayMotSoUIdepTaiDay.BangDanhSach;
import Model.Customers;
import View.Admin.MainAdminView;
import View.Admin.DanhSachChuHo.DSChuHoForm.CapNhatAccountCH;
import View.Admin.DanhSachChuHo.DSChuHoForm.CapNhatCCCDCH;
import View.Admin.DanhSachChuHo.DSChuHoForm.CapNhatThongTinCH;
import View.Admin.DanhSachChuHo.DSChuHoForm.ThemChuHoDialog;
import View.Admin.DanhSachChuHo.DSChuHoForm.XoaChuHoDialog;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
public class DSChuHoView extends javax.swing.JPanel {
    private Customers chuho;
    private List<Customers> dsChuHo;
    //Mac dinh gia tri ban dau 

    public Customers getChuHo() {
        return chuho;
    }

    public void setChuHo(Customers chuHo) {
        this.chuho = chuHo;
    }
       
    private MainAdminView mainNhanVienView = new MainAdminView();
    
    public DSChuHoView(MainAdminView mnv) {
        initComponents();
        this.mainNhanVienView = mnv;
        this.setSize(mainNhanVienView.getMainPanel().getSize());
        this.setVisible(true);
        LammoiDS();
        ShowThongTinTuDBS();
//        CapNhatCombobox.setEnabled(false);
        //Tạo Action khi nhấp chọn hàng trong Jtable BangDSChuHo
//        ListSelectionListener rowListener;
//        rowListener = new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent e) {
//                if (!e.getValueIsAdjusting()) {
//                    int selectedRow = BangDSChuHo.getSelectedRow();
//                    ChuHo chuHo = new DSChuHoController().LayThongTinChuHoQuaCCCD((String) BangDSChuHo.getValueAt(selectedRow, 0));
//                    if (selectedRow != -1 && chuHo != null) { 
//                        // Lấy dữ liệu từ hàng đó và xử lý dữ liệu   
//                        CapNhatCombobox.setEnabled(true);
//                        setChuHo(chuHo);              
//                        TimKiemTF.setText(chuHo.getUsername());
//                    }
//                }
//            };
//        };
//        BangDSChuHo.getSelectionModel().addListSelectionListener(rowListener);
    }
    
    public void LammoiDS(){
        dsChuHo = new DSChuHoController().getDsChuHo();
    }
    
    public void ShowThongTinTuDBS(){
        DefaultTableModel model ;
        model =(DefaultTableModel) BangDSChuHo.getModel();
        model.setRowCount(0);    
        for(Customers chuHo : dsChuHo){
            String hovaten=chuHo.getLastname()+" "+chuHo.getMiddleName()+" "+chuHo.getFirstname();
            Object[] rowData = {
                chuHo.getCCCD(),hovaten, chuHo.getDOB(), 
                chuHo.getAddress(), chuHo.getPhone(), chuHo.getAccount_username(), 
                chuHo.getPassword(),chuHo.isSex() ? "Nữ" :"Nam"
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
        LamMoiBT = new LayMotSoUIdepTaiDay.ButtonThuong();
        CbSort = new LayMotSoUIdepTaiDay.ComboboxThuong();
        CbSex = new LayMotSoUIdepTaiDay.ComboboxThuong();

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
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CCCD", "Họ và tên", "Ngày sinh", "Địa chỉ", "SĐT", "Account", "Password", "Giới tính "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        BangDSChuHo.setEnabled(false);
        BangDSChuHo.getTableHeader().setReorderingAllowed(false);
        ScrollPane.setViewportView(BangDSChuHo);

        LamMoiBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Refresh.png"))); // NOI18N
        LamMoiBT.setText("Làm mới");
        LamMoiBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LamMoiBTActionPerformed(evt);
            }
        });

        CbSort.setBackground(new java.awt.Color(192, 192, 192));
        CbSort.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CCCD", "Họ và Tên ", "Account", "Mặc định" }));
        CbSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbSortActionPerformed(evt);
            }
        });

        CbSex.setBackground(new java.awt.Color(192, 192, 192));
        CbSex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nam", "Nữ ", "Nam và Nữ ", " " }));
        CbSex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbSexActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TimKiemTF, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TimKiemBT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CbSort, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CbSex, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LamMoiBT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TimKiemTF, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TimKiemBT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CbSort, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CbSex, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(LamMoiBT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void LamMoiBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoiBTActionPerformed
        mainNhanVienView.setForm(new DSChuHoView(mainNhanVienView));
    }//GEN-LAST:event_LamMoiBTActionPerformed
    
    public String [] formatName(String hovaten){
        String [] tmp=hovaten.split(" ");
               if(tmp.length==2){
                    tmp=Arrays.copyOf(tmp,tmp.length +1);
                    tmp[2]=tmp[1];
                    tmp[1]="";
               }
        return tmp;       
    }
    
    public void LocDs(){
         String key =(String)CbSex.getSelectedItem();
         DefaultTableModel model = (DefaultTableModel) BangDSChuHo.getModel();  
         model.setRowCount(0);
         if(key.equals("Nam và Nữ ")){
             ShowThongTinTuDBS();
         }else{
            for(Customers chuho :dsChuHo ){ 
            
             if((CbSex.getSelectedIndex()==1 ? true:false) == chuho.isSex()){
                String hovaten=chuho.getLastname() +" "+chuho.getMiddleName()+ chuho.getFirstname();
                Object []rowdata={
                    chuho.getCCCD(),hovaten,chuho.getDOB(),chuho.getAddress(),chuho.getPhone(),
                    chuho.getAccount_username(),chuho.getPassword(),chuho.isSex()==true? "Nữ" :"Nam"
                };
                model.addRow(rowdata);
            }
         }
         }
        model.fireTableDataChanged();
        
    }
    
    private void CbSexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbSexActionPerformed

        LocDs();

    }//GEN-LAST:event_CbSexActionPerformed

    public void Sapxep(int key){
        LammoiDS();
        if(key == 0){
            
            Collections.sort(dsChuHo, new Comparator<Customers>() {
            @Override
            public int compare(Customers p1, Customers p2) {
                return p1.getCCCD().compareTo(p2.getCCCD());
            }
            });
            
        }else if(key == 1){
            
            Collections.sort(dsChuHo, new Comparator<Customers>() {
            @Override
            public int compare(Customers p1, Customers p2) {
                String name1= p1.getLastname()+" "+p1.getMiddleName()+" "+p1.getFirstname();
                String name2= p2.getLastname()+" "+p2.getMiddleName()+" "+p2.getFirstname();
                return name1.compareTo(name2);
            }
            });
            
        }else if(key == 2 ){
            
            Collections.sort(dsChuHo, new Comparator<Customers>() {
            @Override
            public int compare(Customers p1, Customers p2) {
                return p1.getAccount_username().compareTo(p2.getAccount_username());
            }
            });
        }else if(key == 3){
            LammoiDS();
        }
        ShowThongTinTuDBS();
    }
    
    private void CbSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbSortActionPerformed
        int key = CbSort.getSelectedIndex();
        System.out.println(key);
        Sapxep(key);
   
        
    }//GEN-LAST:event_CbSortActionPerformed
    
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
        CapNhatCCCDCH capNhatChuHo = new CapNhatCCCDCH(mainNhanVienView,this, true);
        capNhatChuHo.setVisible(true);
    }  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.BangDanhSach BangDSChuHo;
    private LayMotSoUIdepTaiDay.ComboboxThuong CbSex;
    private LayMotSoUIdepTaiDay.ComboboxThuong CbSort;
    private LayMotSoUIdepTaiDay.ButtonThuong LamMoiBT;
    private javax.swing.JScrollPane ScrollPane;
    private LayMotSoUIdepTaiDay.ButtonThuong TimKiemBT;
    private javax.swing.JTextField TimKiemTF;
    // End of variables declaration//GEN-END:variables
}
