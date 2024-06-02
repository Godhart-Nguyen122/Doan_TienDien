package View.StaffView.GhiChiSoView;

import View.StaffView.DSChuhoStaffView.*;
import Controller.DAO.CustomerDAO;
import Controller.DAO.E_Meter_DetailsDAO;
import Controller.DAO.PhanCongDAO;
import Controller.DSChuHoController.DSChuHo;
import Controller.StaffView.GhiChiSo;
import Controller.SupportFunction.StringProcessing;
import LayMotSoUIdepTaiDay.BangDanhSach;
import LayMotSoUIdepTaiDay.ComboboxThuong;
import Model.Customers;
import Model.E_Meter_Details;
import View.AdminView.DSChuHoView.DSChuHoDialog.FilterLoaiDateDSCHDialog;
import View.AdminView.DSChuHoView.DSChuHoDialog.SortLoaiStringDSCHDialog;
import View.StaffView.GhiChiSoView.GhiChiSoDialog.CapNhatDialog;
import View.StaffView.GhiChiSoView.GhiChiSoDialog.GhiChiSoDialog;

import View.StaffView.MainStaffView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static org.apache.poi.hssf.usermodel.HeaderFooter.date;


public class GhiChiSoStaffView extends javax.swing.JPanel {
    private MainStaffView mainStaffView;
    private int idStafflogin;  
    private List<Customers>dsChuhoMnStaff;  
    private List<E_Meter_Details> listdanhsachghidien;
    
    SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
    Date date =new Date();
    String _dateNow;
    int i=-1;
    private ComboboxThuong SapXepCkb;
    
    public GhiChiSoStaffView(MainStaffView msv,int idStafflogin) throws Exception {
        initComponents();
        this.mainStaffView = msv;
        this.idStafflogin=idStafflogin;
        this.setSize(mainStaffView.getMainPanel().getSize());
        this.dsChuhoMnStaff=new ArrayList<>();
        this.listdanhsachghidien=new ArrayList<>();
        LocKetQua("2024-02-10", "Chưa thanh toán");
        ShowThongTinTuDBS(BangDSChuHo);    
    }
    
    private void devideChuho() throws Exception{
        // Chia danh sách chủ hộ theo nhân viên ghi điện 0 
        if(!dsChuhoMnStaff.isEmpty()){
            this.dsChuhoMnStaff.clear();
        }
        List<Customers>danhsach=new DSChuHo().LayDanhSachChuho();
         for(Customers tmp:danhsach){
             boolean roleStaff=new PhanCongDAO().getRoleStaffbyId(this.idStafflogin);
             System.out.println("Id nhan vien "+this.idStafflogin);
             System.out.println("Vai tro cua nhan vien :"+roleStaff);
             if(roleStaff==false){
                 if(tmp.getId_Staff()==this.idStafflogin){
                     this.dsChuhoMnStaff.add(tmp);
                 }
             }
        }
    }
    

