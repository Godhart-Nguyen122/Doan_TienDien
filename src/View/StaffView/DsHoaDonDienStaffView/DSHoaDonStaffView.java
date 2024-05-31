package View.StaffView.DsHoaDonDienStaffView;

import View.StaffView.DSChuhoStaffView.*;
import Controller.DAO.CustomerDAO;
import Controller.DAO.InvoicesDAO;
import Controller.DAO.PhanCongDAO;
import Controller.DAO.Usage_NormDAO;
import View.AdminView.DSChuHoView.*;
import Controller.DSChuHoController.DSChuHo;
import Controller.StaffView.DSHoaDonStaffviewController;
import Controller.SupportFunction.SplitUsageNum;
import Controller.SupportFunction.StringProcessing;
import LayMotSoUIdepTaiDay.BangDanhSach;
import LayMotSoUIdepTaiDay.ComboboxThuong;
import Model.Customers;
import Model.E_Meter_Details;
import Model.Invoices;
import View.AdminView.DSChuHoView.DSChuHoDialog.FilterLoaiDateDSCHDialog;
import View.AdminView.DSChuHoView.DSChuHoDialog.SortLoaiStringDSCHDialog;
import View.AdminView.MainAdminView;
import View.StaffView.DsHoaDonDienStaffView.DsHoaDonDienStaffViewDialog.SortLoaiStringDSHoaDonStaffViewDialog;
import View.StaffView.DsHoaDonDienStaffView.DsHoaDonDienStaffViewDialog.insertInvoice;
import View.StaffView.DsHoaDonDienStaffView.DsHoaDonDienStaffViewDialog.payMethod;
import View.StaffView.MainStaffView;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


public class DSHoaDonStaffView extends javax.swing.JPanel {
    private Customers Cs;
    private MainStaffView mainStaffView;
    private int idStafflogin;
    private List<Integer>listcusofStaff;
    private  List<Customers> dsChuHo;  
    private List<Invoices>invoiceses;
    private List<Double>usageNorm;
    private int selectedInvoiceId;

    public int getSelectedInvoiceId() {
        return selectedInvoiceId;
    }
   
    public DSHoaDonStaffView(MainStaffView msv,int idStafflogin) throws Exception {
        initComponents();
        this.mainStaffView = msv;
        this.idStafflogin=idStafflogin;
        this.setSize(mainStaffView.getMainPanel().getSize());
        this.BangDSChuHo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.dsChuHo =new DSHoaDonStaffviewController().getListCusMagbyIdStaffWrite(this.idStafflogin);
        this.invoiceses=new InvoicesDAO().getAll();
        selectedInvoiceId=-1;
        this.usageNorm=new Usage_NormDAO().getAll();
        ShowThongTinTuDBS2(BangDSChuHo) ;
    }
    private Customers checkIdCustomer(int customerId){
        for(Customers tmp : this.dsChuHo){
            int  tmpId=new CustomerDAO().getIdCustomerbyCCCD(tmp.getCCCD());
            if(tmpId==customerId){
                return tmp;
            }
        }
        return null;
    } 
    
