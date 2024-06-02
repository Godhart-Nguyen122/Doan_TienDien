
package View.StaffView.DsHoaDonDienStaffView.DsHoaDonDienStaffViewDialog;

import Controller.DAO.CustomerDAO;
import Controller.DAO.Usage_NormDAO;
import Controller.StaffView.DSHoaDonStaffviewController;
import Controller.StaffView.subFormController.insertController;
import Controller.SupportFunction.SplitUsageNum;
import Controller.SupportFunction.StringProcessing;
import Model.Customers;
import Model.E_Meter_Details;
import Model.E_Meters;
import Model.Invoices;
import View.StaffView.MainStaffView;
import com.fasterxml.jackson.databind.ext.Java7Handlers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bao
 */
public class insertInvoice extends javax.swing.JFrame {
    private MainStaffView mainStaffView;
    private int idStafflogin;
    private  List<Customers> dsChuHo=new ArrayList<>();  
    
    //Show thông tin cb Chủ hộ 
    private void showInfocbChuho(){
        cbChuho.removeAllItems();
        for(Customers tmp:this.dsChuHo){
            cbChuho.addItem(tmp);
        }
//        this.cbChuho.setSelectedIndex(0);s
        System.out.println("Id staff Login "+this.idStafflogin);
    }
    //Clear tất cả thông tin tất cả các trường 
    public void clearAllfield(){
        this.cbIdEmeter.removeAllItems();
        this.cbDate.removeAllItems();

        this.cccdTxt.setText("");
        this.addressTxt.setText("");
        this.usageNumTxt.setText("");
        this.levelTxt.setText("");
        
        this.typeLivingTxt.setText("");
        this.levelTxt.setText("");
        this.staffInputTxt.setText("");
        this.staffWriteTxt.setText("");
        this.totalPriceTxt.setText("");

    }
    //Show thông tin khi Chủ hộ được seleceted 
    public void showAllField(Customers cs) throws Exception{
        clearAllfield();
        this.cccdTxt.setText(cs.getCCCD());
        this.addressTxt.setText(cs.getAddress());
        this.staffInputTxt.setText(String.valueOf(cs.getId_Staff()));
        this.staffWriteTxt.setText(String.valueOf(cs.getId_Staff_Write()));
        
        //Xu ly combobox Ma cong to dien
        int idCustomer=new CustomerDAO().getIdCustomerbyCCCD(cs.getCCCD());
        List<E_Meters>lst=new insertController().getlistEbyIdCus(idCustomer);
        if(lst.size()==0){
            JOptionPane.showMessageDialog(null, "Chủ hộ chưa được nhập công tơ điện", "Warning", JOptionPane.WARNING_MESSAGE);
        }else{
            for(E_Meters tmp:lst){
                cbIdEmeter.addItem(tmp);
            }
            this.cbIdEmeter.setSelectedIndex(0);
            actionCbIdEmeter();
        }
    }
   