    public void ShowThongTinTuDBS(BangDanhSach bangDS) throws Exception{
        DefaultTableModel model = (DefaultTableModel) BangDSChuHo.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged(); 
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        devideChuho();
        //Nhan vien ghi điện
        if(this.dsChuhoMnStaff.isEmpty()){
               JOptionPane.showMessageDialog(this, "Danh sách chủ hộ của nhân viên ghi điện là rỗng: ");
        }
           System.out.println("Listdanhsachghidien: "+this.listdanhsachghidien.size());
            for(E_Meter_Details tmp:this.listdanhsachghidien){
                
                String Id_E_Meter=tmp.getID_E_Meter();
                Customers cs=new GhiChiSo().getCustomerbyIdEmeter(Id_E_Meter);
                String cccd=cs.getCCCD();
                String hovaten=cs.getLastname()+" "+cs.getMiddleName()+" "+cs.getFirstname();
                int oldUsageNum=0;
                oldUsageNum=new GhiChiSo().getPreviousUsageNum(tmp.getId(),1);
                int newUsageNum=0;
                if(tmp.getCurrent_num()!=-1){
                    newUsageNum=tmp.getCurrent_num();
                }
                if(newUsageNum==oldUsageNum){
                    oldUsageNum=0;
                }
                String address=new GhiChiSo().getAddressbyIdMeter(Id_E_Meter);
                
//                System.out.println("----Nhung thong tin can show ---");
//                System.out.println("cccd: " +cccd);               
//                System.out.println("hovaten: "+hovaten);
//                System.out.println("oldUsageNum: "+oldUsageNum);
//                System.out.println("newUsageNum: "+newUsageNum);
//                System.out.println("address: "+address);
//                System.out.println("Id_E_Meter: "+Id_E_Meter);

             
                Object[] rowData = {
                         cccd,hovaten,oldUsageNum,newUsageNum,address, Id_E_Meter
                        };
                model.addRow(rowData);       
                
            }
        StringProcessing.StringSortingTable(BangDSChuHo, 0, true);
        model.fireTableDataChanged();
    
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BangSrllp = new javax.swing.JScrollPane();
        BangDSChuHo = new LayMotSoUIdepTaiDay.BangDanhSach();
        LamMoiBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        DangChonTf = new javax.swing.JTextField();
        DangChonLbl = new javax.swing.JLabel();
        TimKiemTf = new javax.swing.JTextField();
        TimKiemBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        TimKiemCb = new LayMotSoUIdepTaiDay.ComboboxThuong();
        jSeparator1 = new javax.swing.JSeparator();
        LocBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        SapXepBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTuThang = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtTuNam = new com.toedter.calendar.JYearChooser();
        btnLocKetQua = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        BangDSChuHo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CCCD", "Họ và tên", "Số điện cũ", "Số điện mới", "Địa Chỉ", "Công Tơ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class
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
        BangDSChuHo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        BangDSChuHo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BangDSChuHoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BangDSChuHoMouseReleased(evt);
            }
        });
        BangSrllp.setViewportView(BangDSChuHo);

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

        TimKiemCb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CCCD", "Họ và tên", "Địa chỉ", "SĐT", "Account" }));
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
        LocBt.setText("Cập Nhật");
        LocBt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LocBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocBtActionPerformed(evt);
            }
        });

        SapXepBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sort.png"))); // NOI18N
        SapXepBt.setText("Ghi Chỉ Số");
        SapXepBt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SapXepBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SapXepBtActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(244, 244, 244));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(19, 90, 118));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(19, 90, 118));
        jLabel3.setText("Từ tháng :");

        txtTuThang.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtTuThang.setForeground(new java.awt.Color(19, 90, 118));
        txtTuThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12" }));
        txtTuThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTuThangActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(19, 90, 118));
        jLabel4.setText("Từ năm :");

        txtTuNam.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTuNamFocusLost(evt);
            }
        });
        txtTuNam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTuNamMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtTuNamMousePressed(evt);
            }
        });

        btnLocKetQua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLocKetQua.setForeground(new java.awt.Color(19, 90, 118));
        btnLocKetQua.setText("Chọn");
        btnLocKetQua.setOpaque(true);
        btnLocKetQua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocKetQuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTuThang, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtTuNam, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLocKetQua, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTuThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4)
                    .addComponent(txtTuNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(btnLocKetQua, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TimKiemTf, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TimKiemCb, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TimKiemBt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LamMoiBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DangChonLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DangChonTf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(101, 101, 101)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LocBt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SapXepBt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BangSrllp, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(DangChonLbl)
                                .addComponent(DangChonTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(9, 9, 9))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TimKiemBt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LamMoiBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LocBt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SapXepBt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(168, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(BangSrllp, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void LamMoiBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoiBtActionPerformed

        try {
            mainStaffView.setForm(new GhiChiSoStaffView(this.mainStaffView,this.idStafflogin));
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }//GEN-LAST:event_LamMoiBtActionPerformed

    private void BangDSChuHoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangDSChuHoMousePressed

         int i = BangDSChuHo.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) BangDSChuHo.getModel();
        String idCongTo=(String) model.getValueAt(i, 5);
         DangChonTf.setText((String) model.getValueAt(i, 0));
        E_Meter_Details wmd =new E_Meter_DetailsDAO().getaddressByIdmeter(idCongTo,_dateNow);
    }//GEN-LAST:event_BangDSChuHoMousePressed
 public void setTxtThoiGian(){
        String datenow =_dateNow;
        E_Meter_DetailsDAO wmd = new E_Meter_DetailsDAO();
        txtTuThang.setSelectedIndex(wmd.getOnlyMonth(datenow));
        txtTuNam.setYear(wmd.getOnlyYear(datenow));
 }
 private Date LayNgayThangTu() {
        int tuthang = txtTuThang.getSelectedIndex() + 1;
        int tunam = txtTuNam.getYear();
        String tungay = tunam + "-" + tuthang + "-10";

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(String.valueOf(tungay));
        } catch (Exception e) {
        }
        return date;
    }
    private void BangDSChuHoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangDSChuHoMouseReleased
        int i = BangDSChuHo.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) BangDSChuHo.getModel();
        DangChonTf.setText((String) model.getValueAt(i, 0));
    }//GEN-LAST:event_BangDSChuHoMouseReleased

    private void TimKiemBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemBtActionPerformed
                     
        E_Meter_DetailsDAO wmd = new E_Meter_DetailsDAO();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(LayNgayThangTu());
            
        BangDSChuHo.setSelectionMode(2);
        Object selected = TimKiemCb.getSelectedIndex();
        String textTimKiem=TimKiemTf.getText();
        if(TimKiemTf.getText().replaceAll(" ", "").equals("") || selected == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại tìm kiếm và không bỏ trống thông tin nhập!!!");
        }
         if((int)selected==0){
           this.listdanhsachghidien= wmd.getListChiTietCongToByName(textTimKiem,date,this.idStafflogin);
             try {
                 ShowThongTinTuDBS(BangDSChuHo);
             } catch (Exception ex) {
                 Logger.getLogger(GhiChiSoStaffView.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        if((int)selected==1){
           this.listdanhsachghidien= wmd.getChiTietCongToByCCCD(textTimKiem,date,this.idStafflogin);
            System.out.println("text + date + id stagffg "+ textTimKiem+date+this.idStafflogin);
             try {
                 ShowThongTinTuDBS(BangDSChuHo);
             } catch (Exception ex) {
                 Logger.getLogger(GhiChiSoStaffView.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        if((int)selected==2){
           this.listdanhsachghidien= wmd.getListChiTietCongToByIDMeter(textTimKiem,date,this.idStafflogin);
             try {
                 ShowThongTinTuDBS(BangDSChuHo);
             } catch (Exception ex) {
                 Logger.getLogger(GhiChiSoStaffView.class.getName()).log(Level.SEVERE, null, ex);
             }
        }

    }//GEN-LAST:event_TimKiemBtActionPerformed

    private void LocBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocBtActionPerformed
        if (i == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn hóa đơn để cập nhật danh sách ghi chỉ số điện");
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String tungay = formatter.format(LayNgayThangTu());
              CapNhatDialog capnhathd = new CapNhatDialog(true);
                i = BangDSChuHo.getSelectedRow();
                DefaultTableModel model = (DefaultTableModel) BangDSChuHo.getModel();
                String idCongTo=(String) model.getValueAt(i, 5);
                E_Meter_Details wmd =new E_Meter_DetailsDAO().getaddressByIdmeter(idCongTo,tungay);
                capnhathd.setdataHoaDon(wmd);
                capnhathd.setVisible(true);
           }
    }//GEN-LAST:event_LocBtActionPerformed

    private void SapXepBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SapXepBtActionPerformed
        GhiChiSoDialog chiSoDialog;
        try {
            chiSoDialog = new GhiChiSoDialog(true,this.idStafflogin);
            chiSoDialog.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_SapXepBtActionPerformed

    private void txtTuThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTuThangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTuThangActionPerformed

    private void txtTuNamFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTuNamFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTuNamFocusLost

    private void txtTuNamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTuNamMouseClicked
        // TODO add your handling code here:
        System.out.print("helooo");
    }//GEN-LAST:event_txtTuNamMouseClicked

    private void txtTuNamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTuNamMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTuNamMousePressed
 
      private void LocKetQua(String tungay, String trangthai) {
        this.listdanhsachghidien = new GhiChiSo().KhoiTaoListCongTo(tungay,this.idStafflogin);
      }
    private void btnLocKetQuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocKetQuaActionPerformed
        // TODO add your handling code here:
        //        if (LayNgayThangTu().compareTo(LayNgayThangDen()) > 0) {
            //            JOptionPane.showMessageDialog(null, "Ngày bắt đầu lọc lớn hơn ngày kết thúc lọc. Vui lòng nhập lại!");
            //        } else {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String tungay = formatter.format(LayNgayThangTu());
            // String denngay = formatter.format(LayNgayThangDen());
            //      System.out.println("lay ngay -ghinuoc = "+tungay);
            //  String maphong = txtCCCD_CH.getText();
            String trangthai="Chưa thanh toán";

            LocKetQua(tungay, trangthai);
        try {
            ShowThongTinTuDBS(BangDSChuHo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnLocKetQuaActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.BangDanhSach BangDSChuHo;
    private javax.swing.JScrollPane BangSrllp;
    private javax.swing.JLabel DangChonLbl;
    private javax.swing.JTextField DangChonTf;
    private LayMotSoUIdepTaiDay.ButtonThuong LamMoiBt;
    private LayMotSoUIdepTaiDay.ButtonThuong LocBt;
    private LayMotSoUIdepTaiDay.ButtonThuong SapXepBt;
    private LayMotSoUIdepTaiDay.ButtonThuong TimKiemBt;
    private LayMotSoUIdepTaiDay.ComboboxThuong TimKiemCb;
    private javax.swing.JTextField TimKiemTf;
    private javax.swing.JButton btnLocKetQua;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.calendar.JYearChooser txtTuNam;
    private javax.swing.JComboBox<String> txtTuThang;
    // End of variables declaration//GEN-END:variables
 
    public ComboboxThuong getSapXepCkb() {
        ComboboxThuong SapXepCkb = null;
        return SapXepCkb;
    }

    public void setSapXepCkb(ComboboxThuong SapXepCkb) {
        this.SapXepCkb = SapXepCkb;
    }
    
    
    public BangDanhSach getBangDSChuHo() {
        return BangDSChuHo;
    }

    public void setBangDSChuHo(BangDanhSach BangDSChuHo) {
        this.BangDSChuHo = BangDSChuHo;
    }
}