    public void ShowThongTinTuDBS2(BangDanhSach bangDs) throws Exception{
        DefaultTableModel model = (DefaultTableModel) BangDSChuHo.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged(); 
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if(this.invoiceses.isEmpty()){
            JOptionPane.showMessageDialog(this, "Danh sách hóa đơn rỗng");
        }else{
            for(Invoices tmpinvoices:this.invoiceses){
                int invoiceid=tmpinvoices.getId();
                String invoiceDate=tmpinvoices.getInvoice_Date();
                boolean InvoiceStatus=tmpinvoices.isInvoice_Status();
                int level=tmpinvoices.getLevel();
                int emeterdetialId=tmpinvoices.getID_E_Meter_Details();
                E_Meter_Details meterDetails=new DSHoaDonStaffviewController().getEdetailbyInvoiceDetialId(emeterdetialId);
                int customerId=new DSHoaDonStaffviewController().getIdCustomerbyEdetail(meterDetails);
                Customers tmpcs=checkIdCustomer(customerId);
                if(checkIdCustomer(customerId)!=null){
                    Customers tmp=checkIdCustomer(customerId);
                    String cccd=tmp.getCCCD();
                    String hovaten=tmp.getLastname()+" "+tmp.getMiddleName()+" "+tmp.getFirstname();
                    //Lay so dien da su dung
                    int UsageElec=new DSHoaDonStaffviewController().getUsageCusNum(emeterdetialId);
                    //Tinh so tien
                    Double total=0.0;
                    List<Double>usageNum=new Usage_NormDAO().getAll();
                    List<Integer>lstmp=new SplitUsageNum().getListUsage(UsageElec);
                    for(int i=0;i<lstmp.size();i++){
                        total+=lstmp.get(i)*usageNum.get(i);
                    }
                    
//                     total=this.usageNorm.get(level-1)*UsageElec;
                    
                     Double tongtien=new StringProcessing().castDoubleget2(total);
               
                    
                    Object[] rowData = {
                         invoiceid, cccd,hovaten,invoiceDate,tongtien,InvoiceStatus ==true?"Đã thanh toán":"Chưa thanh toán"     
                        };
                        model.addRow(rowData);       
                }    
            } 
        }
       
        
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
        SapXepCkb = new LayMotSoUIdepTaiDay.ComboboxThuong();
        SapXepBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        themBtn = new LayMotSoUIdepTaiDay.ButtonThuong();
        xoaBtn = new LayMotSoUIdepTaiDay.ButtonThuong();
        thanhtoanBtn = new LayMotSoUIdepTaiDay.ButtonThuong();

        setBackground(new java.awt.Color(255, 255, 255));

        BangDSChuHo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CCCD", "Họ và tên", "Invoice_Date", "Total_Price", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
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

        TimKiemCb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CCCD", "Họ và tên", "" }));
        TimKiemCb.setSelectedItem(null
        );
        TimKiemCb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TimKiemCb.setLabeText("(Tìm kiếm theo)");
        TimKiemCb.setLineColor(new java.awt.Color(0, 153, 255));

        jSeparator1.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        SapXepCkb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Theo CCCD", "Theo họ và tên", "Theo ngày", "Theo tiền", "Theo tình trạng" }));
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

        themBtn.setText("Thêm");
        themBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        themBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themBtnActionPerformed(evt);
            }
        });

        xoaBtn.setText("Xóa");
        xoaBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xoaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaBtnActionPerformed(evt);
            }
        });

        thanhtoanBtn.setText("Thanh toán");
        thanhtoanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thanhtoanBtnActionPerformed(evt);
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
                        .addComponent(TimKiemBt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(thanhtoanBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LamMoiBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(themBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xoaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SapXepCkb, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SapXepBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 7, Short.MAX_VALUE)))
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
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(DangChonLbl)
                                .addComponent(DangChonTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(9, 9, 9))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TimKiemBt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LamMoiBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(thanhtoanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SapXepCkb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(SapXepBt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(themBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(xoaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(BangSrllp, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void LamMoiBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoiBtActionPerformed
        try {
            mainStaffView.setForm(new DSHoaDonStaffView(this.mainStaffView,this.idStafflogin));
        } catch (Exception ex) {
            Logger.getLogger(DSHoaDonStaffView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_LamMoiBtActionPerformed

    private void BangDSChuHoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangDSChuHoMousePressed
        int i = BangDSChuHo.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) BangDSChuHo.getModel();
        DangChonTf.setText(String.valueOf(model.getValueAt(i, 1)));
        this.selectedInvoiceId= (Integer) model.getValueAt(i,0);
        System.out.println("invoice Id selected: "+this.selectedInvoiceId);
    }//GEN-LAST:event_BangDSChuHoMousePressed

    private void BangDSChuHoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangDSChuHoMouseReleased
       int i = BangDSChuHo.getSelectedRow();
       DefaultTableModel model = (DefaultTableModel) BangDSChuHo.getModel();
       DangChonTf.setText(String.valueOf(model.getValueAt(i, 1)));
    }//GEN-LAST:event_BangDSChuHoMouseReleased

    private void TimKiemBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemBtActionPerformed
        BangDSChuHo.setSelectionMode(2);
        Object selected = TimKiemCb.getSelectedItem();
        if(TimKiemTf.getText().replaceAll(" ", "").equals("") || selected == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại tìm kiếm và không bỏ trống thông tin nhập!!!");            
        }else if(selected.equals("CCCD")){
            if(!DSHoaDonStaffviewController.Searching(TimKiemTf.getText(), BangDSChuHo, 1))
               JOptionPane.showMessageDialog(this, "Không tìm thấy người dùng có CCCD: " + TimKiemTf.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy người dùng có CCCD: " + TimKiemTf.getText());  
        }else if(selected.equals("Họ và tên")){
            if(!DSHoaDonStaffviewController.Searching(TimKiemTf.getText(), BangDSChuHo, 2))
               JOptionPane.showMessageDialog(this, "Không tìm thấy người dùng có họ tên: " + TimKiemTf.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy người dùng có họ tên: " + TimKiemTf.getText());                           
        }
    }//GEN-LAST:event_TimKiemBtActionPerformed

    private void SapXepBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SapXepBtActionPerformed
        Object selected = SapXepCkb.getSelectedItem();
        if(selected == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thuộc tính cần sắp xếp!!!");             
        }else{
            SortLoaiStringDSHoaDonStaffViewDialog sHoaDonStaffViewDialog = new SortLoaiStringDSHoaDonStaffViewDialog(this.mainStaffView, this, true);
            sHoaDonStaffViewDialog.setVisible(true);  
        }
    }//GEN-LAST:event_SapXepBtActionPerformed

    private void thanhtoanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thanhtoanBtnActionPerformed
         if(this.selectedInvoiceId==-1){
             JOptionPane.showMessageDialog(null, "Vui lòng chọn hóa đơn cần thanh toán", "Warning", JOptionPane.WARNING_MESSAGE);
        }else{
            int option = JOptionPane.showConfirmDialog(
                        this,
                        "Bạn có muốn chắc muốn thanh toán hóa đơn này không ?",
                        "Xác nhận thanh toán hóa đơn",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
            );
            if(option==JOptionPane.YES_OPTION){
                payMethod pay=new payMethod(this,true);
                pay.setVisible(true);
            }
        }
    }//GEN-LAST:event_thanhtoanBtnActionPerformed

    private void themBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themBtnActionPerformed
        try {
            insertInvoice view =new insertInvoice(this. mainStaffView);
            view.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_themBtnActionPerformed

    private void xoaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaBtnActionPerformed
        if(this.selectedInvoiceId==-1){
             JOptionPane.showMessageDialog(null, "Vui lòng chọn hóa đơn cần xóa", "Warning", JOptionPane.WARNING_MESSAGE);
        }else{
            int option = JOptionPane.showConfirmDialog(
                        this,
                        "Bạn có muốn chắc muốn xóa hóa đơn hay không ? Việc này đồng nghĩa đã xảy ra sự cố với khách hàng",
                        "Xác nhận xóa hóa đơn",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
            );
            if(option==JOptionPane.YES_OPTION){
                try {
                    boolean result=new DSHoaDonStaffviewController().deleteInvoice(this.selectedInvoiceId);
                    if(result){
                        JOptionPane.showMessageDialog(this, "Xóa hóa đơn thành công", "Success", JOptionPane.INFORMATION_MESSAGE);
                        mainStaffView.setForm(new DSHoaDonStaffView(this.mainStaffView,this.idStafflogin));
                        
                    }else{
                        JOptionPane.showMessageDialog(this, "Xóa hóa đơn thất bại", "Failed", JOptionPane.ERROR_MESSAGE);  
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }    
            }
        }
    }//GEN-LAST:event_xoaBtnActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.BangDanhSach BangDSChuHo;
    private javax.swing.JScrollPane BangSrllp;
    private javax.swing.JLabel DangChonLbl;
    private javax.swing.JTextField DangChonTf;
    private LayMotSoUIdepTaiDay.ButtonThuong LamMoiBt;
    private LayMotSoUIdepTaiDay.ButtonThuong SapXepBt;
    private LayMotSoUIdepTaiDay.ComboboxThuong SapXepCkb;
    private LayMotSoUIdepTaiDay.ButtonThuong TimKiemBt;
    private LayMotSoUIdepTaiDay.ComboboxThuong TimKiemCb;
    private javax.swing.JTextField TimKiemTf;
    private javax.swing.JSeparator jSeparator1;
    private LayMotSoUIdepTaiDay.ButtonThuong thanhtoanBtn;
    private LayMotSoUIdepTaiDay.ButtonThuong themBtn;
    private LayMotSoUIdepTaiDay.ButtonThuong xoaBtn;
    // End of variables declaration//GEN-END:variables
 
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
    
    public BangDanhSach getBangDSChuHo() {
        return BangDSChuHo;
    }

    public void setBangDSChuHo(BangDanhSach BangDSChuHo) {
        this.BangDSChuHo = BangDSChuHo;
    }
}