    //Thêm sư kiện công tơ điện click khi cb chủ được được chọn
    public void actionCbIdEmeter(){
        this.cbIdEmeter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    E_Meters selectedIdEmeter=(E_Meters)cbIdEmeter.getSelectedItem();
                    if(selectedIdEmeter!=null){
                        try {
                            showcbDateWhenidEmeterClick(selectedIdEmeter.toString());
                            typeLivingTxt.setText(selectedIdEmeter.getType_Living());
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
               
                }
               
            });
    }
    
     //Show thông tin các tháng tạo hóa đơn cho chủ hộ  
    public void showcbDateWhenidEmeterClick(String idemeter) throws Exception{
        this.cbDate.removeAllItems();
        List<E_Meter_Details>tmp=new insertController().getListEmeterDetaibtIdEmeter(idemeter);
        if(tmp.size()==0){
            JOptionPane.showMessageDialog(null, "Chủ hộ chưa được ghi điện các tháng", "Warning", JOptionPane.WARNING_MESSAGE);
        }else{
            for(E_Meter_Details a:tmp){
                this.cbDate.addItem(a);
            }
            this.cbDate.setSelectedIndex(0);
            acTioncbDate();
        }
    }
    public void acTioncbDate(){
         this.cbDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    E_Meter_Details selectedDate=(E_Meter_Details) cbDate.getSelectedItem();
                    if(selectedDate!=null){
                        try {
                            //So sanh vs CreatingDate
                             int idEmeterDetail=selectedDate.getId();
                             int UsageElec=new DSHoaDonStaffviewController().getUsageCusNum(idEmeterDetail,0);
                             usageNumTxt.setText(String.valueOf(UsageElec));
                             int level=new SplitUsageNum().caculateLevel(UsageElec);
                             levelTxt.setText(String.valueOf(level));
                             
                             Double total=0.0;
                            List<Double>usageNum=new Usage_NormDAO().getAll();
                            List<Integer>lstmp=new SplitUsageNum().getListUsage(UsageElec);
                            for(int i=0;i<lstmp.size();i++){
                                total+=lstmp.get(i)*usageNum.get(i);
                            }
                             Double tongtien=new StringProcessing().castDoubleget2(total);
                             totalPriceTxt.setText(String.valueOf(tongtien)+ " VNĐ");
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
               
                }
               
            });
    }
    private boolean intsertInvoice() throws Exception{
        LocalDate currentDate = LocalDate.now();
        boolean invoiceStatus=false;
        E_Meter_Details detail=(E_Meter_Details) this.cbDate.getSelectedItem();
        int detialId=detail.getId();
        int level=Integer.parseInt(levelTxt.getText());
        int idStaffWrite=this.idStafflogin;
        Invoices tmp=new Invoices();
        tmp.setInvoice_Date(String.valueOf(currentDate));
        tmp.setInvoice_Status(invoiceStatus);
        tmp.setID_E_Meter_Details(detialId);
        tmp.setLevel(level);
        tmp.setID_Staff_Write(idStaffWrite);
        boolean result=false;
        //Check xem hoa don da ton tai hay chua 
        if(new insertController().checkExistInvoice(detialId)){
            JOptionPane.showMessageDialog(null, "Hóa đơn đã tồn tại", "Warning", JOptionPane.WARNING_MESSAGE);
        }else{
            result= new insertController().addNewInvoice(tmp);
        }
        System.out.println("----INSERT INVOICE--------------");
        System.out.println("currentDate :"+currentDate);
        System.out.println("invoiceStatus :"+invoiceStatus);
        System.out.println("detialId :"+detialId);
        System.out.println("level :"+level);
        System.out.println("idStaffWrite :"+idStaffWrite);
        return result;
        
    }
    
    public insertInvoice(MainStaffView msv) throws Exception {
        //Get list customer Manage by StaffLogin
        initComponents();
        this.setLocationRelativeTo(this.mainStaffView);
        this.idStafflogin=msv.getIdStafflogin();
        this.dsChuHo =new DSHoaDonStaffviewController().getListCusMagbyIdStaffWrite(this.idStafflogin);
        //showninfocombox
        showInfocbChuho();
        //Action combobox
        cbChuho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected item
                if(cbChuho.getSelectedItem()==null){
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn chủ hộ cần tạo hóa đơn", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                else{
                    Customers selected =(Customers) cbChuho.getSelectedItem();
                    try {
                        showAllField(selected);
//                        actionCbIdEmeter();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        //Action combox  idmeter
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressTxt = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        typeLivingTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbDate = new LayMotSoUIdepTaiDay.ComboboxThuong();
        jLabel8 = new javax.swing.JLabel();
        usageNumTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        levelTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        totalPriceTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbChuho = new LayMotSoUIdepTaiDay.ComboboxThuong();
        cccdTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        staffWriteTxt = new javax.swing.JTextField();
        staffInputTxt = new javax.swing.JTextField();
        submitBtn = new LayMotSoUIdepTaiDay.ButtonThuong();
        cancelBtn = new LayMotSoUIdepTaiDay.ButtonThuong();
        cbIdEmeter = new LayMotSoUIdepTaiDay.ComboboxThuong();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(java.awt.SystemColor.controlHighlight);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setText("TypeLiving:");

        addressTxt.setEditable(false);
        addressTxt.setColumns(20);
        addressTxt.setLineWrap(true);
        addressTxt.setRows(5);
        jScrollPane1.setViewportView(addressTxt);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setText("Mã Công tơ:");

        typeLivingTxt.setEditable(false);
        typeLivingTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel7.setText("Số điện sử dụng tháng:");

        cbDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbDate.setLabeText("Tháng nhập hóa đơn");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel8.setText("Chỉ số tháng:");

        usageNumTxt.setEditable(false);
        usageNumTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        usageNumTxt.setText("Chỉ số tháng");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel9.setText("Level:");

        levelTxt.setEditable(false);
        levelTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("TỔNG TIỀN:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel11.setText("Nhân viên ghi điện:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("TẠO HÓA ĐƠN");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel12.setText("Nhân viên nhập hóa đơn:");

        totalPriceTxt.setEditable(false);
        totalPriceTxt.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setText("Họ và Tên :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setText("CCCD:");

        cbChuho.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbChuho.setLabeText("Chọn chủ hộ");

        cccdTxt.setEditable(false);
        cccdTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setText("ĐỊA CHỈ:");

        staffWriteTxt.setEditable(false);
        staffWriteTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        staffInputTxt.setEditable(false);
        staffInputTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        submitBtn.setText("SUBMIT");
        submitBtn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("CANCEL");
        cancelBtn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(staffInputTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(cbChuho, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(cccdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(80, 80, 80)
                                        .addComponent(jLabel8)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel6))
                                                .addGap(39, 39, 39))
                                            .addComponent(cbDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbIdEmeter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(typeLivingTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                                .addGap(80, 80, 80)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(levelTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)
                                    .addComponent(staffWriteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(usageNumTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))))
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(totalPriceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbIdEmeter, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbChuho, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cccdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usageNumTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(levelTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeLivingTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staffInputTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(staffWriteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalPriceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
           int option = JOptionPane.showConfirmDialog(
                        this,
                        "Bạn có muốn chắc muốn thêm hóa đơn hay không?",
                        "Xác nhận thêm hóa đơn",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
            );

            if(option==JOptionPane.YES_OPTION){
                //Xu ly tuong ung 
                 if(this.cccdTxt.getText().equals("")||this.usageNumTxt.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn chủ hộ mã,công tơ điện,ngày tháng ghi điện cần tạo hóa đơn", "Warning", JOptionPane.WARNING_MESSAGE);
                }else{
                try {
                   boolean result=intsertInvoice();
                   if(result){
                        JOptionPane.showMessageDialog(null, "Thêm hóa đơn thành công", "Thông báo", JOptionPane.WARNING_MESSAGE);
                        this.dispose();
                   }else{
                        JOptionPane.showMessageDialog(null, "Thêm hóa đơn thất bại", "Thông báo", JOptionPane.WARNING_MESSAGE); 
                        this.dispose();
                   }
                    
                } catch (Exception ex) {
                    Logger.getLogger(insertInvoice.class.getName()).log(Level.SEVERE, null, ex);
                }  
        }   
            }
           
    }//GEN-LAST:event_submitBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(insertInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(insertInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(insertInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(insertInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new insertInvoice(null).setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(insertInvoice.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addressTxt;
    private LayMotSoUIdepTaiDay.ButtonThuong cancelBtn;
    private LayMotSoUIdepTaiDay.ComboboxThuong cbChuho;
    private LayMotSoUIdepTaiDay.ComboboxThuong cbDate;
    private LayMotSoUIdepTaiDay.ComboboxThuong cbIdEmeter;
    private javax.swing.JTextField cccdTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField levelTxt;
    private javax.swing.JTextField staffInputTxt;
    private javax.swing.JTextField staffWriteTxt;
    private LayMotSoUIdepTaiDay.ButtonThuong submitBtn;
    private javax.swing.JTextField totalPriceTxt;
    private javax.swing.JTextField typeLivingTxt;
    private javax.swing.JTextField usageNumTxt;
    // End of variables declaration//GEN-END:variables
}
