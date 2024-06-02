package View.StaffView.QLThongTinChungView;



import Controller.DAO.CustomerDAO;
import Controller.DAO.Personal_InfosDAO;
import Controller.DAO.PhanCongDAO;
import Controller.DSChuHoController.DSChuHo;
import Controller.QLPhanQuyenTKController.DSTaiKhoanPhanQuyen;
import Controller.QLThongTinChungController.DSThongTinChung;
import Controller.SupportFunction.StringProcessing;
import LayMotSoUIdepTaiDay.BangDanhSach;
import LayMotSoUIdepTaiDay.ComboboxThuong;
import Model.Accounts;
import Model.Customers;
import Model.Personal_Infos;
import View.AdminView.MainAdminView;
import View.StaffView.DSChuhoStaffView.DSChuHoStaffView;
import View.StaffView.MainStaffView;
import View.StaffView.QLThongTinChungView.QLTTChungDialog.CapNhatCCCDTTChungDialog;
import View.StaffView.QLThongTinChungView.QLTTChungDialog.CapNhatTTChungDialog;
import View.StaffView.QLThongTinChungView.QLTTChungDialog.FilterLoaiDateTTCDialog;
import View.StaffView.QLThongTinChungView.QLTTChungDialog.FilterLoaiGioiTinhTTCDialog;
import View.StaffView.QLThongTinChungView.QLTTChungDialog.SortLoaiDateTTCDialog;
import View.StaffView.QLThongTinChungView.QLTTChungDialog.SortLoaiStringTTCDialog;
import View.StaffView.QLThongTinChungView.QLTTChungDialog.ThemTTChungDialog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class QLTTChungStaffView extends javax.swing.JPanel {
     private Customers Cs;
    private MainStaffView mainStaffView;
    private int idStafflogin;
    private List<Customers>dsChuhoMnStaff;
      
 
 
    public QLTTChungStaffView(MainStaffView msv,int idStaff,List<Integer>liscus) throws Exception {
        initComponents();
        this.mainStaffView = msv;
        this.idStafflogin=idStaff;
        this.setSize(mainStaffView.getMainPanel().getSize());
        dsChuhoMnStaff=new ArrayList<>();
        ShowThongTinTuDBS(BangDSTTChung);    
    }

    public QLTTChungStaffView() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public  void devideChuho() throws Exception{
        // Chia danh sách ch? h? theo nhân viên ghi đi?n 0 nhân viên nh?p hóa đơn 1
        List<Customers>danhsach=new DSChuHo().LayDanhSachChuho();
        System.out.println("Danh sach chu ho trong viw :"+danhsach.size());
         for(Customers tmp:danhsach){
             boolean roleStaff=new PhanCongDAO().getRoleStaffbyId(this.idStafflogin);
             System.out.println("Id nhan vien "+this.idStafflogin);
             System.out.println("Vai tro cua nhan vien :"+roleStaff);
             if(roleStaff==true){
                 System.out.println("Id Staff write:"+tmp.getId_Staff_Write());
                 if(tmp.getId_Staff_Write()==this.idStafflogin){
                     this.dsChuhoMnStaff.add(tmp);
                 }
             }else if(roleStaff==false){
                 if(tmp.getId_Staff()==this.idStafflogin){
                     this.dsChuhoMnStaff.add(tmp);
                 }
             }
        }
        System.out.println("Sau khi chia la :"+this.dsChuhoMnStaff.size()); 
    }
    public void ShowThongTinTuDBS(BangDanhSach bangDS) throws Exception{
        DefaultTableModel model = (DefaultTableModel) bangDS.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged(); 
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        devideChuho();
        model.setRowCount(0);    
        if(this.dsChuhoMnStaff.isEmpty()){
           JOptionPane.showMessageDialog(this, "Danh sách chủ hộ rỗng: ");
        }
        else{
            for(Customers tmp:this.dsChuhoMnStaff){
                    Accounts accCustomer=new DSTaiKhoanPhanQuyen().SearchObjAccountbyCCCD(tmp.getCCCD());
                    String usernameCus="";
                    String passCus="";
                    if(accCustomer!=null){
                        usernameCus=accCustomer.getAccount_Username();
                        passCus=accCustomer.getAccount_Password();
                    }
                    String Gioi_tinh;
                    String name = tmp.getFirstname() + " " + tmp.getMiddleName()+ " " + tmp.getLastname();
                    String Ten = new StringProcessing().Name(name);
                    if(tmp.isSex())
                        Gioi_tinh = "Nam";
                    else
                        Gioi_tinh = "Nữ";
                    Object[] rowData = {
                        tmp.getCCCD(), Ten, dateFormat.format(tmp.getDOB()), 
                        tmp.getAddress(), tmp.getPhone(), Gioi_tinh
                        };
//                    String hovaten=tmp.getLastname()+" "+tmp.getMiddleName()+" "+tmp.getLastname();
//                    Object[] rowData = {
//                        tmp.getCCCD(), hovaten,dateFormat.format(tmp.getDOB()), 
//                        tmp.getAddress(), tmp.getPhone(), usernameCus,
//                        passCus,
//                    };
                        
                    model.addRow(rowData);
                }
        }
        
//         if(new PhanCongDAO().getRoleStaffbyId(this.idStafflogin)){
//             if(this.listcusofStaff.isEmpty()){
//               JOptionPane.showMessageDialog(this, "Danh sách chủ hộ rỗng: ");
//            }
//             else{
//                 for(Integer tmp:this.listcusofStaff){
//                      
//                      Personal_Infos tmpPs =new Personal_InfosDAO().getStaffInfosbyID(tmp);
//                      String Gioi_tinh;
//                     String name = tmpPs.getFirstname() + " " + tmpPs.getMiddleName()+ " " + tmpPs.getLastname();
//                    String Ten = new StringProcessing().Name(name);
//                    if(tmpPs.isSex())
//                        Gioi_tinh = "Nam";
//                    else
//                        Gioi_tinh = "Nữ";
//            Object[] rowData = {
//                tmpPs.getCCCD(), Ten, dateFormat.format(tmpPs.getDOB()), 
//                tmpPs.getAddress(), tmpPs.getPhone(), Gioi_tinh
//                    };
//
//            model.addRow(rowData);
//                 }
//                 
//                 for(Personal_Infos ps : dsInfos){
//                    String Gioi_tinh;
//                     String name = ps.getFirstname() + " " + ps.getMiddleName()+ " " + ps.getLastname();
//                    String Ten = new StringProcessing().Name(name);
//                    if(ps.isSex())
//                        Gioi_tinh = "Nam";
//                    else
//                        Gioi_tinh = "Nữ";
//            Object[] rowData = {
//                ps.getCCCD(), Ten, dateFormat.format(ps.getDOB()), 
//                ps.getAddress(), ps.getPhone(), Gioi_tinh
//                    };
//
//            model.addRow(rowData);
//                }   
//            }
//             
//         }
       
        StringProcessing.StringSortingTable(BangDSTTChung, 0, true);
        model.fireTableDataChanged();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BangSrllp = new javax.swing.JScrollPane();
        BangDSTTChung = new LayMotSoUIdepTaiDay.BangDanhSach();
        ThemBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        CapNhatBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        CapNhatCb = new LayMotSoUIdepTaiDay.ComboboxThuong();
        LamMoiBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        DangChonTf = new javax.swing.JTextField();
        DangChonLbl = new javax.swing.JLabel();
        TimKiemTf = new javax.swing.JTextField();
        TimKiemBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        TimKiemCb = new LayMotSoUIdepTaiDay.ComboboxThuong();
        jSeparator1 = new javax.swing.JSeparator();
        LocBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        LocCkb = new LayMotSoUIdepTaiDay.ComboboxThuong();
        SapXepCkb = new LayMotSoUIdepTaiDay.ComboboxThuong();
        SapXepBt = new LayMotSoUIdepTaiDay.ButtonThuong();

        setBackground(new java.awt.Color(255, 255, 255));

        BangDSTTChung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CCCD", "Họ và tên", "Ngày sinh", "Địa chỉ", "SĐT", "Giới tính"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        BangDSTTChung.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        BangDSTTChung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BangDSTTChungMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BangDSTTChungMouseReleased(evt);
            }
        });
        BangSrllp.setViewportView(BangDSTTChung);

        ThemBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Isert_icon.png"))); // NOI18N
        ThemBt.setText("Thêm thông tin người dùng");
        ThemBt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ThemBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemBtActionPerformed(evt);
            }
        });

        CapNhatBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/6.png"))); // NOI18N
        CapNhatBt.setText("Cập nhật thông tin người dùng");
        CapNhatBt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CapNhatBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CapNhatBtActionPerformed(evt);
            }
        });

        CapNhatCb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cập nhật thông tin chung", "Cập nhật CCCD" }));
        CapNhatCb.setSelectedItem(null
        );
        CapNhatCb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CapNhatCb.setLabeText("(Chọn loại cập nhật)");
        CapNhatCb.setLineColor(new java.awt.Color(0, 153, 255));

        LamMoiBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Refresh.png"))); // NOI18N
        LamMoiBt.setText("Làm mới");
        LamMoiBt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LamMoiBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LamMoiBtActionPerformed(evt);
            }
        });

        DangChonTf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DangChonTf.setForeground(new java.awt.Color(102, 102, 102));
        DangChonTf.setText("NULL");
        DangChonTf.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        DangChonLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DangChonLbl.setText("Đang chọn (CCCD):");

        TimKiemTf.setBackground(new java.awt.Color(204, 204, 204));
        TimKiemTf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TimKiemTf.setForeground(new java.awt.Color(102, 102, 102));
        TimKiemTf.setToolTipText("");
        TimKiemTf.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TimKiemTf.setName(""); // NOI18N

        TimKiemBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/search.png"))); // NOI18N
        TimKiemBt.setText("Tìm kiếm");
        TimKiemBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimKiemBtActionPerformed(evt);
            }
        });

        TimKiemCb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CCCD", "Họ và tên", "Địa chỉ", "SĐT" }));
        TimKiemCb.setSelectedItem(null
        );
        TimKiemCb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TimKiemCb.setLabeText("(Tìm kiếm theo)");
        TimKiemCb.setLineColor(new java.awt.Color(0, 153, 255));

        jSeparator1.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        LocBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/filter.png"))); // NOI18N
        LocBt.setText("Lọc");
        LocBt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LocBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocBtActionPerformed(evt);
            }
        });

        LocCkb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Theo ngày sinh", "Theo giới tính" }));
        LocCkb.setSelectedItem(null);
        LocCkb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LocCkb.setLabeText("(Chọn thuộc tính cần lọc)");

        SapXepCkb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Theo CCCD", "Theo họ và tên", "Theo địa chỉ", "Theo SĐT", "Theo ngày sinh" }));
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BangSrllp)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TimKiemTf, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TimKiemCb, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DangChonLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DangChonTf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TimKiemBt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ThemBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LamMoiBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CapNhatCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CapNhatBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(32, 32, 32)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LocCkb, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(SapXepCkb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LocBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SapXepBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(TimKiemCb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(TimKiemTf))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(DangChonLbl)
                                .addComponent(DangChonTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(9, 9, 9))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ThemBt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TimKiemBt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LamMoiBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CapNhatBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CapNhatCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LocCkb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LocBt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(SapXepCkb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SapXepBt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(BangSrllp, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ThemBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemBtActionPerformed
        showThemTTChungDialog();
    }//GEN-LAST:event_ThemBtActionPerformed

    private void LamMoiBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoiBtActionPerformed
 
        try {
            mainStaffView.setForm(new QLTTChungStaffView(this.mainStaffView,this.idStafflogin,new ArrayList<>()));
        } catch (Exception ex) {
            Logger.getLogger(QLTTChungStaffView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_LamMoiBtActionPerformed

    private void CapNhatBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CapNhatBtActionPerformed
        Object selected = CapNhatCb.getSelectedItem();
        if(!(BangDSTTChung.getSelectionModel().isSelectionEmpty()) && (selected != null) && (Cs != null)){          
            if(selected.equals("Cập nhật thông tin chung")){
                showCapNhatTTCDialog();
            }else{
                showCapNhatCCCDTTCDialog();
            }                    
        }else{
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thông tin người dùng cần cập nhật và loại cập nhật trên bảng!!!");
        }
    }//GEN-LAST:event_CapNhatBtActionPerformed

    private void BangDSTTChungMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangDSTTChungMousePressed
        int i = BangDSTTChung.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) BangDSTTChung.getModel();
        Personal_Infos ps = DSThongTinChung.SearchObjCCCD((String) model.getValueAt(i, 0));
        this.Cs = Cs;
        DangChonTf.setText(Cs.getCCCD());
    }//GEN-LAST:event_BangDSTTChungMousePressed

    private void BangDSTTChungMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangDSTTChungMouseReleased
        int i = BangDSTTChung.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) BangDSTTChung.getModel();
        Personal_Infos ps = DSThongTinChung.SearchObjCCCD((String) model.getValueAt(i, 0));
        this.Cs = Cs;
        DangChonTf.setText(Cs.getCCCD());
    }//GEN-LAST:event_BangDSTTChungMouseReleased

    private void TimKiemBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemBtActionPerformed
        BangDSTTChung.setSelectionMode(2);
        Object selected = TimKiemCb.getSelectedItem();
        if(TimKiemTf.getText().replaceAll(" ", "").equals("") || selected == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại tìm kiếm và không bỏ trống thông tin nhập!!!");            
        }else if(selected.equals("CCCD")){
            if(!DSThongTinChung.Searching(TimKiemTf.getText(), BangDSTTChung, 1))
               JOptionPane.showMessageDialog(this, "Không tìm thấy người dùng có CCCD: " + TimKiemTf.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy người dùng có CCCD: " + TimKiemTf.getText());  
        }else if(selected.equals("Họ và tên")){
            if(!DSThongTinChung.Searching(TimKiemTf.getText(), BangDSTTChung, 2))
               JOptionPane.showMessageDialog(this, "Không tìm thấy người dùng có họ tên: " + TimKiemTf.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy người dùng có họ tên: " + TimKiemTf.getText());              
        }else if(selected.equals("Địa chỉ")){
            if(!DSThongTinChung.Searching(TimKiemTf.getText(), BangDSTTChung, 3))
               JOptionPane.showMessageDialog(this, "Không tìm thấy người dùng có địa chỉ: " + TimKiemTf.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy người dùng có địa chỉ: " + TimKiemTf.getText());              
        }else if(selected.equals("SĐT")){
            if(!DSThongTinChung.Searching(TimKiemTf.getText(), BangDSTTChung, 4))
               JOptionPane.showMessageDialog(this, "Không tìm thấy người dùng có SĐT: " + TimKiemTf.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy người dùng có SĐT: " + TimKiemTf.getText());              
        }
    }//GEN-LAST:event_TimKiemBtActionPerformed

    private void LocBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocBtActionPerformed
        Object selected = LocCkb.getSelectedItem();
        if(selected == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thuộc tính cần lọc!!!");             
        }else if(selected.equals("Theo ngày sinh")){
            FilterLoaiDateTTCDialog filterLoaiDateTTCDialog = new FilterLoaiDateTTCDialog(this.mainStaffView, this, true);
            filterLoaiDateTTCDialog.setVisible(true);           
        }else{
            FilterLoaiGioiTinhTTCDialog filterLoaiGioiTinhTTCDialog = new FilterLoaiGioiTinhTTCDialog(this.mainStaffView, this, true);
            filterLoaiGioiTinhTTCDialog.setVisible(true); 
        }
    }//GEN-LAST:event_LocBtActionPerformed

    private void SapXepBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SapXepBtActionPerformed
        Object selected = SapXepCkb.getSelectedItem();
        if(selected == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thuộc tính cần sắp xếp!!!");             
        }else if(selected.equals("Theo ngày sinh")){
            SortLoaiDateTTCDialog sortLoaiDateTTCDialog = new SortLoaiDateTTCDialog(this.mainStaffView, this, true);
            sortLoaiDateTTCDialog.setVisible(true);           
        }else{
            SortLoaiStringTTCDialog sortLoaiStringTTCDialog = new SortLoaiStringTTCDialog(this.mainStaffView, this, true);
            sortLoaiStringTTCDialog.setVisible(true);  
        }
    }//GEN-LAST:event_SapXepBtActionPerformed

    private void showThemTTChungDialog() {
        ThemTTChungDialog themTTChungDialog = new ThemTTChungDialog(this.mainStaffView, this, true);
        themTTChungDialog.setVisible(true);
    }

    private void showCapNhatTTCDialog() {
        CapNhatTTChungDialog capNhatTTChungDialog = new CapNhatTTChungDialog(this.mainStaffView, this, true);
        capNhatTTChungDialog.setVisible(true);
    }    
    
    private void showCapNhatCCCDTTCDialog() {
        CapNhatCCCDTTChungDialog capNhatCCCDTTChungDialog = new CapNhatCCCDTTChungDialog(this.mainStaffView, this, true);
        capNhatCCCDTTChungDialog.setVisible(true);
    }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.BangDanhSach BangDSTTChung;
    private javax.swing.JScrollPane BangSrllp;
    private LayMotSoUIdepTaiDay.ButtonThuong CapNhatBt;
    private LayMotSoUIdepTaiDay.ComboboxThuong CapNhatCb;
    private javax.swing.JLabel DangChonLbl;
    private javax.swing.JTextField DangChonTf;
    private LayMotSoUIdepTaiDay.ButtonThuong LamMoiBt;
    private LayMotSoUIdepTaiDay.ButtonThuong LocBt;
    private LayMotSoUIdepTaiDay.ComboboxThuong LocCkb;
    private LayMotSoUIdepTaiDay.ButtonThuong SapXepBt;
    private LayMotSoUIdepTaiDay.ComboboxThuong SapXepCkb;
    private LayMotSoUIdepTaiDay.ButtonThuong ThemBt;
    private LayMotSoUIdepTaiDay.ButtonThuong TimKiemBt;
    private LayMotSoUIdepTaiDay.ComboboxThuong TimKiemCb;
    private javax.swing.JTextField TimKiemTf;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    public Personal_Infos getPs() {
        return Cs;
    }

    public void setPs(Personal_Infos Ps) {
        this.Cs = Cs;
    }
    
    public BangDanhSach getBangDSTTChung() {
        return BangDSTTChung;
    }

    public void setBangDSTTChung(BangDanhSach BangDSTTChung) {
        this.BangDSTTChung = BangDSTTChung;
    }
    
    public ComboboxThuong getSapXepCkb() {
        return SapXepCkb;
    }

    public void setSapXepCkb(ComboboxThuong SapXepCkb) {
        this.SapXepCkb = SapXepCkb;
    }
   
    
    public Customers getCs() {
        return Cs;
    }

    public void setCs(Customers cs) {
        this.Cs = cs;
    }
    
  
}
